package hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenStep extends AbstractBaseStep {
    private final String WATER_CHECKBOX_LOCATOR = "//label[contains(. ,'Water')]/input";
    private final String WIND_CHECKBOX_LOCATOR = "//label[contains(. ,'Wind')]/input";
    private final String SELEN_RADIO_BUTTON_LOCATOR = "//label[contains(. ,'Selen')]/input";
    private final String YELLOW_DROPDOWN_OPTION_LOCATOR = "//*[@class='colors']/select/option[4]";

    @When("I click 'Water' and 'Wind' checkboxes")
    public void iClickWaterWindCheckBoxes() {
        difElPage.selectElementsByXPath(WATER_CHECKBOX_LOCATOR, WIND_CHECKBOX_LOCATOR);
    }

    @When("I login as user 'Roman Iovlev'")
    public void iLoginAsAUserRoman() {
        indexPage.login(ROMAN_LOGIN, ROMAN_PASSWORD);
    }

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
        difElPage.selectElementsByXPath(SELEN_RADIO_BUTTON_LOCATOR);
    }

    /**
     * This method works only in the context of "Different elements" Page
     */
    @And("I click 'Yellow' in dropdown menu")
    public void iClickDropdownMenuBtnWithName() {
        difElPage.selectElementsByXPath(YELLOW_DROPDOWN_OPTION_LOCATOR);
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
