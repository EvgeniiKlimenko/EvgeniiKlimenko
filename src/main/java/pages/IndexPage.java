package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class IndexPage extends AbstractPage {
    private String HOME_PAGE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String DIFFERENT_ELEMENTS_REF_IN_HEADER_MENU_TOP = "//a[contains(text(), 'Different elements')]";
    private final String USER_TABLE_REF_IN_HEADER_MENU_TOP = "//a[contains(text(), 'User Table')]";
    //private final String SERVICE_BUTTON_IN_HEADER_TOP = "//a[contains(text(), 'Service')]";
    private final String BUTTON_IN_IFRAME = "#frame-button";

    @FindBy(id = ("user-icon"))
    private WebElement userIconLogin;

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

    @FindBy(xpath = ("//*[@class='uui-navigation nav navbar-nav m-l8']"))
    private WebElement headerHorizontalMenu;

    @FindBy(className = ("benefit-icon"))
    private List<WebElement> benefitImagesList;

    @FindBy(xpath = ("//*[@class='col-sm-3']/div/span"))
    private List<WebElement> benefitTextsList;

    @FindBy(xpath = ("//*[@class='sidebar-menu left']/li[position()<6]/a/span"))
    private List<WebElement> sideBarMenuList;

    @FindBy(xpath = ("//div/nav/ul[1]"))
    private WebElement headerMenuTop;

    @FindBy(xpath = ("//header//a[contains(. ,'Service')]"))
    private WebElement serviceTopMenuButton;

    @FindBy(id = ("frame"))
    private WebElement iFrameWithButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openIndexPage() {
        myDriver.get(HOME_PAGE_URL);
    }

    public void login(String login, String pass) {
        userIconLogin.click();
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

    public void clickOnServiceBtnWithinHeader() {
        serviceTopMenuButton.click();
        //myDriver.findElement(By.xpath(SERVICE_BUTTON_IN_HEADER_TOP)).click();
    }

    public void clickOnDiffElemsBtnWithinHeader() {
        headerHorizontalMenu.findElement(By.xpath(DIFFERENT_ELEMENTS_REF_IN_HEADER_MENU_TOP)).click();
    }

    public void clickOnUserTableBtnWithinHeader() {
        headerHorizontalMenu.findElement(By.xpath(USER_TABLE_REF_IN_HEADER_MENU_TOP)).click();
    }

     /**
     * Use only when content is switched to iFrame with goToIFrameByWebElement(iFrameWithButton)     *
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
