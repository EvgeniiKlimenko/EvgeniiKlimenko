package hw3.pages;

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
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement submitBtn;

    @FindBy(xpath = ("/html/body/header/div/nav/ul[1]/li[position()<5]/a"))
    List<WebElement> headerHorizontalList;

    @FindBy(className = ("benefit-icon"))
    List<WebElement> benefitImagesList;

    @FindBy(xpath = ("/html/body/div/div[2]/main/div[2]/div[2]/div[position()<5]/div/span"))
    List<WebElement> benefitTextsList;

    @FindBy(xpath = ("/html/body/div/div[1]/div/div[1]/div/div[1]/ul/li[position()<6]/a/span"))
    List<WebElement> sideBarMenuList;

    public IndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        myDriver = driver;
    }

    public void login(String userName, String password) {
        myDriver.findElements(By.className("dropdown-toggle")).get(1).click();
        user.sendKeys(userName);
        this.password.sendKeys(password);
        submitBtn.click();
    }

    public boolean isLoggedUserCorrect(String nameToCheck) {
        WebElement userName = myDriver.findElement(By.id("user-name"));
        return userName.getText().equals(nameToCheck);
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
