package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.MenuSection;
import pages.projectCRUD.ProjectCreate;
import pages.projectCRUD.ProjectDelete;
import pages.projectCRUD.ProjectUpdate;
import singleton.Session;

public class DeleteProjectTest extends BaseTodoLy{

    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    MenuSection menuSection = new MenuSection();
    ProjectCreate projectCreate = new ProjectCreate("UITest");
    ProjectUpdate projectUpdate = new ProjectUpdate("UiTestUpdate", projectCreate.projName);
    ProjectDelete projectDelete =  new ProjectDelete(projectUpdate.newProjName);
    @Test
    public void verifyDeleteTodoLy() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ui@upb.com");
        loginModal.pwdTxtBox.setText("123");
        loginModal.loginButton.click();
        projectCreate.addProj.click();
        projectCreate.nameProject.setText(projectCreate.projName);
        projectCreate.nameProjectButton.click();

        Assertions.assertTrue(menuSection.logoutButton.isControlDisplayed(),
                "ERROR no se pudo hacer el login");

        projectUpdate.getProject.click();
        projectUpdate.projectSubMenu.click();
        projectUpdate.subMenuEditButton.click();
        projectUpdate.editTextBox.clearSetText(projectUpdate.newProjName);
        projectUpdate.editSubmit.click();
        Thread.sleep(2000);

        Assertions.assertEquals(projectUpdate.newProjName,menuSection.currentProject.getTextControl());

        projectDelete.getProject.click();
        projectDelete.projectSubMenu.click();
        projectDelete.projectSubMenuDelete.click();
        Session.getInstance().getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        Assertions.assertTrue(!projectUpdate.newProjName.equals(menuSection.currentProject.getTextControl()));



    }

}
