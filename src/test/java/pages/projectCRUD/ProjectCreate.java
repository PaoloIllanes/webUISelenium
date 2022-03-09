package pages.projectCRUD;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class ProjectCreate {

    public String projName;
    public ProjectCreate(String projName){
        this.projName=projName;
    }

    public Button addProj = new Button(By.xpath("//td[text()='Add New Project']"));
    public TextBox nameProject =  new TextBox(By.id("NewProjNameInput"));
    public TextBox nameProjectButton =  new TextBox(By.id("NewProjNameButton"));

}
