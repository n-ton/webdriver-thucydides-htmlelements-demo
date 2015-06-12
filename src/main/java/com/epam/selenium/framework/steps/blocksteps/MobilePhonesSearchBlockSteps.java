package com.epam.selenium.framework.steps.blocksteps;

import com.epam.selenium.framework.bo.filter.MobilePhoneFilter;
import com.epam.selenium.framework.ui.pages.MobilePhonesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class MobilePhonesSearchBlockSteps extends SearchBlockSteps {
    public MobilePhonesSearchBlockSteps(Pages pages) {
        super(pages);
    }

    private MobilePhonesPage onMobilePhonesPage() {
        return pages().get(MobilePhonesPage.class);
    }

    @Step
    public void selectPlatform(MobilePhoneFilter.Platforms platform) {
        onMobilePhonesPage().mobilePhonesSearch.platformSelect.selectByVisibleText(platform.getPlatformName());

    }

    @Step
    public void selectPlatform(String platform) {
        onMobilePhonesPage().mobilePhonesSearch.platformSelect.selectByVisibleText(platform);

    }

    @Step
    public void selectType(MobilePhoneFilter.Types type) {
        onMobilePhonesPage().mobilePhonesSearch.typeSelect.selectByVisibleText(type.getTypeName());
    }

    public void selectType(String type) {
        onMobilePhonesPage().mobilePhonesSearch.typeSelect.selectByVisibleText(type);
    }
}
