package br.com.zup.estrelas.gothamcityhall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.SecretariatDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.service.ISecretariatService;

@RestController
@RequestMapping("/secretariats")
public class SecretariatController {

    @Autowired
    ISecretariatService secretariatService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO createSecretariat(@RequestBody SecretariatDTO secretariat) {
        return secretariatService.createSecretariat(secretariat);
    }

    @GetMapping(path = "/{idSecretariat}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Secretariat readSecretariat(@PathVariable Long idSecretariat) {
        return secretariatService.readSecretariat(idSecretariat);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Secretariat> listSecretariats() {
        return secretariatService.listSecretariats();
    }

    @PutMapping(path = "/{idSecretariat}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO updateSecretariat(@PathVariable Long idSecretariat,
            @RequestBody SecretariatDTO secretariat) {
        return secretariatService.updateSecretariat(idSecretariat, secretariat);
    }

    @DeleteMapping(path = "/{idSecretariat}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO deleteSecretariat(@PathVariable Long idSecretariat) {
        return secretariatService.deleteSecretariat(idSecretariat);
    }

}
