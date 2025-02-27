export interface Employee{

    
    id : number,
    firstName : string,
    lastName : string,
    email : string,
    salary : number
}

export interface StandResponse<T> {
    statusCode: number;
    message: string;
    data: T;
  }