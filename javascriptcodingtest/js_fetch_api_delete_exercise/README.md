# Working With Fetch API to delete existing data through RESTful API in JavaScript Exercise

## Objective

The Objective of this assignment is to understand the working of Fetch API to delete existing data using a RESTful API in JavaScript.  

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
  row of a HTML table. Also, add a delete button for each row and call `deleteStudent()`
  function on `click` event of the button by the student id as a parameter.
  Finally once all the rows are added, populate the table body using `innerHTML` property 
  of the table body dynamically.
3. call `fetchStudentDetailsFromDB()` function on page load from `index.html` page.  

4. Create a function `removeStudentFromDB(id)`
  to delete an existing student data from the API
  `http://localhost:3000/students/{id}` where `id` contains the student id passed as a parameter to this function.
  On successful deletion, call the `fetchStudentDetailsFromDB()` function to
  re-populate the student list. Exception handling needs to be done.
 

    > Important: DO NOT call event.preventDefault() function as it will fail the test cases.


## Instructions 
   
 1. `public/js/app.js` is expected to have the following function -  
 	a. `fetchStudentDetailsFromDB()` - To fetch the data from the API and displaying the same in `index.html` page by calling `addToHTML()` function.
  
    b. `addToHTML()` - to populate the table body with the data retrieved from the API. This function will be called by the `fetchStudentDetailsFromDB()` function. 
    
    c. `addStudentToDB()` - to add a new student details using fetch API `POST` method call.

    d. `deleteStudenFromDB()` - to delete an existing student details using Fetch API `DELETE` method call.
	
 2. Test cases for the assignment shall be found in `./test` directory which validates the solution and you shall ensure that all of them pass locally before you submit your code for an automated review (steps shared below)  
	To run test cases locally, you shall execute -  
	`npm install` (if not done already)  
	`npm run test`  
 3. You shall also fix any eslint errors if present in code. To run eslint check locally, you shall execute `npm run eslint`  
 4. Once you have fixed all test cases and eslint errors locally, you shall submit your solution for the automated review as described below. 
 
## Submitting your solution for preliminary automated review  

 1. Open https://hobbes-cts.stackroute.in/#/ and login into the platform  
 2. Under Assignment repository select `js_fetch_api_delete_exercise`, and branch master  
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
 

