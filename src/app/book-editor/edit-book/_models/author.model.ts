export class AuthorModel {
  id: number;
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

  getNameWithSeparators(): string{
    return this.lastName + '-' + this.firstName + '-' + this.middleName;
  }

  getShortName(){
    return this.lastName + ' ' + this.firstName[0] + '. ' + this.middleName[0] + '.';
  }
}
