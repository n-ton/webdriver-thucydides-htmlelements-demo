package com.epam.selenium.framework.ui.pages.blocks.search;

import com.epam.selenium.framework.bo.filter.MobilePhoneFilter;
import com.epam.selenium.framework.ui.webdriver.Driver;
import com.epam.selenium.framework.ui.webdriver.MethodTypes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@Name("Mobile Phones Search block")
@Block(@FindBy(xpath = "//form[@name='hand-select']"))
public class MobilePhonesSearchBlock extends SearchBlock {

    private static final String PLATFORM_SELECT_XPATH = "//select[parent::*[preceding-sibling::*[@class='label'][child::*[contains(text(),'Платформа:')]]]]";
    private static final String TYPE_SELECT_XPATH = "//select[parent::*[preceding-sibling::*[@class='label'][child::*[contains(text(),'Тип:')]]]]";

    @FindBy(xpath = PLATFORM_SELECT_XPATH)
    public Select platformSelect;

    @FindBy(xpath = TYPE_SELECT_XPATH)
    public Select typeSelect;

    public void selectPlatform(MobilePhoneFilter.Platforms platform) {

        Driver.getInstance().findElement(MethodTypes.XPATH, PLATFORM_SELECT_XPATH + "/select/option[text()='" + platform.getPlatformName() + "']").click();
    }

    public void selectPlatform(String platformName) {
        Driver.getInstance().findElement(MethodTypes.XPATH, PLATFORM_SELECT_XPATH + "/select/option[text()='" + platformName + "']").click();
    }

    public void selectType(MobilePhoneFilter.Types type) {
        Driver.getInstance().findElement(MethodTypes.XPATH, TYPE_SELECT_XPATH + "/select/option[text()='" + type.getTypeName() + "']").click();
    }

}
