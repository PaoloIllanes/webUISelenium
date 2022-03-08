package basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;
import java.util.Date;

public class basicSelenium {
    EdgeDriver edgeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.edge.driver","src/test/resources/driver/msedgedriver.exe");
        edgeDriver = new EdgeDriver();
        // implicit wait
        edgeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        edgeDriver.manage().window().maximize();
        edgeDriver.get("http://todo.ly/");
    }


    @Test
    public void verifyLoginTodoLyu() throws InterruptedException {

        // click img login
        edgeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        edgeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("clean@upb22.com");
        // set test pwd
        edgeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("12345");
        // click boton login
        edgeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(2000);

        //creacion

        String nameProj="UPB"+new Date().getTime();
        edgeDriver.findElement(By.xpath("//td[text()='Add New Project']")).click();
        edgeDriver.findElement(By.id("NewProjNameInput")).sendKeys(nameProj);
        edgeDriver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(2000);
        Assertions.assertEquals(nameProj,edgeDriver.findElement(By.id("CurrentProjectTitle")).getText(),"ERROR no se creo el projecto");
        Assertions.assertTrue(edgeDriver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).isDisplayed(),"ERROR no creo el projecto");

        // Actualizacion

        edgeDriver.findElement(By.xpath("//li[last()]//td[text()='"+nameProj+"']")).click();
        edgeDriver.findElement(By.xpath("//div[@style='display: block;']/img")).click();
        edgeDriver.findElement(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']")).click();
        edgeDriver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).clear();

        String newNameProj="upb"+new Date().getTime();
        edgeDriver.findElement(By.xpath("//td/div/input[@id='ItemEditTextbox']")).sendKeys(newNameProj);
        edgeDriver.findElement(By.xpath("//td/div/img[@id='ItemEditSubmit']")).click();

        Thread.sleep(2000);
        Assertions.assertEquals(newNameProj,edgeDriver.findElement(By.id("CurrentProjectTitle")).getText(),"ERROR no se creo el projecto");
        Assertions.assertTrue(edgeDriver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).isDisplayed(),"ERROR no creo el projecto");

        // delete
        edgeDriver.findElement(By.xpath("//li[last()]//td[text()='"+newNameProj+"']")).click();
        edgeDriver.findElement(By.xpath("//div[@style='display: block;']/img")).click();
        edgeDriver.findElement(By.id("ProjShareMenuDel")).click();
        // ******* alerta   ***********
        edgeDriver.switchTo().alert().accept();
        Thread.sleep(2000);
        String currentName=edgeDriver.findElement(By.id("CurrentProjectTitle")).getText();
        Assertions.assertTrue(!currentName.equals(newNameProj),"ERROR el projecto no se Elimino");


    }

    @AfterEach
    public void closeBrowser(){
        edgeDriver.quit();
    }

}
