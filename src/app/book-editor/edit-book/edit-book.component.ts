import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {AuthorModel} from './_models/author.model';
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE, MatDialog} from '@angular/material';
import {NewAuthorDialogComponent} from './new-author-dialog/new-author-dialog.component';
import {GenreModel} from './_models/genre.model';
import {MomentDateAdapter} from '@angular/material-moment-adapter';
import {GenreService} from './_services/genre.service';
import {Observable} from 'rxjs/Observable';
import {map, startWith} from 'rxjs/operators';
import {AuthorService} from './_services/author.service';
import {Router} from '@angular/router';
import {BookService} from './_services/book.service';

export const RU_FORMAT = {
  parse: {
    dateInput: 'LL',
  },
  display: {
    dateInput: 'LL',
    monthYearLabel: 'MMM YYYY',
    dateA11yLabel: 'LL',
    monthYearA11yLabel: 'MMMM YYYY',
  },
};

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css'],
  providers: [
    {provide: DateAdapter, useClass: MomentDateAdapter, deps: [MAT_DATE_LOCALE]},
    {provide: MAT_DATE_FORMATS, useValue: RU_FORMAT},
    {provide: MAT_DATE_LOCALE, useValue: 'ru'},
    GenreService,
    AuthorService,
    BookService
  ]
})
export class EditBookComponent implements OnInit {

  authorList: Array<AuthorModel> = new Array<AuthorModel>();
  filteredAuthors: Observable<any[]>;

  genreList: Array<GenreModel> = new Array<GenreModel>();
  filteredGenres: Observable<any[]>;

  hasNewAuthor: boolean = false;

  authorAutofillControl: FormControl = new FormControl();
  genreAutofillControl: FormControl = new FormControl();

  bookForm: FormGroup;
  publishDateControl: FormControl;


  constructor(
    @Inject(FormBuilder) private fb: FormBuilder,
    private newAuthorDialog: MatDialog,
    private genreService: GenreService,
    private authorService: AuthorService,
    private bookService: BookService,
    private router: Router,
  ) {

  }

  ngOnInit() {

    this.publishDateControl = new FormControl('');

    this.bookForm = this.fb.group({
      id: -1,
      name: '',
      author: AuthorModel,
      genre: GenreModel,
      publishDate: this.publishDateControl,
      copiesLeft: ''
    });

    this.getGenreAutofill();
    this.getAuthorAutofill();
  }

  getGenreAutofill(){
    this.genreService.getAll().subscribe(
      (genreList:  Array<GenreModel>) => {
        this.genreList = genreList;
        this.setFilteredGeners();
      }
    );
  }

  filterGenres(name: string): any[]{
    return this.genreList.filter(genre =>
      genre.name.toLowerCase().indexOf(name.toLowerCase()) >= 0);
  }

  setFilteredGeners() {
    this.filteredGenres = this.genreAutofillControl.valueChanges.pipe(
      startWith(''),
      map(genre => genre && typeof genre !==  'number' ? this.filterGenres(genre) : this.genreList.slice())
    );
  }

  getAuthorAutofill(){
    this.authorService.getAll().subscribe(
      (authorList:  Array<AuthorModel>) => {
        authorList.forEach(
          author => {
            this.authorList.push(new AuthorModel(author));
          }
        );
        this.setFilteredAuthors();
      }
    );
  }

  filterAuthor(name: string): any[]{
    return this.authorList.filter(author =>
      author.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0);
  }

  setFilteredAuthors() {
    this.filteredAuthors = this.authorAutofillControl.valueChanges.pipe(
      startWith(''),
      map(author => author && typeof author !==  'number' ? this.filterAuthor(author) : this.authorList.slice())
    );
  }

  addNewAuthor(){
    let dialogRef = this.newAuthorDialog.open(
      NewAuthorDialogComponent,
      {
        width: '500px'
      }
    );

    dialogRef.afterClosed().subscribe(
      (result: FormGroup) => {
        if(result !== undefined){
          let newAuthor = new AuthorModel(result.value);
          this.setAuthorInForm(newAuthor);
          this.authorList.push(newAuthor);
          this.authorAutofillControl.setValue(newAuthor.getName());
          this.hasNewAuthor = true;
        }
      }
    )
  }

  setAuthorInForm(author: AuthorModel){
    this.bookForm.patchValue(
      {
        author: author,
      }
    );
  }

  setGenreInForm(genre: GenreModel){
    this.bookForm.patchValue(
      {
        genre: genre,
      }
    );
  }

  navigateBack(){
    this.router.navigate(['new']);
  }

  submit(){
    this.bookService.post(this.bookForm.value).subscribe(
      () => {
        //this.router.navigate(['new']);
        console.log('Успешно добавлено!');
      }
    );
  }
}

