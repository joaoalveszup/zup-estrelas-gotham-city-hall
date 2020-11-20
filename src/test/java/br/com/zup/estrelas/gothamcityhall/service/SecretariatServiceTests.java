package br.com.zup.estrelas.gothamcityhall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.dto.SecretariatDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Employee;
import br.com.zup.estrelas.gothamcityhall.entity.Project;
import br.com.zup.estrelas.gothamcityhall.entity.Secretariat;
import br.com.zup.estrelas.gothamcityhall.enums.Department;
import br.com.zup.estrelas.gothamcityhall.repository.SecretariatRepository;

@RunWith(MockitoJUnitRunner.class)
public class SecretariatServiceTests {

    private static final String DOES_EXIST = "THIS SECRETARIAT ALREADY EXISTS";
    private static final String DOES_NOT_EXIST = "THIS SECRETARIAT DOES NOT EXIST";
    private static final String SUCCESSFULLY_CREATED = "THE SECRETARIAT WAS SUCCESSFULLY CREATED";
    private static final String SUCESSFULLY_UPDATED = "THE SECRETARIAT WAS SUCCESSFULLY UPDATED";
    private static final String SUCESSFULLY_DELETED = "THE SECRETARIAT WAS SUCCESSFULLY DELETED";

    @Mock
    SecretariatRepository secretariatRepository;

    @InjectMocks
    SecretariatService secretariatService;

    @Test
    public void shouldCreateSecretariat() {

        SecretariatDTO secretariatDTO = new SecretariatDTO();

        secretariatDTO.setDepartment(Department.CULTURE);
        secretariatDTO.setProjectBudget(1000.00);
        secretariatDTO.setPayrollBudget(1000.00);
        secretariatDTO.setPhoneNumber("11 11111 1111");
        secretariatDTO.setAddress("Culture St.");
        secretariatDTO.setSite("secretariatofculture.com");
        secretariatDTO.setEmail("secretariat@culture.com");

        Mockito.when(secretariatRepository.findByDepartment(secretariatDTO.getDepartment()))
                .thenReturn(Optional.empty());

        ResponseDTO returnedMessage = this.secretariatService.createSecretariat(secretariatDTO);
        ResponseDTO expectedMessage = new ResponseDTO(SUCCESSFULLY_CREATED);

        Assert.assertEquals(returnedMessage, expectedMessage);
    }

    @Test
    public void shouldNotCreateSecretariatWhenAlreadyExists() {

        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        Secretariat secretariat = new Secretariat();

        secretariat.setIdSecretariat(1L);
        secretariat.setDepartment(Department.CULTURE);
        secretariat.setProjectBudget(1000.00);
        secretariat.setPayrollBudget(1000.00);
        secretariat.setPhoneNumber("11 11111 1111");
        secretariat.setAddress("Culture St.");
        secretariat.setSite("secretariatofculture.com");
        secretariat.setEmail("secretariat@culture.com");
        secretariat.setEmployees(employees);
        secretariat.setProjects(projects);

        SecretariatDTO secretariatDTO = new SecretariatDTO();

        secretariatDTO.setDepartment(Department.CULTURE);
        secretariatDTO.setProjectBudget(1000.00);
        secretariatDTO.setPayrollBudget(1000.00);
        secretariatDTO.setPhoneNumber("11 11111 1111");
        secretariatDTO.setAddress("Culture St.");
        secretariatDTO.setSite("secretariatofculture.com");
        secretariatDTO.setEmail("secretariat@culture.com");

        Mockito.when(secretariatRepository.findByDepartment(secretariatDTO.getDepartment()))
                .thenReturn(Optional.of(secretariat));

        ResponseDTO returnedMessage = this.secretariatService.createSecretariat(secretariatDTO);
        ResponseDTO expectedMessage = new ResponseDTO(DOES_EXIST);

        Assert.assertEquals(returnedMessage, expectedMessage);
    }

    @Test
    public void shouldUpdateSecretariat() {

        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        Secretariat secretariat = new Secretariat();

        secretariat.setIdSecretariat(1L);
        secretariat.setDepartment(Department.CULTURE);
        secretariat.setProjectBudget(1000.00);
        secretariat.setPayrollBudget(1000.00);
        secretariat.setPhoneNumber("11 11111 1111");
        secretariat.setAddress("Culture St.");
        secretariat.setSite("secretariatofculture.com");
        secretariat.setEmail("secretariat@culture.com");
        secretariat.setEmployees(employees);
        secretariat.setProjects(projects);

        SecretariatDTO secretariatDTO = new SecretariatDTO();
        BeanUtils.copyProperties(secretariat, secretariatDTO);
        secretariatDTO.setDepartment(Department.HEALTH);

        Mockito.when(secretariatRepository.findById(1L)).thenReturn(Optional.of(secretariat));

        ResponseDTO returnedMessage = this.secretariatService.updateSecretariat(1L, secretariatDTO);
        ResponseDTO expectedMessage = new ResponseDTO(SUCESSFULLY_UPDATED);

        Assert.assertEquals(returnedMessage, expectedMessage);
    }

    @Test
    public void shouldNotUpdateWhenSecretariatDoNotExist() {

        SecretariatDTO secretariatDTO = new SecretariatDTO();

        // FIXME: No método update não há chamada ao existsById,
        // esse método passa pois o findById retorna um nulo, que 
        // acaba fazendo a validação passar.
         Mockito.when(secretariatRepository.existsById(Mockito.anyLong())).thenReturn(false);

        ResponseDTO returnedMessage = this.secretariatService.updateSecretariat(1L, secretariatDTO);
        ResponseDTO expectedMessage = new ResponseDTO(DOES_NOT_EXIST);

        Assert.assertEquals(returnedMessage, expectedMessage);
    }

    @Test
    public void shouldDeleteSecretariat() {

        List<Employee> employees = new ArrayList<>();
        List<Project> projects = new ArrayList<>();

        Secretariat secretariat = new Secretariat();

        secretariat.setIdSecretariat(1L);
        secretariat.setDepartment(Department.CULTURE);
        secretariat.setProjectBudget(1000.00);
        secretariat.setPayrollBudget(1000.00);
        secretariat.setPhoneNumber("11 11111 1111");
        secretariat.setAddress("Culture St.");
        secretariat.setSite("secretariatofculture.com");
        secretariat.setEmail("secretariat@culture.com");
        secretariat.setEmployees(employees);
        secretariat.setProjects(projects);

        Mockito.when(secretariatRepository.existsById(1L)).thenReturn(true);

        ResponseDTO returnedMessage = this.secretariatService.deleteSecretariat(1L);
        ResponseDTO expectedMessage = new ResponseDTO(SUCESSFULLY_DELETED);

        Assert.assertEquals(returnedMessage, expectedMessage);

    }

    @Test
    public void shouldNotDeleteSecretariatWhenSecretariatDoNotExist() {

        Mockito.when(secretariatRepository.existsById(Mockito.anyLong())).thenReturn(false);

        ResponseDTO returnedMessage = this.secretariatService.deleteSecretariat(1L);
        ResponseDTO expectedMessage = new ResponseDTO(DOES_NOT_EXIST);

        Assert.assertEquals(returnedMessage, expectedMessage);
    }
}
