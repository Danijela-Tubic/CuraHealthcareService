import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {

    //ima gettere za sve elemenete sa summary stranice koji nose informacije appointment-a

    private By summaryFacility = By.id("facility");
    private By summaryHospitalReadmission = By.id("hospital_readmission");
    private By summaryHealthcareProgram = By.id("program");
    private By summaryVisitDate = By.xpath("//*[@id=\"visit_date\"]");
    private By summaryComment = By.xpath("//*[@id=\"comment\"]");

    public SummaryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getSummaryFacility() {
        return getDriver().findElement(summaryFacility).getText();
    }

    public String getSummaryHospitalReadmission() {
        return getDriver().findElement(summaryHospitalReadmission).getText();
    }

    public String getSummaryHealthcareProgram() {
        return getDriver().findElement(summaryHealthcareProgram).getText();
    }

    public String getSummaryVisitDate() {
        return getDriver().findElement(summaryVisitDate).getText();
    }

    public String getSummaryComment() {
        return getDriver().findElement(summaryComment).getText();
    }

}
