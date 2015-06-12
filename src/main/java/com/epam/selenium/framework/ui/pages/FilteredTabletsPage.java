package com.epam.selenium.framework.ui.pages;

import com.epam.selenium.framework.bo.filter.TabletFilter;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

/**
 * @author Anton_Ostrenko on 2015/01/06.
 */
public class FilteredTabletsPage extends FilteredProductPage {
    public FilteredTabletsPage(WebDriver driver) {
        super(driver);
    }

    public void assertScreenSize(TabletFilter filter) {
        List<Map<String, String>> products = collectFilteredProduct();
        for (Map product : products) {
            String name = product.get("name").toString();
            String description = product.get("description").toString();
            String temp = description.substring(0, description.indexOf(","));
            int actualScreenSize = Integer.parseInt(temp.substring(temp.indexOf(" ") + 1, temp.indexOf("\"")));
            int screenSize = Integer.parseInt(filter.getScreenSize());
            if (filter.getScreenSizeCondition().equals(TabletFilter.Conditions.FROM.getConditionName())) {
                Assert.assertTrue("Screen size of tablet <" + name + "> is not as expected", actualScreenSize >= screenSize);
            }
            if (filter.getScreenSizeCondition().equals(TabletFilter.Conditions.EQUAL.getConditionName())) {
                Assert.assertTrue("Screen size of tablet <" + name + "> is not as expected", actualScreenSize == screenSize);
            }
            if (filter.getScreenSizeCondition().equals(TabletFilter.Conditions.BEFORE.getConditionName())) {
                Assert.assertTrue("Screen size of tablet <" + name + "> is not as expected", actualScreenSize <= screenSize);
            }
        }
    }
}
