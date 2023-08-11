package com.qa.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.bsc.qa.framework.base.BasePage;

public class BscMicrosoftLogin extends BasePage{
	
    @FindBy(xpath ="//*[@id=\"i0116\" or @name=\"loginfmt\"]")
    private WebElement UsernameTextBox;
    
    @FindBy(xpath="//input[@id=\"idSIButton9\"]")
    
    private WebElement NextButton;
    
    @FindBy(xpath ="//*[@id=\"loginHeader\"]/div")
    private WebElement UserNamePageHeader;
    
    @FindBy(xpath="//*[@id=\"loginHeader\"]/div")
    private WebElement PasswordPageHeader;
    
    @FindBy(xpath ="//input[@id=\"idBtn_Back\"]")
    private WebElement Staysigninpopwindow;
    
    @FindBy(xpath="/html/head/title")
    private WebElement titleOfUsernamePage;
    
    public WebElement setTitleOfUsernamePage() {
    	return titleOfUsernamePage;
    }
    
    public void setUsernameTextBox(String username) {
    	UsernameTextBox.sendKeys(username);
    }
    
    public void NextButton() {
    	NextButton.click();
    }
    
    @FindBy(xpath ="//*[@id=\"i0118\" or @name=\"passwd\"]")
    private WebElement passwordTextBox;
    
    @FindBy(xpath="//input[ @id=\"idSIButton9\" or @value=\"Sign in\"]")
    private WebElement signButton;

    public void setPasswordTextBox(String password) {
    	passwordTextBox.sendKeys(password);
    }
    
    public void signButton(WebDriver driver) {
    	//driver.findElement(By.xpath("//input[@id=\"idSIButton9\" or @type=\"submit\"]")).click();
//    	System.out.println("sign in button is clickable?: "+ signButton.isEnabled() );
//    	System.out.println("sign in button is displayed?: "+ signButton.isDisplayed() );
//    	WebDriverWait wait=new WebDriverWait(driver, 3);
//    	wait.until(ExpectedConditions.presenceOfElementLocated ((By) signButton));
    	signButton.click();
    	
    	//signButton.sendKeys(Keys.ENTER);
    }
    public String UserNamePageHeader() {
    	return UserNamePageHeader.getText();
    }
    public String PasswordPageHeader() {
    	return PasswordPageHeader.getText();
    	
    }
    
    public void SetStaysigninpopwindow() {
    	Staysigninpopwindow.click();
    }
    
    
    public void login(String username,String password, WebDriver driver) {
       	try {
       	Thread.sleep(500);
    	setUsernameTextBox(username);
    	NextButton();
    	//Thread.sleep(500);
    	setPasswordTextBox(password);
    	Thread.sleep(500);
    	//signButton(driver);
    	//driver.findElement(By.)
    	driver.findElement(By.xpath("//input[@value=\"Sign in\"]")).click();
    	Thread.sleep(500);
    	SetStaysigninpopwindow();
    	Thread.sleep(500);
    	} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
    }

    public void loginWithCred(WebDriver driver) {
    	try {
			//	bscMicrosoftLogin.login(System.getenv("INVALIDUSERNAME"), System.getenv("PASSWORD"));
			login(System.getenv("USERNAME"), System.getenv("PASSWORD"), driver);

		}
		catch(Exception e) {

			if(driver.getTitle().equals("Sign in to your account") && UserNamePageHeader().equals("Sign in"))
			{
				String errorMsg1=driver.findElement(By.xpath("//div[@id=\"usernameError\"]")).getText();
				System.err.println("The error message is: "+errorMsg1);
				//bddLogger.log(LogStatus.INFO, "The error message is:  "+errorMsg1);
				
				
			}
			else if(driver.getTitle().equals("Sign in to your account") && PasswordPageHeader().equals("Enter password"))
			{
				String errorMsgpass1=driver.findElement(By.xpath("//*[@id=\"passwordError\"]")).getText();
				System.err.println("The error message is: "+errorMsgpass1);
				//bddLogger.log(LogStatus.INFO, "The error message is:  "+errorMsgpass1);
			}
			else
			{
				e.printStackTrace();
			}
		}
    }
	
}
