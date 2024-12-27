package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.PageBase;

public class PasswordStrengthChecker extends PageBase {


    private final WebElement inputPassword ;
    private final WebElement showPasswordCheckBox;
    private final WebElement showPasswordStrength;
    public PasswordStrengthChecker(WebDriver driver) {
        super(driver);
        inputPassword           = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lgd_out_pg_pass")));
        showPasswordCheckBox    = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showhide")));
        showPasswordStrength    = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("complexity-span")));
    }


    public String checkPasswordStrength(String password) {
        String strength = "Very Weak";
        if (password.matches(".*^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(),.?\\\":{}|<>]).{8,}$.*")) {
            strength = "Very Strong";
            System.out.println(strength);
        } else if (password.matches(".*^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$.*")) {
            strength = "Strong";
            System.out.println(strength);
        } else if (password.matches(".*^(?=.*[a-z])(?=.*[A-Z]).{6,}$.*")) {
            strength = "Medium";
            System.out.println(strength);
        } else if (password.matches(".*^[a-z]{5,}$.*")) {
            strength = "Weak";
            System.out.println(strength);
        }


        return strength;
    }
    public void Show_PassWord_CheckBox(){
        showPasswordCheckBox.click();
    }
    public void performPassword(String PassWord)
    {
        inputPassword.sendKeys(PassWord);
    }

    public String ShowTheStrength()
    {
        return showPasswordStrength.getText();

    }
    public void clearPasswordField() {
        inputPassword.clear();
    }

    }
