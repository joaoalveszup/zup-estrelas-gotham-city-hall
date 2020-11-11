package br.com.zup.estrelas.gothamcityhall.service;

import java.util.List;

import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.SecretariatDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;

public interface ISecretariatService {

	public ResponseDTO createSecretariat(SecretariatDTO secretariatDTO);
	
	public Secretariat readSecretariat(Long idSecretariat);
	
	public List<Secretariat> listSecretariats();

	public ResponseDTO updateSecretariat(Long idSecretariat, SecretariatDTO secretariat);
	
	public ResponseDTO deleteSecretariat(Long idSecretariat);
	
}
