import {Routes, RouterModule} from '@angular/router';
import {BookShopListComponent} from './book-shop/book-shop-list/book-shop-list.component';
import {NoveltiesListComponent} from './novelties/novelties-list/novelties-list.component';
import {EditBookComponent} from './book-editor/edit-book/edit-book.component';


const appRoutes: Routes = [
    { path: '',
      children: [
          { path: 'new', component: NoveltiesListComponent  },
          { path: 'books', component: BookShopListComponent  },
          { path: 'edit/book/:id', component: EditBookComponent  },

        // otherwise redirect to home
        { path: '', redirectTo: 'new', pathMatch: 'full' }
      ]
    }
];

export const routing = RouterModule.forRoot(appRoutes);
