package com.epam.selenium.framework.steps.blocksteps;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.bo.filter.TabletFilter;
import com.epam.selenium.framework.ui.pages.TabletsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class TabletsSearchBlockSteps extends SearchBlockSteps {
    public TabletsSearchBlockSteps(Pages pages) {
        super(pages);
    }

    private TabletsPage onTabletsPage() {
        return pages().get(TabletsPage.class);
    }

    @Step
    public void inputScreenSize(Filter.Conditions condition, String sizeInInches) {
        onTabletsPage().tabletsSearch.inputScreenSize(condition, sizeInInches);
    }

    @Step
    public void inputScreenSize(String condition, String sizeInInches) {
        onTabletsPage().tabletsSearch.inputScreenSize(condition, sizeInInches);
    }

    @Step
    public void selectOperationSystem(TabletFilter.OperationSystems operationSystem) {
        onTabletsPage().tabletsSearch.selectOperationSystem(operationSystem);
    }

    @Step
    public void selectOperationSystem(String operationSystem) {
        onTabletsPage().tabletsSearch.selectOperationSystem(operationSystem);
    }
}
