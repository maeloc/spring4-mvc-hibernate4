package com.websystique.springmvc.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.websystique.springmvc.dao.EmployeeDao;
import com.websystique.springmvc.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	private Employee emp1;
	private Employee emp2;
	
	@Before
	public void setUp() throws Exception {
		emp1 = new Employee.EmployeeBuilder(1).withName("Lorreine Pascale")
				.withJoiningDate(new LocalDate("2012-04-28"))
				.withSalary(new BigDecimal(26000.99))
				.withSsn("0005")
				.build();
		
		emp2 = new Employee.EmployeeBuilder(1).withName("Manolo García")
				.withJoiningDate(new LocalDate("2015-01-31"))
				.withSalary(new BigDecimal(29000.99))
				.withSsn("0006")
				.build();
	}
	
	@Mock
	private EmployeeDao dao;
	
	@InjectMocks
	private EmployeeService service = new EmployeeServiceImpl();

	@Test
	public final void findById_ShouldReturnOne () {

		when(dao.findById(1)).thenReturn(emp1);
		
		assertEquals("Lorreine Pascale", service.findById(1).getName());
		verify(dao).findById(1);
	}
	
	@Test
	public final void findBySsn_ShouldReturnOne () {
		
		when(dao.findEmployeeBySsn("0005")).thenReturn(emp1);
		
		assertEquals("Lorreine Pascale", service.findBySsn("0005").getName());
		verify(dao).findEmployeeBySsn("0005");
	}

	@Test
	public final void findAllEmployees_ShouldReturnTwo () {
		
		List<Employee> employees = Arrays.asList(emp1, emp2);
		
		when(dao.findAllEmployees()).thenReturn(employees);
		
		assertEquals("findAllEmployees should return two employees", 2, service.findAllEmployees().size());
		verify(dao).findAllEmployees();
	}
	

}
