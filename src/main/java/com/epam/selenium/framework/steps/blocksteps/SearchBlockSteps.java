package com.epam.selenium.framework.steps.blocksteps;

import com.epam.selenium.framework.ui.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Anton_Ostrenko on 2015/01/14.
 */
public class SearchBlockSteps extends ScenarioSteps {
    public SearchBlockSteps(Pages pages) {
        super(pages);
    }

    private ProductPage onProductPage() {
        return pages().get(ProductPage.class);
    }

    @Step
    public void inputPriceFrom(String price) {
        onProductPage().search.priceFromInput.sendKeys(price);
    }

    @Step
    public void inputPriceTo(String price) {
        onProductPage().search.priceToInput.sendKeys(price);
    }

    @StepGroup("Ввод цены")
    public void inputPrice(String from, String to) {
        inputPriceFrom(from);
        inputPriceTo(to);
    }

    @Step
    public void clickLinkToAdvancedSearch() {
        onProductPage().search.linkToAdvancedSearch.click();
    }

    @Step
    public void clickSubmitButton() {
        onProductPage().search.submitButton.click();
    }
}
