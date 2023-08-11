package com.qa.web.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;
import com.bsc.qa.crc.bdd.CrcTestRunner;
import com.bsc.qa.crc.page.BscMicrosoftLogin;
import com.bsc.qa.crc.page.CrcLandingPage;
import com.bsc.qa.crc.page.CriteriaForm;
import com.bsc.qa.crc.page.DimensionalGraphicalRepresentation;
import com.bsc.qa.crc.page.ReportDetails;
import com.bsc.qa.crc.page.TabVerifyPage;
import com.bsc.qa.crc.page.ToolTipVerification;
import com.bsc.qa.crc.util.DataUtils;
import com.bsc.qa.framework.base.BaseTest;
import com.bsc.qa.framework.utility.ExcelUtils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions extends BaseTest implements IHookable {
	private BscMicrosoftLogin bscMicrosoftLogin;
	private CrcLandingPage crcLandingPage;
	private TabVerifyPage tabVerifyPage ;
	private CriteriaForm criteriaForm= new CriteriaForm();
	private ToolTipVerification toolTipVerification;
	private DimensionalGraphicalRepresentation dimensionalGraphicalRepresentation;
	private ReportDetails reportDetails;
	private static Map<String, Map<String, String>> testDataMap = null;
	Map<String, String> graphMap=new HashMap<String, String>();
	private static DataUtils dataUtils= new DataUtils();
	private static Map<String, String> dataMap;
	
	private static ExtentTest bddLogger=null;
	String reviewId=null;
	Scenario sc;
	CrcTestRunner runner=new CrcTestRunner();
//	IHookCallBack callBack; 
//	ITestResult testResult;
//	WebDriver driver=null;
//	static String BROWSER_NAME = "chrome";
//	static String S_DRVER ="src\\test\\resources\\selenium_standalone_binaries\\windows\\googlechrome\\64bit\\chromedriver.exe";
//	static String URL="https://crc-qa1.bsc.bscal.com/clinicalreviewcriteria/crc/home";
//	static String PLATFORM_NAME="";
//	static String IMPLICIT_WAIT="true";
//	static String HEADLESS="true";
//	static String BROWSER_DIMS="1200,1000";
//	static String PORTAL_NAME="";
//	static String EXEC_TYPE="";
//	static String SCREEN_RESOLITION="";
	
	
	static {
		dataMap= dataUtils.getRandomData();
	}
	public StepDefinitions() {
		//dataMap= dataPicker.getRandomData();
		readTestData();
		
		
	}
	protected static Map<String, String> getTestData(String testName) {
		return testDataMap.get(testName);
	}
	
	private void readTestData() {
		String xlsPath = "src/test/resources/CriteriaFormPage.xlsx";
		testDataMap = new ExcelUtils().cacheAllExcelData(xlsPath);
		System.out.println("Loading data from " + xlsPath);
		System.out.println(testDataMap);
	}
	
	
//	private static void initWebDriver(String browserName, String sdriver, String url, String implicitWaitString,
//			String headlessString, String browserDimensions) {
//		 driver = BrowserFactory.startBrowser(browserName, sdriver, url, implicitWaitString, headlessString,
//				browserDimensions);
//		BrowserFactoryManager.setWebDriver(driver);
//	}
//	public WebDriver startBrowser(String browserName, String sdriver, String url, String implicitWaitString,
//			String headlessString, String browserDimensions) {
//		
//		WebDriver webDriver = null;
//		System.setProperty("webdriver.chrome.driver", sdriver);
//		ChromeOptions chromeOptions = new ChromeOptions();
//
//		// ChromeDriver is just AWFUL because every version or two it breaks unless you
//		// pass cryptic arguments
//		// AGRESSIVE: options.setPageLoadStrategy(PageLoadStrategy.NONE); //
//		// https://www.skptricks.com/2018/08/timed-out-receiving-message-from-renderer-selenium.html
//		// options.addArguments("start-maximized"); //
//		// https://stackoverflow.com/a/26283818/1689770
//		// chromeOptions.addArguments("enable-automation"); //
//		// https://stackoverflow.com/a/43840128/1689770
//		if (headless != null && !"".equals(headless) && !"false".equals(headless) && "true".equals(headless)) {
//			chromeOptions.addArguments("--headless"); // only if you are ACTUALLY running headless
//		}
//		if (browserDimensions != null && !"".equals(browserDimensions)) {
//			chromeOptions.addArguments("--window-size=" + browserDimensions); // https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
//		}
//		// chromeOptions.addArguments("log-level=3");
//		chromeOptions.addArguments("--no-sandbox"); // https://stackoverflow.com/a/50725918/1689770
//		chromeOptions.addArguments("--disable-infobars"); // https://stackoverflow.com/a/43840128/1689770
//		chromeOptions.addArguments("--disable-dev-shm-usage"); // https://stackoverflow.com/a/50725918/1689770
//		chromeOptions.addArguments("--disable-browser-side-navigation"); // https://stackoverflow.com/a/49123152/1689770
//		chromeOptions.addArguments("--disable-gpu"); // https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
//		chromeOptions.addArguments("--ignore-certificate-errors");
//		chromeOptions.setAcceptInsecureCerts(true);
//		Map<String, Object> experimentalOptions = new HashMap<String, Object>();
//		experimentalOptions.put("download.default_directory", System.getenv("DOWNLOADED_REPORT_PATH"));
//		chromeOptions.setExperimentalOption("prefs", experimentalOptions);
//
//		// driver = new ChromeDriver(options);
//		// webDriver = new ChromeDriver(options);
//		chromeOptions.addArguments("--incognito");
//		DesiredCapabilities desiredCapabilitiesChrome = DesiredCapabilities.chrome();
//		desiredCapabilitiesChrome.setCapability("applicationCacheEnabled", false);
//		desiredCapabilitiesChrome.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//		desiredCapabilitiesChrome.setCapability("tunnelIdentifier", "BlueShieldCA");
//		if (browserName.toLowerCase().contains("-hub")) {
//			String gridUrl = System.getenv("SAUCELABS_HUB_URL");
//			if (gridUrl == null || "".equals(gridUrl)) {
//				gridUrl = System.getenv("BQSA_HUB_URL");
//			}
//			System.out.println("Connecting to hub: " + gridUrl);
//			try {
//				webDriver = new RemoteWebDriver(new URL(gridUrl), desiredCapabilitiesChrome);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			System.setProperty("webdriver.chrome.driver", sdriver);
//			webDriver = new ChromeDriver(desiredCapabilitiesChrome);
//		}
//		if (browserDimensions == null && "".equals(browserDimensions)) {
//			webDriver.manage().window().maximize();
//		}
//		// webDriver.get("chrome://settings/clearBrowserData");
//		// webDriver.switchTo().activeElement();
//		// webDriver.findElement(By.cssSelector("#clearBrowsingDataConfirm")).click();
//	
//		
//				return driver;
//		
//	}

	protected void initBrowser(String testCaseName, String testMethodName) {
		initDriver(testMethodName);
		 
//		String browserName = "chrome";
//		
//		String sdriver = S_DRVER;
//		String url = URL;
//		String platformName = PLATFORM_NAME;
//		// TODO: PUT IN CHECK FOR ENVNAME_WEB NOT SET IN ENV
//		url = url.replace("ENVNAME_WEB", System.getenv("ENVNAME_WEB"));
//		String implicitWaitString = IMPLICIT_WAIT;
//		String headlessString =HEADLESS;
//		String browserDimensions = BROWSER_DIMS;
//		String portalName =PORTAL_NAME;
//		String executionType =EXEC_TYPE;
//		String screenResolution = SCREEN_RESOLITION;
//		
////		initWebDriver( browserName,  sdriver,  url,  implicitWaitString,
////				 headlessString,  browserDimensions);
//		
//		
//		driver = BrowserFactory.startBrowser(browserName, sdriver, url, implicitWaitString, headlessString,
//				browserDimensions);
//		BrowserFactoryManager.setWebDriver(driver);
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
	
	@Before
	public void initiateElements(Scenario s) {
		this.sc=s;
		initBrowser("login with valid cred", "login page");
		
	}
	public void screenshot()  {
	    TakesScreenshot screenshot=(TakesScreenshot)driver;
	    String name=sc.getName();
	     byte[] data=screenshot.getScreenshotAs(OutputType.BYTES);
	     File screenshotsave=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     try {
	        FileUtils.copyFile(screenshotsave ,new File ("./target/cucumber-reports/"+ sc.getName()+".png"));
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	     sc.embed(data, "image/png");

	    }
	@Given("^browser is navigated to Microsoft login page$")
	public void browser_is_navigated_to_Microsoft_login_page(){
		//initBrowser("login with valid cred", "login page");
		System.out.println("login started");

	}

	@When("^user submit valid credentials to CRC web application$")
	public void user_submit_valid_credentials_to_CRC_web_application() {
		try {
			//	bscMicrosoftLogin.login(System.getenv("INVALIDUSERNAME"), System.getenv("PASSWORD"));
			bscMicrosoftLogin.login(System.getenv("USERNAME"), System.getenv("PASSWORD"), driver);

		}
		catch(Exception e) {

			if(driver.getTitle().equals("Sign in to your account") && bscMicrosoftLogin.UserNamePageHeader().equals("Sign in"))
			{
				String errorMsg1=driver.findElement(By.xpath("//div[@id=\"usernameError\"]")).getText();
				System.err.println("The error message is: "+errorMsg1);
				//bddLogger.log(LogStatus.INFO, "The error message is:  "+errorMsg1);
				
				
			}
			else if(driver.getTitle().equals("Sign in to your account") && bscMicrosoftLogin.PasswordPageHeader().equals("Enter password"))
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

	@Then("^user should be logged in$")
	public void user_should_be_logged_in()  {
		
		boolean isLoggedIn=crcLandingPage.isLoggedIn(bddLogger);
		if(isLoggedIn== false) {
			softAssert.assertTrue(isLoggedIn, "User is not logged in to the portal");
		}
		else {
			System.out.println("Is user logged in to the portal-"+ isLoggedIn );
		}
		//System.out.println("Data map is: "+ dataMap.get("MemberId"));
		screenshot();
	}
	


	@When("^user is on Assigned to me tab$")
	public void user_is_on_Assigned_to_me_tab() {
	//initBrowser("login with valid cred", "login page");
	//crcLandingPage.isLandingPage(bddLogger, softAssert);
		crcLandingPage.isLoggedIn(bddLogger);
	}
	@Then("^user is able to see the given fields for available cases$")
	public void user_is_able_to_see_the_given_fields_for_available_cases() {
	crcLandingPage.fetchTableDataForAssignedByMe(bddLogger);
	screenshot();
	}
	@When("^user is navigated to Modified by me tab$")
	public void user_is_navigated_to_Modified_by_me_tab() {
	crcLandingPage.modified();
	}
	@Then("^user is able to see modified cases with given field values$")
	public void user_is_able_to_see_modified_cases_with_given_field_values() {
	crcLandingPage.fetchTableDataForModifiedByMe(bddLogger);
	screenshot();
	}

	@Given("^user is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
		crcLandingPage.isLoggedIn(bddLogger);
	}
	@When("^clicked upon Assigned to me tab$")
	public void clicked_upon_Assigned_to_me_tab() throws Throwable {
		tabVerifyPage.assignedToMe();
	}
	@Then("^user is able to access Assigned to me tab$")
	public void user_is_able_to_access_Assigned_to_me_tab()  {
		tabVerifyPage.isAssignedtometab(bddLogger);
		screenshot();
	}
	@When("^clicked upon  Modified by me tab$")
	public void clicked_upon_Modified_by_me_tab()  {
		tabVerifyPage.modifiedByMe();
	}
	@Then("^user is able to access Modified by me tab$")
	public void user_is_able_to_access_Modified_by_me_tab()  {
		tabVerifyPage.isModifiedbymetab(bddLogger);
		screenshot();
	}
	@When("^clicked upon All active reviews tab$")
	public void clicked_upon_All_active_reviews_tab() throws Throwable {
		tabVerifyPage.allActiveReviews();
	}
	@Then("^user is able to access All active reviews tab$")
	public void user_is_able_to_access_All_active_reviews_tab()  {
		tabVerifyPage.isAllactivereviewstab(bddLogger);
		screenshot();
	}
	
	@Given("^user is on criteria form to validate warning message$")
	public void user_is_on_criteria_form_to_validate_warning_message() throws Throwable {
		//softAssert.assertEquals(actual, expected, message);
		//driver.navigate().refresh();
		
		criteriaForm.criteriaLink().click();
		criteriaForm.closethepopup().click();
		criteriaForm.isLoggedIn(bddLogger);
	}

	@When("^clicked upon save button without assigning value to mandatory fields$")
	public void clicked_upon_save_button_without_assigning_value_to_mandatory_fields() throws Throwable {

		criteriaForm.memberId().sendKeys(dataMap.get("MemberId"));
		criteriaForm.lastName().sendKeys(dataMap.get("LastName"));
		criteriaForm.firstName().sendKeys(dataMap.get("FirstName"));
	}

	@Then("^warning messages are populated for all missed mandatory fields for save$")
	public void warning_messages_is_populated_for_all_missed_mandatory_fields_for_save() throws Throwable {

		criteriaForm.saveButton().click();
		Thread.sleep(2000);
		if(criteriaForm.errorMessage().isDisplayed()) {
			System.out.println("Error message when clicked upon save button: "+criteriaForm.errorMessage().getText() );
			//bddLogger.log(LogStatus.INFO, "Error message is "+criteriaForm.errorMessage().getText());
			criteriaForm.warningsClickedUponSave(bddLogger);
		}
		screenshot();
	}

	@When("^clicked upon submit button without assigning value to mandatory fields$")
	public void clicked_upon_submit_button_without_assigning_value_to_mandatory_fields() throws Throwable {

		driver.navigate().refresh();
		Thread.sleep(1000);
		criteriaForm.submitButton();
	}

	@Then("^warning messages is populated for all missed mandatory fields for submit$")
	public void warning_messages_is_populated_for_all_missed_mandatory_fields_for_submit() throws Throwable {

		if(criteriaForm.errorMessage().isDisplayed()) {
			System.out.println("Error message when clicked upon save button: "+criteriaForm.errorMessage().getText() );
			//bddLogger.log(LogStatus.INFO, "Error message is "+criteriaForm.errorMessage().getText());
			criteriaForm.warningsClickedUponSubmit(bddLogger);
		}
		screenshot();
	}
	

	@Given("^user is on criteria form to fill up all mandatory fields$")
	public void user_is_on_criteria_form_to_fill_up_all_mandatory_fields() throws Throwable {
	driver.navigate().refresh();
	criteriaForm.isLoggedIn(bddLogger);
	//criteriaForm.criteriaLink().click();
	}
	@When("^all mandatory fields are updated with valid data$")
	public void all_mandatory_fields_are_updated_with_valid_data() throws Throwable {
	criteriaForm.memberId().sendKeys(dataMap.get("MemberId"));
	//System.out.println("Random member id is: "+ randomMemberId);
	criteriaForm.lastName().sendKeys(dataMap.get("LastName"));
	criteriaForm.firstName().sendKeys(dataMap.get("FirstName"));
	criteriaForm.caseId().sendKeys(dataMap.get("CaseId"));
	criteriaForm.caseType().click();
	criteriaForm.selectCaseIdType().click();
	criteriaForm.dateOfServiceFrom().sendKeys(dataMap.get("DosFrom"));
	criteriaForm.dateOfServiceTo().sendKeys(DataUtils.EndDateofservice(LocalDate.parse(dataMap.get("DosFrom"),DateTimeFormatter.ofPattern("M/d/yyyy"))));
	criteriaForm.dobCalender().sendKeys(dataMap.get("Dob"));
	criteriaForm.admissionDate().sendKeys(DataUtils.AdmissionDate(LocalDate.parse(dataMap.get("DosFrom"),DateTimeFormatter.ofPattern("M/d/yyyy"))));
	//System.out.println(getTestData("testMaxLengthOfTextarea").get("Testdata"));
	String paragraph=getTestData("testClinicalRationale").get("TestData");
	System.out.println("Paragraph size: "+ paragraph.length());
	criteriaForm.requestLevelOfCare().click();
	//criteriaForm.selectRequestLevelOfCare().click();
	
	WebElement selectedRlc=criteriaForm.selectRequestLevelOfCare();
	String selectedRlcName=selectedRlc.getText();
	selectedRlc.click();
	// Select levelOfCare=new Select(criteriaForm.acuteIntox());
	// levelOfCare.selectByIndex(2);
	if(selectedRlcName.contains("LVL 4.0: Medically managed intensive inpatient") || 
			selectedRlcName.contains("Acute inpatient detox (withdrawal management)")) {
		criteriaForm.requestSubsetLevelOfCare().click();
		criteriaForm.selectRequestSubsetLevelOfCare().click();
		}
	
	criteriaForm.acuteIntox().click();
	criteriaForm.selectAcuteIntox().click();
	//Thread.sleep(1000);
	//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)", "");
	criteriaForm.biomedicalComplications().click();
	criteriaForm.selectBiomedicalComplications();
	criteriaForm.psychiatricComplications().click();
	criteriaForm.selectPsychiatricComplications();
	criteriaForm.readinessToChange().click();
	criteriaForm.selectReadinessToChange().click();
	criteriaForm.relapse().click();
	criteriaForm.selectRelapse();
	criteriaForm.recoveryEnv().click();
	criteriaForm.selectRecoveryEnv();
	criteriaForm.clinicalRationaeForAcuteIntox().sendKeys(paragraph);
	//Thread.sleep(1000);
	//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)", "");
	Thread.sleep(500);
	criteriaForm.biomedicalComplicationsClinicalRotionle().sendKeys(paragraph);
	criteriaForm.psychiatricComplicationsClinicalRotionle().sendKeys(paragraph);
	criteriaForm.readinessToChangeClinicalRotionle().sendKeys(paragraph);
	criteriaForm.relapseClinicalRotionle().sendKeys(paragraph);
	criteriaForm.recoveryEnvClinicalRotionle().sendKeys(paragraph);
	Thread.sleep(2000);
	criteriaForm.assignedTo().sendKeys(dataUtils.getLanId());
	criteriaForm.reviewType().click();
	criteriaForm.selectReviewType().click();
	//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)", "");
	criteriaForm.recommendedLevelOfCare().click();
	WebElement selectedRecommendedLevelOfCare= criteriaForm.selectRecommendedLevelOfCare();
	String rlcText=selectedRecommendedLevelOfCare.getText();
	selectedRecommendedLevelOfCare.click();
	System.out.println("Recommended levelof care is: "+rlcText );
	criteriaForm.outCome().click();
	criteriaForm.selectOutCome().click();

	if(rlcText.contains("LVL 4.0: Medically managed intensive inpatient")) {
	criteriaForm.approvedSubsetLevelOfCare().click();
	criteriaForm.selectApprovedSubsetLevelOfCare().click();
	}



	// criteriaForm.approvedLevelOfCare().click();
	// criteriaForm.selectApprovedLevelOfCare().click();
	criteriaForm.clinicalRationaleForDetermination().sendKeys(paragraph);
}

	@And("^tooltips are verified$")
	public void tooltips_are_verified() throws Throwable {

	toolTipVerification.rlcClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewRequestedCareTooltip\"]/div/div/div[1]"));
	Thread.sleep(2000);
	String tooltiprlc=driver.findElement(By.xpath("//*[@id=\"viewRequestedCareTooltip\"]/div/div")).getText();
	toolTipVerification.isRlcClickForHelp(bddLogger);
	System.out.println("the Text on tooltip of rlc: "+tooltiprlc);
	toolTipVerification.closeRlcClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.acuteClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltipacute=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of acute: "+tooltipacute);
	toolTipVerification.isAcuteClickForHelp(bddLogger);
	toolTipVerification.closeAcuteClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.biomedicalClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltipbiomedical=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of biomedical: "+tooltipbiomedical);
	toolTipVerification.isBiomedicalClickForHelp(bddLogger);
	toolTipVerification.closeBiomedicalClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.psychiatricClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltippsychiatric=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of psychiatric: "+tooltippsychiatric);
	toolTipVerification.isPsychiatricClickForHelp(bddLogger);
	toolTipVerification.closePsychiatricClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.readinessClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltipreadiness=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of psychiatric: "+tooltipreadiness);
	toolTipVerification.closerReadinessClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.relapseClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltiprelapse=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of relapse: "+tooltiprelapse);
	toolTipVerification.closeRelapseClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.recoveryClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"i\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltiprecovery=driver.findElement(By.xpath("//*[@id=\"i\"]/div/div")).getText();
	System.out.println("the Text on tooltip of recovery: "+tooltiprecovery);
	toolTipVerification.closeRecoveryClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.recommendedLocClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewRecommendedCareTooltip\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltiprecommendedLoc=driver.findElement(By.xpath("//*[@id=\"viewRecommendedCareTooltip\"]/div/div")).getText();
	System.out.println("the Text on tooltip of recommendedLoc: "+tooltiprecommendedLoc);
	toolTipVerification.closeRecommendedLocClickForHelp().click();
	Thread.sleep(2000);

	toolTipVerification.approvedLocClickForHelp();
	driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewApprovedCareTooltip\"]/div/div/div[1]/h4"));
	Thread.sleep(2000);
	String tooltipapprovedLoc=driver.findElement(By.xpath("//*[@id=\"viewApprovedCareTooltip\"]/div/div")).getText();
	System.out.println("the Text on tooltip of approvedLoc: "+tooltipapprovedLoc);
	toolTipVerification.closeApprovedLocdClickForHelp().click();
	Thread.sleep(2000);
	screenshot();
	}

	@And("^scores in the dimension details are matched with that of graph$")
	public void scores_in_the_dimension_details_are_matched_with_that_of_graph() throws Throwable {

	String texttooltip="//*[local-name()='svg']//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-0\"]//*[name()='text']//*[name()='tspan']";
	String ele= "//*[local-name()='svg']//*[name()='g' and @class=\"highcharts-point highcharts-color-0\"]";
	List<WebElement> barslist=driver.findElements(By.xpath(ele));
	for(WebElement e:barslist)
	{
	Actions act= new Actions(driver);
	act.moveToElement(e).perform();
	try {
	Thread.sleep(500);
	} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	String graphDimention = driver.findElements(By.xpath(texttooltip)).get(0).getText();
	String graphDimentionScore= driver.findElements(By.xpath(texttooltip)).get(3).getText();
	//System.out.println("tooltip text: "+text);
	graphMap.put(graphDimention, graphDimentionScore);

	}
	System.out.println(graphMap);
	screenshot();
//	bddLogger.log(LogStatus.INFO, "Acute intox score in dinemsion details: "+ criteriaForm.acuteIntox().getText());
//	bddLogger.log(LogStatus.INFO, "Acute intox score in graph: "+ graphMap.get("Acute Intox / Withdrawal"));
//
//	bddLogger.log(LogStatus.INFO, "Biomedical Complications score in dinemsion details: "+ criteriaForm.biomedicalComplications().getText());
//	bddLogger.log(LogStatus.INFO, "Biomedical Complicationsscore in graph: "+ graphMap.get("Biomedical Complications"));
//
//	bddLogger.log(LogStatus.INFO, "Psychiatric Complications score in dinemsion details: "+ criteriaForm.psychiatricComplications().getText());
//	bddLogger.log(LogStatus.INFO, "Psychiatric Complications score in graph: "+ graphMap.get("Psychiatric Complications"));
//
//	bddLogger.log(LogStatus.INFO, "Readiness to Change score in dinemsion details: "+ criteriaForm.readinessToChange().getText());
//	bddLogger.log(LogStatus.INFO, "Readiness to Change score in graph: "+ graphMap.get("Readiness to Change"));
//
//	bddLogger.log(LogStatus.INFO, "Relapse / Con't Use Risk score in dinemsion details: "+ criteriaForm.relapse().getText());
//	bddLogger.log(LogStatus.INFO, "Relapse / Con't Use Risk score in graph: "+ graphMap.get("Relapse / Con't Use Risk"));
//
//	bddLogger.log(LogStatus.INFO, "Recovery Environment score in dinemsion details: "+ criteriaForm.recoveryEnv().getText());
//	bddLogger.log(LogStatus.INFO, "Recovery Environment score in graph: "+ graphMap.get("Recovery Environment"));

	}

	@Then("^user is able to successfully save the form$")
	public void user_is_able_to_successfully_save_the_form() throws Throwable {

	criteriaForm.saveButton().click();
	Thread.sleep(3000);
	String alertText= criteriaForm.alertTextAfterClickedUponSaveButton().getText();
	System.out.println("Popup text is: "+ alertText);
	//bddLogger.log(LogStatus.INFO, "Text on the popup after clicking on the save button: "+ alertText);
	criteriaForm.submitAlertAfterClickedUponSaveButton().click();
	Thread.sleep(3000);
	screenshot();

	}
	
	
	@When("^searched with member id, user is able to access the case in home page$")
	public void searched_with_member_id_user_is_able_to_access_the_case_in_home_page() throws Throwable {
		criteriaForm.homeButton().click();
		Thread.sleep(3000);
		crcLandingPage.searchMemberId().sendKeys(dataMap.get("MemberId"));
		Thread.sleep(3000);
		crcLandingPage.searchedCase().click();
		
	}

	@Then("^edit the case and capture dimension scores$")
	public void edit_the_case_and_capture_dimension_scores() throws Throwable {
		driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewAsamFormDetails\"]/div/div/div[1]/h4")).click();
