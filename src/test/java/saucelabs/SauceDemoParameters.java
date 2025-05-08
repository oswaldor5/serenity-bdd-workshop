package saucelabs;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import saucelabs.actions.LoginActions;
import saucelabs.model.Messages;
import saucelabs.model.SauceUser;

import java.util.stream.Stream;

@ExtendWith(SerenityJUnit5Extension.class)
public class SauceDemoParameters {
    @Steps
    private LoginActions loginActions;

    @ParameterizedTest
    @EnumSource(names = {"STANDARD_USER","PROBLEM_USER","PERFORMANCE_GLITCH_USER"})
    public void loginTest(SauceUser sauceUser) {
        loginActions.openLoginPage();
        loginActions.loginAs(sauceUser);

        loginActions.verifyPageHeader();
    }

    private static Stream <Arguments> credentialsSource(){
        return Stream.of(
                Arguments.arguments(SauceUser.BAD_USER, Messages.INCORRECT_CREDENTIALS_ERROR),
                Arguments.arguments(SauceUser.LOCKED_OUT_USER,Messages.LOCKED_OUT_ERROR)
        );
    }

    @ParameterizedTest
    @MethodSource("credentialsSource")
    public void errorMessageTest(SauceUser sauceUser, String errorMessage) {
        loginActions.openLoginPage();
        loginActions.loginAs(sauceUser);

        loginActions.verifyErrorMessage(errorMessage);
    }
}
