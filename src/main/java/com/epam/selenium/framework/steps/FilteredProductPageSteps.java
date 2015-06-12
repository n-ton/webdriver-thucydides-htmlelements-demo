package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.steps.blocksteps.AdvancedSearchBlockSteps;
import com.epam.selenium.framework.steps.blocksteps.NavigationBlockSteps;
import com.epam.selenium.framework.ui.pages.FilteredProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/06.
 */
public class FilteredProductPageSteps extends ScenarioSteps {
    public FilteredProductPageSteps(Pages pages) {
        super(pages);
    }

    private FilteredProductPage onFilteredProductPage() {
        return pages().get(FilteredProductPage.class);
    }

    @Steps
    public NavigationBlockSteps navigation;

    @Steps
    public AdvancedSearchBlockSteps advancedSearch;

    @Step
    public void assertPrice(Filter filter) {
        onFilteredProductPage().assertPrice(filter);
    }

    @Step
    public void assertVendor(Filter filter) {
        onFilteredProductPage().assertVendor(filter);
    }

    @Step
    public void checkEmptyResult() {
        onFilteredProductPage().checkEmptyResult();
    }
}
