package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
//hw3
public class IndexPage extends AbstractPage {

    //private final String
    private final String DIFFERENT_ELEMENTS_REF_IN_HEADER_MENU_TOP = "//li[3]/ul/li[8]/a";
    private final String BUTTON_IN_IFRAME = "#frame-button";

    @FindBy(xpath = ("//header/div/nav/ul[2]/li/a"))
    private WebElement openLoginDropdownButton;

    @FindBy(id = "name")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitBtn;

    @FindBy(id = "user-name")
    private WebElement loggedUserName;

    @FindBy(xpath = ("//div/nav/ul[1]/li[position()<5]/a"))
    private List<WebElement> headerHorizontalList;

    @FindBy(className = ("benefit-icon"))
    private List<WebElement> benefitImagesList;

    @FindBy(xpath = ("//*[@class='col-sm-3']/div/span"))
    private List<WebElement> benefitTextsList;

    @FindBy(xpath = ("//*[@class='sidebar-menu left']/li[position()<6]/a/span"))
    private List<WebElement> sideBarMenuList;

    @FindBy(xpath = ("//div/nav/ul[1]"))
    private WebElement headerMenuTop;

    @FindBy(xpath = ("//header/div/nav/ul[1]/li[3]"))
    private WebElement serviceTopMenuButton;

    @FindBy(id = ("frame"))
    private WebElement iFrameWithButton;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String login, String pass) {
        openLoginDropdownButton.click();
        userField.sendKeys(login);
        passwordField.sendKeys(pass);
        submitBtn.click();
    }

    public boolean isLoggedUserCorrect(String userExpectedName) {
        return loggedUserName.getText().equals(userExpectedName);
    }

    public List<WebElement> getHeaderHorizList() {
        return headerHorizontalList;
    }

    public List<WebElement> getBenefitImagesList() {
        return benefitImagesList;
    }

    public List<WebElement> getBenefitTextsList() {
        return benefitTextsList;
    }

    public List<WebElement> getSideBarMenuList() {
        return sideBarMenuList;
    }

    public WebElement getIFrameWithButton() {
        return iFrameWithButton;
    }

    public void switchToDefaultContent() {
        myDriver.switchTo().defaultContent();
    }

    /**
     * Use only when content is switched to iFrame with goToIFrameByWebElement(iFrameWithButton)
     * @return button within iFrame
     */
    public WebElement getButtonFromIFrame() {
        return myDriver.findElement(By.cssSelector(BUTTON_IN_IFRAME));
    }

    public void goToDifferentElementsPage() {
        serviceTopMenuButton.click();
        headerMenuTop.findElement(By.xpath(DIFFERENT_ELEMENTS_REF_IN_HEADER_MENU_TOP)).click();
    }

    public void goToIFrameByWebElement(WebElement frameElement) {
        myDriver.switchTo().frame(frameElement);
    }

}
