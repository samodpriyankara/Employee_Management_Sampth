import { Component, OnInit } from '@angular/core';
import { Employee } from './employee.modal';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.scss'
})
export class EmployeeComponent implements OnInit{

  employee: Employee = {
    id : 0,
    firstName : '',
    lastName : '',
    email : '',
    salary : 0
  }

  constructor(private employeeService: EmployeeService,
    private router : Router
  ) {

  }

  ngOnInit(): void {

  }



  saveEmployee(employeeForm: NgForm): void {
    this.employeeService.saveEmployee(this.employee).subscribe(
      {
        next: (res: any) => {
          console.log(res);
          employeeForm.reset();
         
          this.router.navigate(["/"]);

        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }
    );
  }

}
