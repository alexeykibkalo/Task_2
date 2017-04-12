import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

/**
 * Created by China on 12.04.2017.
 */
public class MainTest {
        private static String path = "http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/";
        private  static  String login = "webinar.test@gmail.com";
        private static String password = "Xcg7299bnSmMuRLp9ITw";

    public static void main(String[] args) {
        String menuName;
        System.setProperty("webdriver.chrome.driver"
                ,"D:\\Учеба\\Automation\\Task_2\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(path);
        WebElement loginTB = driver.findElement(By.id("email"));
        loginTB.sendKeys(login);
        WebElement passTB = driver.findElement(By.id("passwd"));
        passTB.sendKeys(password);
        WebElement submit = driver.findElement(By.name("submitLogin"));
        submit.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> menuElements = driver.findElement(By.id("nav-sidebar")).findElement(By.className("menu"))
                .findElements(By.className("maintab"));

        if(menuElements.size()==13)//если количество эллементов не равно 13 страница отобразилась некорректно
            System.out.println("Count = "+menuElements.size());

        WebElement el;
        Random random = new Random();
        el = menuElements.get(random.nextInt(menuElements.size()));
        el.click();

        menuName = driver.findElement(By.id("main")).findElement(By.id("content"))
                .findElement(By.className("bootstrap")).findElement(By.className("page-head "))
                .findElement(By.className("page-title")).getText();
        driver.navigate().refresh();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(menuName.equalsIgnoreCase(driver.findElement(By.id("main")).findElement(By.id("content"))
                .findElement(By.className("bootstrap")).findElement(By.className("page-head "))
                .findElement(By.className("page-title")).getText()))
            System.out.println("Test is ok");

        driver.close();

    }
}

