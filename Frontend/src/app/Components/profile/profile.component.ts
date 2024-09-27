import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit{

  ngOnInit() {
    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);
    
  }
}
