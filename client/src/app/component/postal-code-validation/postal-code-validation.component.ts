import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { DisplayService } from "src/app/service/display/display.service";
import { environment } from "src/environments/environment";

@Component({
    selector: 'postal-code-validation',
    templateUrl: './postal-code-validation.component.html',
    styleUrls: ['./postal-code-validation.component.scss']
})
export class PostalCodeValidationComponent implements OnInit {
    protected validationForm: FormGroup;
    private postalCodeURL: string;

    constructor(public displayService: DisplayService) {
        this.postalCodeURL = environment.postalCardBasePath;
        const formBuilder = new FormBuilder();
        this.validationForm = formBuilder.group({
            postalCode: new FormControl(''),
            provinceCode: new FormControl('')
        });
    }

    public ngOnInit(): void {

    }

    protected pingService(): void {
        fetch(`${this.postalCodeURL}/api/postalCode-ws/`).then((response: any) => {
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
        fetch(`${this.postalCodeURL}/api/postalCode-ws/validation`).then((response: any) => {
            response.json().then((body: any) => {
                this.displayService.result = body?.message;
            }).catch((BodyParseError: any) => {
                console.log(BodyParseError);
            });
        }).catch((requestError: any) => {
            console.log(requestError);
        });
    }

    protected validatePostalCode(): void {
        fetch(`${this.postalCodeURL}/api/postalCode-ws/validation/K1W1K9/ON`).then((response: any) => {
            response.json().then((body: any) => {
                this.displayService.result = `Validation attempt for postal code "${this.validationForm.controls.postalCode.value}" in province "${this.validationForm.controls.provinceCode.value}".\n${body?.message}`;
            }).catch((BodyParseError: any) => {
                console.log(BodyParseError);
            });
        }).catch((requestError: any) => {
            console.log(requestError);
        });
    }
}
