export class GenreModel {
  id: number;
  name: string;

  constructor(data){
    this.id = data.id;
    this.name = data.name;
  }
}
