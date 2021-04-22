package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractStep {

    private final String WATER_CHECKBOX_LOCATOR = "//label[contains(. ,'Water')]/input";
    private final String WIND_CHECKBOX_LOCATOR = "//label[contains(. ,'Wind')]/input";
    private final String SELEN_RADIO_BUTTON_LOCATOR = "//label[contains(. ,'Selen')]/input";
    private final String YELLOW_DROPDOWN_OPTION_LOCATOR = "//*[@class='colors']/select/option[4]";
    private final String DIFFERENT_ELEMENTS_PAGE_TITLE_EXPECTED = "Different Elements";

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
    public void selectCheckBoxes() {
        difElPage.selectElementsByXPath(WATER_CHECKBOX_LOCATOR, WIND_CHECKBOX_LOCATOR);
    }

    @Step("Select Selen radio button")
    public void selectRadioButton() {
        difElPage.selectElementsByXPath(SELEN_RADIO_BUTTON_LOCATOR);
    }

    @Step("Select Yellow color from dropdown menu")
    public void selectFromDropdownMenu() {
        difElPage.selectElementsByXPath(YELLOW_DROPDOWN_OPTION_LOCATOR);
    }

}
