package com.ali.fitness.Fit_Account.account.api.create;

import com.ali.fitness.Fit_Account.account.api.dto.request.AccountRequestDTO;
import com.ali.fitness.Fit_Account.FitAccountApplicationTests;
import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;


public class CreateAccountAPITest extends FitAccountApplicationTests {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTestClient restClient;


    /**
     * Test the Happy Case Senior For Create Employee
     * Result: Employee Created Successfully
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Prepare Create Employee Request
        final AccountCreationRequest request = AccountRequestDTO.normalFlow();

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


        restClient.post()
                .uri("/v1/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestDetails)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);


//        // Get the Actual Created Employee
//        final Employee actualEmployee = employeeService.findByIdentificationValueAndType(request.getIdentificationValue(),
//                request.getIdentificationType());
//
//
//        // Create the Excepted Employee
//        final Employee exceptedEmployee = Employee.builder()
//                .employeeNo(actualEmployee.getEmployeeNo())
//                .firstName(request.getFirstName().toUpperCase())
//                .lastName(request.getLastName().toUpperCase())
//                .status(EmployeeStatus.ACTIVE.name())
//                .department(Department.builder()
//                        .code(request.getDeptCode())
//                        .build())
//                .build();
//
//        // Assert the Result is True ( actualEmployee == exceptedEmployee)
//        assertThat(actualEmployee.equals(exceptedEmployee))
//                .isTrue();

    }
}
