package com.employee.employee.dto.paginated;

import com.employee.employee.dto.response.EmpResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginatedEmployees {
   private List<EmpResponseDto> empResponseDtoList;
   private Long count;
}
