package com.epam.selenium.framework.ui.webdriver;

/**
 * @author Anton_Ostrenko on 12/11/2014.
 */
public enum DriverTypes {

    FIREFOX("firefox"), IE("internet explorer"), CHROME("chrome");

    private String driverName;

    private DriverTypes(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverName() {
        return driverName;
    }
}
