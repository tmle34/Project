package com.example.demo.Model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    public String EmployeeID = UUID.randomUUID().toString();
    @Column(name = "employeename")
    public String EmployeeName;
    @Column(name = "employeenum")
    public int EmployeeNum;


    public Employee(String EmployeeName, int EmployeeNum) {
        this.EmployeeName = EmployeeName;
        this.EmployeeNum = EmployeeNum;
    }
    public Employee()
    {

    }
    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String EmployeeName) {
        this.EmployeeName = EmployeeName;
    }

    public int getEmployeeNum() {
        return EmployeeNum;
    }

    public void setEmployeeNum(int EmployeeNum) {
        this.EmployeeNum = EmployeeNum;
    }
}
