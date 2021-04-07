package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenStep extends AbstractBaseStep {

    @When("I click 'Water' and 'Wind' checkboxes")
    public void iClickWaterWindCheckBoxes() {
        difElPage.selectCheckBoxes();
    }

    @When("I login as user 'Roman Iovlev'")
    public void iLoginAsAUserRoman() {
        indexPage.login(ROMAN_LOGIN, ROMAN_PASSWORD);
    }

    // write separate action for click on service menu
    @When("I click on 'Service' button in Header")
    public void iClickOnServiceMenuBtn() {
        indexPage.clickOnServiceBtnWithinHeader();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void iSelectVIPcheckBoxForName() {
        userTablePage.clickVipCheckBoxInTableForSergeyIvan();
    }

    @And("I click 'Selen' radiobutton")
    public void iClickRadioBtnWithName() {
        difElPage.selectRadioButton();
    }

    /**
     * This method works only in the context of "Different elements" Page
     */
    @And("I click 'Yellow' in dropdown menu")
    public void iClickDropdownMenuBtnWithName() {
        difElPage.selectFromDropdownMenu();
    }

    @And("I click on \"Different elements\" button in Service dropdown menu")
    public void iClickOnDifElemsBtnInServiceMenu() {
        indexPage.clickOnDiffElemsBtnWithinHeader();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void iClickOnUserTableBtnInServiceMenu() {
        indexPage.clickOnUserTableBtnWithinHeader();
    }



}
