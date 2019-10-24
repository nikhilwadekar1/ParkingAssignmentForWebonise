import { UserDetailsService } from './../../services/user-details.service';
import { IdsForSlot } from './../../classes/ids-for-slot';
import { City } from './../../classes/city';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {
  cities;
  areas;
  selectedCityOption;
  selectedAreaOption;
  availableBalance = 0.00;
  // city: City;
  constructor(
    private service: DataService,
    private userDetailsService: UserDetailsService,
    private router: Router
  ) { }

  ngOnInit() {
    this.service.getCities().subscribe(data => {
      this.cities = data;
    });
    this.availableBalance = this.userDetailsService.userDatails.walletBalance;
  }

  getAreas(){
    const city = new City();
    const cityObj = this.selectedCityOption.split('_');
    city.cityId = +cityObj[0];
    city.cityName = cityObj[1];
    this.service.getAreas(city).subscribe(data => {
      this.areas = data;
    });
  }

  getSlots() {
    const idsForSlot = new IdsForSlot();
    const slotObj = this.selectedAreaOption.split('_');
    idsForSlot.areaId = +slotObj[0];
    idsForSlot.cityId = +slotObj[1];
    this.service.getFwSlots(idsForSlot).subscribe(data => {
      this.service.slotFwData.next(data);
    });
    this.service.getSlots(idsForSlot).subscribe(data => {
      this.service.slotData.next(data);
      this.router.navigate(['homepage/book']);
    });
  }

  logout(){
    this.userDetailsService.userDatails.isLoggedIn = false;
    this.router.navigate(['login']);
  }

}
