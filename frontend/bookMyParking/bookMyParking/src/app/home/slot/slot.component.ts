import { UserDetails } from './../../classes/user-details';
import { UserDetailsService } from './../../services/user-details.service';
import { IdsForSlot } from './../../classes/ids-for-slot';
import { DataService } from './../../services/data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {
  isTwCollapsed = false;
  isFwCollapsed = true;
  slotsArray;
  fwSlotsArray;
  responseMessageClass = '';
  responseMessageFlag = false;
  responseMessage = '';
  constructor(
    private service: DataService,
    private userDetailsService: UserDetailsService
  ) { }

  ngOnInit() {
    this.service.slotData.subscribe(data => {
      this.slotsArray = data;
    });
    this.service.slotFwData.subscribe(data => {
      this.fwSlotsArray = data;
    });
  }

  reserveParking(slot) {
    this.service.reserveSlot(slot).subscribe(data => {
      this.responseMessage = data['message'];
      this.responseMessageClass = data['className']
      this.responseMessageFlag = true;
      if (data['message'] === 'Reserved successfully!') {
        this.userDetailsService.userDatails.walletBalance -= 20;
        this.service.deductBalance(this.userDetailsService.userDatails).subscribe(data => {
          console.log(data);
          const user = new UserDetails(data['userId'], data['city'], data['contactNo'], data['email'], data['password'], data['userName'], data['walletBalance'], data['loggedIn']);
          this.userDetailsService.userDatails = user;
        })
        const idsForSlot = new IdsForSlot();
        idsForSlot.areaId = slot.id.areaId;
        idsForSlot.cityId = slot.id.cityId;
        this.service.getSlots(idsForSlot).subscribe(data => {
          this.slotsArray = data;
        })
        setTimeout(() => {
          this.responseMessageFlag = false;
        }, 5000);
      }
    });
  }

  reserveFwParking(slot) {
    this.service.reserveFwSlot(slot).subscribe(data => {
      this.responseMessage = data['message'];
      this.responseMessageClass = data['className']
      this.responseMessageFlag = true;
      if (data['message'] === 'Reserved successfully!') {
        this.userDetailsService.userDatails.walletBalance -= 40;
        this.service.deductBalance(this.userDetailsService.userDatails).subscribe(data => {
          console.log(data);
          const user = new UserDetails(data['userId'], data['city'], data['contactNo'], data['email'], data['password'], data['userName'], data['walletBalance'], data['loggedIn']);
          this.userDetailsService.userDatails = user;
        });
        const idsForSlot = new IdsForSlot();
        idsForSlot.areaId = slot.id.areaId;
        idsForSlot.cityId = slot.id.cityId;
        this.service.getFwSlots(idsForSlot).subscribe(data => {
          this.fwSlotsArray = data;
        });
        setTimeout(() => {
          this.responseMessageFlag = false;
        }, 5000);
      }
    });
  }
}
