package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class Edge implements IBrowser{
    @Override
    public WebDriver createBrowser() {
        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver.exe");
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    }
}