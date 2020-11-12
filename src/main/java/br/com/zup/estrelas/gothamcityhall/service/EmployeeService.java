package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.gothamcityhall.dto.EmployeeDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Employee;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.repository.EmployeeRepository;
import br.com.zup.estrelas.gothamcityhall.repository.SecretariatRepository;

@Service
public class EmployeeService implements IEmployeeService {

	private static final String DOES_EXIST = "THIS EMPLOYEE ALREADY EXISTS";
	private static final String DOES_NOT_EXIST = "THIS EMPLOYEE DOES NOT EXIST";
	private static final String ONE_OR_OTHER_DOES_NOT_EXIST = "THIS SECRETARIAT OR THIS EMPLOYEE DOES NOT EXIST";
	private static final String SUCCESSFULLY_CREATED = "THE EMPLOYEE WAS SUCCESSFULLY HIRED";
	private static final String SUCESSFULLY_DELETED = "THE EMPLOYEE WAS SUCCESSFULLY DELETED";
	private static final String SUCESSFULLY_UPDATED = "THE EMPLOYEE WAS SUCCESSFULLY UPDATED";
	private static final String INSUFFICIENT_PAYROLL_BUDGET = "THE SECRETARIAT HAS NO BUDGET TO ACCEPT THIS EMPLOYEE";

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	SecretariatRepository secretariatRepository;

	public ResponseDTO createEmployee(EmployeeDTO employeeDTO) {

		Optional<Employee> employee = employeeRepository.findByCpf(employeeDTO.getCpf());
		if (employee.isPresent()) {
			return new ResponseDTO(DOES_EXIST);
		}

		Optional<Secretariat> secretariat = secretariatRepository.findById(employeeDTO.getSecretariat());
		Secretariat analizedSecretariat = secretariat.get();
		boolean isPayRollBudgetSufficient = analizedSecretariat.getPayrollBudget() - employeeDTO.getSalary() >= 0;
		
		if (!isPayRollBudgetSufficient) {
			return new ResponseDTO(INSUFFICIENT_PAYROLL_BUDGET);
		}
		
		this.storesEmployee(analizedSecretariat, employeeDTO);
		
		return new ResponseDTO(SUCCESSFULLY_CREATED);
	}

	public Employee readEmployee(Long idEmployee) {
		return employeeRepository.findById(idEmployee).orElse(null);
	}

	public List<Employee> listEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public ResponseDTO updateEmployee(Long idEmployee, EmployeeDTO employeeDTO) {
		
		Optional<Employee> employee = employeeRepository.findById(idEmployee);
		Optional<Secretariat> secretariat = secretariatRepository.findById(employeeDTO.getSecretariat());
		
		if (employee.isEmpty() || secretariat.isEmpty()) {
			return new ResponseDTO(ONE_OR_OTHER_DOES_NOT_EXIST);
		}
		
		Secretariat analizedSecretariat = secretariat.get();
		boolean isPayRollBudgetSufficient = analizedSecretariat.getPayrollBudget() - employeeDTO.getSalary() >= 0;
		
		if (!isPayRollBudgetSufficient) {
			return new ResponseDTO(INSUFFICIENT_PAYROLL_BUDGET);
		}
		
		this.storesUpdatedEmployee(analizedSecretariat, employeeDTO, employee);
		
		return new ResponseDTO(SUCESSFULLY_UPDATED);
	}

	public ResponseDTO deleteEmployee(Long idEmployee) {

		if (employeeRepository.existsById(idEmployee)) {
			employeeRepository.deleteById(idEmployee);
			
			return new ResponseDTO(SUCESSFULLY_DELETED);
		}
		
		return new ResponseDTO(DOES_NOT_EXIST);
	}
		
	private void storesEmployee(Secretariat secretariat, EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();
		
		employee.setName(employeeDTO.getName());
		employee.setCpf(employeeDTO.getCpf());
		employee.setSalary(employeeDTO.getSalary());
		employee.setSecretariat(secretariat);
		employee.setRole(employeeDTO.getRole());
		employee.setPermanent(employeeDTO.isPermanent());
		
		employeeRepository.save(employee);
		
	}
	
	private void storesUpdatedEmployee(Secretariat secretariat, EmployeeDTO employeeDTO, Optional<Employee> analizedEmployee) {
		
		Employee updatedEmployee = analizedEmployee.get();
		
		updatedEmployee.setName(employeeDTO.getName());
		updatedEmployee.setCpf(employeeDTO.getCpf());
		updatedEmployee.setSalary(employeeDTO.getSalary());
		updatedEmployee.setSecretariat(secretariat);
		updatedEmployee.setRole(employeeDTO.getRole());
		updatedEmployee.setPermanent(employeeDTO.isPermanent());
		
		employeeRepository.save(updatedEmployee);
		
	}
	
}
