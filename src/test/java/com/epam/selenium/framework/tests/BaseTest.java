package com.epam.selenium.framework.tests;

import com.epam.selenium.framework.steps.UserSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

/**
 * @author Anton_Ostrenko on 2/2/2015.
 */
public class BaseTest {

    @Managed
    public WebDriver driver;

    @ManagedPages()
    public Pages pages;

    @Steps
    public UserSteps user;

    @Before
    public void openBrowser() {
        user.navigateTo();
    }

    @After
    public void closeBrowser() {
        user.closeBrowser();
    }

}
