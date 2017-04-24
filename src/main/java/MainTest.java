import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

/**
 * Created by China on 12.04.2017.
 */
public class MainTest extends TestScripts {


    public static void main(String[] args) {
        String menuName;
        WebDriver driver = getWebDriver();
        LogIn(driver);

        List<WebElement> menuElements = ValidateSideBar(driver);

        CheckMenu(driver, menuElements);

    }


}

