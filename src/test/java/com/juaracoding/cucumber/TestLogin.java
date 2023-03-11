package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.LoginPage;
import com.juaracoding.cucumber.utils.Constant;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {

    public static WebDriver driver;
    public static LoginPage pageLog = new LoginPage();

    public TestLogin(){
        driver = Hook.driver;
    }


    @Given("User open browser and url")
    public void user_open_browser_and_url() {
        System.out.println("User open browser and url");
        driver.get(Constant.URL);
    }

    @Given("User click button logout")
    public void user_click_button_logout() {
        Hook.delay(1);
        System.out.println("User click button logout");
        pageLog.btnLogout();
    }

    @Given("User refresh web HRM")
    public void user_refresh_web_HRM() {
        Hook.delay(1);
        System.out.println("User refresh web HRM");
        driver.navigate().refresh();
    }

    @When("User enter valid username")
    public void user_enter_valid_username() {
        System.out.println("User enter valid username");
        logUs("Admin");
    }

    @When("User enter valid password")
    public void user_enter_valid_password() {
        System.out.println("User enter valid password");
        logPas("admin123");
    }

    @When("User click button login")
    public void user_click_button_login() {
        System.out.println("User click button login");
        pageLog.btnLogin();
    }

    @When("User enter invalid username")
    public void user_enter_invalid_username() {
        System.out.println("User enter invalid username");
        logUs("anakpejabatpajak");
    }

    @When("User enter invalid password")
    public void user_enter_invalid_password() {
        System.out.println("User enter invalid password");
        logPas("tapiboong");
    }

    @When("User empty username")
    public void user_empty_username() {
        System.out.println("User empty username");
        logUs("");
    }

    @When("User empty password")
    public void user_empty_password() {
        System.out.println("User empty password");
        logPas("");
        Hook.delay(1);
    }

    @Then("User go to page dashboard")
    public void user_go_to_page_dashboard() {
        System.out.println("User go to page dashboard");
        Assert.assertEquals(pageLog.getTxtDashboard(), "Dashboard");
    }

    @Then("User get message invalid credential")
    public void user_get_message_invalid_credential() {
        System.out.println("User get message invalid credential");
        Assert.assertEquals(pageLog.getTxtInvalid(), "Invalid credentials");
    }

    @Then("User get message required")
    public void user_ge_message_required() {
        System.out.println("User get message required");
        Assert.assertEquals(pageLog.getTxtReq(), "Required");
    }

    public void logUs(String user) {
        pageLog.enterUsername(user);
    }

    public void logPas(String pass) {
        pageLog.enterPassword(pass);
    }

}
