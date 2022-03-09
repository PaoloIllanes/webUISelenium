package pages;

import control.Button;
import control.Image;

import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"));
     public Image currentProject =new Image(By.id("CurrentProjectTitle"));
}