import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//*[@id='create-btn']")
    private WebElement createButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewPost() {
        createButton.click();
    }
}
