package com.ali.fitness.Fit_Account.account.api.create;

import com.ali.fitness.Fit_Account.account.api.dto.request.AccountRequestDTO;
import com.ali.fitness.Fit_Account.FitAccountApplicationTests;
import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.service.AccountInfoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;


public class CreateAccountAPITest extends FitAccountApplicationTests {


//    @MockitoBean
//    private AccountInfoService accountInfoService;

//    @Autowired
//    private WebTestClient webTestClient;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * Test the Happy Case Senior For Create Employee
     * Result: Employee Created Successfully
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Delete All Exists User
//        accountInfoService.deleteAll();

        // Prepare Create Employee Request
        final AccountCreationRequest request = AccountRequestDTO.normalFlow();

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);


//        webTestClient.post()
//                .uri("/api/accounts")
//                .bodyValue(requestDetails)
//                .exchange()
//                .expectStatus().isCreated()
//                .expectHeader().contentType("application/json");


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
