import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class HomeWork2Test {

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
        //HomeWork2
    void getErrorAuthorisationWithOutLoginPassword() {
        // Ленивый вариант
        //WebElement buttonLogin = driver.findElement(By.xpath("//*[@class='mdc-button__label']"));
        //buttonLogin.click();

        // Вариант с LoginPage
        LoginPageWithoutLoginPassword notLoginPass = new LoginPageWithoutLoginPassword(driver);
        notLoginPass.notAuthorisationInSystem();

        List<WebElement> search = driver.findElements(By.xpath("//*[text()='Invalid credentials.']"));
        Assertions.assertEquals(1, search.size());
    }

    @Test //HomeWork2
    void changeCountStudents() throws InterruptedException {
        LoginPageAdmin loginPageAdmin = new LoginPageAdmin(driver);
        loginPageAdmin.adminInSystem();
        //Проверка авторизации Admin
        //List<WebElement> searchElement = driver.findElements(By.partialLinkText("Hello, GB2024013f4816"));
        //Assertions.assertEquals(1, searchElement.size());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        MainPageAdmin mainPageAdmin = new MainPageAdmin(driver);

        mainPageAdmin.addNewStudent();

        CreateNewMaleStudentPage createNewMaleStudentPage = new CreateNewMaleStudentPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        createNewMaleStudentPage.newMaleStudent("FirstName2", "LastName1", "01.02.1990",
                "test_testLogin12", "89210985436");

        List<WebElement> search = driver.findElements(By.xpath("//*[text()='FirstName2']"));

        Assertions.assertEquals(1, search.size());
    }

    @AfterAll
    static void close() {
        driver.quit();
    }
}
