import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewMaleStudentPage {

    //Не совсем правильное указание пути, но на данной учебной странице иначе никак
    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[1]/label/input")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[2]/label/input")
    private WebElement inputLastName;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[3]/label/input")
    private WebElement inputBirthDay;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[4]/div[1]/div[1]")
    private WebElement buttonMale;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[5]/label/input")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[6]/label/input")
    private WebElement inputPhone;

    @FindBy(xpath = "//*[@id=\"upsert-item\"]/div[8]/button/span")
    private WebElement buttonSave;

    public CreateNewMaleStudentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getInputFirstName() {
        return inputFirstName;
    }

    public void newMaleStudent(String FirstName, String LastName, String BirthDay, String Login, String Phone) {
        inputFirstName.sendKeys(FirstName);
        inputLastName.sendKeys(LastName);
        inputBirthDay.sendKeys(BirthDay);
        inputLogin.sendKeys(Login);
        inputPhone.sendKeys(Phone);
        buttonSave.click();
    }
}
