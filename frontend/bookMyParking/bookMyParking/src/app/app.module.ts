import { UserDetailsService } from './services/user-details.service';
import { AuthGuardService } from './guards/auth-guard.service';
import { Configuration } from './classes/configuration';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './home/login/login.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { LandingPageComponent } from './home/landing-page/landing-page.component';
import { SlotComponent } from './home/slot/slot.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LandingPageComponent,
    SlotComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    NgbModule
  ],
  providers: [
    Configuration,
    AuthGuardService,
    UserDetailsService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
