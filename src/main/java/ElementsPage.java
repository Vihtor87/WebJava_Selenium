import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage {

    @FindBy(xpath = "//button")
    private List<WebElement> buttons;

    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void delPost() {
        buttons.get(1).click();
    }
}
