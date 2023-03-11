package com.juaracoding.cucumber;

import com.juaracoding.cucumber.pages.LoginPage;
import com.juaracoding.cucumber.pages.RecruitmentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestRecruitment {

    public static WebDriver driver;
    public static LoginPage pageLog = new LoginPage();
    public static RecruitmentPage pageRecruitment = new RecruitmentPage();

    public TestRecruitment(){
        driver = Hook.driver;
    }

    @When("Admin click menu recruitment")
    public void admin_click_menu_recruitment(){
        pageLog.login("Admin","admin123");
        System.out.println("Admin click menu recruitment");
        pageRecruitment.goRect();
    }
    @Then("Admin go to page recruitment")
    public void  admin_go_to_page_recruitment(){
        System.out.println("Admin go to page recruitment");
        Assert.assertEquals(pageRecruitment.getTextRec(),"Recruitment");
    }

}
