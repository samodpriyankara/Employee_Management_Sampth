package com.employee.employee.service;

import com.employee.employee.dto.paginated.PaginatedEmployees;
import com.employee.employee.dto.request.EmpSaveReqDto;
import com.employee.employee.dto.request.EmpUpdateReqDto;
import com.employee.employee.dto.response.EmpResponseDto;

import java.util.List;

public interface EmployeeService {
    EmpResponseDto saveEmployee(EmpSaveReqDto empSaveReqDto);

    List<EmpResponseDto> getEmployees();

    EmpResponseDto getEmployee(long employeeId);

    String deleteEmployee(long employeeId);

    EmpResponseDto updateEmployee(EmpUpdateReqDto empUpdateReqDto);

    PaginatedEmployees getEmployeesPage(int page, int size);
}
