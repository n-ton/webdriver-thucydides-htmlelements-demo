package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.ui.pages.blocks.search.TabletsSearchBlock;
import net.thucydides.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Anton_Ostrenko on 2015/01/03.
 */
public class TabletsPage extends ProductPage {

    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    public TabletsSearchBlock tabletsSearch;
}
