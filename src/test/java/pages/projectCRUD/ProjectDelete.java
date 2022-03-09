package pages.projectCRUD;

import control.Button;
import control.TextBox;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProjectDelete {


    public ProjectDelete(String projName){

        this.projName=projName;
        this.getProject=new Button(By.xpath("//li[last()]//td[text()='"+projName+"']"));
    }
    public String projName;
    public Button getProject;
    public Button projectSubMenu =  new Button(By.xpath("//div[@style='display: block;']/img"));
    public Button projectSubMenuDelete =  new Button(By.id("ProjShareMenuDel"));



}
