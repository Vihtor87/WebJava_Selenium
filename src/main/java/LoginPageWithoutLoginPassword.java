import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithoutLoginPassword {

    @FindBy(xpath = "//*[@class='mdc-button__label']")
    private WebElement buttonLogin;

    public LoginPageWithoutLoginPassword (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void notAuthorisationInSystem() {
        buttonLogin.click();
    }
}
