package com.example.integrationtesting2.DTO;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeFullInfo {
    private String name;
    private int salary;
    private String positionName;

    @Override
    public String toString() {
        return "EmployeeFullInfo{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}