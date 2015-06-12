package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.ui.pages.blocks.search.MobilePhonesSearchBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Anton_Ostrenko on 2015/01/03.
 */
public class MobilePhonesPage extends ProductPage {

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public MobilePhonesSearchBlock mobilePhonesSearch;
}
