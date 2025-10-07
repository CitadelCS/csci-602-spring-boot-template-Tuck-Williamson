package edu.citadel.hw1;

import java.time.LocalDate;
import java.util.Objects;

public class HourlyEmployee extends Employee{
    private double wageRate;
    private double hoursWorked;

    public HourlyEmployee(String name, LocalDate hireDate, double wageRate, double hoursWorked) {
        super(name, hireDate);
        this.wageRate = wageRate;
        this.hoursWorked = hoursWorked;
    }

    public double getWageRate() {
        return wageRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double getMonthlyPay() {
        return wageRate * hoursWorked;
    }

    public String toString() {
        return String.format("HourlyEmployee[name=%s, hireDate=%s, wageRate=$%.2f, hoursWorked=%.2f]", getName(), getHireDate(), getWageRate(), getHoursWorked());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HourlyEmployee){
            HourlyEmployee other = ((HourlyEmployee) obj);
            return super.equals(other) && this.wageRate == other.wageRate && this.hoursWorked == other.hoursWorked;
        }
        else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHireDate(), getWageRate(), getHoursWorked());
    }
}
