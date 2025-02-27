package com.employee.employee.service.Impl;

import com.employee.employee.dto.paginated.PaginatedEmployees;
import com.employee.employee.dto.request.EmpSaveReqDto;
import com.employee.employee.dto.request.EmpUpdateReqDto;
import com.employee.employee.dto.response.EmpResponseDto;
import com.employee.employee.entity.Employee;
import com.employee.employee.exception.BadRequestException;
import com.employee.employee.exception.CustomerNotFoundException;
import com.employee.employee.repository.EmployeeRepo;
import com.employee.employee.service.EmployeeService;
import com.employee.employee.util.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public EmpResponseDto saveEmployee(EmpSaveReqDto empSaveReqDto) {
        Employee employee = employeeMapper.dtoToEntity(empSaveReqDto);
        Employee employee1 =  employeeRepo.save(employee);
        if(employeeRepo.existsById(employee1.getId())) {
            EmpResponseDto employeeResponseDto = employeeMapper.entityToDto(employee1);
            return employeeResponseDto;
        }
        throw new BadRequestException("Customer Not Saved");

    }

    @Override
    public List<EmpResponseDto> getEmployees() {
       List<Employee> employees =  employeeRepo.findAll();
       if(employees.size()>0){
        return employeeMapper.entityListToDtoList(employees);
       }else{
           throw new CustomerNotFoundException("Not Fond any employees");
       }
    }

    @Override
    public EmpResponseDto getEmployee(long employeeId) {
        if(employeeRepo.existsById(employeeId)) {
            Employee employee = employeeRepo.findById(employeeId).orElseThrow();
            EmpResponseDto employeeResponseDto = employeeMapper.entityToDto(employee);
            return employeeResponseDto;
        }else{
            throw new CustomerNotFoundException("No found Customer");
        }
    }

    @Override
    public String deleteEmployee(long employeeId) {
        if(employeeRepo.existsById(employeeId)) {
            employeeRepo.deleteById(employeeId);

            return "Deleted";
        }else{
            throw new CustomerNotFoundException("No found Customer");
        }
    }

    @Override
    public EmpResponseDto updateEmployee(EmpUpdateReqDto empUpdateReqDto) {
        Employee employee = employeeMapper.dtoUpdateToEntity(empUpdateReqDto);
        if(employeeRepo.existsById(employee.getId())) {

            EmpResponseDto employeeResponseDto = employeeMapper.entityToDto(employeeRepo.save(employee));
            return employeeResponseDto;

        }else{
            throw new CustomerNotFoundException("No found Customer");
        }
    }

    @Override
    public PaginatedEmployees getEmployeesPage(int page, int size) {
        Page<Employee> employeePage = employeeRepo.findAll(PageRequest.of(page,size));
        if(employeePage.getSize()>0){
            PaginatedEmployees paginatedEmployees = new PaginatedEmployees(
                    employeeMapper.entityPageTodtoList(employeePage),
                    employeeRepo.count()
            );
            return paginatedEmployees;
        }else{
            throw new CustomerNotFoundException("No found Items");
        }
    }
    }



