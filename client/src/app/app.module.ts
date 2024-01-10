import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreditCardValidationComponent } from './component/credit-card-validation/credit-card-validation.component';
import { HomeComponent } from './component/home/home.component';
import { PostalCodeValidationComponent } from './component/postal-code-validation/postal-code-validation.component';
import { MaterialModule } from './setting/material.module';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

@NgModule({
    declarations: [
        AppComponent,
        CreditCardValidationComponent,
        HomeComponent,
        PostalCodeValidationComponent,
        PageNotFoundComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        MaterialModule,
        ReactiveFormsModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
