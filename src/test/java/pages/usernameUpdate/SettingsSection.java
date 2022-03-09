package pages.usernameUpdate;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {

    public SettingsSection(String newUserName){
        this.newUserName=newUserName;

    }

    public String newUserName;
    public Button settingsButton =  new Button(By.xpath("//a[text()='Settings']"));
    public TextBox fullnameInput = new TextBox(By.id("FullNameInput"));
    public Button okButton =  new Button(By.xpath("//span[text()='Ok']"));


}
