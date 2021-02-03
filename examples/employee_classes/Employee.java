import java.util.Scanner;

public class Employee
{
    private int empId;
    private String empName;
    private double empSalary;
    private double annualSalary;
    
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public double getAnnualSalary() {
        setAnnualSalary();
        return annualSalary;
    }

    private void setAnnualSalary() {
        double annual = empSalary*12;
        this.annualSalary = annual;
    }

    public Employee(int empId, String empName, double empSalary) {
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public Employee() {
    }

    public Employee[] acceptEmployeeDetails()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees : ");
        int n = sc.nextInt();
        Employee[] emplist = new Employee[n];

        for(int i = 0;i<n;i++)
        {
            //emplist -> objects of employee
           // Employee emp = new Employee();
            emplist[i] = new Employee();
            System.out.println("Enter emp Id : ");
            emplist[i].setEmpId(sc.nextInt());
            System.out.println("Enter Emp name : ");
            emplist[i].setEmpName(sc.next());
            System.out.println("Enter emp salary : ");
            emplist[i].setEmpSalary(sc.nextDouble());

           // emplist[i] = emp;
        }
        return emplist;
    }

}