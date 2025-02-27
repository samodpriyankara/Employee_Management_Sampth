package com.employee.employee.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpSaveReqDto {

    private String firstName;
    private String lastName;
    private String email;
    private double salary;
}
