package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Change context to IFrame with button")
    public void goToIFrameWithName(String name) {
        indexPage.goToIFrameWithButton(name);
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
        difElPage.selectCheckBoxes();
    }

    @Step("Select Selen radio button")
    public void selectRadioButton() {
        difElPage.selectRadioButton();
    }

    @Step("Select Yellow color from dropdown menu")
    public void selectFromDropdownMenu() {
        difElPage.selectFromDropdownMenu();
    }

}
