package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.ui.webdriver.Driver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2014/12/28.
 */
public class UserSteps extends ScenarioSteps {
    public UserSteps(Pages pages) {
        super(pages);
        pages.setDriver(Driver.getInstance().getWebDriver());
    }

    @Steps
    public YandexMainPageSteps yandexMainPage;

    @Steps
    public MarketMainPageSteps marketMainPage;

    @Steps
    public FilteredMobilePhonesPageSteps filteredMobilePhonesPage;

    @Steps
    public FilteredTabletsPageSteps filteredTabletsPage;

    @Steps
    public MobilePhonesPageSteps mobilePhonesPage;

    @Steps
    public TabletsPageSteps tabletsPage;

    @Step
    public void navigateTo() {
        Driver.getInstance().openPage("http://yandex.ru/");
    }

    @Step
    public void closeBrowser() {
        Driver.getInstance().quitDriver();
    }

}
