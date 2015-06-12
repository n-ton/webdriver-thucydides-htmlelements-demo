package com.epam.selenium.framework.ui.webdriver;

import com.epam.selenium.framework.exceptions.MyElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * @author Anton_Ostrenko on 12/17/2014.
 */
public class MyElement {

    private WebElement element;

    private By by;

    public void setElement(WebElement element) {
        this.element = element;
    }

    public WebElement getElement() {
        return this.element;
    }

    public By getBy() {
        return by;
    }

    public MyElement findElement(MethodTypes methodType, String locator) {
        Driver.getInstance().getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        By by = null;
        switch (methodType) {
            case XPATH:
                by = By.xpath(locator);
                break;
            case NAME:
                by = By.name(locator);
                break;
            case ID:
                by = By.id(locator);
                break;
            case CLASSNAME:
                by = By.className(locator);
                break;
            case TEXT:
                by = By.xpath("//*[text() = '" + locator + "']");
                break;
        }
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getInstance().getWebDriver(), 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            WebElement element = this.element.findElement(by);
            MyElement myElement = new MyElement();
            myElement.setElement(element);
            return myElement;
        } catch (NoSuchElementException e) {
            throw new MyElementNotFoundException("My element is not found: " + methodType.getMethodName() + ": " + by);
        }
    }

    public void click() {
        if (element != null) {
            element.click();
        } else {
            throw new NullPointerException("No such element was found");
        }
    }

    public void sendKeys(String str) {
        element.sendKeys(str);
    }

    public void clear() {
        if (element != null) {
            element.clear();
        } else {
            throw new NullPointerException("No such element was found");
        }
    }

    public void submit() {
        if (element != null) {
            element.submit();
        } else {
            throw new NullPointerException("No such element was found");
        }
    }

    public String getText() {
        if (element != null) {
            return element.getText();
        }
        return "No such element was found";
    }
}
