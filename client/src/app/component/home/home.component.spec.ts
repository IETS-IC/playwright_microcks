import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { FormBuilder } from '@angular/forms';
import { DisplayService } from 'src/app/service/display/display.service';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
    let homeFixture: ComponentFixture<HomeComponent>;
    let homeComponent: HomeComponent;

    beforeEach(waitForAsync(() => {
        TestBed.configureTestingModule({
            declarations: [HomeComponent],
            providers: [
                DisplayService,
                FormBuilder
            ]
        });

        TestBed.compileComponents().then(() => {
            homeFixture = TestBed.createComponent(HomeComponent);
            homeComponent = homeFixture.componentInstance;
            homeFixture.detectChanges();
        });
    }));

    it('should create', () => {
        expect(homeComponent).toBeTruthy();
    });
});
