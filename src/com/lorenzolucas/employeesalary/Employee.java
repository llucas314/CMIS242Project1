package com.lorenzolucas.employeesalary;
/**
 * Purpose: This class creates the employee superclass.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since November 3, 2018
 */

public class Employee {
    private String name;
    private int salary;

    // constructor
    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    /**
     * Calculates yearly wages based of off monthly pay.
     * @return annual salary
     */
    public int annualSalary(){
        return salary*12;
    }

    //getter method
    public int getSalary() {
        return salary;
    }

    /**
     * Provides string output for employee class and super of salesman and executive classes
     * @return label for employee class and basic information for salesman and executive classes
     */
    public String toString(){
        String[] nameSplit = name.split(",");
        String firstAndLast = nameSplit[1] + " " + nameSplit[0];
        if (this instanceof Salesman | this instanceof Executive){
            return "Name: " + firstAndLast + ", Monthly Salary: $" + salary;
        }
        return "(Employee) Name: " + firstAndLast + ", Monthly Salary: $" + salary;
    }
}
