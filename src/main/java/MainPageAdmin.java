import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPageAdmin {

    @FindBy(xpath = "//*[@id='create-btn']")
    private WebElement createButton;

    @FindBy(xpath = "//table[@aria-label='Dummies list']/tbody/tr")
    private List<WebElement> rowsInStudentGroup;

    public MainPageAdmin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void addNewStudent() {
        createButton.click();
    }

    public List<WebElement> getRowsWebElements() {
        List<WebElement> rowsWebElements = this.rowsInStudentGroup;
        return rowsWebElements;
    }

//    public void getGroupTableRows(List<WebElement> rowsWebElements) {
//        List<StudentTableRow> groupTableRows = rowsWebElements
//                .stream().map(StudentTableRow::new).toList();
//    }
//
//    private StudentTableRow getRowByStudent(String student) {
//        return rowsInStudentGroup.stream()
//                .map(StudentTableRow::new)
//                .filter(row -> row.getName().equals(student))
//                .findFirst().orElseThrow();
//    }
}
