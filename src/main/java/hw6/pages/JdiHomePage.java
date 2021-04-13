package hw6.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Link;
import hw6.entities.User;
import hw6.forms.LoginForm;

public class JdiHomePage extends WebPage {

    @XPath("//header/div/nav/ul[1]/li[4]/a")
    public Link linkToMetalsAndColorsPage;

    @Css("#login-form")
    public LoginForm loginForm;

    @FindBy(id = "user-icon")
    public Icon loginIcon;

    @FindBy(id = "user-name")
    public Label userName;

    public void login(User user) {
        loginIcon.click();
        loginForm.login(user);
    }

    public void goToMetalsAndColorsPage() {
        linkToMetalsAndColorsPage.click();
    }

    public String getUserName() {
        return userName.getText();
    }

}
