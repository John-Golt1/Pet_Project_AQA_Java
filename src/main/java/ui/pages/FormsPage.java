package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.Normalizer;

public class FormsPage {
    private WebDriver driver;
    private final By practiceForm = By.xpath("//span[normalize-space()='Practice Form']");

    public FormsPage(WebDriver driver) {
        this.driver = driver;
    }


}
