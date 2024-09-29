import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexhomeComponent } from './Components/index/index.component';
import { LoginComponent} from "./Components/login/login.component";
import {ListingsComponent} from "./Components/listings/listings.component";
import { SignupComponent } from './Components/signup/signup.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { ContactComponent } from './Components/contact/contact.component';
import { ContactsuccessComponent } from './Components/contactsuccess/contactsuccess.component';
import { PublishlistingsComponent } from './Components/publishlistings/publishlistings.component';
const routes: Routes = [
  {path : "index", component : IndexhomeComponent},
  {path : "login", component : LoginComponent },
  {path : "createListing", component : ListingsComponent },
  {path : "register" , component : SignupComponent},
  {path : "user-profile" , component : ProfileComponent},
  {path : "contact-us" , component : ContactComponent},
  {path : "contact-success" , component : ContactsuccessComponent},
  {path : "listings" , component : ListingsComponent},
  {path : "publish" , component : PublishlistingsComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
