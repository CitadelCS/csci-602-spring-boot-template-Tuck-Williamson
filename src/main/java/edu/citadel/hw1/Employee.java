package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Employee implements Comparable<Employee> {
    private String name;
    private LocalDate hireDate;

    public Employee(String name, LocalDate hireDate) {
        this.name = name;
        this.hireDate = hireDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    abstract public double getMonthlyPay();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getName(), employee.getName()) && Objects.equals(getHireDate(), employee.getHireDate()) && Objects.equals(getMonthlyPay(), employee.getMonthlyPay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHireDate());
    }

    @Override
    public int compareTo(Employee other) {
        return this.getMonthlyPay() < other.getMonthlyPay() ? -1 : 1;
    }
}
