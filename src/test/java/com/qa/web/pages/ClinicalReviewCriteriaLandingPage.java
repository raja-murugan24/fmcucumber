package com.qa.web.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.bsc.qa.framework.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ClinicalReviewCriteriaLandingPage extends BasePage{
	
	String pageTitle="Blue Shield of California | Clinical Review Criteria";
	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id=\"layoutContainers\"]/div/div[2]/div/section/div[2]/div[2]/div/div[1]/h1") })
	@CacheLookup
	List<WebElement> getMoreFromBlueShieldTextList;
	WebElement getMoreFromBlueShieldText;

	/*
	 * ===========helper functions ========
	 */



	public String getMoreFromBlueShieldText(ExtentTest logger) {
		logger.log(LogStatus.INFO, "Read value of first Image Text");
		getMoreFromBlueShieldText = listElement(getMoreFromBlueShieldTextList);
		return getMoreFromBlueShieldText.getText();
	}


	public boolean isLandingPage (ExtentTest logger) {
		logger.log(LogStatus.INFO, "Check if page title is "+pageTitle);
		System.out.println ("DB="+webDriver.getTitle());
		waitForPageToLoad(5);
		return true;
	}
	
	public void waitForPageToLoad(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
