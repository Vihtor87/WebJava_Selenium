import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Sem1Test {

    static WebDriver driver;
    private String login = "test_1706292487";
    private String password = "cd2f6a3b45";

    @BeforeAll
    static void setup() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //неявное ожидание
    }

    @Test
    @Disabled
    void openLink() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //режим полного экрана
        //chromeOptions.addArguments("--headless"); работа браузера в скрытом режиме

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://test-stand.gb.ru/login");
        Thread.sleep(5000l); //задержка выполнения
        driver.quit();
    }

    @Test
    void authorization() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement loginSite = driver.findElement(By.xpath("//*[@type='text']"));
        //WebElement passwordSite = driver.findElement(By.xpath("//*[@type='password']"));

        WebElement loginSite = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='text']"))); //или By.cssSelector("form#login input[type='text']")
        WebElement passwordSite = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='password']")));
        WebElement button = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));

        loginSite.sendKeys(login);
        passwordSite.sendKeys(password);
        button.click();

        List<WebElement> searchElement = driver.findElements(By.partialLinkText("Hello"));

        Assertions.assertEquals(1, searchElement.size());
    }

    @Test
    void createPost() throws InterruptedException {
        String newTitle = "post with Java";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginSite = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='text']"))); //или By.cssSelector("form#login input[type='text']")
        WebElement passwordSite = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='password']")));
        WebElement button = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));

        loginSite.sendKeys(login);
        passwordSite.sendKeys(password);
        button.click();

        WebElement createButton = driver.findElement(By.xpath("//*[@id='create-btn']"));
        createButton.click();

        WebElement titleCreate = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@type='text']")));
        titleCreate.sendKeys(newTitle);
        WebElement buttonSave = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));
        buttonSave.click();

        List<WebElement> searchEl = driver.findElements(By.xpath("//*[@class='container svelte-1pbgeyl']"));

//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        try {
//            FileUtils.copyFile(screenshot, new File("C:\\Users\\vikto\\Desktop\\IDEA\\WebWithJava\\src\\test\\resources\\scr.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
// Не получилось со скриншотом...

        Assertions.assertEquals(1, searchEl.size());

    }


    @AfterAll
    static void close() {
        driver.quit();
    }
}
