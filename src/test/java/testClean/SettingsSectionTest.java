package testClean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginModal;
import pages.MainPage;
import pages.usernameUpdate.SettingsSection;

public class SettingsSectionTest extends BaseTodoLy {

    MainPage mainPage= new MainPage();
    LoginModal loginModal= new LoginModal();
    SettingsSection settingsSection = new SettingsSection("NewUser");



    @Test
    public void verifyUserUpdate() throws InterruptedException {
        mainPage.loginImage.click();
        loginModal.emailTxtBox.setText("ui@upb.com");
        loginModal.pwdTxtBox.setText("123");
        loginModal.loginButton.click();
        Thread.sleep(2000);
        settingsSection.settingsButton.click();
        settingsSection.fullnameInput.clearSetText(settingsSection.newUserName);
        settingsSection.okButton.click();
        Thread.sleep(2000);
        settingsSection.settingsButton.click();
        Thread.sleep(2000);
        Assertions.assertTrue(settingsSection.newUserName.equals(settingsSection.fullnameInput.getTextAttributeControl("value")));





    }
}
