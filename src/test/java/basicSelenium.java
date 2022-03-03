import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class basicSelenium {
    EdgeDriver edgeDriver;
    @BeforeEach
    public void openBrowser(){

        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver.exe");
        edgeDriver = new EdgeDriver();
        edgeDriver.get("https://todo.ly/");
        // login xp //*[@id="ctl00_MainContent_PanelNotAuth"]/div[2]/div[1]/div[2]/a/img
        // email //*[@id="ctl00_MainContent_LoginControl1_TextBoxEmail"]
        //pwd //*[@id="ctl00_MainContent_LoginControl1_TextBoxPassword"]
        //login //*[@id="ctl00_MainContent_LoginControl1_ButtonLogin"]

    }
    @Test
    public void goToGoogle() throws InterruptedException {


        edgeDriver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PanelNotAuth\"]/div[2]/div[1]/div[2]/a/img")).click();
        edgeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("upb_api@api.com");
        edgeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        edgeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

    }

    @AfterEach
    public void closeBrowser(){
        edgeDriver.quit();
    }

}
