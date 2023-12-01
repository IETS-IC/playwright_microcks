import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DisplayService } from 'src/app/service/display/display.service';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
    public formData: any;

    constructor(public display: DisplayService, formBuilder: FormBuilder) {
        this.formData = formBuilder.group({
            comment: ['', Validators.required]
        });
    }

    ngOnInit(): void {
        this.formData.valueChanges.subscribe(() => {
            this.display.result = this.formData.value.comment ?? '';
        });
    }
}
