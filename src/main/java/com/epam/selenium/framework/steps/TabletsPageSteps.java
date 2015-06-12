package com.epam.selenium.framework.steps;

import com.epam.selenium.framework.steps.blocksteps.TabletsSearchBlockSteps;
import com.epam.selenium.framework.ui.pages.TabletsPage;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

/**
 * @author Anton_Ostrenko on 12/29/2014.
 */
public class TabletsPageSteps extends ProductPageSteps {
    public TabletsPageSteps(Pages pages) {
        super(pages);
    }

    private TabletsPage onTabletsPage() {
        return pages().get(TabletsPage.class);
    }

    @Steps
    public TabletsSearchBlockSteps search;

}
