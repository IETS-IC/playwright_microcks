import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { CreditCardComponent } from './component/credit-card/credit-card.component';
import { PostalCodeComponent } from './component/postal-code/postal-code.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'crdt-crd', component: CreditCardComponent },
    { path: 'pstl-cd', component: PostalCodeComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
