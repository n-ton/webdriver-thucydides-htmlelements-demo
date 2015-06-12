package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.ui.pages.FilteredMobilePhonesPage;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 12/29/2014.
 */
public class FilteredMobilePhonesPageSteps extends FilteredProductPageSteps {
    public FilteredMobilePhonesPageSteps(Pages pages) {
        super(pages);
    }

    private FilteredMobilePhonesPage onFilteredMobilePhonesPage() {
        return pages().get(FilteredMobilePhonesPage.class);
    }

}
