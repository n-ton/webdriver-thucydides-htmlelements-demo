package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.steps.blocksteps.NavigationBlockSteps;
import com.epam.selenium.framework.steps.blocksteps.SearchBlockSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/15.
 */
public class ProductPageSteps extends ScenarioSteps {
    public ProductPageSteps(Pages pages) {
        super(pages);
    }

    @Steps
    public NavigationBlockSteps navigation;

    @Steps
    public SearchBlockSteps search;
}
