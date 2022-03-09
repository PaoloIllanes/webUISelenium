package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.usernameUpdate.UserUpdate;

public class UserUpdateTest extends BaseTodoLy {

    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    UserUpdate userUpdate = new UserUpdate("NewUser");



    @Test
    public void verifyUserUpdate() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ui@upb.com");
        loginModal.pwdTxtBox.setText("123");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        userUpdate.settingsButton.click();
        userUpdate.fullnameInput.clearSetText(userUpdate.newUserName);
        userUpdate.okButton.click();
        Thread.sleep(2000);
        userUpdate.settingsButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(userUpdate.newUserName.equals(userUpdate.fullnameInput.getTextAttributeControl("value")));





    }
}
