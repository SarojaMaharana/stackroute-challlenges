/*
1.	Create the following function using functional programming
       Create a function which takes employee array and return the 
       employee who is having more salary      

*/ 
function findEmployee(emp) {
       if(!Array.isArray(emp))
              throw 'Input must be an Array of employees'
       var tempIndex = 0
       var tempMaxSalary = 0
       for(var i=0; i<emp.length; i++){
              var tempObjKeys = Object.keys(emp[i])
              if(tempObjKeys.length < 3)
                     throw 'Array must contain employee objects with salary key'
              else if(tempMaxSalary < emp[i].salary){
                     tempMaxSalary = emp[i].salary
                     tempIndex = i
              }
       }
       return emp[tempIndex]
}

module.exports = findEmployee;
