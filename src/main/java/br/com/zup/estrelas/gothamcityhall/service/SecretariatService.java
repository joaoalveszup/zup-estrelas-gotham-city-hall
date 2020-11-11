package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.SecretariatDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.repository.SecretariatRepository;

@Service
public class SecretariatService implements ISecretariatService {

	private static final String DOES_EXIST = "THIS SECRETARIAT ALREADY EXISTS";
	private static final String DOES_NOT_EXIST = "THIS SECRETARIAT DOES NOT EXIST";
	private static final String SUCCESSFULLY_CREATED = "THE SECRETARIAT WAS SUCCESSFULLY CREATED";
	private static final String SUCESSFULLY_DELETED = "THE SECRETARIAT WAS SUCCESSFULLY DELETED";
	private static final String SUCESSFULLY_UPDATED = "THE SECRETARIAT WAS SUCCESSFULLY UPDATED";

	@Autowired
	SecretariatRepository secretariatRepository;

	public ResponseDTO createSecretariat(SecretariatDTO secretariatDTO) {

		Optional<Secretariat> secretariat = secretariatRepository.findByDepartment(secretariatDTO.getDepartment());

		if (secretariat.isEmpty()) {

			Secretariat createdSecretariat = new Secretariat();
			BeanUtils.copyProperties(secretariatDTO, createdSecretariat);

			secretariatRepository.save(createdSecretariat);
			return new ResponseDTO(SUCCESSFULLY_CREATED);
		}

		return new ResponseDTO(DOES_EXIST);
	}

	public Secretariat readSecretariat(Long idSecretariat) {
		return secretariatRepository.findById(idSecretariat).orElse(null);
	}

	public List<Secretariat> listSecretariats() {
		return (List<Secretariat>) secretariatRepository.findAll();
	}

	public ResponseDTO updateSecretariat(Long idSecretariat, SecretariatDTO secretariatDTO) {

		Optional<Secretariat> secretariat = secretariatRepository.findById(idSecretariat);

		if (secretariat.isPresent()) {

			Secretariat updatedSecretariat = secretariat.get();

			updatedSecretariat.setDepartment(secretariatDTO.getDepartment());
			updatedSecretariat.setProjectBudget(secretariatDTO.getProjectBudget());
			updatedSecretariat.setPayrollBudget(secretariatDTO.getPayrollBudget());
			updatedSecretariat.setAddress(secretariatDTO.getAddress());
			updatedSecretariat.setSite(secretariatDTO.getSite());
			updatedSecretariat.setEmail(secretariatDTO.getEmail());

			secretariatRepository.save(updatedSecretariat);
			return new ResponseDTO(SUCESSFULLY_UPDATED);
		}

		return new ResponseDTO(DOES_NOT_EXIST);
	}

	public ResponseDTO deleteSecretariat(Long idSecretariat) {

		if (secretariatRepository.existsById(idSecretariat)) {
			secretariatRepository.deleteById(idSecretariat);
			return new ResponseDTO(SUCESSFULLY_DELETED);
		}

		return new ResponseDTO(DOES_NOT_EXIST);
	}

}
