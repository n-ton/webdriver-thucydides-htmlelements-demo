package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.ui.webdriver.Driver;
import net.thucydides.core.annotations.At;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@At("http://yandex.ru/")
public class YandexMainPage extends PageObject {
    public YandexMainPage(WebDriver driver) {
        super(driver);

        if (!Driver.getInstance().getWindowTitle().equals("Яндекс")) {
            throw new IllegalStateException("You are not on the Yandex Main Page");
        }
    }

    @FindBy(id = "tab-market")
    public Link marketTab;

}
