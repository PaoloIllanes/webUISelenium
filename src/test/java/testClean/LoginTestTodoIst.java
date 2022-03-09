package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoIst.LoginPageTodoIst;
import pages.todoIst.MainMenuLeftPart;
import pages.todoIst.MainPageTodoIst;

public class LoginTestTodoIst extends BaseTodoIst{
    MainPageTodoIst mainPageTodoIst= new MainPageTodoIst();
    LoginPageTodoIst loginPageTodoIst= new LoginPageTodoIst();
    MainMenuLeftPart mainMenuLeftPart =  new MainMenuLeftPart();

    @Test
    public void verifyLoginTodoLy() throws InterruptedException {
        mainPageTodoIst.loginImage.click();
        loginPageTodoIst.emailTextbox.setText("ui@upb.com");
        loginPageTodoIst.passwordTextbox.setText("1234567890");
        loginPageTodoIst.loginButton.click();
        Thread.sleep(2000);

        Assertions.assertTrue(mainMenuLeftPart.textProyectos.isControlDisplayed(),
                "ERROR no se pudo hacer el login");
    }

}
