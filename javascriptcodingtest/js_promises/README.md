# Working With Promises in JavaScript Exercise

## Objective

The Objective of this assignment is to understand working Promises in JavaScript.  

## Prerequisites

1. Fork this boilerplate repository  
2. Clone the boilerplate repository and cd into it  
3. Install dependencies. 

```
  npm install
```

## Coding Guidelines
  
1. All your JavaScript code resides in the `./js` folder  
2. Javascript code should be well indented and commented  
3. The Assignment should be pushed to gitlab on completion and submitted for Preliminary Automated Review as described below.  
  
## Exercise

1. Create a function `getAppraisalPct()` which accepts the BSC(Balanced Score Card) score of an employee and returns a Promise:

    Under the following situations, the promise will be resolved and the Promise with message will have to be returned:

    1. BSC > 100 - `'20% hike to be given'`
    2. BSC between 90 to 99 - `'10% hike to be given'`
    3. BSC between 85 to 89 - `'5% hike to be given'`
## Instructions 
   
 1. `js/app.js` is expected to have the following function -  
 	a. `getAppraisalPct()` - to evaluate the appraisal outcome('% of hike') based on BSC score and return the same as promise 
	
 2. Test cases for the assignment shall be found in `./test` directory which validates the solution and you shall ensure that all of them pass locally before you submit your code for an automated review (steps shared below)  
	To run test cases locally, you shall execute -  
	`npm install` (if not done already)  
	`npm run test`  
 3. You shall also fix any eslint errors if present in code. To run eslint check locally, you shall execute `npm run eslint`  
 4. Once you have fixed all test cases and eslint errors locally, you shall submit your solution for the automated review as described below. 
 
## Submitting your solution for preliminary automated review  

 1. Open https://hobbes-cts.stackroute.in/#/ and login into the platform  
 2. Under Assignment repository select `javascript-promises-exercise`, and branch master  
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
 

