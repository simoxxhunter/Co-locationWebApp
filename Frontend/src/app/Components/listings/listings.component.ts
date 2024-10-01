import { Component, Input, OnInit } from '@angular/core';
import { ListingsModel } from 'src/app/models/ListingsModel';
import { ListingService } from 'src/app/Service/Listing/listing.service';

@Component({
  selector: 'app-listings',
  templateUrl: './listings.component.html',
  styleUrls: ['./listings.component.scss']
})
export class ListingsComponent implements OnInit{

  listings: ListingsModel[] = [];

  constructor(
    private listingService: ListingService
  ) {
  }


  ngOnInit() {
    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);
    
    this.loadListings();
    
  }


  loadListings(): void {
    this.listingService.getListings().subscribe(data => {
      this.listings = data;
    });}



}
