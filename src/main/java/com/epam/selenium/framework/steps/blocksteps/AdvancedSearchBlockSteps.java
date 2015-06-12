package com.epam.selenium.framework.steps.blocksteps;

import com.epam.selenium.framework.ui.pages.FilteredProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class AdvancedSearchBlockSteps extends ScenarioSteps {
    public AdvancedSearchBlockSteps(Pages pages) {
        super(pages);
    }

    private FilteredProductPage onFilteredProductPage() {
        return pages().get(FilteredProductPage.class);
    }

    @Step
    public void selectVendor(List<String> vendor) {
        onFilteredProductPage().advancedSearch.selectVendor(vendor);
    }

    @Step
    public void clickSubmitButton() {
        onFilteredProductPage().advancedSearch.submitButton.click();
    }

}
