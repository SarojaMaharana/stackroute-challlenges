public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee();
        EmployeeAnalyzer employeeAnalyzer = new EmployeeAnalyzer();
        Employee [] employees = employee.acceptEmployeeDetails();
        employeeAnalyzer.displayEmployees(employees);
        System.out.println("Average salary of the employees : "+employeeAnalyzer.findAverageSalary(employees));
        System.out.println("Highest salary is : "+employeeAnalyzer.findHighestSalary(employees));
    }
}
