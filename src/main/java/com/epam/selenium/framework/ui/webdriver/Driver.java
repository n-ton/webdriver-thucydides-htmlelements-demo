package com.epam.selenium.framework.ui.webdriver;

import com.epam.selenium.framework.exceptions.MyElementNotFoundException;
import com.epam.selenium.framework.exceptions.UnknownDriverTypeException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton_Ostrenko on 12/11/2014.
 */
public class Driver {

    private static DriverTypes defaultDriverType = DriverTypes.CHROME;
    private WebDriver webDriver;
    private static Driver instance;

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    private Driver() {
    }

    public static Driver getInstance() {
        initDriverInstance(defaultDriverType);
        return instance;
    }

    public static Driver getInstance(DriverTypes type) {
        initDriverInstance(type);
        return instance;
    }


    static {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
    }

    public MyElement findElement(MethodTypes methodType, String locator) {
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
            case LINKTEXT:
                by = By.linkText(locator);
                break;
        }
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            WebElement element = this.webDriver.findElement(by);
            MyElement myElement = new MyElement();
            myElement.setElement(element);
            return myElement;
        } catch (NoSuchElementException e) {
            throw new MyElementNotFoundException("My element is not found: " + by);
        }
    }

    private static void initDriverInstance(DriverTypes driverType) {

        if (instance == null) {
            instance = new Driver();
            WebDriver webDriver;
            switch (driverType) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
                    webDriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    webDriver = new FirefoxDriver();
                    break;
                case IE:
                    webDriver = new InternetExplorerDriver();
                    break;
                default:
                    throw new UnknownDriverTypeException("Unknown WebDriver specified: " + driverType.getDriverName());
            }
            instance.setWebDriver(webDriver);
        }
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
        instance = null;
    }

    public void openPage(String url) {
        if (webDriver != null) {
            webDriver.get(url);
        }
    }

    public String getWindowTitle() {
        String title = null;
        if (webDriver != null) {
            title = webDriver.getTitle();
        }
        return title;
    }

    public List<MyElement> findElements(MethodTypes methodType, String locator) {
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
        }
        try {
            List<WebElement> elements = this.webDriver.findElements(by);
            List<MyElement> myElements = new ArrayList<MyElement>();
            for (WebElement element : elements) {
                MyElement myElement = new MyElement();
                myElement.setElement(element);
                myElements.add(myElement);
            }
            return myElements;
        } catch (NoSuchElementException e) {
            throw new MyElementNotFoundException("My element is not found: " + methodType.getMethodName() + ": " + by);
        }
    }
}


