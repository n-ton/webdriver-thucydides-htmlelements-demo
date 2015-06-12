package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.steps.blocksteps.NavigationBlockSteps;
import com.epam.selenium.framework.ui.pages.MarketMainPage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/03.
 */
public class MarketMainPageSteps extends ScenarioSteps {
    public MarketMainPageSteps(Pages pages) {
        super(pages);
    }

    private MarketMainPage onMarketMainPage() {
        return pages().get(MarketMainPage.class);
    }

    @Steps
    public NavigationBlockSteps navigation;
}


