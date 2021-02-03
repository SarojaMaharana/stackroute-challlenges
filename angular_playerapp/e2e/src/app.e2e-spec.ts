import { AppPage } from './app.po';

describe('PlayerApp', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display App Title', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('PlayerApp');
  });

  it('form should be invalid if any of its field is invalid', () => {
    page.navigateTo();
    page.getName().sendKeys("");
    page.getCountry().sendKeys("");
    page.getMatchesPlayed().sendKeys(0);
    let classText = page.getForm().getAttribute("class");
    expect(classText).not.toContain("ng-valid");
  });

  it('form should be valid when all of its fields are provided with valid values', () => {
    page.navigateTo();
    page.getName().sendKeys("Dummy");
    page.getCountry().sendKeys("XYZ");
    page.getMatchesPlayed().sendKeys(2014);
    let classText = page.getForm().getAttribute("class");
    expect(classText).not.toContain("ng-invalid");
  });

  // afterEach(async () => {
  //   // Assert that there are no errors emitted from the browser
  //   const logs = await browser.manage().logs().get(logging.Type.BROWSER);
  //   expect(logs).not.toContain(jasmine.objectContaining({
  //     level: logging.Level.SEVERE,
  //   } as logging.Entry));
  // });
});
