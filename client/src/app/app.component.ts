import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { routes } from './app-routing.module';
import { DisplayService } from './service/display/display.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    protected appTitle = 'Playwright & Microcks';

    /** @var navigation app-routing results translated into menu items */
    protected navigation: any[] = [];

    /**
     * @param display DisplayService
     */
    constructor(public display: DisplayService,
        private titleService: Title,
        private router: Router
    ) {
        routes.forEach((route: any) => {
            const path = route.path;
            const title = route.title;
            const label = route.label;
            if (path && label) {
                this.navigation.push({ routerLink: '/' + path, title, label });
            }
        });
    }
}
