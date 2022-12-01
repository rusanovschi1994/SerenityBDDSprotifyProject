import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testpackage.steps.SignUpSteps;

@RunWith(SerenityRunner.class)
public class WhenSignUpTest {

    @Steps
    SignUpSteps step;

    @Managed
    WebDriver driver;


    @Test
    public void typeInvalidYearTest(){

        step.open_signup_page();
        step.set_day("11");
        step.set_month("December");
        step.set_year("99");
        step.select_gender("Male");
        step.should_see_error("Need_Error");
        step.should_not_see_error("Enter a name for your profile");
    }

    @Test
    public void typeInvalidConfirmEmailTest(){

        step.open_signup_page();
        step.type_email("rusanovschi1994@mail.ru");
        step.type_confirmation_email("rus@gmail.com");
        step.type_password("1111");
        step.type_name("Cristi");
        step.should_see_error("The email addresses don't match.");
    }

    @Test
    public void signUpWithEmptyPasswordTest(){

        step.open_signup_page();
        step.type_email("sadasdasd");
        step.type_confirmation_email("sdwwwwrwer");
        step.type_name("Test");
        step.should_not_see_error("You need to enter a password");
    }

    @Test
    public void typeInvalidValuesTest(){

        step.open_signup_page();
        step.type_email("sdasdas@");
        step.type_confirmation_email("ttt@gmaiul");
        step.type_password("1111");
        step.type_name("123");
        step.set_day("12");
        step.set_month("December");
        step.set_year("99");
        step.set_agree_policy(true);
        step.set_share(true);
        step.select_gender("Male");
        step.should_see_error_number(7);
        step.should_see_error_by_number("Your password is too short.", 4);
    }
}
