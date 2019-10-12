import { HttpClient, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Configuration } from './../classes/configuration';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private loginUrl: string;
  private cityUrl: string;
  private areasUrl: string;
  private slotsUrl: string;
  private fwSlotsUrl: string;
  private reserveSlotUrl: string;
  private reserveFwSlotUrl: string;
  private data;
  private fwData;

  constructor(private http: HttpClient, private configuration: Configuration) {
    this.loginUrl = configuration.server + 'login';
    this.cityUrl = configuration.server + 'cities';
    this.areasUrl = configuration.server + 'areas';
    this.slotsUrl = configuration.server + 'slots';
    this.fwSlotsUrl = configuration.server + 'fwSlots';
    this.reserveSlotUrl = configuration.server + 'reserveSlot';
    this.reserveFwSlotUrl = configuration.server + 'reserveFwSlot';
  }

  public slotData = new BehaviorSubject(this.data);

  public slotFwData = new BehaviorSubject(this.fwData);

  public login<T>(user): Observable<T> {
    return this.http.post<T>(this.loginUrl, user);
  }

  public getCities<T>(): Observable<T> {
    return this.http.get<T>(this.cityUrl);
  }

  public getAreas<T>(cityId): Observable<T> {
    return this.http.post<T>(this.areasUrl, cityId);
  }

  public getSlots<T>(idsForSlots): Observable<T> {
    return this.http.post<T>(this.slotsUrl, idsForSlots);
  }

  public getFwSlots<T>(idsForSlots): Observable<T> {
    return this.http.post<T>(this.fwSlotsUrl, idsForSlots);
  }

  public reserveSlot<T>(slot): Observable<T> {
    return this.http.post<T>(this.reserveSlotUrl, slot);
  }

  public reserveFwSlot<T>(slot): Observable<T> {
    return this.http.post<T>(this.reserveFwSlotUrl, slot);
  }
}
