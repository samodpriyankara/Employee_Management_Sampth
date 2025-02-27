package com.employee.employee.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandResponse {
    private int StatusCode;
    private String message;
    private Object data;
}
