import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Employee, StandResponse } from './employee/employee.modal';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http: HttpClient) { }

  apiUrl = "http://localhost:8080/api/v1/employee";

  public saveEmployee(employee: Employee): Observable<Employee> {
    return this.http.post<Employee>(`${this.apiUrl}/save`, employee);
  }

  public getEmployees(): Observable<Employee[]> {
   
    return this.http.get<StandResponse<Employee[]>>(`${this.apiUrl}/employees`).pipe(
      map(response => response.data) 
    );
  }

  public deleteEmployee(employeeId: number): Observable<string> {
    return this.http.delete<string>(`${this.apiUrl}/delete/${employeeId}`);

  }

  public updateEmployee(employee: Employee): Observable<Employee> {
    return this.http.put<StandResponse<Employee>>(`${this.apiUrl}/update`, employee).pipe(
      map(response => response.data)
    );

  }

  public getEmployee(id : number): Observable<Employee> {
   
    return this.http.get<StandResponse<Employee>>(`${this.apiUrl}/employee/${id}`).pipe(
      map(response => response.data) 
    );
  }
}
