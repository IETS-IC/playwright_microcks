import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditCardValidationComponent } from './credit-card-validation.component';

describe('CreditCardComponent', () => {
    let component: CreditCardValidationComponent;
    let fixture: ComponentFixture<CreditCardValidationComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [CreditCardValidationComponent]
        });
        fixture = TestBed.createComponent(CreditCardValidationComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
