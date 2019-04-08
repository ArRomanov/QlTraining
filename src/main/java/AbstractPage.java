import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.xpath;

public abstract class AbstractPage {

    WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }


    public AbstractPage clickLMB(String elementXpath) {
        driver
                .findElement(xpath(elementXpath))
                .click();
        return this;
    }


    public AbstractPage setTextInField(String fieldXpath, String text) {
        WebElement textField = driver.findElement(xpath(fieldXpath));
        textField.clear();
        textField.sendKeys(text);
        return this;
    }


    public AbstractPage selectDropDown(String dropDownXpath, String text) {
        Select dropdown = new Select(driver.findElement(xpath(dropDownXpath)));
        dropdown.selectByVisibleText(text);
        return this;
    }


    public AbstractPage waitUntilElementIsVisible(String elementXpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath(elementXpath))));
        return this;
    }

    public AbstractPage waitUntilElementAppearInDom(String elementXpath, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(elementXpath)));
        return this;
    }


    public AbstractPage checkDisplayedOfElement(String elementXpath) {
        WebElement element = driver.findElement(xpath(elementXpath));
        if (!element.isDisplayed()) {
            Assert.fail("Element " + elementXpath + " not found");
        }
        return this;
    }


    public AbstractPage switchToOtherTab() {
        String newHandle = "";
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(driver.getWindowHandle())) {
                newHandle = handle;
            }
        }
        driver.switchTo().window(newHandle);
        return this;
    }


    public AbstractPage switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }


    public AbstractPage checkTitle(String matchText) {
        Assert.assertEquals(driver.getTitle(), matchText);
        return this;
    }

    public String getElementText(String xpath) {
        waitUntilElementIsVisible(xpath, 3);
        return driver.findElement(xpath(xpath)).getText();
    }
}
