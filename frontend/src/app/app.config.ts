import { ApplicationConfig, importProvidersFrom, LOCALE_ID } from '@angular/core';
import { provideRouter } from '@angular/router';
import localeDe from '@angular/common/locales/de';
import localeDeExtra from '@angular/common/locales/extra/de';
import { registerLocaleData } from '@angular/common';
import { routes } from './app.routes';
import { HttpClientModule } from '@angular/common/http';
import { provideNgIconsConfig } from '@ng-icons/core';


registerLocaleData(localeDe, localeDeExtra);

export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes),importProvidersFrom(HttpClientModule), {provide: LOCALE_ID, useValue:'de'},
    provideNgIconsConfig({
      size: '1.5em'
    })
  ]
};
