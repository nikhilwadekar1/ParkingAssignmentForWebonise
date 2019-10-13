import { UserDetails } from './../classes/user-details';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserDetailsService {
  public userDatails = new UserDetails();
  constructor() { }

}
