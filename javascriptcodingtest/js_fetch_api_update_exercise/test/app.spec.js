const chai = require('chai');
const expect = chai.expect;
const script = require('../public/js/app');
const fetchMock = require('fetch-mock');
const mochaJsdom = require('mocha-jsdom');


describe('Students', ()=> {
    mochaJsdom();

    const studentsTestData = [{
        name: 'John Doe',
        contactno: 1234567890,
        email: 'john.doe@gmail.com',
        id: 1
    },
    {
        name: 'Chris Evans',
        contactno: 1122334455,
        email: 'chris.evans@gmail.com',
        id: 2
    },
    {
        name: 'Jonathan Davis',
        contactno: 1223334444,
        email: 'jonathan.davis@gmail.com',
        id: 3
	}];

	const studentTestDataToUpdate = {
		name: 'Jonathan Davis',
		contactno: 1223334445,
		email: 'jonathan.davis@gmail.com',
		id: 3
	};

	const updatedStudentTestData = {
			name: 'Jonathan Davis',
			contactno: '1223334445',
			email: 'jonathan.davis@gmail.com'
    };


	beforeEach(() => {
		document.body.innerHTML =
		`<div class="container">
		<div class="jumbotron" style="margin:45px 0px">
			<h2 class="text-center">STUDENT CRUD APP</h2>
	 </div>

<form onsubmit="addStudentToDB(event)">
		 <div class="form-group">
			 <label for="exampleInputName">Name</label>
			 <input type="text" class="form-control" id="name" aria-describedby="name" 
			 placeholder="Enter Name">
					 </div>
		 <div class="form-group">
			 <label for="exampleInputContactNo">Contact No</label>
			 <input type="text" class="form-control" id="contactno" placeholder="Enter Contact No">
		 </div>

		 <div class="form-group">
						 <label for="exampleInputEmail">Email</label>
						 <input type="email" class="form-control" id="email" placeholder="Enter E-mail">
					 </div>            
		 <button type="submit" class="btn btn-primary">Submit</button>
		 <small class="status"></small>
	 </form>


<div style="margin-top:1em;text-align:center">
 <h2>All Students Information</h2>
 <table class="table table-striped">
				 <thead>
					 <tr>
						 <th>Name</th>
						 <th>Contact No</th>
						 <th>Email</th>
						 <th>Update</th>
					 </tr>
				 </thead>
				 <tbody id='studentsList'>
	
				 </tbody>

 </table>

 <h2 class="error"></h2>

</div>

<!-- Update modal -->
<!-- Modal -->
<div class="modal hidden fade" id="updateForm" tabindex="-1" role="dialog" 
aria-labelledby="myModalLabel" aria-hidden="true">
<div class="modal-dialog">
<form onsubmit="updateStudentToDB(event)">
<div class="modal-content">
<!-- Modal Header -->
<div class="modal-header">
		
		<h4 class="modal-title" id="myModalLabel">
			 Update Student Details
		</h4>
</div>

<!-- Modal Body -->
<div class="modal-body">
 <!-- <form onsubmit="updateStudentToDB(event)"> -->
	 <input type="hidden" class="hidden" id="studentid">
	 <div class="form-group">
		 <label for="exampleInputName">Name</label>
		 <input type="text" class="form-control" id="studentname" aria-describedby="name" 
		 placeholder="Enter Name">
	 </div>
	 <div class="form-group">
		 <label for="exampleInputContactNo">Contact No</label>
		 <input type="text" class="form-control" id="studentcontactno" placeholder="Enter Contact No">
	 </div>

	 <div class="form-group">
		 <label for="exampleInputEmail">Email</label>
		 <input type="email" class="form-control" id="studentemail" placeholder="Enter E-mail">
	 </div>            
	
	 <!-- Modal Footer -->
<div class="modal-footer">
	 <button type="button" class="btn btn-default"
					 data-dismiss="modal">
							 Close
	 </button>
	 <button type="submit" class="btn btn-primary">
			 Save changes
	 </button>
</div>
 </form>
						

</div>


</div>
</div>
</div>


</div>`;
	});

	afterEach(fetchMock.restore);

    it('fetchStudentDetailsFromDB() shall hit correct api and return correct response', (done) => {
        fetchMock.get('http://localhost:3000/students', studentsTestData, {overwriteRoutes: false});

		script.fetchStudentDetailsFromDB()
		.then(res => {
			expect(fetchMock.lastUrl()).to.equal('http://localhost:3000/students');
			expect(res).to.deep.equal(studentsTestData);
			done();
		})
		.catch(err => {
			expect(err).to.equal(null, err);
			done();
		});
	});

    it('there shall be only one server call in fetchStudentDetailsFromDB()', (done) => {
		fetchMock.get('http://localhost:3000/students', studentsTestData, {overwriteRoutes: false});

		script.fetchStudentDetailsFromDB()
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			})
			.catch(err => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('data fetched from fetchStudentDetailsFromDB() to be populated in DOM at appropriate place',
	(done) => {
		fetchMock.get('http://localhost:3000/students', studentsTestData, {overwriteRoutes: false});
		script.fetchStudentDetailsFromDB()
				.then(() => {
						expect(document.getElementById('studentsList').innerHTML)
						.to.include('John Doe');
						expect(document.getElementById('studentsList').innerHTML)
						.to.include('Evans');
						done();
				})
				.catch(err => {
						expect(err).to.equal(null, err);
						done();
				});
});


	it(`updateStudentToDB() shall hit the correct api with correct data and 
		return correct response`, (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData);
			fetchMock.put('http://localhost:3000/students/3', JSON.stringify(updatedStudentTestData));

			script.fetchStudentDetailsFromDB()
			.then(() => {
				document.getElementById('studentid').value = `${studentTestDataToUpdate.id}`;
				document.getElementById('studentname').value = `${studentTestDataToUpdate.name}`;
				document.getElementById('studentcontactno').value = `${studentTestDataToUpdate.contactno}`;
				document.getElementById('studentemail').value = `${studentTestDataToUpdate.email}`;
				script.updateStudentToDB();
			})
			.then(() => {
				const lastCallArgs = fetchMock.lastCall();
				expect(lastCallArgs[0]).to.equal('http://localhost:3000/students/3');
				expect(lastCallArgs[1].method).to.equal('PUT');
				expect(lastCallArgs[1].body).to.equal(JSON.stringify(updatedStudentTestData));
				done();
			}).catch((err) => {
				expect(err).to.equal(null, err);
				done();
				});
	});

	it('there shall be only one server call in updateStudentToDB()', (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData);

			script.fetchStudentDetailsFromDB()
			.then(() => {
				fetchMock.restore();
				fetchMock.put('http://localhost:3000/students/3', updatedStudentTestData);
					document.getElementById('studentid').value = `${studentTestDataToUpdate.id}`;
					document.getElementById('studentname').value = `${studentTestDataToUpdate.name}`;
					document.getElementById('studentcontactno')
					.value = `${studentTestDataToUpdate.contactno}`;
					document.getElementById('studentemail').value = `${studentTestDataToUpdate.email}`;
				return script.updateStudentToDB();
			})
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			}).catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('server error in updateStudentToDB() is handled', (done) => {
		fetchMock.get('http://localhost:3000/students', studentsTestData);
		fetchMock.put('http://localhost:3000/students/3',
			{ throws: { message: 'Dummy error from server' }});

		script.fetchStudentDetailsFromDB()
		.then(() => {
			document.getElementById('studentid').value = `${studentTestDataToUpdate.id}`;
			document.getElementById('studentname').value = `${studentTestDataToUpdate.name}`;
			document.getElementById('studentcontactno').value = `${studentTestDataToUpdate.contactno}`;
			document.getElementById('studentemail').value = `${studentTestDataToUpdate.email}`;

			return script.updateStudentToDB();
		})
		.catch((err) => {
			expect(err).to.not.equal(null, err);
			expect(err.message).to.equal('Dummy error from server');
			done();
		});
	});
});
