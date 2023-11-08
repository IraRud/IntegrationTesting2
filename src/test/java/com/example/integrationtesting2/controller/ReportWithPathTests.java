package com.example.integrationtesting2.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.example.integrationtesting2.pojo.Employee;
import com.example.integrationtesting2.pojo.Position;
import com.example.integrationtesting2.repository.EmployeeRepository;
import com.example.integrationtesting2.repository.PositionRepository;
import com.example.integrationtesting2.service.ReportWithPathService;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ReportWithPathTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ReportWithPathService reportWithPathService;


    @Test
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin1234")
    void getReport() throws Exception {
        addEmployeeListInRepository();
        mockMvc.perform(post("/reportWithPath/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(1));
    }

    @Test
    @WithMockUser(username = "admin", roles = "ADMIN", password = "admin1234")
    void getReportById() throws Exception {
        addEmployeeListInRepository();
        Integer id = reportWithPathService.addReportWithPath();
        MvcResult result = mockMvc.perform(get("/reportWithPath/{id}", id))
                .andExpect(status().isOk())
                .andReturn();
        byte[] resourceContent = result.getResponse().getContentAsByteArray();
        assertThat(resourceContent).isNotEmpty();
    }

    void addEmployeeListInRepository() {
        Position position = new Position(1, "position-1");
        Position position2 = new Position(2, "position-2");
        positionRepository.save(position);
        positionRepository.save(position2);
        List<Employee> employeeList = List.of(
                new Employee(1, "Ivan", 10000, 1, position),
                new Employee(2, "Inna", 20000, 2, position2),
                new Employee(3, "Anna", 30000, 3, position2)
        );
        employeeRepository.saveAll(employeeList);
    }

}
