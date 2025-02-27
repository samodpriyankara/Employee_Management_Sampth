import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee/employee.modal';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.scss'
})
export class EmployeeListComponent implements OnInit {

  employeeToUpdate: Employee = {
    id : 0,
    firstName : '',
    lastName : '',
    email : '',
    salary : 0
  }

  edit(employee: Employee) {
   this.employeeToUpdate = employee;
  }


  dataSource: Employee[] = [];

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'email', 'salary', 'edit', 'delete'];

  constructor(private employeeService: EmployeeService,
    private router: Router
  ) {
    this.getEmployees();
  }

  ngOnInit(): void {

  }

  getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      {
        next: (res: Employee[]) => {
          this.dataSource = res;
          console.log(res);
        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }
    )
  }

  deleteEmployee(employeeId: number): void {
    this.employeeService.deleteEmployee(employeeId).subscribe(
      {
        next: (res: any) => {
          console.log(res);
          this.router.navigate(["/"]);
        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }
    )

  }

  updateEmployee(employeeEditForm: NgForm): void {
    this.employeeService.updateEmployee(this.employeeToUpdate).subscribe(
      {
        next: (res: any) => {
          console.log(res);
          employeeEditForm.reset();
         
          this.router.navigate(["/"]);

        },
        error: (err: HttpErrorResponse) => {
          console.log(err);
        }
      }
    );
  }

}

