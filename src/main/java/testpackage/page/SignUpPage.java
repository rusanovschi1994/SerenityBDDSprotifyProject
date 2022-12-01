package testpackage.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

@DefaultUrl("https://www.spotify.com/md-ru/signup")
public class SignUpPage extends PageObject {

    private final By emailField = By.cssSelector("input#email");
    private final By confirmEmailField = By.cssSelector("input#confirm");
    private final By passwordField = By.cssSelector("input#password");
    private final By displayNameField = By.cssSelector("input#displayname");
    private final By dayField = By.cssSelector("input#day");
    private final By monthDropDown = By.cssSelector("select#month");
    private String optionMonthDropDown = "//select[@id=\"month\"]/option[text()=\"%s\"]";
    private final By yearField = By.cssSelector("input#year");
    private String genderRadioButton = "//label[contains(@for, \"gender_option\")]/span[text()=\"%s\"]";
    private String errorByText = "//div[@aria-label=\"Error indicator\" and text()=\"%s\"]";
    private final By errorLabel
            = By.xpath("//div[@aria-label=\"Error indicator\" and string-length(text())>0]|//div[@aria-label=\"Error indicator\"]/span");
    private final By notReceiveMessCheckBox = By.xpath("//label[@for=\"marketing-opt-checkbox\"]/span[2]");
    private final By shareCheckBox = By.xpath("//label[@for=\"third-party-checkbox\"]//span[2]/span");
    private final By agreeCheckBox = By.xpath("//label[@for=\"privacy-policy-checkbox\"]//span[2]/span");
    private final By signUpButton = By.xpath("//button[@type=\"submit\"]");

    public SignUpPage typeEmail(String email){

        find(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typeConfirmEmail(String email){

        find(confirmEmailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password){

        find(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeDisplayName(String displayName){

        find(displayNameField).sendKeys(displayName);
        return this;
    }

    public SignUpPage setDay(String day){

        find(dayField).sendKeys(day);
        return this;
    }

    public SignUpPage setMonth(String month){

        find(monthDropDown).click();
        find(By.xpath(format(optionMonthDropDown, month))).waitUntilVisible().click();
        return this;
    }

    public SignUpPage setYear(String year){

        find(yearField).sendKeys(year);
        return this;
    }

    public SignUpPage setGender(String gender){

        find(By.xpath(format(genderRadioButton, gender))).click();
        return this;
    }

    public SignUpPage setShareCheckBox(boolean value){

        WebElement checkBox = find(shareCheckBox);
        if(!checkBox.isSelected() == value){
            checkBox.click();
        }

        return this;
    }

    public SignUpPage setNotReceiveCheckBox(boolean value){

        WebElement checkBox = find(notReceiveMessCheckBox);
        if(!checkBox.isSelected() == value){

            checkBox.click();
        }

        return this;
    }

    public SignUpPage setAgreeCheckBox(boolean value){

        WebElement checkBox = find(agreeCheckBox);
        if(!checkBox.isSelected() == value){

            checkBox.click();
        }

        return this;
    }

    public void clickSignUpButton(){

     find(signUpButton).waitUntilVisible().click();
    }

    public List<WebElementFacade> getErrors(){

       return findAll(errorLabel);
    }

    public String getErrorByNumber(int number){

        return findAll(errorLabel).get(number - 1).getText();
    }

    public boolean isErrorVisible(String message){

        return findAll(By.xpath(format(errorByText, message))).size() > 0
                && findAll(By.xpath(format(errorByText, message))).get(0).isDisplayed();
    }
}
