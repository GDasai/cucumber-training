package com.ahold.ecommerce.definitions.snapshot;

import com.ahold.ecommerce.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Gegeven;
import io.qameta.allure.Step;
import javax.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sherwin on 2-7-2017.
 */
public class SnapshotStepDef extends BaseStepDef {
    private SnapshotPage snapshotPage;

    @PostConstruct
    public void setUp() {
        snapshotPage = PageFactory.initElements(webDriver, SnapshotPage.class);
    }


    /* E.g; resultLocation = "C://screenshots//" runtype = baseline or actual
            baseline means that a baseline is created of the current situation
            actual means that the baseline will be compared with with actual */
    @Gegeven("^Resultatenlocatie is \"([^\"]*)\" en runtype is \"([^\"]*)\" en marge is \"([^\"]*)\"")
    public void openAH(String resultLocation, String runtype, int marge){
        snapshotPage.setBaselineLocation(resultLocation);
        snapshotPage.setResultLocation(resultLocation);
        snapshotPage.setRunType(runtype);
        snapshotPage.setCompareMarge(marge);
        snapshotPage.navigateToAH();
    }


    @Step("Make a snapshot of the complete page")
    @Als("^ik een snapshot \"([^\"]*)\" maak en vergelijk$")
    public void ikEenSnapshotMaakEnVergelijk(String naam)  {
        snapshotPage.takeSnapshotAndCompare(naam,"");
    }

    @Step("Make a snapshot of an element on a page")
    @Als("^ik een snapshot \"([^\"]*)\" maak van een element \"([^\"]*)\" en vergelijk$")
    public void ikEenSnapshotMaakVanEenElementEnVergelijk(String naam, String element)  {
        snapshotPage.takeSnapshotAndCompare(naam,element);
    }


}
