package com.qa.web.test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.bsc.qa.crc.page.BscMicrosoftLogin;
import com.bsc.qa.crc.page.CrcLandingPage;
import com.bsc.qa.crc.page.CriteriaForm;
import com.bsc.qa.crc.page.DimensionalGraphicalRepresentation;
import com.bsc.qa.crc.page.ReportDetails;
import com.bsc.qa.crc.page.TabVerifyPage;
import com.bsc.qa.crc.page.ToolTipVerification;
import com.bsc.qa.crc.util.DataUtils;
import com.bsc.qa.crc.page.BscMicrosoftLogin;
import com.bsc.qa.crc.page.CrcLandingPage;
import com.bsc.qa.framework.base.BaseTest;
import com.bsc.qa.framework.factory.BrowserFactoryManager;
import com.bsc.qa.framework.utility.ExcelUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import cucumber.api.testng.TestNGCucumberRunner;

public class CrcHomePageTest extends BaseTest implements IHookable {
	
	//private TestNGCucumberRunner testNGCucumberRunner;
		private BscMicrosoftLogin bscMicrosoftLogin;
		private CrcLandingPage crcLandingPage;
		private TabVerifyPage tabVerifyPage ;
		private CriteriaForm criteriaForm= new CriteriaForm();
		private ToolTipVerification toolTipVerification;
		private DimensionalGraphicalRepresentation dimensionalGraphicalRepresentation;
		private ReportDetails reportDetails;
		private static Map<String, Map<String, String>> testDataMap = null;
		Map<String, String> graphMap=new HashMap<String, String>();
		private static DataUtils dataPicker= new DataUtils();
		private static Map<String, String> dataMap;
		Scenario scenario;
		private static ExtentTest bddLogger=null;
		String reviewId=null;
		ExcelUtils exclutls = new ExcelUtils();
	
	@DataProvider(name = "getData")
	private Object[][] getData(Method method) {
		Object[][] data = null;
		Map<String, String> dataMap = new HashMap<String, String>();

		String xlsPath = "src/test/resources/"
				+ this.getClass().getSimpleName() + ".xlsx";
		//dataMap = ExcelUtils.getTestMethodData(xlsPath, method.getName());
		dataMap = exclutls.getTestMethodData(xlsPath, method.getName());

		data = new Object[][] { { dataMap } };

		return data;
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
	
	@Test
	public void testAdministrationButtonIsClickable(Map<String, String> data) {
		//softAssert.assertTrue(true);
		System.out.println("test1 implemented");
	}

	@Test
	public void testReportsButtonIsClickable(Map<String, String> data) {
		//softAssert.assertTrue(true);
		System.out.println("test2 implemented");
	}

	


}
