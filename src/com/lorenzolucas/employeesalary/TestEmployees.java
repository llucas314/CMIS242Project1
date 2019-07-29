package com.lorenzolucas.employeesalary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Purpose: This package demonstrates the use of subclasses in java
 *
 * @author Lorenzo Lucas
 * @version 1.0
 * @since November 3, 2018
 */
public class TestEmployees {

    public static void main(String[] arg){
        // initializing variables
        int numberOfEmployees = 20;
        Scanner scanner = null;
        Employee[] employees2014 = new Employee[numberOfEmployees];
        Employee[] employees2015 = new Employee[numberOfEmployees];
        int i14 = 0;
        int i15 = 0;
        int bonus = 0;
        int sum14 = 0;
        int count14 = 0;
        int sum15 = 0;
        int count15 = 0;
        // catch for file exception
        try {
            scanner = new Scanner(new FileReader("employee.txt"));
        }
        catch (FileNotFoundException e){
            System.err.println("File not Found " + e.getMessage());
        }
        // reads the file and groups the employees into arrays based on years
        while (scanner.hasNextLine()){
            String row = scanner.nextLine();
            String[] input = row.split(" ");
            int year = Integer.parseInt(input[0]);
            String type = input[1];
            String employeeName = input[2];
            int monthSalary = Integer.parseInt(input[3]);
            if (type.equals("Salesman") || type.equals("Executive")){
                bonus = Integer.parseInt(input[4]);
            }
            if (year == 2014){
                if (type.equals("Employee")){
                    employees2014[i14] = new Employee(employeeName,monthSalary);
                }
                if (type.equals("Salesman")){
                    employees2014[i14] = new Salesman(employeeName,monthSalary,bonus);
                }
                if (type.equals("Executive")){
                    employees2014[i14] = new Executive(employeeName,monthSalary,bonus);
                }
                i14++;
            }
            if (year == 2015){
                if (type.equals("Employee")){
                    employees2015[i15] = new Employee(employeeName,monthSalary);
                }
                if (type.equals("Salesman")){
                    employees2015[i15] = new Salesman(employeeName,monthSalary,bonus);
                }
                if (type.equals("Executive")){
                    employees2015[i15] = new Executive(employeeName,monthSalary,bonus);
                }
                i15++;
            }


        }
        //prints out employee info and calculates annual average
        System.out.println("2014 Employees: ");
        for (Employee anEmployees2014 : employees2014) {
            if (anEmployees2014 != null) {
                System.out.println(anEmployees2014.toString() + ", Annual Salary: $" + anEmployees2014.annualSalary());
                sum14 += anEmployees2014.annualSalary();
                count14++;
            }
        }
        System.out.println("The average annual salary is $" + (sum14/count14) + ".");
        System.out.println("2015 Employees: ");
        for (Employee anEmployees2015 : employees2015) {
            if (anEmployees2015 != null){
                System.out.println(anEmployees2015.toString() + ", Annual Salary: $" + anEmployees2015.annualSalary());
                sum15 += anEmployees2015.annualSalary();
                count15++;
            }
        }
        System.out.println("The average annual salary is $" + (sum15/count15) + ".");
    }
}
