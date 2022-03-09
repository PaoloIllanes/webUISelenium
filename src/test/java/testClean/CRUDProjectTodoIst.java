package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoIst.*;

public class CRUDProjectTodoIst extends BaseTodoIst{

    String projectName="NewProject";
    String projectNameUpdate = "UpdatedProject";
    MainPageTodoIst mainPageTodoIst= new MainPageTodoIst();
    LoginPageTodoIst loginPageTodoIst= new LoginPageTodoIst();
    EditMenuTodoIst editMenuTodoIst =  new EditMenuTodoIst();
    DeleteMenu deleteMenu= new DeleteMenu();
    MainMenuLeftPart mainMenuLeftPart =  new MainMenuLeftPart();

    @Test
    public void verifyCRUDTodoIst() throws InterruptedException {


        mainPageTodoIst.loginImage.click();
        loginPageTodoIst.emailTextbox.setText("ui@upb.com");
        loginPageTodoIst.passwordTextbox.setText("1234567890");
        loginPageTodoIst.loginButton.click();
        Thread.sleep(2000);

        Assertions.assertTrue(mainMenuLeftPart.textProyectos.isControlDisplayed(),
                "ERROR no se pudo hacer el login");
        //Create
        mainMenuLeftPart.addProjectButton.click();
        mainMenuLeftPart.textBoxProjectName.setText(projectName);
        mainMenuLeftPart.anadirButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals(projectName,mainMenuLeftPart.currentProject.getTextControl(),"No se creo el proyecto");

        //Update
        mainMenuLeftPart.createdProject.click();
        mainMenuLeftPart.projectSubMenuButton.click();
        mainMenuLeftPart.editProjectButton.click();
        editMenuTodoIst.editProjectTextbox.clearSetText(projectNameUpdate);
        editMenuTodoIst.saveProjectUpdate.click();
        Thread.sleep(2000);
        //Verify update
        mainMenuLeftPart.createdProject.click();
        mainMenuLeftPart.projectSubMenuButton.click();
        mainMenuLeftPart.editProjectButton.click();
        Thread.sleep(2000);

        Assertions.assertEquals(projectNameUpdate,editMenuTodoIst.editProjectTextbox.getTextAttributeControl("value"),"No se actualizo el proyecto");

        editMenuTodoIst.cancelEditButton.click();

        //Delete project

        mainMenuLeftPart.createdProject.click();
        mainMenuLeftPart.projectSubMenuButton.click();
        mainMenuLeftPart.deleteProjectButton.click();
        deleteMenu.eliminarButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(!projectNameUpdate.equals(mainMenuLeftPart.currentProject.getTextControl()),
                "No elimino el proyecto");




    }

}
