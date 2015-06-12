package com.epam.selenium.framework.tests;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.bo.filter.TabletFilter;
import com.epam.selenium.framework.features.Application;
import com.epam.selenium.framework.steps.UserSteps;
import com.epam.selenium.framework.ui.pages.MarketMainPage;
import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.webdriver.Driver;
import javafx.scene.control.Tab;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * @author Anton_Ostrenko on 2014/12/28.
 */

@RunWith(ThucydidesRunner.class)
@Story(Application.YandexMarket.FilterTablets.class)
public class FilterTabletsTest extends BaseTest{

    private TabletFilter filter;

    @Before
    public void openTabletsCategory() {
        user.navigateTo();
        user.yandexMainPage.openMarket();
        user.marketMainPage.navigation.openCategory(NavigationBlock.Categories.TABLETS);
    }

    @Test
    public void filterTabletsByPriceAndScreenSize() {
        filter = TabletFilter.newBuilder("4500", "5000", new String[]{""}).setScreenSize(Filter.Conditions.EQUAL, "7").build();
        user.tabletsPage.search.inputPrice(filter.getPriceFrom(), filter.getPriceTo());
        user.tabletsPage.search.inputScreenSize(filter.getScreenSizeCondition(), filter.getScreenSize());
        user.tabletsPage.search.clickSubmitButton();
        user.filteredTabletsPage.assertPrice(filter);
        user.filteredTabletsPage.assertScreenSize(filter);
    }

    @Test
    public void filterTabletsByPriceAndOperationSystem_emptyResult() {
        filter = TabletFilter.newBuilder("2000", "3000", new String[]{""}).setOperationSystem(TabletFilter.OperationSystems.IOS).build();
        user.tabletsPage.search.inputPrice(filter.getPriceFrom(), filter.getPriceTo());
        user.tabletsPage.search.selectOperationSystem(filter.getOperationSystem());
        user.tabletsPage.search.clickSubmitButton();
        user.filteredTabletsPage.checkEmptyResult();
    }

}
