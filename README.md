# Gotham City Hall
## City secretariats manager

**Author**: *Gabriel Garcia*

**Contact**: *gabriel_garcia@zup.com.br*

**Year**: *2020*

**Note 1**: *Faaala, João. Na paz? Fiz tudo em inglês, porque você disse que tem projetos de todos os jeitos, maneiras e manias. MAAAS, o motivo principal é que Gotham City é uma cidade do Tads Unids.*

## Function

- `City secretariats manager` has as your main function the management of Gotham's secretariats as well as their employees and projects.

### How it works?

- At the beginning, we have the most vital `CRUD` operations linked by the whole system. Based on  `Spring Boot Components`, the `API` is capable of:

	#### Secretariats:
	- Create a new secretariat;
	- Update their infos;
	- Consult an existing one;
	- List all of them;
	- Remove;

	#### Employees:
	- Register a hired employee;
	- Update their infos;
	- Consult an existing employee;
	- List all of them;
	- Remove fired ones;

	#### Projects:
	- Register a project;
	- Update their descriptions;
	- Consult the actual state;
	- List all of them;
	- Set the projects done;

## Structure

### JAVA - *Spring Boot Components*

#### #Entity
- `Secretariat.java`;
- `Employee.java`;
- `Project.java`;

#### #DTO
- `SecretariatDTO.java`;
- `EmployeeDTO.java`;
- `CreateProjectDTO.java`;
- `UpdateProjectDTO.java`;
- `DoneProjectDTO.java`;

#### #Enums
- `Department.java`;

#### #Repository
- `SecretariatRepository.java`;
- `EmployeeRepository.java`;
- `ProjectRepository.java`;

#### #Service
- `ISecretariatService.java`;
- `SecretariatService.java`;
- `IEmployeeService.java`;
- `EmployeeService.java`;
- `IProjectService.java`;
- `ProjectService.java`;

#### #Controller
- `SecretariatController.java`;
- `EmployeeController.java`;
- `ProjectController.java`;

#### #Application
- `ZupEstrelasGothamCityHallApplication.java`;

### Postman - *Requests and Bodies*

#### #Secretariat
| REQUEST | URL |
|--|--|
| POST - `creatSecretariat`| localhost:8080/secretariats/ |
| GET - `readSecretariat`| localhost:8080/secretariats/{id}/ |
| GET - `listSecretariat`| localhost:8080/secretariats/ |
| PUT - `updateSecretariat`| localhost:8080/secretariats/{id}/ |
| DEL - `deleteSecretariat`| localhost:8080/secretariats/{id}/ |

#### Body Example

    {
    "department":  "CULTURE",
    "projectBudget":  "0000.00",
    "payrollBudget":  "0000.00",
    "phoneNumber":  "11 11111 1111",
    "address":  "Av. Paulista, 111",
    "site":  "secretariatofculture.com",
    "email":  "secretariat@culture.com"
    }

#### #Employee
| REQUEST | URL |
|--|--|
| POST - `createEmployee`| localhost:8080/employees/ |
| GET - `readEmployee`| localhost:8080/employees/{id}/ |
| GET - `listEmployee`| localhost:8080/employees/ |
| PUT - `updateEmployee`| localhost:8080/employees/{id}/ |
| DEL - `deleteEmployee`| localhost:8080/employees/{id}/ |

#### Body Example

    {
    "name":  "First Name",
    "cpf":  "000.000.000-00",
    "salary":  "00000.00",
    "secretariat":  "{idSecretariat}",
    "role":  "Role",
    "permanent":  false (or true)
    }

#### #Projects
| REQUEST | URL |
|--|--|
| POST - `createProject`| localhost:8080/projects/ |
| GET - `readProject`| localhost:8080/projects/{id}/ |
| GET - `listProject`| localhost:8080/projects/ |
| PUT - `updateProject`| localhost:8080/projects/descriptions/{id}/ |
| PUT - `finishProject`| localhost:8080/projects/{id}/ |

#### Body Example

*createProject*

    {
    "name":  "Estrelas",
    "description":  "Zup project",
    "cost":  "0000.00",
    "secretariat":  "{idSecretariat}"
    }

## Lincense

[The MIT License](https://opensource.org/licenses/MIT)