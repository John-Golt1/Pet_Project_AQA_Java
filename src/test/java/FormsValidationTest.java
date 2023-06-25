import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.FormsPage;

public class FormsValidationTest extends BaseTest  {
    private  FormsPage formsPage;
    @Before
    public void initSteps() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        formsPage = new FormsPage(driver);
        mainPage.goToForms();
       /* видимо при последнем обновлении сайта сделали "фичу", из-за которой при запуска страницы
       * с помощью веб драйвера - она просто сразу падает и её нужно рефрешить*/
        try {
            wait.until(ExpectedConditions.elementToBeClickable(formsPage.getPracticeFormElement()));
        } catch (Exception e) {
            driver.navigate().refresh();
        }
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
    public void checkNameFieldWithEmptyName() {
        formsPage.getSubmitButton().click();
        String backgroundImageUrl = formsPage.getNameField().getCssValue("background-image");
        Assert.assertEquals("label is not correct", formsPage.getBackgroundImageError(), backgroundImageUrl);
    }

    @Test
    public void checkSecondNameFieldWithCorrectName() {
        formsPage.inputLastName("Makurin");
        formsPage.getSubmitButton().click();
        String backgroundImageUrl = formsPage.getLastNameField().getCssValue("background-image");
        Assert.assertEquals("label is not correct", formsPage.getBackgroundSuccessImageUrl(), backgroundImageUrl);
    }

    @Test
    public void checkSecondNameFieldWithEmptyName() {
        formsPage.getSubmitButton().click();
        String backgroundImageUrl = formsPage.getLastNameField().getCssValue("background-image");
        Assert.assertEquals("label is not correct", formsPage.getBackgroundImageError(), backgroundImageUrl);
    }
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
