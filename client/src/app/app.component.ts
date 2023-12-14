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

    public appTitle = 'Playwright & Microcks';

    /** @var navigation app-routing results translated into menu items */
    public navigation: any[] = [];

    /**
     * @param display DisplayService
     */
    constructor(public display: DisplayService,
        private titleService: Title,
        private router: Router) {

        this.autoGenerateSideMenu();

        router.events.subscribe((val) => {
            if (val instanceof NavigationEnd) {
                let url = this.router.url;
                url = url.replace('/', '');

                routes.forEach((route: any) => {
                    const path = route.path;

                    if (url == path)
                        this.titleService.setTitle(this.getCompponentName(route.component) + ' | ' + this.appTitle);
                });
            }
        });
    }

    private autoGenerateSideMenu(): void {
        routes.forEach((route: any) => {
            const path = route.path;
            const title = this.getCompponentName(route.component);
            this.navigation.push({ routerLink: '/' + path, title: title });
        });
    }

    private getCompponentName(component: any) {
        var title = component.name;
        title = title.replace('Component', '');
        title = title.replace(/([A-Z])/g, ' $1').trim();

        return title || 'Home';
    }
}
