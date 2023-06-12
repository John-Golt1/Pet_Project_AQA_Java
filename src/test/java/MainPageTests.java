
import jdk.jfr.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ui.pages.MainPage;

import java.util.Collection;


@RunWith(Parameterized.class)
public class MainPageTests extends BaseTest {
    private MainPage mainPage;
    private String elementName;

    @Before
    public void initStep() {
        mainPage = new MainPage(driver);
    }

    public MainPageTests(String elementName) {
        this.elementName = elementName;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Elements"},
                {"Forms"},
                {"Alerts, Frame & Windows"},
                {"Widgets"},
                {"Interactions"},
                {"Book Store Application"}
        };
    }

    @Test
    @Description("Проверяем, что на странице есть все необходимые элементы")
    public void checkPageElements() {
        mainPage.findElementByName(elementName);
        Assert.assertNotNull("Элемент '" + elementName + "' не найден", elementName);
    }
}