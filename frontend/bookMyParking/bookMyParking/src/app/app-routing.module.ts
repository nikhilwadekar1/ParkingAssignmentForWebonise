import { AuthGuardService } from './guards/auth-guard.service';
import { SlotComponent } from './home/slot/slot.component';
import { LandingPageComponent } from './home/landing-page/landing-page.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './home/login/login.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'homepage',
    canActivate: [AuthGuardService],
    component: LandingPageComponent,
    children: [
      {
        path: 'book',
        canActivate: [AuthGuardService],
        component: SlotComponent
      }
    ]
  },
  {
    path: '', redirectTo: '/login', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
