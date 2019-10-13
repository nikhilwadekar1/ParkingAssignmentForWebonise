import { UserDetailsService } from './../services/user-details.service';
import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
  constructor(private userDetailsService: UserDetailsService, private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    return this.checkLogin();
  }

  checkLogin(): boolean {
    if (this.userDetailsService.userDatails.isLoggedIn) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }

}
