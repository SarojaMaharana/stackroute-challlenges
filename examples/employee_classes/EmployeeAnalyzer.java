public class EmployeeAnalyzer {
  
public double findAverageSalary(Employee[] empArray)
{
    double avgSal = 0;
    for(int i = 0 ; i< empArray.length;i++)
    {
        avgSal = empArray[i].getAnnualSalary()/empArray.length;
    }
return avgSal;
}

public double findHighestSalary(Employee[] empArray)
{
    double highestSalary = 0;
    for(int i = 0 ; i< empArray.length;i++)
    {
        highestSalary = empArray[i].getAnnualSalary();
        if(empArray[i].getAnnualSalary() > highestSalary)
        {
            highestSalary = empArray[i].getAnnualSalary();
        }
    }
    return highestSalary;
}

public void displayEmployees(Employee[] empArray)
{
    for(Employee employee : empArray)
        System.out.println(employee.getEmpId() +" "+employee.getEmpName()+" "+employee.getEmpSalary()+" "+employee.getAnnualSalary());
}
}
