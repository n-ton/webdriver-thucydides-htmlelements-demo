package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.steps.blocksteps.MobilePhonesSearchBlockSteps;
import com.epam.selenium.framework.ui.pages.MobilePhonesPage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 12/29/2014.
 */
public class MobilePhonesPageSteps extends ProductPageSteps {
    public MobilePhonesPageSteps(Pages pages) {
        super(pages);
    }

    private MobilePhonesPage onMobilePhonesPage() {
        return pages().get(MobilePhonesPage.class);
    }

    @Steps
    public MobilePhonesSearchBlockSteps search;

}
