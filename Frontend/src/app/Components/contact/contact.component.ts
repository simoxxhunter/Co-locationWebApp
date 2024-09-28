import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ContactService } from 'src/app/Service/Contact/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  contactForm: FormGroup;
  submitted = false;
  success = false;
  errorMessage: string | null = null;
  loading = false;

  constructor(
    private formBuilder: FormBuilder,
    private contactService: ContactService
  ) {
    this.contactForm = this.formBuilder.group({
      fullname: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      company: ['', Validators.required],
      message: ['', Validators.required],
      date: [{value: '', disabled: true}] // Disabled because it will be set automatically
    });
  }

  ngOnInit() {
    const today = new Date().toISOString().split('T')[0]; // Formats date as YYYY-MM-DD
    this.contactForm.get('date')?.setValue(today);

    const script = document.createElement('script');
    script.src = 'assets/js/webflow.js';
    script.type = 'text/javascript';
    document.body.appendChild(script);
  }

  onSubmit() {
    this.submitted = true;
    this.errorMessage = null;
    this.loading = true;

    if (this.contactForm.invalid) {
      this.loading = false;
      return;
    }

    this.contactForm.get('date')?.setValue(new Date().toISOString().split('T')[0]);

    this.contactService.createContact(this.contactForm.getRawValue()).subscribe(
      response => {
        this.success = true;
        this.contactForm.reset();
        this.contactForm.get('date')?.setValue(new Date().toISOString().split('T')[0]);
        this.submitted = false;
        this.loading = false;
      },
      error => {
        console.error('Error submitting form:', error);
        this.errorMessage = 'There was an issue submitting your form. Please try again.';
        this.success = false;
        this.loading = false;
      }
    );
  }
}
