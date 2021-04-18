package hw4.ex2;

import hw4.AbstractBaseTest;
import org.testng.annotations.Test;


public class Exercise2Test extends AbstractBaseTest {

    private final String  DIFFERENT_ELEMENTS_PAGE_TITLE_EXPECTED = "Different Elements";

    @Test(description = "Test different elements page, exercise 2")
    public void exerciseTwoTest() {
        //1. Open index page
        actionStep.openIndexPage();

        //2. Check title
        assertionStep.pageTitleIsCorrect(driver.getTitle(), super.HOME_PAGE_TITLE_EXPECTED);

        //3. Perform login
        actionStep.login(ROMAN_LOGIN, ROMAN_PASSWORD);

        //4. User name
        assertionStep.loggedInUserNameIsCorrect(ROMAN_CORRECT_NAME);

        //5. Service -> Different Elements Page
        actionStep.goToDifferentElementsPage();
        assertionStep.pageTitleIsCorrect(driver.getTitle(), DIFFERENT_ELEMENTS_PAGE_TITLE_EXPECTED);

        //6. Select checkboxes water and wind
        actionStep.selectCheckBoxes();

        //7. Select radio button selen
        actionStep.selectRadioButton();

        //8. Select dropdown yellow
        actionStep.selectFromDropdownMenu();

        //9. Check logs (Water, wind, selen, yellow)
        assertionStep.logListContainsSpecificLogs();
    }

}
