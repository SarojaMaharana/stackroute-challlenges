import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('.navbar-brand')).getText() as Promise<string>;
  }

  getForm() {
    return element(by.tagName('form'));
  }

  getName() {
    return element(by.id("playername"));
  }
  getCountry() {
    return element(by.id("country"));
  }
  getMatchesPlayed() {
    return element(by.id("matchesPlayed"));
  }
   
}
