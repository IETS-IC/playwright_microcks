import { Injectable, NgModule } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { RouterModule, RouterStateSnapshot, Routes, TitleStrategy } from '@angular/router';
import { CreditCardValidationComponent } from './component/credit-card-validation/credit-card-validation.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { PostalCodeValidationComponent } from './component/postal-code-validation/postal-code-validation.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
    { path: '', component: HomeComponent, title: 'Home' },
    { path: 'crdt-crd', component: CreditCardValidationComponent, title: 'Credit Card' },
    { path: 'pstl-cd', component: PostalCodeValidationComponent, title: 'Postal Code' },
    { path: '**', component: PageNotFoundComponent }
];

@Injectable()
export class PageTitleStrategy extends TitleStrategy {
    constructor(private readonly title: Title) {
        super();
    }

    override updateTitle(routerState: RouterStateSnapshot) {

        var title = this.buildTitle(routerState) || '';

        if (title)
            title += ' | ';

        this.title.setTitle(`${title}${AppComponent.title()} `);
    }
}

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
    providers: [
        {
            provide: TitleStrategy,
            useClass: PageTitleStrategy
        }
    ]
})
export class AppRoutingModule { }