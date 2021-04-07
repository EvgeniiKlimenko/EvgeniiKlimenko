package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class IndexPage extends AbstractPage {
    private String URL = "https://jdi-testing.github.io/jdi-light/index.html";

    @FindBy(id = "name")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitBtn;

    @FindBy(xpath = ("*[@class='uui-navigation nav navbar-nav m-l8']/li[position()<5]"))
    private List<WebElement> headerHorizontalList;

    @FindBy(xpath = ("//*[@class='uui-navigation nav navbar-nav m-l8']"))
    private WebElement headerHorizontalMenu;

    @FindBy(className = ("benefit-icon"))
    private List<WebElement> benefitImagesList;

    @FindBy(xpath = ("//*[@class='col-sm-3']/div/span"))
    private List<WebElement> benefitTextsList;

    @FindBy(xpath = ("//*[@class='sidebar-menu']/li[position()<6]/a/span"))
    private List<WebElement> sideBarMenuList;

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openIndexPage() {
        myDriver.get(URL);
    }

    public void login(String login, String pass) {
        myDriver.findElements(By.className("dropdown-toggle")).get(1).click();
        userField.sendKeys(login);
        this.passwordField.sendKeys(pass);
        submitBtn.click();
    }

    public boolean isLoggedUserCorrect(String userExpectedName) {
        WebElement userName = myDriver.findElement(By.id("user-name"));
        return userName.getText().equals(userExpectedName);
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

    public WebElement getIFrameByName(String frameName) {
        return myDriver.findElement(By.id(frameName));
    }

    public void switchToDefaultContent() {
        myDriver.switchTo().defaultContent();
    }

    /**
     * Use only when content is switched to iFrame with switchToIFrameWButton()
     *
     * @return button within iFrame
     */
    public WebElement getButtonFromIFrame() {
        return myDriver.findElement(By.xpath("/html/body/span/div/div/input"));
    }

    /**
     * This method is for old HWs.
     */
    public void goToDifferentElementsPage() {
        clickOnServiceBtnWithinHeader();
        headerHorizontalMenu.findElement(By.xpath("//li[3]/ul/li[8]/a")).click();
    }

    public void goToIFrameWithButton(String name) {
        myDriver.switchTo().frame(name);
    }

    public void clickOnServiceBtnWithinHeader() {
        myDriver.findElement(By.xpath("//header/div/nav/ul[1]/li[3]")).click();
    }

    public void clickOnDiffElemsBtnWithinHeader() {
        headerHorizontalMenu.findElement(By.xpath("//li[3]/ul/li[8]/a")).click();
    }

    public void clickOnUserTableBtnWithinHeader() {
        headerHorizontalMenu.findElement(By.xpath("//li[3]/ul/li[6]/a")).click();
    }

}
