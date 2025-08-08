package com.example.employeeservice;

public class Employee {
    private int id;
    private String name;
    private String department;
    private String source;

    public Employee() {
    }

    public Employee(int id, String name, String department, String source) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.source = source;
    }

    // Getters and Setters
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
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
}
