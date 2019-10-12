import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
  public isLoggedIn = false;
  constructor() { }

}
