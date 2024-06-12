import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPageAdmin {
    @FindBy(xpath = "//*[@type='text']")
    private WebElement loginAdmin;

    @FindBy(xpath = "//*[@type='password']")
    private WebElement passwordAdmin;

    @FindBy(xpath = "//*[@class='mdc-button__label']")
    private WebElement buttonLogin;

    public LoginPageAdmin (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void adminInSystem() {
        loginAdmin.sendKeys("GB2024013f4816");
        passwordAdmin.sendKeys("d3a340f5c5");
        buttonLogin.click();
    }
}
