package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.pages.blocks.search.SearchBlock;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * @author Anton_Ostrenko on 2015/01/15.
 */
public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public NavigationBlock navigation;
    public SearchBlock search;
}
