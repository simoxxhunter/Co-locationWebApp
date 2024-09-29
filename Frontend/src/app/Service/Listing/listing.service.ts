import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ListingsModel } from 'src/app/models/ListingsModel';

@Injectable({
  providedIn: 'root'
})
export class ListingService {

  private apiUrl = 'http://localhost:8089/listings'; 

  constructor(private http: HttpClient) { }


  getListings(): Observable<ListingsModel[]> {
    return this.http.get<ListingsModel[]>(this.apiUrl);
  }

}
