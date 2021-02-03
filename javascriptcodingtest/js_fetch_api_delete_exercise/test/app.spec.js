const chai = require('chai');
const expect = chai.expect;
chai.use(require('dirty-chai'));
const script = require('../public/js/app');
const fetchMock = require('fetch-mock');
const jsdom = require('mocha-jsdom');

describe('Students', ()=>{
    jsdom();

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


	beforeEach(() => {
		document.body.innerHTML =
		`<div class="container">
		<div class="jumbotron" style="margin:45px 0px">
			<h2 class="text-center">STUDENT CRUD APP</h2>
	 </div>


<div style="margin-top:1em;text-align:center">
 <h2>All Students Information</h2>
 <table class="table table-striped">
				 <thead>
					 <tr>
						 <th>Name</th>
						 <th>Contact No</th>
						 <th>Email</th>
						 <th>Delete</th>
					 </tr>
				 </thead>
				 <tbody id='studentsList'>
						 <!-- this will be generated dynamically -->
				 </tbody>

 </table>

 <h2 class="error"></h2>

</div>


</div>`;
	});

	afterEach(fetchMock.restore);

		it('fetchStudentDetailsFromDB() shall hit correct api and return correct response',
		(done) => {
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

	it(`removeStudentFromDB() shall hit the correct api with correct data and 
		return correct response`, (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData);
			fetchMock.delete('http://localhost:3000/students/2', '{}');

			script.removeStudentFromDB(2)
			.then(() => {
				const callArgs = fetchMock.calls();
				expect(callArgs[0][0]).to.equal('http://localhost:3000/students/2');
				expect(callArgs[0][1].method).to.equal('DELETE');
				expect(callArgs[0][1].body).to.be.undefined();
				expect(callArgs[1][0]).to.equal('http://localhost:3000/students');
				done();
			})
			.catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('there shall be only one server call in removeStudentFromDB()', (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData);

			script.fetchStudentDetailsFromDB()
			.then(() => {
				fetchMock.restore();
				fetchMock.delete('http://localhost:3000/students/2', '{}');
				fetchMock.get('http://localhost:3000/students', studentsTestData);
				return script.removeStudentFromDB(2);
			})
			.then(() => {
				expect(fetchMock.done()).to.equal(true);
				done();
			})
			.catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
	});

	it('server error in removeStudentFromDB() is handled', () => {
		fetchMock.get('http://localhost:3000/students', studentsTestData);
		fetchMock.delete('http://localhost:3000/students/2', '{}',
			{ throws: { message: 'Dummy error from server' }});
			script.removeStudentFromDB(2)
			.catch((err) => {
				expect(err).to.not.equal(null, err);
				expect(err.message).to.equal('some error occured');
			});
		});
});
