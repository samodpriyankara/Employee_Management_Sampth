package com.employee.employee.util.mapper;

import com.employee.employee.dto.request.EmpSaveReqDto;
import com.employee.employee.dto.request.EmpUpdateReqDto;
import com.employee.employee.dto.response.EmpResponseDto;
import com.employee.employee.entity.Employee;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee dtoToEntity(EmpSaveReqDto empSaveReqDto);

    EmpResponseDto entityToDto(Employee employee);

    List<EmpResponseDto> entityListToDtoList(List<Employee> employees);

    Employee dtoUpdateToEntity(EmpUpdateReqDto empUpdateReqDto);

    List<EmpResponseDto> entityPageTodtoList(Page<Employee> employees);
}
