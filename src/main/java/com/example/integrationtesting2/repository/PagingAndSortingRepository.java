package com.example.integrationtesting2.repository;

import com.example.integrationtesting2.pojo.Employee;

public interface PagingAndSortingRepository extends org.springframework.data.repository.PagingAndSortingRepository<Employee, Integer> {
}