package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;
    private final By elementsChapter = By.xpath("//*[@class='card-body']/h5[contains(text(),'Elements')]");
    private final By formsChapter = By.xpath("//h5[contains(text(),'Forms')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public ElementsPage goToElements() {
        driver.findElement(elementsChapter).click();
        return new ElementsPage(driver);
    }

    public FormsPage goToForms() {
        driver.findElement(formsChapter).click();
        return new FormsPage(driver);
    }

    public WebElement findElementByName(String elementName) {
        return driver.findElement(By.xpath(String.format("//div[@class='card mt-4 top-card']//*[contains(text(),'%s')]", elementName)));
    }
}