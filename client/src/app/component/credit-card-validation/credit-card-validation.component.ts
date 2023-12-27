import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { DisplayService } from "src/app/service/display/display.service";
import { environment } from "src/environments/environment";

@Component({
    selector: 'credit-card-validation',
    templateUrl: './credit-card-validation.component.html',
    styleUrls: ['./credit-card-validation.component.scss']
})
export class CreditCardValidationComponent implements OnInit {
    protected validationForm: FormGroup;
    private creditCardURL: string;

    constructor(public displayService: DisplayService) {
        this.creditCardURL = environment.creditCardBasePath;
        const formBuilder = new FormBuilder();
        this.validationForm = formBuilder.group({
            ccn: new FormControl('')
        });
    }

    public ngOnInit(): void {

    }

    protected pingService(): void {
        fetch(`${this.creditCardURL}/api/creditCard-ws/`).then((response: any) => {
            response.json().then((body: any) => {
                this.displayService.result = body?.message;
            }).catch((BodyParseError: any) => {
                console.log(BodyParseError);
            });
        }).catch((requestError: any) => {
            console.log(requestError);
        });
    }

    protected requestRootInstructions(): void {
        fetch(`${this.creditCardURL}/api/creditCard-ws/validation`).then((response: any) => {
            response.json().then((body: any) => {
                this.displayService.result = body?.message;
            }).catch((BodyParseError: any) => {
                console.log(BodyParseError);
            });
        }).catch((requestError: any) => {
            console.log(requestError);
        });
    }

    protected validateCreditCard(): void {
        fetch(`${this.creditCardURL}/api/creditCard-ws/validation/${this.validationForm.controls.ccn.value}`).then((response: any) => {
            response.json().then((body: any) => {
                this.displayService.result = `Validation attempt for credit card number "${this.validationForm.controls.ccn.value}".\n${body?.message}`;
            }).catch((BodyParseError: any) => {
                console.log(BodyParseError);
            });
        }).catch((requestError: any) => {
            console.log(requestError);
        });
    }
}
