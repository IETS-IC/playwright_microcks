import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostalCodeValidationComponent } from './postal-code-validation.component';

describe('PostalCodeComponent', () => {
    let component: PostalCodeValidationComponent;
    let fixture: ComponentFixture<PostalCodeValidationComponent>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [PostalCodeValidationComponent]
        });
        fixture = TestBed.createComponent(PostalCodeValidationComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
