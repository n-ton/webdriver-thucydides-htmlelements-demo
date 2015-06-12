package com.epam.selenium.framework.tests;

import com.epam.selenium.framework.bo.filter.MobilePhoneFilter;
import com.epam.selenium.framework.features.Application;
import com.epam.selenium.framework.steps.UserSteps;
import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.webdriver.Driver;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Anton_Ostrenko on 2014/12/28.
 */

@RunWith(ThucydidesParameterizedRunner.class)
@Story(Application.YandexMarket.FilterMobilePhones.class)
public class FilterMobilePhonesTest extends BaseTest {

    @TestData
    public static Collection<Object[]> dataProvider() {
        return Arrays.asList(new Object[][]{
                {MobilePhoneFilter.newBuilder("100", "1000", new String[]{"Nokia"})
                        .setPlatform(MobilePhoneFilter.Platforms.NOMATTER)
                        .setType(MobilePhoneFilter.Types.PHONE)
                        .build()},
//                {MobilePhoneFilter.newBuilder("5000", "10000", new String[]{"Acer"})
//                        .setPlatform(MobilePhoneFilter.Platforms.ANDROID)
//                        .setType(MobilePhoneFilter.Types.NOMATTER)
//                        .build()},
//                {MobilePhoneFilter.newBuilder("14000", "15000", new String[]{"Samsung", "Acer"})
//                        .setPlatform(MobilePhoneFilter.Platforms.ANDROID)
//                        .setType(MobilePhoneFilter.Types.SMARTPHONE)
//                        .build()}
        });
    }

    private MobilePhoneFilter filter;

    public FilterMobilePhonesTest(MobilePhoneFilter filter) {
        this.filter = filter;
    }

    @Before
    public void openMobilePhonesCategory() {
        user.yandexMainPage.openMarket();
        user.marketMainPage.navigation.openCategory(NavigationBlock.Categories.MOBILE_PHONES);
    }

    @Test
    public void filterMobilePhones() {
        user.mobilePhonesPage.search.inputPrice(filter.getPriceFrom(), filter.getPriceTo());
        user.mobilePhonesPage.search.selectPlatform(filter.getPlatform());
        user.mobilePhonesPage.search.selectType(filter.getType());
        user.mobilePhonesPage.search.clickSubmitButton();
        user.filteredMobilePhonesPage.advancedSearch.selectVendor(filter.getVendors());
        user.filteredMobilePhonesPage.advancedSearch.clickSubmitButton();
        user.filteredMobilePhonesPage.assertPrice(filter);
        user.filteredMobilePhonesPage.assertVendor(filter);
    }

}