//		crcLandingPage.isRlcDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isAcuteDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isBiomedicalDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isPsychiatricDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isReadinesstochangeDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isRelapsetochangeDimension(bddLogger);
//		Thread.sleep(2000);
//		crcLandingPage.isRecovEnvDimension(bddLogger);

		Thread.sleep(3000);
		driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewAsamFormDetails\"]/div/div/div[3]/button[2]")).click();
		screenshot();
		
	}

	@Then("^submit the case$")
	public void submit_the_case() throws Throwable {
		Thread.sleep(2000);
		criteriaForm.submitButtonAfterEdit().click();
		Thread.sleep(2000);
		//bddLogger.log(LogStatus.INFO, "Confirmation text after submitting the form: "+ criteriaForm.confirmationTextAfetrSubmitTheForm().getText());
		System.out.println("Confirmation text after submitting the form: "+ criteriaForm.confirmationTextAfetrSubmitTheForm().getText() );
		criteriaForm.confirmationAfterSubmit().click();
		Thread.sleep(2000);
		screenshot();
	}
	
	
	@When("^a new case with existing member id and addmission date is created$")
	public void a_new_case_with_existing_member_id_and_addmission_date_is_created() throws InterruptedException  {
	    driver.navigate().refresh();
	    criteriaForm.isLoggedIn(bddLogger);
	    criteriaForm.homeButton().click();
	    criteriaForm.assignedByMe().click();
	    Thread.sleep(3000);
	}

	@Then("^user can pull the comments after editing that case$")
	public void user_can_pull_the_comments_after_editing_that_case() throws InterruptedException  {
		String paragraph=getTestData("testClinicalRationale").get("TestData");
//		tabVerifyPage.allActiveReviews();
//	    crcLandingPage.searchBar().sendKeys(dataMap.get("MemberId"));
//	    Thread.sleep(3000);
//	    crcLandingPage.searchButton().click();
		
		crcLandingPage.searchMemberId().sendKeys(dataMap.get("MemberId"));
	    Thread.sleep(3000);
	    String copymemberid=crcLandingPage.copyMemberId().getText();
	    Thread.sleep(3000);
	    System.out.println("member id: "+copymemberid);
	    String copyaddmissiondate=crcLandingPage.copyAddmissionDate().getText();
	    Thread.sleep(3000);
	    System.out.println("addmission date: "+copyaddmissiondate);
	    Thread.sleep(3000);
	    criteriaForm.criteriaLink().click();
	    Thread.sleep(3000);
	    criteriaForm.closethepopup().click();
	    Thread.sleep(3000);
	    criteriaForm.memberId().sendKeys(copymemberid);
	   
	    criteriaForm.admissionDate().sendKeys(copyaddmissiondate);
	    crcLandingPage.pullCommentsButton().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"asamCloneModal\"]/div/div"));
	    crcLandingPage.copyPullCommentsButton().click();
	    
	    crcLandingPage.expandAcuteIntox().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String acutedetails=crcLandingPage.acuteIntoxDetails().getText();
	    System.out.println("dimension details of acute intox: "+acutedetails);
	    crcLandingPage.isAcuteIntoxDimensions(bddLogger);
	    crcLandingPage.commentsAcuteIntoxDetails().sendKeys(paragraph);
	    crcLandingPage.closeCommentsAcuteIntoxDetails().click();
	    Thread.sleep(3000);
