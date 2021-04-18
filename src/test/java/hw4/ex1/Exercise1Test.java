package hw4.ex1;

import hw4.AbstractBaseTest;
import org.testng.annotations.Test;



public class Exercise1Test extends AbstractBaseTest {

    private final String FRAME_WITH_BUTTON_NAME = "frame";


    @Test(description = "Test main page, exercise 1")
    public void exerciseOneTest() {
        //1. Open index page
        actionStep.openIndexPage();

        //2. Check title
        assertionStep.pageTitleIsCorrect(driver.getTitle(), super.HOME_PAGE_TITLE_EXPECTED);

        //3. Perform login
        actionStep.login(ROMAN_LOGIN, ROMAN_PASSWORD);

        //4. User name
        assertionStep.loggedInUserNameIsCorrect(ROMAN_CORRECT_NAME);

        //5. 4 items on the header
        assertionStep.checkHeaderItemsIsCorrect();

        //6. 4 images on the Index Page are displayed
        assertionStep.benefitImagesIsDisplayed();

        //7. 4 texts under images
        assertionStep.textsUnderImagesIsCorrect();

        //8. iFrame with button
        assertionStep.iFrameWithButtonIsDisplayed();

        //9. Switch to frame and check button
        actionStep.goToIFrameWithName(FRAME_WITH_BUTTON_NAME);
        assertionStep.buttonWithinIFrameIsDisplayed();

        //10. Switch back
        actionStep.goBackToHomePage();

        //11. Sidebar menu
        assertionStep.sidebarMenuContainsCorrectNames();

        //12. Closing is in Abstract parent class

    }

}
