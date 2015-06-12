package com.epam.selenium.framework.ui.pages.blocks.search;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.bo.filter.MobilePhoneFilter;
import com.epam.selenium.framework.ui.pages.FilteredProductPage;
import com.epam.selenium.framework.ui.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@Name("Advanced Search block")
@Block(@FindBy(xpath = "//div[@class='resultsAddon']"))
public class AdvancedSearchBlock extends HtmlElement {

    @FindBy(xpath = "//*[@class='b-gurufilters__filter'][descendant::*[text()='Цена']]//input[1]")
    public TextInput priceFromInput;

    @FindBy(xpath = "//*[@class='b-gurufilters__filter'][descendant::*[text()='Цена']]//input[2]")
    public TextInput priceToInput;

    @FindBy(xpath = "//*[@class='b-gurufilters__filter'][descendant::*[text()='Популярные производители']|descendant::*[text()='Все производители']]")
    public WebElement vendors;

    @FindBy(xpath = "//input[@type='button'][@class='b-gurufilters_submit-button']")
    public Button submitButton;

    //TODO
    public void inputPrice(String from, String to) {
//        WebElement priceFilter = getFilter(MobilePhoneFilter.FilterParameters.PRICE);
//        WebElement inputFrom = priceFilter.findElement(By.xpath("//input[1]"));
//        WebElement inputTo = priceFilter.findElement(By.xpath("//input[2]"));
//        ((JavascriptExecutor) Driver.getInstance().getWebDriver()).executeScript("arguments[0].setAttribute('value', '" + from + "')", inputFrom);
//        ((JavascriptExecutor) Driver.getInstance().getWebDriver()).executeScript("arguments[0].setAttribute('value', '" + to + "')", inputTo);
//        inputFrom.sendKeys(from);
//        inputTo.sendKeys(to);
//        MobilePhoneFilter.setPriceFrom(from);
//        MobilePhoneFilter.setPriceTo(to);
    }

    public void selectVendor(Filter.Vendors vendor) {
        WebElement checkbox = vendors
                .findElement(By.xpath("//*[@type='checkbox'][following-sibling::span[contains(text(),'" + vendor.getVendorName() + "')]]"));
        if (!checkbox.isDisplayed()) {
            WebElement all = checkbox.findElement(By.xpath("//preceding::span[text()='все'][preceding-sibling::*[text()='Все производители']]"));
            all.click();
        }
        checkbox.click();
        if (!checkbox.isSelected())
            throw new NullPointerException(vendor.getVendorName() + " is not selected.");
    }

    public void selectVendor(List<String> vendor) {
        for (int i = 0; i < vendor.size(); i++) {
            WebElement checkbox = vendors
                    .findElement(By.xpath("//*[@type='checkbox'][following-sibling::span[contains(text(),'" + vendor.get(i) + "')]]"));
            if (!checkbox.isDisplayed()) {
                WebElement all = checkbox.findElement(By.xpath("//preceding::span[text()='все'][preceding-sibling::*[text()='Все производители']]"));
                all.click();
            }
            checkbox.click();
            if (!checkbox.isSelected())
                throw new IllegalStateException(vendor + " is not selected.");
        }
    }

    public void selectVendor(String vendor) {
        WebElement checkbox = vendors
                .findElement(By.xpath("//*[@type='checkbox'][following-sibling::span[contains(text(),'" + vendor + "')]]"));
        if (!checkbox.isDisplayed()) {
            WebElement all = checkbox.findElement(By.xpath("//preceding::span[text()='все'][preceding-sibling::*[text()='Все производители']]"));
            all.click();
        }
        checkbox.click();
        if (!checkbox.isSelected())
            throw new NullPointerException(vendor + " is not selected.");
    }

    public FilteredProductPage clickSubmitButton() {
        submitButton.click();
        return new FilteredProductPage(Driver.getInstance().getWebDriver());
    }
}
