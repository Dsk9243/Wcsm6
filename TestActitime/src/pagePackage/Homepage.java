package pagePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	//Declaration
	

	
	@FindBy(name="username") private WebElement usn;
	@FindBy(name="pwd") private WebElement psw;
	@FindBy(id="loginButton") private WebElement loginBtn;
	@FindBy(xpath="//img[contains(@src,'timer')]") private WebElement logo;
     
	@FindBy(id="keepLoggedInCheckBox") private WebElement keepMeLoggedInCheckBox;
    @FindBy(xpath="//a[.='Logout']") private WebElement   logout;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Initialization
    public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//Utilization
	public WebElement getUsn() {
		return usn;
	}

	public WebElement getPsw() {
		return psw;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public WebElement getLogout() {
		return logout;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getKeepMeLoggedInCheckBox() {
		return keepMeLoggedInCheckBox;
	}
	       
	
	public void sendUsername() {
		usn.sendKeys("admin");
	}
	public void sendpassword() {
		psw.sendKeys("manager");
	}
	public void clickOnLoginButton() {
		loginBtn.click();
	}
	//generic reusable method
	public void validLogin(String validUsername,String validPassword) throws InterruptedException {
		usn.sendKeys(validUsername);
		psw.sendKeys(validPassword);
		Thread.sleep(2000);
		loginBtn.click();
		Thread.sleep(5000);
	}
	public void InvalidLigin(String InvalidUsername,String InvalidPassword) throws InterruptedException {
		usn.sendKeys(InvalidUsername);
		psw.sendKeys(InvalidPassword);
		Thread.sleep(3000);
		loginBtn.click();
		Thread.sleep(2000);
		usn.clear();
	}
	public void Logout() {
		logout.click();
	}
	
	}	

