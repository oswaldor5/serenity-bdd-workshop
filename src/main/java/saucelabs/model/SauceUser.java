package saucelabs.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SauceUser {
    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    PROBLEM_USER("problem_user", "secret_sauce"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user", "secret_sauce"),
    BAD_USER("bad_user", "bad_creds");

    private final String userName;
    private final String password;

    @Override
    public String toString() {
        return this.name();
    }
}
