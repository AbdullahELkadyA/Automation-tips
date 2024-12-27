import Pages.PasswordStrengthChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PasswordStrengthCheckerTest extends TestBase{



    private PasswordStrengthChecker passwordStrengthChecker;

    @BeforeClass
    public void setupPageObject() {
        passwordStrengthChecker = new PasswordStrengthChecker(driver);
    }
    @Test
    public void testStrongPassword() {
        passwordStrengthChecker.Show_PassWord_CheckBox();
        String password = "Aa120kjmp";
        passwordStrengthChecker.performPassword(password);
        assertEquals(passwordStrengthChecker.ShowTheStrength(), passwordStrengthChecker.checkPasswordStrength(password));
        passwordStrengthChecker.clearPasswordField();
    }
    @Test
    public void testVeryStrongPassword() {
        String password = "P@ss87g@#$%@d";
        passwordStrengthChecker.performPassword(password);
        assertEquals(passwordStrengthChecker.ShowTheStrength(), passwordStrengthChecker.checkPasswordStrength(password));
        passwordStrengthChecker.clearPasswordField();
    }
    @Test
    public void testMediumPassword() {
        String password = "bgfbvcAd";
        passwordStrengthChecker.performPassword(password);
        assertEquals(passwordStrengthChecker.ShowTheStrength(), passwordStrengthChecker.checkPasswordStrength(password));
        passwordStrengthChecker.clearPasswordField();
    }
    @Test
    public void testWeakPassword() {
        String password = "sdassssw";
        passwordStrengthChecker.performPassword(password);
        Assert.assertEquals(passwordStrengthChecker.ShowTheStrength(), passwordStrengthChecker.checkPasswordStrength(password));
        passwordStrengthChecker.clearPasswordField();
    }
    @Test
    public void testVeryWeakPassword() {
        String password = "sdaa";
        passwordStrengthChecker.performPassword(password);
        assertEquals(passwordStrengthChecker.ShowTheStrength(), passwordStrengthChecker.checkPasswordStrength(password));
        passwordStrengthChecker.clearPasswordField();
    }


}
