package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;

import br.com.zup.estrelas.gothamcityhall.dto.EmployeeDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Employee;

public interface IEmployeeService {

	public ResponseDTO createEmployee(EmployeeDTO employeeDTO);
	
	public Employee readEmployee(Long idEmployee);
	
	public List<Employee> listEmployee();

	public ResponseDTO updateEmployee(Long idEmployee, EmployeeDTO employeeDTO);
	
	public ResponseDTO deleteEmployee(Long idEmployee);
	
}
