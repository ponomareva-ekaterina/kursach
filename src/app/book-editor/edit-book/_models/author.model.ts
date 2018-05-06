export class AuthorModel {
  id: string;
  firstName: string;
  lastName: string;
  middleName: string;

  constructor(data){
    this.id = data.id;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.middleName = data.middleName;
  }

  getName(): string {
    return this.lastName + ' ' + this.firstName + ' ' + this.middleName;
  }
}
