import { Component } from '@angular/core';
import { DisplayService } from './service/display/display.service';
import { routes } from './app-routing.module';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    /** @var navigation app-routing results translated into menu items */
    public navigation: any[] = [];

    /**
     * @param display DisplayService
     */
    constructor(public display: DisplayService) {
        routes.forEach((route: any) => {
            const path = route.path;
            this.navigation.push({ routerLink: '/' + path, title: path.replace('-', ' ') || 'Home' });
        });
    }
}
