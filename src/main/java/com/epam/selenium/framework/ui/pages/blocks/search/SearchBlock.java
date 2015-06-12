package com.epam.selenium.framework.ui.pages.blocks.search;

import com.epam.selenium.framework.bo.filter.Filter;
import com.epam.selenium.framework.ui.pages.MarketMainPage;
import com.epam.selenium.framework.ui.pages.blocks.NavigationBlock;
import com.epam.selenium.framework.ui.webdriver.Driver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * @author Anton_Ostrenko on 1/13/2015.
 */
@Name("Search block")
@Block(@FindBy(xpath = "//form[@name='hand-select']"))
public class SearchBlock extends HtmlElement {

    private final static String PRICE_INPUTS_XPATH = "//input[@type='text'][parent::*[@class='input'][preceding-sibling::*[@class='label'][text()='Цена:']]]";

    @FindBy(xpath = PRICE_INPUTS_XPATH + "[1]")
    public TextInput priceFromInput;

    @FindBy(xpath = PRICE_INPUTS_XPATH + "[2]")
    public TextInput priceToInput;

    @FindBy(xpath = "//*[@href][contains(text(),'расширенный поиск')]")
    public Link linkToAdvancedSearch;

    @FindBy(xpath = "//input[@type='submit']")
    public Button submitButton;
}
