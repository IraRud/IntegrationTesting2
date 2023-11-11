package com.example.integrationtesting2.DTO;

import com.example.integrationtesting2.pojo.Employee;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDTO implements Serializable {
    private Integer id;
    private String name;
    private int salary;
    private Integer department;
    private PositionDTO positionDTO;


    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setPositionDTO(PositionDTO.fromPosition(employee.getPosition()));
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setId(this.getId());
        employee.setName(this.getName());
        employee.setSalary(this.getSalary());
        employee.setPosition(this.getPositionDTO().toPosition());
        employee.setDepartment(this.getDepartment());
        return employee;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                ", position=" + positionDTO +
                '}';
    }
}