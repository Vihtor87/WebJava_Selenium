import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//*[@type='text']")
    private WebElement loginSite;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordSite;

    @FindBy(xpath = "//*[@class='mdc-button__label']")
    private WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void loginInSystem(String login, String password) {
        loginSite.sendKeys(login);
        passwordSite.sendKeys(password);
        buttonLogin.click();
    }
}
