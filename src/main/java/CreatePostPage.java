import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatePostPage {

    @FindBy(xpath = "//*[@type='text']")
    private WebElement title;

    @FindBy(xpath = "//textarea[@class='mdc-text-field__input']")
    private WebElement description;

    @FindBy(xpath = "//*[@class='mdc-button__label']")
    private WebElement buttonSave;

    public CreatePostPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createNewPost(String titleNew, String descriptionNew) {
        title.sendKeys(titleNew);
        description.sendKeys(descriptionNew);
        buttonSave.click();
    }
}
