import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AppointmentPage extends BasePage {

    /*
o   getter za facility select
o   getter za apply for hospital readmission
o   getter za radio dugme (trazeno po value atributu)
§ xpath-u - kao parametar se prima value za trazeno radio dugme § //*[@name='programs'][@value='"+ radioInputName +"']
o   getter za visit date input
o   getter za comment input
o   getter za book appointment button
o   metodu isFormPresented() koja vraca informaciju da li je ucitan element id="appointment",
(iskoriste logiku preko liste, ako je lista prazna element nije na stanici).
Napomena: Datum se takodje postavlja preko metode sendKeys samo je potrebno datum uneti u formatu "dd/mm/yyyy" => npr: "21/09/2020"*/

    private By facility = By.id("combo_facility");
    private By applyForHospital = By.name("hospital_readmission");
    private By radioBtnMedicare = By.xpath("//*[@id='radio_program_medicare'][@value = 'Medicare']");
    private By radioBtnMedicaid = By.xpath("//*[@id='radio_program_medicaid'][@value = 'Medicaid']");
    private By radioBtnNone = By.xpath("//*[@id='radio_program_none'][@value = 'None']");
    private By visitDate = By.id("txt_visit_date");
    private By comment = By.id("txt_comment");
    private By bookAppointmentBtn = By.id("btn-book-appointment");
    private By sectionAppointment = By.id("appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void facilitySelect(String value) {
        Select choice = new Select(getDriver().findElement(facility));
        getDriver().findElement(facility).click();
        choice.selectByValue(value);
    }


    public void applyForHospitalClick() {

        getDriver().findElement(applyForHospital).click();

    }

    public void chooseRadioBtn(String value) {

        if (value.equals("Medicare")) {
            getDriver().findElement(radioBtnMedicare).click();
        } else if (value.equals("Medicaid")) {
            getDriver().findElement(radioBtnMedicaid).click();
        } else {
            getDriver().findElement(radioBtnNone).click();
        }
    }

    public void selectData(String data) {
        getDriver().findElement(visitDate).sendKeys(data);
    }

    public void fillCommentField(String comments) {
        getDriver().findElement(comment).sendKeys(comments);
    }

    public void bookAppointmentBtnClick() {
        getDriver().findElement(bookAppointmentBtn).click();
    }

    public boolean isFormPresented() {
        return getDriver().findElement(sectionAppointment).isDisplayed();
    }


}
