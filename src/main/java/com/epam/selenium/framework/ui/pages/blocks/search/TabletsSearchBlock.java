package com.epam.selenium.framework.ui.pages.blocks.search;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.bo.filter.TabletFilter;
import com.epam.selenium.framework.ui.webdriver.Driver;
import com.epam.selenium.framework.ui.webdriver.MethodTypes;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@Name("Tablets Search block")
@Block(@FindBy(xpath = "//form[@name='hand-select']"))
public class TabletsSearchBlock extends SearchBlock {

    private static final String SCREENSIZE_XPATH = "//td[@class='label']/*[contains(text(),'Размер экрана')]/../following-sibling::td[@class='input']";
    private static final String SCREENSIZE_CONDITION_SELECT_XPATH = SCREENSIZE_XPATH + "/select";
    private static final String SCREENSIZE_INPUT_XPATH = SCREENSIZE_XPATH + "/input";
    private static final String OS_SELECT_XPATH = "//td[@class='label']/*[contains(text(),'Операционная система')]/../following-sibling::td[@class='input']";


    @FindBy(xpath = SCREENSIZE_CONDITION_SELECT_XPATH)
    public WebElement screenSizeConditionSelect;

    @FindBy(xpath = SCREENSIZE_INPUT_XPATH)
    public TextInput screenSizeInput;

    @FindBy(xpath = OS_SELECT_XPATH)
    public WebElement operationSystemSelect;

    public void inputScreenSize(Filter.Conditions condition, String sizeInInches) {
        screenSizeConditionSelect.click();
        Driver.getInstance().findElement(MethodTypes.XPATH, SCREENSIZE_CONDITION_SELECT_XPATH + "/option[text()='" + condition.getConditionName() + "']").click();
        screenSizeInput.sendKeys(sizeInInches);
    }

    public void inputScreenSize(String condition, String sizeInInches) {
        screenSizeConditionSelect.click();
        Driver.getInstance().findElement(MethodTypes.XPATH, SCREENSIZE_CONDITION_SELECT_XPATH + "/option[text()='" + condition + "']").click();
        screenSizeInput.sendKeys(sizeInInches);
    }

    public void selectOperationSystem(TabletFilter.OperationSystems operationSystem) {
        operationSystemSelect.click();
        Driver.getInstance().findElement(MethodTypes.XPATH, OS_SELECT_XPATH + "/select/option[text()='" + operationSystem.getOperationSystemName() + "']").click();
    }

    public void selectOperationSystem(String operationSystem) {
        operationSystemSelect.click();
        Driver.getInstance().findElement(MethodTypes.XPATH, OS_SELECT_XPATH + "/select/option[text()='" + operationSystem + "']").click();
    }

}
