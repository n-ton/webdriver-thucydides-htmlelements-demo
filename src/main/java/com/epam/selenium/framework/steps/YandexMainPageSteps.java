package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.ui.pages.YandexMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class YandexMainPageSteps extends ScenarioSteps {
    public YandexMainPageSteps(Pages pages) {
        super(pages);
    }

    private YandexMainPage onYandexMainPage() {
        return pages().get(YandexMainPage.class);
    }

    @Step
    public void openMarket() {
        onYandexMainPage().marketTab.click();
    }
}
