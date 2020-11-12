package br.com.zup.estrelas.gothamcityhall.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.zup.estrelas.gothamcityhall.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	Optional<Employee> findByCpf(String cpf);
	
}
