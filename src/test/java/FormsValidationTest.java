import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import ui.pages.FormsPage;

public class FormsValidationTest extends BaseTest  {
    private  FormsPage formsPage;
    @Before
    public void initSteps() {
        formsPage = new FormsPage(driver);
        mainPage.goToForms();
        formsPage.getPracticeFormElement().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].remove()", driver.findElement(By.tagName("footer")));
        js.executeScript("document.getElementById(\"fixedban\").style.display=\"none\"");
    }

    @Test
    public void checkNameFieldWithCorrectName() {
        formsPage.inputName("Anton");
        formsPage.getSubmitButton().click();
        String backgroundImageUrl = formsPage.getNameField().getCssValue("background-image");
        Assert.assertEquals("label is not correct", formsPage.getBackgroundSuccessImageUrl(), backgroundImageUrl);

    }

    @Test
    public void checkNameFieldWithIncorrectName() {
        //formsPage.inputName("");
        formsPage.getSubmitButton().click();
        String backgroundImageUrl = formsPage.getNameField().getCssValue("background-image");
        Assert.assertEquals("label is not correct", formsPage.getBackgroundImageError(), backgroundImageUrl);
    }

//    @Test
//    public void checkSecondNameFieldWithCorrectName() {
//
//    }
//
//    @Test
//    public void checkSecondNameFieldWithIncorrectName() {
//
//    }
//
//    @Test
//    public void checkEmailFieldWithCorrectData() {
//
//    }
//
//    @Test
//    public void checkEmailFieldWithIncorrectData() {
//
//    }

}
