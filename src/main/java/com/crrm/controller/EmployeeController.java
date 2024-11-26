package com.crrm.controller;


import com.crrm.entity.Employee;
import com.crrm.payload.EmployeeDto;
import com.crrm.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Employee")
public class EmployeeController {

private EmployeeService employeeService;
public EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
    }

//    @PostMapping("/add")
//    public ResponseEntity<Employee> addEmployee(
//            @RequestBody Employee employee
//    ){
//      Employee emp =  employeeService.addEmployee(employee);
//        return new ResponseEntity<>(emp, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(
            @Valid  @RequestBody EmployeeDto dto,
            BindingResult result
    ){
    if(result.hasErrors()){
        return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
        EmployeeDto employeedto =  employeeService.addEmployee(dto);
        return new ResponseEntity<>(employeedto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/v1/Employee?id=1

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(
            @RequestParam Long id
    ){
    employeeService.deleteEmployee(id);
    return new ResponseEntity<>("deleted",HttpStatus.OK);
    }
//    @PutMapping
//    public ResponseEntity<String> updateEmployee(
//            @RequestParam Long id,
//            @RequestBody EmployeeDto dto){
//        employeeService.updateEmployee(id,dto);
//        return new ResponseEntity("updated",HttpStatus.OK);
//    }

        @PutMapping
    public ResponseEntity<EmployeeDto> updateEmployee(
            @RequestParam Long id,
            @RequestBody EmployeeDto dto){
       EmployeeDto employeeDto =  employeeService.updateEmployee(id,dto);
        return new ResponseEntity(employeeDto,HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<List <Employee>> getEmployee(){
//        List<Employee> employees = employeeService.getEmployee();
//        return new ResponseEntity<>(employees,HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List <EmployeeDto>> getEmployee(

            @RequestParam(name="PageNo",required=false,defaultValue="0") int PageNo,
            @RequestParam(name="PageSize",required=false,defaultValue="5") int PageSize,
            @RequestParam(name="SortBy",required=false,defaultValue="name") String SortBy,
            @RequestParam(name="SortDir",required=false,defaultValue="asc")String SortDir
    ){
        List<EmployeeDto> employeesDto = employeeService.getEmployee(PageNo,PageSize,SortBy,SortDir);
        return new ResponseEntity<>(employeesDto,HttpStatus.OK);
    }
    //http://localhost:8080/api/v1/Employee/EmployeeId/3
    @GetMapping("/EmployeeId/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable long empId
    ){
    EmployeeDto dto = employeeService.getEmployeeById(empId);
    return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
