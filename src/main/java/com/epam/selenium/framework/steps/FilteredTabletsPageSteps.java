package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.bo.filter.TabletFilter;
import com.epam.selenium.framework.ui.pages.FilteredTabletsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 12/29/2014.
 */
public class FilteredTabletsPageSteps extends FilteredProductPageSteps {
    public FilteredTabletsPageSteps(Pages pages) {
        super(pages);
    }

    private FilteredTabletsPage onFilteredTabletsPage() {
        return pages().getPage(FilteredTabletsPage.class);
    }

    @Step
    public void assertScreenSize(TabletFilter filter) {
        onFilteredTabletsPage().assertScreenSize(filter);
    }
}
