package com.crrm.service;

import com.crrm.entity.Employee;
import com.crrm.exception.ResourceNotFound;
import com.crrm.payload.EmployeeDto;
import com.crrm.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {


    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    public EmployeeService(EmployeeRepository employeeRepository,ModelMapper modelMapper){

        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


//    public Employee addEmployee(Employee employee) {
//       Employee emp =  employeeRepository.save(employee);
//       return emp;
//    }

    public EmployeeDto addEmployee(EmployeeDto dto) {
       Employee employee = MapToEntity(dto);
        Employee emp =  employeeRepository.save(employee);
        EmployeeDto employeeDto = MapToDto(emp);
//        employeeDto.setDate(new Date());
        return employeeDto;
    }

    public void deleteEmployee( long id){

        employeeRepository.deleteById(id);
    }

//    public void updateEmployee(Long id, EmployeeDto dto) {
//        Optional<Employee> opEmp = employeeRepository.findById(id);
//
//            Employee employee = opEmp.get();
//            employee.setName(dto.getName());
//            employee.setEmailId(dto.getEmailId());
//            employee.setMobile(dto.getMobile());
//            employeeRepository.save(employee);
//
//
//    }

    public EmployeeDto updateEmployee(Long id,EmployeeDto dto){
        Employee employee = MapToEntity(dto);
        employee.setId(id);
        Employee updateEmployee = employeeRepository.save(employee);
        EmployeeDto employeeDto = MapToDto(updateEmployee);
        return employeeDto;
    }

//    public List<Employee> getEmployee() {
//       return  employeeRepository.findAll();
//    }

    public List<EmployeeDto> getEmployee(int PageNo, int PageSize,String SortBy,String SortDir) {
//       List<Employee> employee= employeeRepository.findAll();

        Sort sort = SortDir.equalsIgnoreCase("asc")?Sort.by(SortBy).ascending():Sort.by(SortBy).descending();
       Pageable page = PageRequest.of(PageNo,PageSize,sort);
//
//        Pageable page = PageRequest.of(PageNo,PageSize, Sort.by(SortBy));
        Page<Employee> all = employeeRepository.findAll(page);
            List<Employee> employee = all.getContent();

       List<EmployeeDto> dto = employee.stream().map(x->MapToDto(x)).collect(Collectors.toList());
       return dto;

    }
    public EmployeeDto getEmployeeById(long empId){
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFound("Record not found with id"+ empId)
        );
         EmployeeDto dto = MapToDto(employee);
         return dto;
    }

    EmployeeDto MapToDto(Employee employee){
//        EmployeeDto dto = new EmployeeDto();
//       dto.setId(employee.getId());
//        dto.setName(employee.getName());
//        dto.setEmailId(employee.getEmailId());
//        dto.setMobile(employee.getMobile());
        EmployeeDto dto = modelMapper.map(employee, EmployeeDto.class);
        return dto;
    }
    Employee MapToEntity(EmployeeDto dto){
//        Employee employee = new Employee();
//        employee.setId(dto.getId());
//        employee.setName(dto.getName());
//        employee.setEmailId(dto.getEmailId());
//        employee.setMobile(dto.getMobile());
        Employee employee = modelMapper.map(dto, Employee.class);
        return employee;
    }

}
