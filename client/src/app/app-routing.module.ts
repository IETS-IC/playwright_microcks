import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreditCardValidationComponent } from './component/credit-card-validation/credit-card-validation.component';
import { HomeComponent } from './component/home/home.component';
import { PostalCodeValidationComponent } from './component/postal-code-validation/postal-code-validation.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, title: 'Home' },
    { path: 'crdt-crd', component: CreditCardValidationComponent, title: 'Credit Card' },
    { path: 'pstl-cd', component: PostalCodeValidationComponent, title: 'Postal Code' },
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
