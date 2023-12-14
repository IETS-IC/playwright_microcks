import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { MaterialModule } from './setting/material.module';
import { ReactiveFormsModule } from '@angular/forms';
import { PostalCodeComponent } from './component/postal-code/postal-code.component';
import { CreditCardComponent } from './component/credit-card/credit-card.component';

@NgModule({
    declarations: [
        AppComponent,
        HomeComponent,
        PostalCodeComponent,
        CreditCardComponent
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
