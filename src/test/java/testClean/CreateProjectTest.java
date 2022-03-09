package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.projectCRUD.ProjectCreate;

public class CreateProjectTest extends BaseTodoLy{

    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    ProjectCreate projectCreate = new ProjectCreate("UI");

    @Test
    public void verifyCreateTodoLy(){
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ui@upb.com");
        loginModal.pwdTxtBox.setText("123");
        loginModal.loginButton.click();
        projectCreate.addProj.click();
        projectCreate.nameProject.setText(projectCreate.projName);
        projectCreate.nameProjectButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo hacer el login");
    }

}
