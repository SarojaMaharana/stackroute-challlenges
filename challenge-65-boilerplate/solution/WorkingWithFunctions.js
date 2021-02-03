/**
 * Create the following functions
1. Create a function called calculateSalary() which takes employee salary as a parameter and increment the salary by 15% and returns the updated salary

Input:  calculateSalary(20000)
Output : 23000

Input : calculateSalary(-2000)
Output: Error : Enter valid input




 */
function calculateSalary(empSalary) {
    if(empSalary < 0){
        throw('Salary must be positive number')
    }
    if(typeof empSalary == 'string'){
        throw('Enter Valid Input')
    }
    return empSalary+((empSalary/100)*15)
}

module.exports = calculateSalary;