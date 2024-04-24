import { LOCALE_ID, NgModule, importProvidersFrom } from '@angular/core';
import { BrowserModule, bootstrapApplication } from '@angular/platform-browser';
import { AppRoutingModule, routes } from './app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CommonModule, registerLocaleData } from '@angular/common';
import { ActivatedRoute, provideRouter, Router, RouterLink, RouterLinkActive, RouterOutlet, withComponentInputBinding } from '@angular/router';

import { AppComponent } from './app.component';
import { ApiModule } from './api';
import { HttpClientModule } from '@angular/common/http';
import { provideNgIconsConfig } from '@ng-icons/core';

import localeDe from '@angular/common/locales/de';
import localeDeExtra from '@angular/common/locales/extra/de';

registerLocaleData(localeDe, localeDeExtra);

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    RouterOutlet,
    RouterLink,
    RouterLinkActive,
    NgbModule,
    ApiModule
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [AppComponent],
  providers: [
    provideRouter(routes, withComponentInputBinding()),
    importProvidersFrom(HttpClientModule), { provide: LOCALE_ID, useValue: 'de' },
    provideNgIconsConfig({
      size: '1.5em'
    })
  ]
})

export class AppModule {
}
