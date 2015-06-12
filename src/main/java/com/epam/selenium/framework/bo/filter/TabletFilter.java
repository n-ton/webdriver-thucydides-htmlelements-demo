package com.epam.selenium.framework.bo.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anton_Ostrenko on 2015/01/09.
 */
public class TabletFilter extends Filter {

    private Map<String, String> screenSize = new HashMap<>();
    private String operationSystem;

    private TabletFilter(String priceFrom, String priceTo, String[] vendors) {
        setPriceFrom(priceFrom);
        setPriceTo(priceTo);
        setVendors(vendors);
    }

    public String getScreenSize() {
        return screenSize.get("screenSize");
    }

    public String getScreenSizeCondition() {
        return screenSize.get("screenSizeCondition");
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public static Builder newBuilder(String priceFrom, String priceTo, String[] vendors) {
        return new TabletFilter(priceFrom, priceTo, vendors).new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setScreenSize(Conditions screenSizeCondition, String screenSize) {
            TabletFilter.this.screenSize.put("screenSizeCondition", screenSizeCondition.getConditionName());
            TabletFilter.this.screenSize.put("screenSize", screenSize);
            return this;
        }

        public Builder setOperationSystem(String operationSystem) {
            TabletFilter.this.operationSystem = operationSystem;
            return this;
        }

        public Builder setOperationSystem(OperationSystems operationSystem) {
            TabletFilter.this.operationSystem = operationSystem.getOperationSystemName();
            return this;
        }

        public TabletFilter build() {
            return TabletFilter.this;
        }
    }


    public enum OperationSystems {
        ANDROID("Android"), IOS("iOS"), DOS("DOS"), NOMATTER("неважно");

        private String operationSystemName;

        private OperationSystems(String operationSystemName) {
            this.operationSystemName = operationSystemName;
        }

        public String getOperationSystemName() {
            return operationSystemName;
        }
    }
}
