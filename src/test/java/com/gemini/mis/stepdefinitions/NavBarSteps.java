package com.gemini.mis.stepdefinitions;

import com.gemini.mis.pages.AccountPortalPage;
import com.gemini.mis.pages.NavBarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;


public class NavBarSteps extends PageObject {



    @Steps
    NavBarPage navPages;

    @Steps
    AccountPortalPage accountPage;

    @Then("^Verify user is redirected to landing page$")
    public void VerifyNavigationToLandingPage(){
        navPages.verifyUserRedirectedToLandingPage();
    }

    @Then("^Verify \"(.*?)\" disappears form current screen$")
    public void verifySideNavigationBarDisappears(String eleName){
        accountPage.verifyElementIsNotVisible(eleName);
    }

     @Then("^Verify navigation to landing page is successful after log in$")
    public void verifyNavigationToLandingPage(){
         accountPage.verifyElementOnCurrentPage("Profile card");
         waitABit(1500);
     }

    @And("^Verify all menu items are present in the dropdown$")
    public void verifyAllMenuItemsArePresentInTheDropdown() {
       navPages.verifyElementsPresent();
    }

    @Then("^Select \"(.*?)\" from technology dropdown on add skills window$")
    public void selectFromTechnologyDropdownOnAddSkillsWindow(String itemToBeSelected) {
        navPages.selectValueFromDropdown(itemToBeSelected);
    }

    @Then("^Select \"(.*?)\" from \"(.*?)\" dropdown on add skills window$")
    public void selectFromProficiencyDropdownOnAddSkillsWindow(String option, String dropdownName) {
        navPages.selectDropdownOption(option,dropdownName);
    }
    @And("^Enter \"(.*?)\" in \"(.*?)\" text field$")
    public void verifyTextFieldAndEnterText(String textToType,String fieldName){
        navPages.enterTextInField(textToType,fieldName);
    }

    @And("^Verify \"(.*?)\" Skill  is \"(.*?)\" and \"(.*?)\" added in my skills card$")
    public void verifySkillIsAddedInMySkillsCard(String skillName,String status,String expectedCondition) {
        navPages.verifySkillAdded(skillName,status,expectedCondition);
        getDriver().close();
    }
    @And("^Verify \"(.*?)\" is not added on my skill card$")
    public void verifyNoDuplicateSkillsAreAdded(String duplicateSkillName){
        navPages.verifyNoTwoSkillsArePresentWithSameName(duplicateSkillName);
    }

    @Then("^Verify Experience text field does not accepts invalid values like \"(.*?)\"$")
    public void verifyExperienceTextFieldDoesNotAcceptsInvalidValues(String value) {
        navPages.verifyInvalidValuesAreNotAllowed( value);
        getDriver().close();
    }

    @And("^Verify user is logged off and redirected to login page$")
    public void verifyUserIsLoggedOffAndRedirectedToLoginPage() {
        navPages.verifyRedirectedToLoginPage();
    }

    @Then("^Verify all check boxes are uncheck$")
    public void uncheckAndVerifyCheckBox(){
        navPages.uncheckAndVerifyAllCheckBox();
    }

    @And("^Verify no card is shown on the dashboard$")
   public void verifyIsCardsVisibleOnDashboard(){
        navPages.verifyNoCardIsShownOnTheDashboard();
    }

    @Then("^Select \"(.*?)\" from dropdown menu list$")
        public void selectFromMenuList(String optionName){
            navPages.SelectFromMenuOptions(optionName);
        }




    @Then("^Verify skill card window is closed$")
    public void verifySkillCardWindowIsClosed() {
        accountPage.verifyElementIsNotVisible("Add skills window");
    }

     @Then("^Verify \"(.*?)\" message appear in screen$")
     public void verifyMessageBoxAfterAddingRecord(String message){
         accountPage.verifyMessageBoxAfterAddingRecord(message);}

    @Then("^Open profile menu list from top right on navbar$")
    public void openProfileMenuList(){
        navPages.openProfileMenuList();
    }
    
      @Then("^Check all text box$")
    public void checkAllCards(){
        navPages.checkAllCards();
    }
    @And("^Verify all cards are visible on the dashboard$")
    public void verifyAllCardsAreShownOnDashboard(){
        navPages.verifyAllCardsAreShownOnDashboard();
    }


}
