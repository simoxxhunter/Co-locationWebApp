import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './Components/index/index.component';
import { LoginComponent} from "./Components/login/login.component";
import {ListingsComponent} from "./Components/listings/listings.component";

const routes: Routes = [
  {path : "index", component : IndexComponent},
  {path : "login", component : LoginComponent },
  {path : "createListing", component : ListingsComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
