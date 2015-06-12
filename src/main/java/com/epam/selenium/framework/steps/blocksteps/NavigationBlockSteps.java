package com.epam.selenium.framework.steps.blocksteps;

import com.epam.selenium.framework.ui.pages.MarketMainPage;
import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class NavigationBlockSteps extends ScenarioSteps {
    public NavigationBlockSteps(Pages pages) {
        super(pages);
    }

    private MarketMainPage onMarketMainPage() {
        return pages().get(MarketMainPage.class);
    }

    @Step
    public void openCategory(NavigationBlock.Categories category) {
        onMarketMainPage().navigation.openCategory(category);
    }
}
