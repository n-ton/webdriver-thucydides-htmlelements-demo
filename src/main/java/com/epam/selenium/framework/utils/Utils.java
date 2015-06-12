package com.epam.selenium.framework.utils;

import com.epam.selenium.framework.ui.webdriver.Driver;
import org.openqa.selenium.JavascriptExecutor;

/**
 * @author Anton_Ostrenko on 2014/12/15.
 */
public class Utils {

    public static boolean isDocumentComplete(Driver driver) {
        String complete = ((JavascriptExecutor) driver.getWebDriver()).executeScript("return document.readyState").toString();
        System.out.println(complete);
        return complete.trim().equals("complete");
    }
}
