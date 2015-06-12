package com.epam.selenium.framework.exceptions;

/**
 * @author Anton_Ostrenko on 12/17/2014.
 */
public class MyElementNotFoundException extends RuntimeException {

    public MyElementNotFoundException(String msg) {
        super(msg);
    }
}
