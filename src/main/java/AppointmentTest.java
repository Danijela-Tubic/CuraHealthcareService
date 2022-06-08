import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AppointmentTest {

/*Učitajte stranicu https://katalon-demo-cura.herokuapp.com/
Ulogujte se na stranicu preko demo naloga John Doe/ThisIsNotAPassword
Za proveru da li je korisnik ulogovan iskoristite metodu isFormPresented iz AppointmentPage klase.*/

    private WebDriver driver;
    private WebDriverWait driverWait;
    private BasePage basePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tubic\\Desktop\\IT BOOTCAMP\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        loginPage = new LoginPage(driver, driverWait);
        basePage = new BasePage(driver, driverWait);
        appointmentPage = new AppointmentPage(driver, driverWait);
        summaryPage = new SummaryPage(driver, driverWait);


        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

    }

    @Test(priority = 1)
    public void verifyThatMakeAppBtnIsClicked() {
        loginPage.makeAppointmentBtnClick();
        Assert.assertTrue(loginPage.verifyThatMakeAppointmentBtnIsClicked());
    }

    @Test(priority = 2)
    public void login() {

        loginPage.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.isFormPresented());
    }


    @Test(priority = 3)
    public void fillAppointmentForm() {
        appointmentPage.facilitySelect("Tokyo CURA Healthcare Center");
        appointmentPage.applyForHospitalClick();
        appointmentPage.chooseRadioBtn("Medicare");
        appointmentPage.selectData("22/03/2022");
        appointmentPage.fillCommentField("Thank you!");
        appointmentPage.bookAppointmentBtnClick();


        Assert.assertEquals(summaryPage.getSummaryFacility(), "Tokyo CURA Healthcare Center");
        Assert.assertEquals(summaryPage.getSummaryHospitalReadmission(), "Yes");
        Assert.assertEquals(summaryPage.getSummaryHealthcareProgram(), "Medicare");
        Assert.assertEquals(summaryPage.getSummaryVisitDate(), "22/03/2022");
        Assert.assertEquals(summaryPage.getSummaryComment(), "Thank you!");

    }

    @AfterClass
    public void afterClass() {
        driver.close();
        driver.quit();
    }


}

