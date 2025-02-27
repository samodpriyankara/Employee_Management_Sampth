import { Component } from '@angular/core';
import { Employee } from '../employee/employee.modal';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.scss'
})
export class SearchComponent {

  constructor(private employeeService: EmployeeService,
    private router: Router
  ) {

  }


  clickedEmployee: Employee = {
    id: 0,
    firstName: '',
    lastName: '',
    email: '',
    salary: 0
  }

  edit(id: any) {
    this.getEmployee(id);
  }

  getEmployee(employeeForm: NgForm): void {
    this.employeeService.getEmployee(this.clickedEmployee.id).subscribe(
      {
        next: (res: Employee) => {
          this.clickedEmployee = res;
          console.log(res);
        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }
    )
  }

}
