package pages.projectCRUD;

import control.Button;
import control.TextBox;

import org.openqa.selenium.By;



public class ProjectUpdate {



    public String newProjName;
    public String actualProj;
    public Button getProject ;
    public Button projectSubMenu =  new Button(By.xpath("//div[@style='display: block;']/img"));
    public Button subMenuEditButton = new Button(By.xpath("//ul[contains(@style,'block')]/li/a[text()='Edit']"));
    public TextBox editTextBox = new TextBox(By.xpath("//td/div/input[@id='ItemEditTextbox']"));
    public Button editSubmit =  new Button(By.xpath("//td/div/img[@id='ItemEditSubmit']"));

    public ProjectUpdate(String newProjName,String actualProj){
        this.newProjName=newProjName;
        this.actualProj = actualProj;
        this.getProject =  new Button(By.xpath("//li[last()]//td[text()='"+actualProj+"']"));



    }
}
