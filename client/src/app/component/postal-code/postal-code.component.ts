import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DisplayService } from 'src/app/service/display/display.service';

@Component({
    selector: 'app-postal-code',
    templateUrl: './postal-code.component.html',
    styleUrls: ['./postal-code.component.scss']
})
export class PostalCodeComponent {
    public formData: any;

    constructor(public display: DisplayService, formBuilder: FormBuilder) {
        this.formData = formBuilder.group({
            postalCode: ['', Validators.required],
            province: ['']
        });
    }

    ngOnInit(): void {
        this.formData.valueChanges.subscribe(() => {
            this.display.result = this.formData.value.postalCode + this.formData.value.province ?? '';
        });
    }
}
