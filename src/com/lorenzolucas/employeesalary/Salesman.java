package com.lorenzolucas.employeesalary;
/**
 * Purpose: This class creates the salesman subclass of the employee class.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since November 3, 2018
 */
public class Salesman extends Employee {
    private int annualSales;
    // constructor
    public Salesman(String firstName, int salary, int annualSales){
        super(firstName, salary);
        this.annualSales = annualSales;
    }

    /**
     * Calculates annual salary, adding a higher bonus for sales of $20,000 or more.
     * @return annual salary with bonus
     */
    public int annualSalary(){
        double commission = 0.0;
        if (annualSales <= 20000) {
            commission = (annualSales * .02);
        } else {
            commission = (20000 * .02);
        }
        int annualSalary = (getSalary() * 12) + (int)commission;
        return annualSalary;
    }

    // convert variables to string
    public String toString(){
        return "(Salesman) " + super.toString() + ", Annual Sales:  $" + annualSales;
    }
}
