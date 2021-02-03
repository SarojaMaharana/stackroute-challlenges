# Working With Fetch API to update existing data through RESTful API in JavaScript Exercise

## Objective

The Objective of this assignment is to understand the working of Fetch API to update existing data using a RESTful API in JavaScript.  

## Prerequisites

1. Fork this boilerplate repository  
2. Clone the boilerplate repository and cd into it  
3. Install dependencies. 

```
  npm install
```

## Coding Guidelines
  
1. All your JavaScript code resides in the `./public/js` folder 
1. All your HTML code resides in the `./public` folder 
2. Javascript code should be well indented and commented  
3. The Assignment should be pushed to gitlab on completion and submitted for Preliminary Automated Review as described below.  
  
## Exercise

1. Create a function `fetchStudentDetailsFromDB()`
  to retrieve the data from the API
  `http://localhost:3000/students`.
  On receiving the response, call the `addToHTML()` function by
  passing the JSON object containing the student data to `addToHTML()`
  function which will dynamically generate the HTML response.
  As fetch() returns a promise, ensure that you
  resolve the same. Also, exception handling needs to be done.
2. Create a function `addToHTML()` which will take
  a JSON object as a parameter. On receiving the
  parameter value, convert it into a JSON array.
  For each element in the JSON array, populate a table
  row of a HTML table. Also, add an update button for each row and call `updateStudent()`
  function on `click` event of the button by passing the stringified
  student object as a parameter.
  Finally once all the rows are added, populate the table body using `innerHTML` property 
  of the table body dynamically.
3. call `fetchStudentDetailsFromDB()` function on page load from `index.html` page.  
4. Create a function `addStudentToDB()`
  to add a new student data using the API
  `http://localhost:3000/students` using HTTP POST method.
  the following are the steps to be followed:
    1. retrieve the values of the text boxes `name`, `contactno` and `email` into local variables.
    2. create and populate a new student JSON object having the following structure:
    ```
    {
        name: <value>,
        contactno: <value>,
        email: <value>
    }
    ```
    3. Using fetch API, send a POST request to the API `http://localhost:3000/students`
     by passing the student JSON object created in the previous step.
    4. Perform exception handling.
  5. call `addStudentToDB(event)` function on form submit event in `index.html` page.
  6. Create a function `updateStudent(student)` which takes student
  object as a parameter. This function is responsible
  for displaying the update modal dialog box and also
  populate the textboxes containing student id, student name,
  contact number and email with the value captured from the object passed as parameter.
 7. Create a function `updateStudentToDB()` which will be called on clicking
  the submit button in the form which is in `index.html` page. This function
  should perform the following:
    1. retrieve the values of the text boxes 'id', 'name', 
    'contactno' and 'email' into local variables.
    2. create and populate a new student JSON object having the following 
     structure with the values retrieved from the textboxes
     in the previous step:
     ```
    {
        name: <value>,
        contactno: <value>,
        email: <value>
    }
    ```
    3. Using fetch API, send a PUT request to the API
     `http://localhost:3000/students/{id}` where id
     is the retrieved id in the first step  by passing
     the student JSON object populated (containing the
     updated student data) in the previous step.
  4. Perform exception handling

    > Important: DO NOT call event.preventDefault() function as it will fail the test cases.


## Instructions 
   
 1. `public/js/app.js` is expected to have the following function -  
 	a. `fetchStudentDetailsFromDB()` - To fetch the data from the API and displaying the same in `index.html` page by calling `addToHTML()` function.
  
    b. `addToHTML()` - to populate the table body with the data retrieved from the API. This function will be called by the `fetchStudentDetailsFromDB()` function. 
    
    c. `addStudentToDB()` - to add a new student details using fetch API `POST` method call.

    d. `updateStudent(student)` - This function displays the update modal dialog box and also
  populates the textboxes containing student id, student name, contact number and email with the value captured from the object passed as parameter.
    
    e. `updateStudenToDB()` - to update an existing student details using Fetch API `PUT` method call.
	
 2. Test cases for the assignment shall be found in `./test` directory which validates the solution and you shall ensure that all of them pass locally before you submit your code for an automated review (steps shared below)  
	To run test cases locally, you shall execute -  
	`npm install` (if not done already)  
	`npm run test`  
 3. You shall also fix any eslint errors if present in code. To run eslint check locally, you shall execute `npm run eslint`  
 4. Once you have fixed all test cases and eslint errors locally, you shall submit your solution for the automated review as described below. 
 
## Submitting your solution for preliminary automated review  

 1. Open https://hobbes-cts.stackroute.in/#/ and login into the platform  
 2. Under Assignment repository select `js_fetch_api_update_exercise`, and branch master  
 3. Under Your solution repository select your own repository and branch  
 4. Press Submit  
 5. Press click here for the feedback  
 6. Evaluation will take around 2 mins to complete after which you need to refresh your browser and get the updated status  
 7. Watch out for your total score and detailed status on each test and eslint errors in the coloured blocks on the screen  
 8. Fix failing test cases as well as eslint errors and re-submit your solution until you get 100%  
 
## MENTORS TO BEGIN REVIEW YOUR WORK ONLY AFTER ->

- You add the respective Mentor as a Reporter/Master into your Assignment Repository

- You have checked your Assignment on the Automated Evaluation Tool - Hobbes (Check for necessary steps in your Boilerplate - README.md file. ) and got the required score - Check with your mentor about the Score you must achieve before it is accepted for Manual Submission.

- Intimate your Mentor on Slack and/or Send an Email to learner.support@stackroute.in - with your Git URL - Once you are done working and are ready for final submission.
 

