import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { NavigationEnd, Router } from '@angular/router';
import { routes } from './app-routing.module';
import { DisplayService } from './service/display/display.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    static appTitle = 'Playwright & Microcks';
    protected AppComponent = AppComponent;

    /** @var navigation app-routing results translated into menu items */
    protected navigation: any[] = [];

    /**
     * @param display DisplayService
     */
    constructor(public display: DisplayService) {
        routes.forEach((route: any) => {
            const path = route.path;
            const title = route.title;
            if (path && title) {
                this.navigation.push({ routerLink: '/' + path, title: title });
            }
        });
    }

    static title(): string {
        return AppComponent.appTitle;
    }
}
