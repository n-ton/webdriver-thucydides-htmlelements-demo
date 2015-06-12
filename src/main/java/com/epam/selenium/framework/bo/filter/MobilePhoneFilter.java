package com.epam.selenium.framework.bo.filter;

/**
 * @author Anton_Ostrenko on 2015/01/09.
 */
public class MobilePhoneFilter extends Filter {

    private String platform;
    private String type;

    private MobilePhoneFilter(String priceFrom, String priceTo, String[] vendors) {
        setPriceFrom(priceFrom);
        setPriceTo(priceTo);
        setVendors(vendors);
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getType() {
        return this.type;
    }

    public static Builder newBuilder(String priceFrom, String priceTo, String[] vendors) {
        return new MobilePhoneFilter(priceFrom, priceTo, vendors).new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setPlatform(String platform) {
            MobilePhoneFilter.this.platform = platform;
            return this;
        }

        public Builder setPlatform(Platforms platform) {
            MobilePhoneFilter.this.platform = platform.getPlatformName();
            return this;
        }

        public Builder setType(String type) {
            MobilePhoneFilter.this.type = type;
            return this;
        }

        public Builder setType(Types type) {
            MobilePhoneFilter.this.type = type.getTypeName();
            return this;
        }

        public MobilePhoneFilter build() {
            return MobilePhoneFilter.this;
        }

    }

    public enum Platforms {

        ANDROID("Android"), IOS("iOS"), NOMATTER("неважно");

        private String platformName;

        private Platforms(String platformName) {
            this.platformName = platformName;
        }

        public String getPlatformName() {
            return platformName;
        }

    }

    public enum Types {

        SMARTPHONE("смартфон/коммуникатор"), PHONE("телефон"), NOMATTER("неважно");

        private String typeName;

        private Types(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }
}
