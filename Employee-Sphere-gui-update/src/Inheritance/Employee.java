package Inheritance;

import Interfaces.EmployeeActions;
public abstract class Employee implements Comparable<Employee>{

    protected int id;
    protected String name;
    protected String surname;
    protected double salary;
    protected double performanceScore;
    protected int departmentId;
    public static int totalEmployees = 0;

    public Employee(int id, String name, String surname, double salary, int departmentId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.departmentId = departmentId;
        totalEmployees++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    abstract void calculatePerformanceScore(int tasks, int doneTasks);

  
    @Override
    public String toString() {
        return
                "Id= " + id +
                "  Name= " + name + " "+surname +
                "\nSalary=" + String.format("%.2f", salary) +
                " Performance Score= " + String.format("%.2f", performanceScore) +
                '\n';
    }

	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		 		return (int) (o.getPerformanceScore() -getPerformanceScore() );

	}

}
