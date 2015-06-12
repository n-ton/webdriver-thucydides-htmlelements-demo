package com.epam.selenium.framework.bo.filter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anton_Ostrenko on 2015/01/08.
 */
public class Filter {

    private String priceFrom;
    private String priceTo;
    private ArrayList<String> vendors = new ArrayList<>();

    public ArrayList<String> getVendors() {
        return vendors;
    }

    public String getPriceFrom() {
        return priceFrom;
    }

    public String getPriceTo() {
        return priceTo;
    }

    public void setVendors(String[] vendors) {
        Collections.addAll(this.vendors, vendors);
    }

    public void setPriceFrom(String priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(String priceTo) {
        this.priceTo = priceTo;
    }

    public enum Conditions {

        BEFORE("до"), FROM("от"), EQUAL("равно");

        private String conditionName;

        private Conditions(String conditionName) {
            this.conditionName = conditionName;
        }

        public String getConditionName() {
            return conditionName;
        }
    }

    public enum Vendors {

        Samsung("Samsung"), Acer("Acer");

        private String vendorName;

        private Vendors(String vendorName) {
            this.vendorName = vendorName;
        }

        public String getVendorName() {
            return vendorName;
        }
    }

}
