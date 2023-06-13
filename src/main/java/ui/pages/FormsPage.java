package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormsPage {
    private WebDriver driver;
    private String backgroundErrorImageUrl = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='12' height='12' fill='none' "
            + "stroke='%23dc3545' viewBox='0 0 12 12'%3e%3ccircle cx='6' cy='6' r='4.5'/%3e%3cpath stroke-linejoin='round' d='M5.8 3.6h.4L6 6.5z'/%3e%3ccircle "
            + "cx='6' cy='8.2' r='.6' fill='%23dc3545' stroke='none'/%3e%3c/svg%3e\")";
    private String backgroundSuccessImageUrl = "url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'"
            + " viewBox='0 0 8 8'%3e%3cpath fill='%2328a745' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")";
    private final By practiceForm = By.xpath("//span[normalize-space()='Practice Form']");
    private final By firstName = By.id("firstName");
    private final By submitButton = By.xpath("//*[@id='submit']");

    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getPracticeFormElement() {
        return driver.findElement(practiceForm);
    }

    public void inputName(String name) {
        driver.findElement(firstName).sendKeys(name);
    }

    public WebElement getNameField() {
        return driver.findElement(firstName);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public String getBackgroundImageError() {
        return backgroundErrorImageUrl;
    }

    public String getBackgroundSuccessImageUrl() {
        return backgroundSuccessImageUrl;
    }
}
