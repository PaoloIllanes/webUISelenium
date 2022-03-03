import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;



public class FireFoxSelenium {

    FirefoxDriver firefoxDriver;
    @BeforeEach
    public void openBrowser(){

        System.setProperty("webdriver.firefox.driver","src/test/resources/driver/geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://todo.ly/");


    }
    @Test
    public void goToGoogle() throws InterruptedException {
        Thread.sleep(5000);


    }

    @AfterEach
    public void closeBrowser(){
        firefoxDriver.quit();
    }

}
