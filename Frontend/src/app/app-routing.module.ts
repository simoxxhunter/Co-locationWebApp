import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexhomeComponent } from './Components/index/index.component';
import { LoginComponent} from "./Components/login/login.component";
import {ListingsComponent} from "./Components/listings/listings.component";
import { SignupComponent } from './Components/signup/signup.component';
const routes: Routes = [
  {path : "index", component : IndexhomeComponent},
  {path : "login", component : LoginComponent },
  {path : "createListing", component : ListingsComponent },
  {path : "register" , component : SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
