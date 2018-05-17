import {AuthorModel} from './author.model';
import {GenreModel} from './genre.model';

export class BookModel {
  id: number;
  name: string;
  author: AuthorModel;
  genre: GenreModel;
  publishDate: Date;
  copiesLeft: number;

  constructor(data) {
    this.id = data.id;
    this.name = data.name;
    this.author = new AuthorModel(data.author);
    this.genre = new GenreModel(data.genre);
    this.publishDate = data.publishDate;
    this.copiesLeft = data.copiesLeft;
  }
}
