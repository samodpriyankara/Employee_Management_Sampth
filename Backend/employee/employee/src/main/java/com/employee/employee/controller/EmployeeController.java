package com.employee.employee.controller;

import com.employee.employee.dto.paginated.PaginatedEmployees;
import com.employee.employee.dto.request.EmpSaveReqDto;
import com.employee.employee.dto.request.EmpUpdateReqDto;
import com.employee.employee.dto.response.EmpResponseDto;
import com.employee.employee.service.EmployeeService;
import com.employee.employee.util.StandResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<StandResponse> saveEmployee(@RequestBody EmpSaveReqDto empSaveReqDto){
        EmpResponseDto empResponseDto = employeeService.saveEmployee(empSaveReqDto);
        return new ResponseEntity<>(new StandResponse(200,"Success",empResponseDto), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<StandResponse> getEmployees(){
        List<EmpResponseDto> empResponseDtos = employeeService.getEmployees();
        return new ResponseEntity<>(new StandResponse(200,"Success",empResponseDtos), HttpStatus.OK);
    }

    @GetMapping(path = "/employee/{id}")
    public ResponseEntity<StandResponse> getEmployee(@PathVariable(value = "id") long employeeId){
        EmpResponseDto empResponseDto = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(new StandResponse(200,"Success",empResponseDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<StandResponse> deleteEmployee(@PathVariable(value = "id") long employeeId){
        String message = employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<>(new StandResponse(200,"Success",message), HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<StandResponse> updateEmployee(@RequestBody EmpUpdateReqDto empUpdateReqDto){
        EmpResponseDto empResponseDto = employeeService.updateEmployee(empUpdateReqDto);
        return new ResponseEntity<>(new StandResponse(200,"Success",empResponseDto), HttpStatus.OK);
    }

    //Get Employees with pagination
    @GetMapping(
            path = "/employees",
            params = {"page","size"}
    )
    public ResponseEntity<StandResponse> getEmployeesPage(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size

    ){
        PaginatedEmployees paginatedEmployees = employeeService.getEmployeesPage(page,size);
        return new ResponseEntity<>(new StandResponse(200,"Success",paginatedEmployees), HttpStatus.OK);
    }
}
