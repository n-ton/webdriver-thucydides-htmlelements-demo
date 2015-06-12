package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.bo.filter.MobilePhoneFilter;
import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.pages.blocks.search.AdvancedSearchBlock;
import com.epam.selenium.framework.ui.webdriver.Driver;
import com.epam.selenium.framework.ui.webdriver.MethodTypes;
import junit.framework.Assert;
import net.thucydides.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anton_Ostrenko on 2015/01/15.
 */
public class FilteredProductPage extends PageObject {

    private final static int MAX_PRODUCT_ON_PAGE = 10;

    public FilteredProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//form[@style][child::div[@class='page__b-offers__guru']]")
    public WebElement filteredProductList;

    @FindBy(xpath = "//*[@class='b-pager i-bem b-pager_js_inited']")
    public WebElement pager;

    @FindBy(xpath = "//p[contains(text(),'выбрано')]")
    public WebElement productCount;

    public NavigationBlock navigation;
    public AdvancedSearchBlock advancedSearch;

    public List<Map<String, String>> collectFilteredProduct() {
        List<Map<String, String>> products = new ArrayList<>();
        for (int i = 0; i < getActivePagesNumber() + 1; i++) {
            List<WebElement> elements = filteredProductList.findElements(By.xpath("//div[@class='b-offers b-offers_type_guru']"));
            for (WebElement element : elements) {
                String nameOfProduct = element.findElement(By.className("b-offers__name")).getText().trim();
                String description = element.findElement(By.className("b-offers__spec")).getText().trim();
                String price = element.findElement(By.className("b-prices__num")).getText().trim();
                Map<String, String> product = new HashMap<>();
                product.put("name", nameOfProduct);
                product.put("description", description);
                product.put("price", price);
                products.add(product);
            }
            openNextPage();
        }
        return products;
    }

    public int getProductCount() {
        String s = productCount.getText().trim();
        return Integer.parseInt(s.substring(s.indexOf('—') + 2));
    }

    public int getActivePagesNumber() {
        return getProductCount() / MAX_PRODUCT_ON_PAGE;
    }

    public FilteredProductPage openPreviousPage() {
        if (getProductCount() > MAX_PRODUCT_ON_PAGE) {
            WebElement previousPageLink = pager.findElement(org.openqa.selenium.By.xpath("//span[@class='b-pager__active'][1]/a"));
            if (previousPageLink.getText().trim().equals("предыдущая"))
                previousPageLink.click();
        }
        return new FilteredProductPage(Driver.getInstance().getWebDriver());
    }

    public FilteredProductPage openNextPage(int timesToOpen) {
        for (int i = 0; i < timesToOpen; i++) {
            openNextPage();
        }
        return new FilteredProductPage(Driver.getInstance().getWebDriver());
    }

    public FilteredProductPage openNextPage() {
        if (getProductCount() > MAX_PRODUCT_ON_PAGE) {
            List<WebElement> nextPageLink = pager.findElements(org.openqa.selenium.By.xpath("//span[@class='b-pager__active']/a"));
            if (nextPageLink.size() != 2) {
                if (nextPageLink.get(0).getText().trim().equals("следующая"))
                    nextPageLink.get(0).click();
            } else {
                if (nextPageLink.get(1).getText().trim().equals("следующая"))
                    nextPageLink.get(1).click();
            }
        }
        return new FilteredProductPage(Driver.getInstance().getWebDriver());
    }

    public void assertPrice(Filter filter) {
        List<Map<String, String>> products = collectFilteredProduct();
        int priceFrom = Integer.parseInt(filter.getPriceFrom());
        int priceTo = Integer.parseInt(filter.getPriceTo());
        for (Map product : products) {
            String name = product.get("name").toString();
            int price = Integer.parseInt(product.get("price").toString().replaceAll(" ", "").trim());
            Assert.assertTrue("Price of product <" + name + "> : " + price + " is out of range: [" + priceFrom + " , " + priceTo + "]",
                    price >= priceFrom && price <= priceTo);
        }
    }

    public void assertVendor(Filter filter) {
        List<Map<String, String>> products = collectFilteredProduct();
        List<String> filterVendors = filter.getVendors();
        for (Map product : products) {
            String name = product.get("name").toString();
            String vendor = name.substring(0, name.indexOf(" "));
            for (int i = 0; i < filterVendors.size(); i++) {
                if (vendor.equals(filterVendors.get(i))) {
                    break;
                } else if (i == filterVendors.size() - 1) {
                    Assert.assertFalse("Vendor of product <\" + name + \" is not as expected.", false);
                }
            }
        }
    }

    //TODO
    public void assertVendors() {

    }

    public void checkEmptyResult() {
        Assert.assertEquals("Список не пуст или текст сообщения не правильный:", Driver.getInstance().findElement(MethodTypes.XPATH, "//p[@style]").getText(),
                "Заданным характеристикам не соответствует ни одна модель.");
    }
}
