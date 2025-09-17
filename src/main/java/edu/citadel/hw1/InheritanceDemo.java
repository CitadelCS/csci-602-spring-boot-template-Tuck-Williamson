package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class InheritanceDemo {
    public static void main(String[] args) {
        // Create some hourly employees
        HourlyEmployee hr_employee_1 = new HourlyEmployee("John Doe", LocalDate.of(2009, 5, 21), 50.5, 160.0);
        HourlyEmployee hr_employee_2 = new HourlyEmployee("Jane Doe", LocalDate.of(2005, 9, 1), 150.5, 80.0);

        // Create some salaried employees
        SalariedEmployee sal_employee_1 = new SalariedEmployee("Moe Howard", LocalDate.of(2004, 1, 1), 75000.0);
        SalariedEmployee sal_employee_2 = new SalariedEmployee("Curly Howard", LocalDate.of(2018, 1, 1), 105000.0);

        // Create a list of all employees
        ArrayList<Employee> employees = new ArrayList<>(Arrays.asList(hr_employee_1, hr_employee_2, sal_employee_1, sal_employee_2));

        // Print out the list of employees before sorting.
        System.out.println("List of Employees (before sorting)");
        employees.forEach(System.out::println);
        System.out.println();

        // Print out the list of employees after sorting.
        Collections.sort(employees);
        System.out.println("List of Employees (after sorting)");
        employees.forEach(System.out::println);
        System.out.println();

        // Compute the total monthly pay for all employees and print the individual monthly pay followed by the total.
        double totalPay = 0.0;
        for (Employee employee : employees) {
            totalPay += employee.getMonthlyPay();
            System.out.printf("%s: $%,.2f\n", employee.getName(), employee.getMonthlyPay());
        }
        System.out.printf("Total Monthly Pay: $%,.2f", totalPay);
    }
}
