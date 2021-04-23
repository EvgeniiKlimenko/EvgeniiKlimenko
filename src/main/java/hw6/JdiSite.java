package hw6;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw6.pages.JdiHomePage;
import hw6.pages.JdiMetalsAndColorsPage;
import hw6.pages.JdiPages;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    @Title("Home Page")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    @Title("Metal and Colors")
    public static JdiMetalsAndColorsPage jdiMetalsAndColorsPage;

    public static void goToPage(JdiPages jdiPage) {
        switch (jdiPage) {
            case HOME_PAGE:
                jdiHomePage.linkToHomePage.click();
                break;
            case METALS_AND_COLORS_PAGE:
                jdiHomePage.linkToMetalsAndColorsPage.click();
                break;
        }
    }

}
