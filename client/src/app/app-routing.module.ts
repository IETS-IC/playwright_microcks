import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { CreditCardValidationComponent } from './component/credit-card-validation/credit-card-validation.component';
import { PostalCodeValidationComponent } from './component/postal-code-validation/postal-code-validation.component';

export const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'credit-card', component: CreditCardValidationComponent },
    { path: 'postal-code', component: PostalCodeValidationComponent },
    { path: '', component: HomeComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
