package com.gemini.mis.implementations;

import com.gemini.mis.commonfunctions.CommonFunctions;
import com.gemini.mis.selectors.OrgStructureSelectors;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

public class OrgStructureImpl extends PageObject {

    //declarations
    private final OrgStructureSelectors os = new OrgStructureSelectors();
    private final CommonFunctions cf = new CommonFunctions();
    private final static Logger log = LoggerFactory.getLogger("SampleLogger");
    /*-----------------------------------------------------------------------------------------------------------*/

    /*-------------------------------FUNCTIONS SPECIFIC TO ORGANIZATION STRUCTURE--------------------------------*/

    public void searchEmployee(String Name) {
        $(os.searchBox).waitUntilVisible().sendKeys(Name);
        waitABit(4000);
        $(By.xpath("//*[@title='zoom in']")).click();
        By searchedEmployee = By.xpath("//*[text()='"+Name+"']");
        if($(searchedEmployee).isDisplayed()) {
            log.info("Employee search successful. " + Name + " found");
        }else {
            Assert.fail("Employee search failed. " + Name + " not found");
        }
    }

    public void printEmployeeDesig(String Name) {
        WebElementFacade searchedEmployee = $(By.xpath("(//*[local-name()='text' and text()='"+Name+"']//following-sibling::*[local-name()='text'])[1]"));
        waitABit(2000);
        System.out.println("Designation of "+ Name + " is " + searchedEmployee.getText());
    }

    public void countSeniorsWithReportees() {
        int seniorsCount = getDriver().findElements(os.seniors).size();
        System.out.println(seniorsCount + " seniors have reportees");
    }

    public String seniorWithMaxReportees() {
        int seniorsCount = getDriver().findElements(os.seniors).size();
        int[] reporteesCount = new int[seniorsCount+1];
        //get reportees count for each senior
        for(int i=1; i<=seniorsCount; i++) {
            reporteesCount[i] = Integer.parseInt($(By.xpath("(//*[local-name()='circle' and @display='block']//following-sibling::*[ local-name()='text' and @class='reporters-text'])["+i+"]")).getText());
        }
        //get index of max value from reporteesCount array
        int maxValue = Arrays.stream(reporteesCount).max().getAsInt();
        int countofMaxValue = 1;
        for(int i=1; i<seniorsCount; i++) {
            if(reporteesCount[i]==maxValue) {
                countofMaxValue = i;
            }
        }
        //get name of senior with max reportees
        String seniorName = $(By.xpath("((//*[local-name()='circle' and @display='block'])["+countofMaxValue+"]//preceding-sibling::*[local-name()='text'])[1]")).getText();
        return seniorName;
    }

    public void confirmSideArrows() {
        cf.hoverOver($(os.ceoCard));
        waitABit(1000);
        if($(os.arrowUp).isDisplayed() && $(os.arrowDown).isDisplayed() && $(os.arrowLeft).isDisplayed() && $(os.arrowRight).isDisplayed()) {
            log.info("Side arrows present on the page");
        }else {
            Assert.fail("Side arrows not present on the page");
        }
    }

    public void expandOrCompressSenior(String Name) {
        WebElementFacade btnExpComp = $(By.xpath("(//*[local-name()='text' and text()='"+Name+"']//following::*[local-name()='circle'])[3]"));
        btnExpComp.click();
//        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
//        executor.executeScript("arguments[0].focus();", btnExpComp);
//        executor.executeScript("arguments[0].click",btnExpComp);
    }

    public void verifyUpDownArrows() {
        //verify right arrow
        //verify left arrow
    }

    public void zoomOnDoubleClick() {
        Dimension sizeBeforeZoomIn = $(os.ceoCard).getSize();
        SerenityActions action = new SerenityActions(getDriver());
        action.doubleClick($(os.ceoCard)).perform();
        waitABit(3000);
        Dimension sizeAfterZoomIn = $(os.ceoCard).getSize();
        if (sizeBeforeZoomIn.width<sizeAfterZoomIn.width && sizeBeforeZoomIn.height<sizeAfterZoomIn.height) {
            log.info("Card zoomed in successfully");
        }else {
            Assert.fail("Card not zoomed in");
        }
        action.doubleClick($(os.ceoCard)).perform();
        waitABit(3000);
        Dimension sizeAfterZoomOut = $(os.ceoCard).getSize();
        if (sizeAfterZoomOut.width==sizeBeforeZoomIn.width && sizeAfterZoomOut.height==sizeBeforeZoomIn.height) {
            log.info("Card zoomed out successfully");
        }else {
            Assert.fail("Card not zoomed out");
        }
    }

    public void zoomInOrgStuct() {
        $(os.btnZoomIn).click();
        waitABit(1000);
        if(!$(os.rightMostCard).isDisplayed() && !$(os.leftMostCard).isDisplayed()) {
            log.info("Organization structure zoomed in successfully");
        }else {
            Assert.fail("Organization structure not zoomed in");
        }
    }

    public void verifyRightLeftArrows() {
        //verify right arrow
        //verify left arrow
    }

    public void zoomOutOrgStuct() {
        $(os.btnZoomOut).click();
        waitABit(1000);
        if($(os.rightMostCard).isDisplayed() && $(os.leftMostCard).isDisplayed()) {
            log.info("Organization structure zoomed out successfully");
        }else {
            Assert.fail("Organization structure not zoomed out");
        }
    }

}