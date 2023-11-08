package com.example.integrationtesting2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.integrationtesting2.pojo.Report;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends CrudRepository<Report, Integer> {

    List<Report> findAll();

    @Override
    Optional<Report> findById(Integer integer);
}
