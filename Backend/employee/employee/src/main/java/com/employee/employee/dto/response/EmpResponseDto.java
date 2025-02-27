package com.employee.employee.dto.response;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private double salary;
}
