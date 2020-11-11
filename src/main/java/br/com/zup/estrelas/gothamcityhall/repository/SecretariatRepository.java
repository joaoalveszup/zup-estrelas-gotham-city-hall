package br.com.zup.estrelas.gothamcityhall.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.enums.Department;

@Repository
public interface SecretariatRepository extends CrudRepository<Secretariat, Long> {
	
	Optional<Secretariat> findByDepartment(Department department);
	
}
