package com.example.integrationtesting2.repository;

import com.example.integrationtesting2.pojo.ReportWithPath;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportWithPathRepository extends CrudRepository<ReportWithPath, Integer> {

    List<ReportWithPath> findAll();

    @Override
    Optional<ReportWithPath> findById(Integer integer);
}
