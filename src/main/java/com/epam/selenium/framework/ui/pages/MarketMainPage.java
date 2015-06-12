package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.webdriver.Driver;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * @author Anton_Ostrenko on 12/29/2014.
 */

@At("http://market.yandex.ru/")
public class MarketMainPage extends PageObject {
    public MarketMainPage(WebDriver driver) {
        super(driver);

        if (!Driver.getInstance().getWindowTitle().startsWith("Яндекс.Маркет")) {
            throw new IllegalStateException("You are not on the Market Page");
        }
    }

    public NavigationBlock navigation;
}
