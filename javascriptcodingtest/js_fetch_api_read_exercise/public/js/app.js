/*
  Create a function addToHTML() which will take
  a JSON object as a parameter. On receiving the
  parameter value, convert it into a JSON array.
  For each element in the JSON array, populate a table
  row.
  Finally once all the rows are added, populate the table
  body using innerHTML property
  of the table body dynamically.
*/

function addToHTML(studentsList) {
    
 }

/*
  Create a function 'fetchStudentDetailsFromDB'
  to retrieve the data from the API
  'http://localhost:3000/students'.
  On receiving the response, call the 'addToHTML' function by
  passing the JSON object containing the student data to 'addToHTML()'
  function which will dynamically generate the HTML response.
  As fetch() returns a promise, ensure that you
  resolve the same. Also, exception handling needs to be done.
*/

function fetchStudentDetailsFromDB() {
    
 }

/*
  Create a function 'addStudentToDB'
  to add a new student data using the API
  'http://localhost:3000/students' using HTTP POST method.
  the following are the steps to be followed:
  1. retrieve the values of the text boxes 'name', 'contactno' and 'email' into local variables.
  2. create and populate a new student JSON object having the following structure:
    {
        name: <value>,
        contactno: <value>,
        email: <value>
    }
  3. Using fetch API, send a POST request to the API 'http://localhost:3000/students'
     by passing the student JSON object created in the previous step.
  4. Perform exception handling

    Important: DO NOT call event.preventDefault() function as it will fail the test cases

*/

 function addStudentToDB() {
    
}

 module.exports = {
    fetchStudentDetailsFromDB,
    addStudentToDB
 };
