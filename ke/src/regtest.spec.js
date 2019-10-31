const { Builder, By, Key, until } = require('selenium-webdriver');
const assert = require('assert');

describe('reg_test', function() {
  this.timeout(30000);
  let driver;
  let vars;
  beforeEach(async function() {
    driver = await new Builder().forBrowser('firefox').build();
    vars = {}
  });
  afterEach(async function() {
    await driver.quit();
  });
  it('reg_test', async function() {
    await driver.get("https://pikabu.ru/")
    await driver.setRect(1216, 729)
    {
      const element = await driver.findElement(By.css(".auth__footer > .social-icon:nth-child(4)"));
      await driver.actions({ bridge: true }).moveToElement(element).perform();
    }
    await driver.findElement(By.css(".auth__footer > .social-icon:nth-child(4)")).click();
    await driver.findElement(By.id("identifierId")).sendKeys("olejiksin@gmail.com");
    await driver.findElement(By.css("#identifierNext > .ZFr60d")).click();
    await driver.findElement(By.name("password")).sendKeys("QaZWsXEdC99");
    {
      const element = await driver.findElement(By.css("#passwordNext .RveJvd"));
      await driver.actions({ bridge: true }).moveToElement(element).clickAndHold().perform()
    }
    {
      const element = await driver.findElement(By.css("#passwordNext .RveJvd"));
      await driver.actions({ bridge: true }).moveToElement(element).perform()
    }
    {
      const element = await driver.findElement(By.css("#passwordNext .RveJvd"));
      await driver.actions({ bridge: true }).moveToElement(element).release().perform()
    }
    await driver.findElement(By.css(".Wxwduf")).click();
    await driver.findElement(By.css("#passwordNext .RveJvd")).click()
  })
});
