import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {

    //LoginPage – dodati neophodne metode

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    private By makeAppointmentBtn = By.id("btn-make-appointment");
    private By usernameField = By.id("txt-username");
    private By passwordField = By.id("txt-password");
    private By loginBtn = By.xpath("//*[@id=\"btn-login\"]");


    public void makeAppointmentBtnClick() {
        getDriver().findElement(makeAppointmentBtn).click();
    }

    public boolean verifyThatMakeAppointmentBtnIsClicked (){
        return getDriver().findElement(loginBtn).isDisplayed();
    }

    public void fillUsernameField(String username) {
        getDriver().findElement(usernameField).sendKeys(username);
    }

    public void fillPasswordField(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }


    public void login (String username, String password){
        fillUsernameField(username);
        fillPasswordField(password);
        loginBtnClick();
    }

    public void loginBtnClick() {
        getDriver().findElement(loginBtn).click();
    }

}
