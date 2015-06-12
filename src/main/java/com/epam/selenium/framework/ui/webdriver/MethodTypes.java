package com.epam.selenium.framework.ui.webdriver;

/**
 * @author Anton_Ostrenko on 12/17/2014.
 */
public enum MethodTypes {

    XPATH("by xpath"), ID("by id"), NAME("by name"), CLASSNAME("by className"), TEXT("by text"), LINKTEXT("by link text");

    private String methodName;

    private MethodTypes(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

}
