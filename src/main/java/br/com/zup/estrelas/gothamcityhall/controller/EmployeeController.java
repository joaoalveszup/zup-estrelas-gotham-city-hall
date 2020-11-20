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

import br.com.zup.estrelas.gothamcityhall.dto.EmployeeDTO;
import br.com.zup.estrelas.gothamcityhall.dto.ResponseDTO;
import br.com.zup.estrelas.gothamcityhall.entity.Employee;
import br.com.zup.estrelas.gothamcityhall.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO createSecretariat(@RequestBody EmployeeDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping(path = "/{idEmployee}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Employee readEmployee(@PathVariable Long idEmployee) {
        return employeeService.readEmployee(idEmployee);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> listSecretariat() {
        return employeeService.listEmployee();
    }

    @PutMapping(path = "/{idEmployee}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO updateEmployee(@PathVariable Long idEmployee,
            @RequestBody EmployeeDTO employee) {
        return employeeService.updateEmployee(idEmployee, employee);
    }

    @DeleteMapping(path = "/{idEmployee}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseDTO deleteEmployee(@PathVariable Long idEmployee) {
        return employeeService.deleteEmployee(idEmployee);
    }

}
