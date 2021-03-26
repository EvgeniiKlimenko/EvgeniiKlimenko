package hw3.pages;

import hw2.LoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IndexPage {
    private WebDriver myDriver;

    @FindBy(id = "name")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitBtn;
// //*[@class='uui-navigation nav navbar-nav m-l8']/li[position()<5]/a
    // "/html/body/header/div/nav/ul[1]/li[position()<5]/a"
    @FindBy(xpath = ("//*[@class='uui-navigation nav navbar-nav m-l8']/li[position()<5]/a"))
    List<WebElement> headerHorizontalList;

    @FindBy(className = ("benefit-icon"))
    List<WebElement> benefitImagesList;

    @FindBy(xpath = ("//*[@class='col-sm-3']/div/span"))
    List<WebElement> benefitTextsList;

    @FindBy(xpath = ("//*[@class='sidebar-menu']/li[position()<6]/a/span"))
    List<WebElement> sideBarMenuList;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        myDriver = driver;
    }

    public void login(LoginUser loginUser) {
        myDriver.findElements(By.className("dropdown-toggle")).get(1).click();
        userField.sendKeys(loginUser.getLogin());
        this.passwordField.sendKeys(loginUser.getPassword());
        submitBtn.click();
    }

    public boolean isLoggedUserCorrect(LoginUser loginUser) {
        WebElement userName = myDriver.findElement(By.id("user-name"));
        return userName.getText().equals(loginUser.getCorrectName());
    }

    public List<WebElement> getHeaderHorizList() { return headerHorizontalList; }

    public List<WebElement> getBenefitImagesList() { return benefitImagesList; }

    public List<WebElement> getBenefitTextsList() { return benefitTextsList; }

    public List<WebElement> getSideBarMenuList() { return sideBarMenuList;}

    public WebElement getIFrameByName(String frameName) {
        return myDriver.findElement(By.id(frameName));
    }

    public void switchToDefaultContent() {
        myDriver.switchTo().defaultContent();
    }

    /**
     * Use only when content is switched to iFrame with switchToIFrameWButton()
     * @return button within iFrame
     */
    public WebElement getButtonFromIFrame() {
        return myDriver.findElement(By.xpath("/html/body/span/div/div/input"));
    }

    public void goToDifferentElementsPage() {
        WebElement headerListTop = myDriver.findElement(By.xpath("//*[@class='uui-navigation nav navbar-nav m-l8']"));
        myDriver.findElement(By.xpath("//header/div/nav/ul[1]/li[3]")).click();
        headerListTop.findElement(By.xpath("//li[3]/ul/li[8]/a")).click();
    }

}
