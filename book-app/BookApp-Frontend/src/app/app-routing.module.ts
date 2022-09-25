import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './components/books/book/book.component';
import { RelatedBookApiComponent } from './components/books/related-book-api/related-book-api.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CartComponent } from './components/dashboard_components/cart/cart.component';
import { ChangepasswordComponent } from './components/dashboard_components/changepassword/changepassword.component';
import { NavbarComponent } from './components/dashboard_components/navbar/navbar.component';
import { WishlistComponent } from './components/dashboard_components/wishlist/wishlist.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'' , component:LoginComponent, pathMatch:'full'},
  {path:'login' , component : LoginComponent},
  {path:'navbar', component:NavbarComponent,canActivate:[AuthGuard]},
  {path:'cart' , component:CartComponent ,canActivate:[AuthGuard]},
  {path:'wishlist', component:WishlistComponent ,canActivate:[AuthGuard]},
  {path:'book', component:BookComponent},
  {path:'register',component:RegisterComponent},
  {path:'changepassword' , component:ChangepasswordComponent ,canActivate:[AuthGuard]},
  {path: 'dashboard', component:DashboardComponent ,canActivate:[AuthGuard]},
  {path:'searched',component:RelatedBookApiComponent,canActivate:[AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
