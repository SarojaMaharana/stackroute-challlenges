const chai = require('chai');
const expect = chai.expect;
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

    const newStudentTestData = {
        name: 'Kayla Grieves',
        contactno: 9999900000,
        email: 'kayla.grieves@gmail.com',
        id: 1
    };

    beforeEach(() => {
        document.body.innerHTML =
        `<body onload="fetchStudentDetailsFromDB()">
        <div class="container">
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
                <input type="text" class="form-control" id="contactno" 
                placeholder="Enter Contact No">
              </div>
  
              <div class="form-group">
                      <label for="exampleInputEmail">Email</label>
                      <input type="email" class="form-control" id="email" 
                      placeholder="Enter E-mail">
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
                    </tr>
                  </thead>
                  <tbody id='studentsList'>
                      <!-- this will be populated dynanically -->
                  </tbody>
  
          </table>
  
          <h2 class="error"></h2>
      
      </div>
  
  
  </div>`;
    });
    afterEach(() => {
        fetchMock.restore();
    });


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

	it(`addStudentToDB() shall hit the correct api with correct data and 
		return correct response`, (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData, {overwriteRoutes: false});
            fetchMock.post('http://localhost:3000/students', newStudentTestData);


            script.addStudentToDB()
            .then(() => {
               const lastCallArgs = fetchMock.lastCall();
               expect(lastCallArgs[0]).to.equal('http://localhost:3000/students');
               expect(lastCallArgs[1].method).to.equal('POST');
               studentsTestData.push(newStudentTestData);
                 done();
            })
            .then(() => {
                script.fetchStudentDetailsFromDB()
                .then(() => { // eslint-disable-line max-nested-callbacks
                    const lastCallArgs = fetchMock.lastCall();
                    expect(lastCallArgs[0]).to.equal('http://localhost:3000/students');
                    expect(document.getElementById('studentsList').innerHTML)
                    .to.include('Kayla Grieves');
                });
            })
			.catch((err) => {
				expect(err).to.equal(null, err);
				done();
			});
        });
    // });

	it('there shall be only one server call in addStudentToDB()', (done) => {
			fetchMock.get('http://localhost:3000/students', studentsTestData);

			script.fetchStudentDetailsFromDB()
			.then(() => {
				fetchMock.restore();
				fetchMock.post('http://localhost:3000/students', newStudentTestData);
                return script.addStudentToDB();
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

	it('server error in addStudentToDB() is handled', (done) => {
		fetchMock.get('http://localhost:3000/students', studentsTestData);
		fetchMock.post('http://localhost:3000/students',
			{ throws: { message: 'some internal error occured..' }});

		script.fetchStudentDetailsFromDB()
		.then(() => {
			return script.addStudentToDB();
		})
		.catch((err) => {
			expect(err).to.not.equal(null, err);
			expect(err.message).to.equal('some internal error occured..');
			done();
		});
	});
});
