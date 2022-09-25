import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/dashboard_components/navbar/navbar.component';
import { CartComponent } from './components/dashboard_components/cart/cart.component';
import { FooterComponent } from './components/footer/footer.component';
import { WishlistComponent } from './components/dashboard_components/wishlist/wishlist.component';
import { BookComponent } from './components/books/book/book.component';
import { SearchPipe } from './pipes/search.pipe';
import { HttpClientModule } from '@angular/common/http';
import { ChangepasswordComponent } from './components/dashboard_components/changepassword/changepassword.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { RelatedBooksComponent } from './components/books/related-books/related-books.component';
import { WishedBooksComponent } from './components/books/wished-books/wished-books.component';
import { FavouriteBookComponent } from './components/books/favourite-book/favourite-book.component';
import { BookApiComponent } from './components/books/book-api/book-api.component';
import { RelatedBookApiComponent } from './components/books/related-book-api/related-book-api.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    NavbarComponent,
    CartComponent,
    FooterComponent,
    WishlistComponent,
    BookComponent,
    SearchPipe,
    ChangepasswordComponent,
    DashboardComponent,
    RelatedBooksComponent,
    WishedBooksComponent,
    FavouriteBookComponent,
    BookApiComponent,
    RelatedBookApiComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
