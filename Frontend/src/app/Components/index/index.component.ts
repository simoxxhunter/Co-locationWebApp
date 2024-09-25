import { Component, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss', '../../../assets/css/normalize.scss','../../../assets/css/webflow.scss' , '../../../assets/css/simos-stupendous-site-472b4d.webflow.scss'],

})
export class IndexhomeComponent {
  ngOnInit() {
    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);
  }
  
}
