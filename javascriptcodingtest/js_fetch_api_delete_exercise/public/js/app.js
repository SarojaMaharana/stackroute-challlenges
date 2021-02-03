/*
  Create a function addToHTML() which will take
  a JSON object as a parameter. On receiving the
  parameter value, convert it into a JSON array.
  For each element in the JSON array, populate a table
  row. Add a delete button for each row and call deleteStudentFromDB(id)
  function on click event of the button by passing the student id as a parameter.
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
  Create a function 'removeStudentFromDB(id)' by passing
  the student id as a parameter
  to delete an existing student data from the API
  'http://localhost:3000/students/{id}' where id is the
  student id passed to the function as parameter. the API call
  should be done with HTTP DELETE method.
  On successful deletion, call the 'fetchStudentDetailsFromDB()' function to
  re-populate the student list. As fetch() returns a promise, ensure that you
  resolve the same. Also, exception handling needs to be done.
*/
function removeStudentFromDB(id) {
    
}

 module.exports = {
    fetchStudentDetailsFromDB,
    removeStudentFromDB
};
