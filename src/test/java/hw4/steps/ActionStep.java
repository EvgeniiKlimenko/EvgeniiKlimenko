package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    private final String WATER_CHECKBOX_LOCATOR = "//label[contains(. ,'Water')]/input";
    private final String WIND_CHECKBOX_LOCATOR = "//label[contains(. ,'Wind')]/input";
    private final String SELEN_RADIO_BUTTON_LOCATOR = "//label[contains(. ,'Selen')]/input";
    private final String YELLOW_DROPDOWN_OPTION_LOCATOR = "//option[contains(. ,'Yellow')]";

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Change context to IFrame with button")
    public void goToIFrameWithButton() {
        indexPage.goToIFrameByWebElement(indexPage.getIFrameWithButton());
    }

    @Step("Change context back to home page")
    public void goBackToHomePage() {
        indexPage.switchToDefaultContent();
    }

    @Step("Go to Different elements page")
    public void goToDifferentElementsPage() {
        indexPage.goToDifferentElementsPage();
    }

    @Step("Select wind and water check boxes")
    public void selectCheckBoxes(String ... checkboxes) {
        difElPage.selectCheckBoxes(checkboxes);
    }

    @Step("Select Selen radio button")
    public void selectRadioButton(String radioButton) {
        difElPage.selectRadioButton(radioButton);
    }

    @Step("Select Yellow color from dropdown menu")
    public void selectFromDropdownMenu(String option) {
        difElPage.selectFromDropdownMenu(option);
    }

}
