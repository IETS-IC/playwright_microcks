import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DisplayService } from 'src/app/service/display/display.service';

@Component({
    selector: 'app-credit-card',
    templateUrl: './credit-card.component.html',
    styleUrls: ['./credit-card.component.scss']
})
export class CreditCardComponent {
    public formData: any;

    constructor(public display: DisplayService, formBuilder: FormBuilder) {
        this.formData = formBuilder.group({
            creditCard: ['', Validators.required]
        });
    }

    ngOnInit(): void {
        this.formData.valueChanges.subscribe(() => {
            this.display.result = this.formData.value.creditCard ?? '';
        });
    }
}
