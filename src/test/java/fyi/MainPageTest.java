package fyi;

import Driver.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MainPageTest extends Driver {
    MainPage mainPage;
    HelpPage helpPage;
    ContactUSPage contactUSPage;

    @BeforeMethod
    public void setUp() {
        mainPage = new MainPage(driver);
        helpPage = new HelpPage(driver);
        contactUSPage = new ContactUSPage(driver);
        mainPage.openFYIPage();
    }

    @Test(description = "Terms of Service Page Displays \"©2024 FYI.FYI, Inc.\" at the Botton")
    public void first_scenario() {
        Assert.assertEquals(mainPage.getCopyRightText(), "Terms of Service's text is incorrect");
    }

    @Test(description = "Hamburger Menu Contains Correct User Selection Options")
    public void second_scenario() {
        mainPage.clickOnMenuHamburgerIcon();
        List<String> expectedList = Arrays.asList("Home", "Help", "About us","The Team","Press","Terms of Service","Privacy Policy");
        List<String> actualList = mainPage.getListOfMenuItems();
        Assert.assertEquals(actualList, expectedList, "Menu Icons is not correct");
    }

    @Test(description = "Contact Support Button Redirects User to the Submit Request Page")
    public void third_scenario() {
        mainPage.clickOnMenuHamburgerIcon();
        mainPage.clickOnMenuLink("Help");
        mainPage.switchToTab(1);
        helpPage.clickOnContactUsButton();
        helpPage.switchToTab(2);
        Assert.assertTrue(helpPage.getCurrentPageUrl().contains("https://help.fyi.me/hc/en-us/requests/new"), "Contact us page url is not correct");
    }

    @Test(description = "Contact Support Button Redirects User to the Submit Request Page")
    public void fourth_scenario() {
        mainPage.clickOnMenuHamburgerIcon();
        mainPage.clickOnMenuLink("Help");
        mainPage.switchToTab(1);
        helpPage.clickOnContactUsButton();
        helpPage.switchToTab(2);
        contactUSPage.searchByText("AI");
        Assert.assertTrue(contactUSPage.getSearchSubHeadingText().contains("15"), "AI search result count is not 15");
    }
}
