package testpackage.steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import testpackage.page.SignUpPage;

public class SignUpSteps {

    SignUpPage page;

    @Step
    public void open_signup_page(){

        page.open();
    }

    @Step
    public void type_email(String email){

        page.typeEmail(email);
    }

    @Step
    public void type_confirmation_email(String email){

        page.typeConfirmEmail(email);
    }

    @Step
    public void type_password(String password){

        page.typePassword(password);
    }

    @Step
    public void type_name(String name){

        page.typeDisplayName(name);
    }

    @Step
    public void set_day(String day){

        page.setDay(day);
    }

    @Step
    public void set_month(String month){

        page.setMonth(month);
    }

    @Step
    public void set_year(String year){

        page.setYear(year);
    }

    @Step
    public void select_gender(String gender){

        page.setGender(gender);
    }

    @Step
    public void set_not_receive_messages(boolean value){

        page.setNotReceiveCheckBox(value);
    }

    @Step
    public void set_share(boolean value){

        page.setShareCheckBox(value);
    }

    @Step
    public void set_agree_policy(boolean value){

        page.setAgreeCheckBox(value);
    }

    @Step
    public void sign_up(){

        page.clickSignUpButton();
    }

    @Step
    public void should_see_error(String message){

        Assertions.assertThat(page.isErrorVisible(message))
                .as("User should see message, but he doesn't")
                .isTrue();
    }

    @Step
    public void should_not_see_error(String message){

        Assertions.assertThat(page.isErrorVisible(message))
                .as("User should not see message, but he does")
                .isFalse();
    }

    @Step
    public void should_see_error_number(int number){

        Assertions.assertThat(page.getErrors()).hasSize(number);
    }

    @Step
    public void should_see_error_by_number(String message, int number){

        Assertions.assertThat(page.getErrorByNumber(number)).isEqualTo(message);
    }
}
