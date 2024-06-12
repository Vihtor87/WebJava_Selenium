import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class LoginPageTest {


    @Test
    void loginTest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //режим полного экрана
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://test-stand.gb.ru/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginInSystem("test_1706292487", "cd2f6a3b45");

        List<WebElement> searchElement = driver.findElements(By.partialLinkText("Hello,"));
        Assertions.assertEquals(1, searchElement.size());

        MainPage mainPage = new MainPage(driver);
        mainPage.createNewPost();

        List<WebElement> titleCreate = driver.findElements(By.xpath("//*[@type='text']"));
        Assertions.assertEquals(1, titleCreate.size());

        CreatePostPage createPostPage = new CreatePostPage(driver);
        createPostPage.createNewPost("Test", "Description Test");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> searchEl = driver.findElements(By.xpath("//h1[@class='svelte-tv8alb']"));
        Assertions.assertEquals(1, searchEl.size());

        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.delPost();


        driver.quit();
    }
}
