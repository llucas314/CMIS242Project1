package com.lorenzolucas.employeesalary;
/**
 * Purpose: This class creates the executive subclass of the employee class.
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since November 3, 2018
 */
public class Executive extends Employee {
    private int stockPrice;

    // constructor
    public Executive(String name, int salary, int stockPrice){
        super(name, salary);
        this.stockPrice = stockPrice;
    }

    /**
     * Calculates the annual salary for executives and adds an additional $30,000 if stock prices are over $50.
     * @return annual salary with optional bonus
     */
    public int annualSalary(){
        int annualSalary = (getSalary() * 12);
        if (stockPrice > 50){
            annualSalary += 30000;
        }
        return annualSalary;
    }

    // convert variables to string
    public String toString(){
        return "(Executive) " + super.toString() + ", Stock Price:  $" + stockPrice;

    }
}
