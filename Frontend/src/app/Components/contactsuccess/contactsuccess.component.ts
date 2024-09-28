import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contactsuccess',
  templateUrl: './contactsuccess.component.html',
  styleUrls: ['./contactsuccess.component.scss']
})
export class ContactsuccessComponent implements OnInit{

  ngOnInit() {
    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);
    
  }

}
