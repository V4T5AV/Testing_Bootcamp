package com.JotForm.TestCases;

import org.testng.annotations.Test;

import com.JotForm.Pages.BaseClass;
import com.JotForm.Pages.LoginPage;

public class LoginNopForm extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        LoginPage loginJotform = new LoginPage(driver);

        String username = excel.getStringData(
                "LoginHRM", 0, 0
        );

        String password = excel.getStringData(
                "LoginHRM", 0, 1
        );

        loginJotform.login_Jotform(
                username,
                password
        );
    }
}