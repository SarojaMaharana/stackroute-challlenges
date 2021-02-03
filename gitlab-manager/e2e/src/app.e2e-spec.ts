import { AppPage } from './app.po';
import { browser, By, element, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  // it('should display welcome message', () => {
  //   page.navigateTo();
  //   expect(page.getTitleText()).toEqual('gitlab-manager app is running!');
  // });

  it ('should display signin/signup', () => {
    page.navigateTo();
    browser.sleep(1500);
  });

  it ('should contain the text SignIn/SignUp', () => {
    expect(page.getTitleText()).toEqual('SignIn/SignUp');
  });

  it ('check successfull login', () => {
    const elements = element.all(By.css('input'));
    console.log(elements);
    elements.get(0).sendKeys('mehersupreeth@gmail.com');
    elements.get(1).sendKeys('1234567');
    const button = element(By.css('button'));
    button.click();
    expect(browser.getCurrentUrl()).toContain('home');
  });

  it ('check successfull logout', () => {
    // const elements = element.all(By.css('input'));
    // console.log(elements);
    // elements.get(0).sendKeys('mehersupreeth@gmail.com');
    // elements.get(1).sendKeys('1234567');
    // const button = element(By.css('button'));
    // button.click();
    const logoutButton = element(By.css('button'));
    logoutButton.click();
    expect(browser.getCurrentUrl()).toBe('http://localhost:4200');
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
