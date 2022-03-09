package pages.todoIst;

import control.Button;
import control.Image;
import control.TextBox;
import org.openqa.selenium.By;

public class MainMenuLeftPart {

    public Image currentProject = new Image(By.xpath("//div[@class='view_header__content']//span[@class='simple_content']"));
    public Image textProyectos = new Image(By.xpath("//span[text()='Proyectos']"));
    public Button addProjectButton= new Button(By.xpath("//button[@data-track='navigation|projects_quick_add']"));
    public TextBox textBoxProjectName= new TextBox(By.xpath("//input[@aria-describedby]"));
    public Button anadirButton= new Button(By.xpath("//button[text()='Añadir']"));
    public Image createdProject= new Image(By.xpath("//ul[@id='projects_list']//li[last()]"));
    public Button projectSubMenuButton= new Button(By.xpath("//ul[@id='projects_list']//li[last()]//button[@aria-label='Más acciones de proyecto']"));
    public Button editProjectButton= new Button(By.xpath("//div[text()='Editar proyecto']"));
    public Button deleteProjectButton= new Button(By.xpath("//div[text()='Eliminar proyecto']"));






}
