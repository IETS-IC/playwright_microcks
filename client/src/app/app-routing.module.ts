import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreditCardValidationComponent } from './component/credit-card-validation/credit-card-validation.component';
import { HomeComponent } from './component/home/home.component';
import { PostalCodeValidationComponent } from './component/postal-code-validation/postal-code-validation.component';


const appTitle = 'Playwright & Microcks';

export const routes: any = [
    { path: 'hm', component: HomeComponent, title: `Home | ${appTitle}`, label: 'Home' },
    { path: 'crdt-crd', component: CreditCardValidationComponent, title: `Credit Card | ${appTitle}`, label: 'Credit Card' },
    { path: 'pstl-cd', component: PostalCodeValidationComponent, title: `Postal Code | ${appTitle}`, label: 'Postal Code' },
    { path: '', redirectTo: 'hm', pathMatch: 'full' },
    { path: '**', redirectTo: 'hm', pathMatch: 'full' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
