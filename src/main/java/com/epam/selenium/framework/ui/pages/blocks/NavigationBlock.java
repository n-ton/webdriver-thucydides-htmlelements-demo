package com.epam.selenium.framework.ui.pages.blocks;

import com.epam.selenium.framework.ui.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@Name("Navigation block")
@Block(@FindBy(xpath = "//*[@class='topmenu i-bem topmenu_js_inited']"))
public class NavigationBlock extends HtmlElement {

    public void openMainCategory(MainCategories mainCategoryName) {
        Driver.getInstance().getWebDriver().findElement(By.linkText(mainCategoryName.getName())).click();
    }

    public void openCategory(Categories categoryName) {
        Actions actions = new Actions(Driver.getInstance().getWebDriver());
        switch (categoryName) {
            case MOBILE_PHONES:
                actions.moveToElement(Driver.getInstance().getWebDriver().findElement(By.linkText(MainCategories.ELECTRONICS.getName()))).perform();
                break;
            case TABLETS:
                actions.moveToElement(Driver.getInstance().getWebDriver().findElement(By.linkText(MainCategories.COMPUTERS.getName()))).perform();
                break;
        }
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getWebDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class][text()='" + categoryName.getName() + "'][child::img]")));
        actions.moveToElement(Driver.getInstance().getWebDriver().findElement(By.xpath("//*[@class][text()='" + categoryName.getName() + "'][child::img]")))
                .click()
                .perform();
    }

    public enum MainCategories {
        ELECTRONICS("Электроника"), COMPUTERS("Компьютеры");
        private final String name;

        MainCategories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Categories {
        MOBILE_PHONES("Мобильные телефоны"), TABLETS("Планшеты");
        private final String name;

        Categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
