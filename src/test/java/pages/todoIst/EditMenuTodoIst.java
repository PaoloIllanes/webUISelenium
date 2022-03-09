package pages.todoIst;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class EditMenuTodoIst {
    public TextBox editProjectTextbox = new TextBox(By.xpath("//div[@class='form_field']//input[@id='edit_project_modal_field_name']"));
    public Button saveProjectUpdate =  new Button(By.xpath("//button[text()='Guardar']"));
    public Button cancelEditButton =  new Button(By.xpath("//button[text()='Cancelar']"));
}
