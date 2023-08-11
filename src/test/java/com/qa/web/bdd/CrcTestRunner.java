package com.qa.web.bdd;


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.support.PageFactory;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//import io.cucumber.*;
import com.bsc.qa.crc.page.TabVerifyPage;
import com.bsc.qa.crc.page.ToolTipVerification;
import com.bsc.qa.crc.page.BscMicrosoftLogin;
import com.bsc.qa.crc.page.CrcLandingPage;
import com.bsc.qa.crc.page.CriteriaForm;
import com.bsc.qa.crc.page.DimensionalGraphicalRepresentation;
import com.bsc.qa.crc.page.ReportDetails;
import com.bsc.qa.framework.base.BaseTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.TestNGCucumberRunner;



@CucumberOptions(
		features = { "src/test/resources/features"},
		plugin = { "pretty", "html:target/cucumber-reports/report", "json:target/cucumber.json" },
		glue= {"classpath:com.bsc.qa.crc.stepDefinition"})

public class CrcTestRunner extends BaseTest implements IHookable{
	private TestNGCucumberRunner testNGCucumberRunner;
	private BscMicrosoftLogin bscMicrosoftLogin;
	private CrcLandingPage crcLandingPage;
	private TabVerifyPage tabVerifyPage ;
	private CriteriaForm criteriaForm= new CriteriaForm();
	private ToolTipVerification toolTipVerification;
	private DimensionalGraphicalRepresentation dimensionalGraphicalRepresentation;
	private ReportDetails reportDetails;
	private static Map<String, Map<String, String>> testDataMap = null;
	Map<String, String> graphMap=new HashMap<String, String>();
	Scenario scenario;
	private static ExtentTest bddLogger=null;
	String reviewId=null;
	

	
	protected static Map<String, String> getTestData(String testName) {
		return testDataMap.get(testName);
	}
	

	
	protected void initBrowser(String testCaseName, String testMethodName) {
		initDriver(testMethodName);
		 
		bscMicrosoftLogin = PageFactory.initElements(driver, BscMicrosoftLogin.class);
		bscMicrosoftLogin.setPage(driver, environment, browser,testCaseName);
		//CrcLandingPage.isLandingPage(logger);

		crcLandingPage = PageFactory.initElements(driver, CrcLandingPage.class);
		crcLandingPage.setPage(driver, environment, browser,testCaseName);

		tabVerifyPage = PageFactory.initElements(driver, TabVerifyPage.class);
		tabVerifyPage.setPage(driver, environment, browser,testCaseName);
		
		criteriaForm = PageFactory.initElements(driver, CriteriaForm.class);
		criteriaForm.setPage(driver, environment, browser,testCaseName);
		
		toolTipVerification = PageFactory.initElements(driver, ToolTipVerification.class);
		toolTipVerification.setPage(driver, environment, browser,testCaseName);
		
		dimensionalGraphicalRepresentation = PageFactory.initElements(driver, DimensionalGraphicalRepresentation.class);
		dimensionalGraphicalRepresentation.setPage(driver, environment, browser,testCaseName);
		
		reportDetails = PageFactory.initElements(driver, ReportDetails.class);
		reportDetails.setPage(driver, environment, browser,testCaseName);
		
	
	}

	@Override
	public void run(IHookCallBack callBack, ITestResult testResult) {
		System.out.println ("IN RUN METHOD");
		reportInit(testResult.getTestContext().getName(), testResult.getMethod().getMethodName());
		initBrowser(testResult.getTestName(), testResult.getMethod().getMethodName());
		softAssert = new SoftAssert();
		bddLogger=logger;
		logger.log(LogStatus.INFO, "Starting test " + testResult.getName());
		callBack.runTestMethod(testResult);
		softAssert.assertAll();
		//run(callBack, testResult, data);
	}

	
	
	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		//readTestData();
		
	
	}

	

	@Test(groups = "cucumber", description = "Runs Cucumber Feature",priority=1)
	public void runFeatures() {
		
		System.out.println ("IN RUN FEATURES");
		//bscMicrosoftLogin.loginWithCred(driver);
		testNGCucumberRunner.runCukes();
		
	}
	
	
}