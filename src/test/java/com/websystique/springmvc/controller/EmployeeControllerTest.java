package com.websystique.springmvc.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.websystique.springmvc.model.Employee;
import com.websystique.springmvc.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private EmployeeController controller;
	
	@Mock
	private EmployeeService employeeServiceMock;
	
	@Before
	public void setUp() throws Exception {
		//We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
		Mockito.reset(employeeServiceMock);
		
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build(); 
	}

	@Test
	public void listEmployees_ShouldAddAllEmployeesToModelAndRenderAllEmployeesViewTest() throws Exception {
		// Arrange the mock behaviour
		Employee employee1 = new Employee(1, "Lorreine Pascale", new LocalDate("2012-04-28"), new BigDecimal(26000.99), "0005");
		Employee employee2 = new Employee(1, "Julius", new LocalDate("2015-03-23"), new BigDecimal(29000.99), "0006");
		
		Mockito.when(employeeServiceMock.findAllEmployees()).thenReturn(Arrays.asList(employee1, employee2));
		
		// Act (perform the mvc request) and Assert results
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			;
			
		verify(employeeServiceMock, times(1)).findAllEmployees();
		verifyNoMoreInteractions(employeeServiceMock);
	}

}