//	    dataMap.put("Memberid", "568787892332");
//	    System.out.println(dataMap.get("Memberid"));
	    crcLandingPage.expandBiomedical().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String biomedicaldetails=crcLandingPage.biomedicalDetails().getText();
	    System.out.println("dimension details of biomedical: "+biomedicaldetails);
	    crcLandingPage.isBiomedicalDimensions(bddLogger);
	    crcLandingPage.commentsBiomedicalDetails().sendKeys(paragraph);
	    crcLandingPage.closecommentsBiomedicalDetails().click();
	    Thread.sleep(3000);
	    
	    crcLandingPage.expandPsychiatric().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String psychiatricdetails=crcLandingPage.psychiatricDetails().getText();
	    System.out.println("dimension details of psychiatric: "+psychiatricdetails);
	    crcLandingPage.isPsychiatricDimensions(bddLogger);
	    crcLandingPage.commentsPsychiatricDetails().sendKeys(paragraph);
	    crcLandingPage.closecommentsPsychiatricDetails().click();
	    Thread.sleep(3000);
	    
	    crcLandingPage.expandReadiness().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String readinessdetails=crcLandingPage.readinessDetails().getText();
	    System.out.println("dimension details of readiness: "+readinessdetails);
	    crcLandingPage.isReadinessDimensions(bddLogger);
	    crcLandingPage.commentsReadinessDetails().sendKeys(paragraph);
	    crcLandingPage.closecommentsReadinessDetails().click();
	    Thread.sleep(3000);
	    
	    crcLandingPage.expandRelapse().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String relapsedetails=crcLandingPage.relapseDetails().getText();
	    System.out.println("dimension details of relapse: "+relapsedetails);
	    crcLandingPage.isRelapseDimensions(bddLogger);
	    crcLandingPage.commentsRelapseDetails().sendKeys(paragraph);
	    crcLandingPage.closecommentsRelapseDetails().click();
	    Thread.sleep(3000);
	    
	    crcLandingPage.expandRecoveryenv().click();
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div"));
	    String recovenvdetails=crcLandingPage.recoveryenvDetails().getText();
	    System.out.println("dimension details of relapse: "+recovenvdetails);
	    crcLandingPage.isRecovenvDimensions(bddLogger);
	    crcLandingPage.commentsRecoveryenvDetails().sendKeys(paragraph);
	    crcLandingPage.closecommentsRecoveryenvDetails().click();
	    Thread.sleep(3000);
	    screenshot();
	}
	
		
	@When("^fill the fields in the report tab$")
	public void fill_the_fields_in_the_report_tab() throws InterruptedException, IOException {
		driver.navigate().back();
		criteriaForm.homeButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		reportDetails.reportTab().click();
		reportDetails.isLoggedIn(bddLogger);
		
		String memid = dataMap.get("MemberId");
		reportDetails.memberId().sendKeys(memid);
		reportDetails.caseId().sendKeys(dataMap.get("CaseId"));
		//reportDetails.memberName().sendKeys(dataMap.get("LastName") + ", "+ dataMap.get("FirstName"));
		reportDetails.filterInput().sendKeys("submitted");
		reportDetails.searchButton().click();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}

	@Then("^user is able to download and print the report$")
	public void user_is_able_to_download_and_print_the_report() throws Exception {
		reportDetails.excelButton().click();
		Thread.sleep(2000);
		
		screenshot();
		
		//reportDetails.isFileDownloaded(System.getenv("DOWNLOADED_REPORT_PATH"), System.getenv("FILENAME"));
		//Thread.sleep(2000);
		reportDetails.reviewLink().click();
		Thread.sleep(2000);
		reportDetails.formButton().click();
		Thread.sleep(2000);
		driver.switchTo().activeElement().findElement(By.xpath("//*[@id=\"viewAsamFormDetails\"]/div/div"));
		Thread.sleep(2000);
		screenshot();
	}

	
	@Given("^user is on report tab$")
	public void user_is_on_report_tab() throws InterruptedException {
		driver.navigate().refresh();
		reportDetails.isLoggedIn(bddLogger);
		reportDetails.reportTab().click();
	    
		//Need to edit this	
	    //reportDetails.reviewId().sendKeys(reportDetails.selectid());
	    
	    //bddLogger.log(LogStatus.INFO, "Searching case using review id: "+"707");
	    //reportDetails.searchButton().click();
	   // screenshot();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //reportDetails.resetButton().click();
	    //member id
	    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    reportDetails.memberId().sendKeys(dataMap.get("MemberId"));
	    //bddLogger.log(LogStatus.INFO, "Searching case using member id: "+"77777777777");
	    reportDetails.searchButton().click();
	    //screenshot();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //  bddLogger.log(LogStatus.INFO, "Searching case using member id: "+reportDetails.memberidverification().getText());
	    reportDetails.resetButton().click();
	    //member name
	    reportDetails.memberName().sendKeys(dataMap.get("LastName") + ", "+ dataMap.get("FirstName"));
	    reportDetails.searchButton().click();
	    //screenshot();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //  bddLogger.log(LogStatus.INFO, "Searching case using member name: "+reportDetails.membernameverification().getText());
	    reportDetails.resetButton().click();
	    //case id
	    reportDetails.caseId().sendKeys(dataMap.get("CaseId"));
	    reportDetails.searchButton().click();
	    //screenshot();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 //  bddLogger.log(LogStatus.INFO, "Searching case using case id: "+reportDetails.caseidverification().getText());
	    reportDetails.resetButton().click();
	    //review by
	    reportDetails.reviewby().sendKeys(dataUtils.getLanId());
	    reportDetails.searchButton().click();
	   // screenshot();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   // bddLogger.log(LogStatus.INFO, "Searching case using review id: "+reportDetails.reviewbyverification().getText());
	    reportDetails.resetButton().click();
	    //criteria all
	    reportDetails.criteria().click();
	    reportDetails.criteriaSelectAllOption().click();
	    reportDetails.searchButton().click();
	   
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //screenshot();
	   // bddLogger.log(LogStatus.INFO, "Searching case using criteria type: "+reportDetails.criteriaoptionverification().getText());
	    reportDetails.resetButton().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //criteria all
	   /* reportDetails.criteria().click();
	    reportDetails.criteriaSelectAsamOption().click();
	    reportDetails.approvedLocClick().click();
	    reportDetails.approvedLocClickSelect().click();
	    reportDetails.searchButton().click();*/
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	    reportDetails.resetButton().click();
	    // outcome
	   /* reportDetails.outcomeClick().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    reportDetails.outputOptionsSelect().click();
	    reportDetails.searchButton().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   // bddLogger.log(LogStatus.INFO, "Searching case using outcome option: "+reportDetails.outcomeverification().getText());
	    reportDetails.resetButton().click();
	    */
	    
	    //status type
                                                                                                                     	    reportDetails.status().click();
	    reportDetails.statusSelectOptions().click();
	    reportDetails.searchButton().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //screenshot();
	    
	   // bddLogger.log(LogStatus.INFO, "Searching case using status type: "+reportDetails.statustypeverification().getText());
	    reportDetails.resetButton().click();
	    
	    //turnaroundtime
	    reportDetails.trunaroundtime().click();
	    reportDetails.trunaroundtiomeSelectOptions().click();
	    reportDetails.searchButton().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    //screenshot();
	   // bddLogger.log(LogStatus.INFO, "Searching case using trunaround time: "+reportDetails.trunaroundtimeverification().getText());
	    reportDetails.resetButton().click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    screenshot();
	}
	@Then("^see all types of cases$")
	public void see_all_types_of_cases() throws InterruptedException, IOException {
		reportDetails.filterInput().sendKeys(dataMap.get("MemberId"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //screenshot();
		//bddLogger.log(LogStatus.INFO, "Searching case using search by all filter: "+reportDetails.reviewLink().getText());
		//reportDetails.resetButton().click();
		screenshot();
		
	}
	
	@When("^clicked upon review id from report pan$")
	public void clicked_upon_review_id_from_report_pan() throws Throwable {
	   
		driver.navigate().refresh();
		reportDetails.reportTab().click();
		reportDetails.isLoggedIn(bddLogger);
		reportDetails.navigateToCase(driver);
	}
	
	@Then("^user is able to see modification history$")
	public void user_is_able_to_see_modification_history() throws Throwable {
		
	    reportDetails.fetchModificationHistory(driver);
	    Thread.sleep(2000);
	    screenshot();
	}
	

}
