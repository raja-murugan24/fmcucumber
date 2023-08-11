package com.qa.web.pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.bsc.qa.framework.base.BasePage;
import com.github.javafaker.Faker;
import com.relevantcodes.extentreports.ExtentTest;

public class CriteriaForm extends BasePage{
	Faker faker = new Faker(new Locale("en-US"));
	Random random = new Random();
	String expectedPageTitle="Blue Shield of California | Clinical Review Criteria";

	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul[1]/li[2]/a")
	private WebElement criteriaLink;

	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	private WebElement errorMessage;

	public WebElement errorMessage(){

		return errorMessage;
	}

	@FindBy(xpath="//*[@id=\"asamMemberId\"]")
	private WebElement memberId;

	public WebElement memberId() {
		return memberId;
	}

	public boolean isLoggedIn (ExtentTest logger) {
		try {
			//logger.log(LogStatus.INFO, "Check if page title is "+pageTitle);
			String actualPageTitle= webDriver.getTitle();
			if(actualPageTitle.equals(expectedPageTitle) && criteriaFormHeader().getText().contains("Criteria Scoring Form")) {
				System.out.println ("Page title= "+actualPageTitle + " and home page header is: "+ criteriaFormHeader().getText());
				return true;
			}
		}
		catch(NoSuchElementException e){
			System.err.println(e.getMessage());
		}
		return false;
	}


	@FindBy(xpath="//app-crc-criteria-form/h5")
	private WebElement criteriaFormHeader;

	public WebElement criteriaFormHeader() {
		return criteriaFormHeader;
	}

	@FindBy(xpath="//div[@class=\"card shadow-lg mt-1 pt-2 pb-1 mb-4 border border-primary\"]/div[1]/div[1]/div/div")
	private WebElement warningForMemId;

	public WebElement warningForMemId() {
		return warningForMemId;
	}

	@FindBy(xpath="//*[@id=\"asamMemberLastName\"]")
	private WebElement lastName;

	public WebElement lastName() {
		return lastName;
	}
	@FindBy(xpath="//div[@class=\"card shadow-lg mt-1 pt-2 pb-1 mb-4 border border-primary\"]/div[2]/div[1]/div/div")
	private WebElement warningForLastName;

	public WebElement warningForLastName() {
		return warningForLastName;
	}

	@FindBy(xpath="//*[@id=\"asamMemberFirstName\"]")
	private WebElement firstName;

	public WebElement firstName() {
		return firstName;
	}

	@FindBy(xpath="//div[@class=\"card shadow-lg mt-1 pt-2 pb-1 mb-4 border border-primary\"]/div[2]/div[2]/div/div")
	private WebElement warningForFirstName;

	public WebElement warningForFirstName() {
		return warningForFirstName;
	}

	@FindBy(xpath="//*[@id=\"asamMemberMiddleInitial\"]")
	private WebElement middleName;

	@FindBy(xpath="//*[@id=\"asamCaseId\"]")
	private WebElement caseId;

	public WebElement caseId() {
		return caseId;
	}

	@FindBy(xpath="//div[@class=\"card shadow-lg mt-1 pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div[1]/div/div")
	private WebElement warningForCaseId;

	public WebElement warningForCaseId() {
		return warningForCaseId;
	}

	@FindBy(xpath="//*[@id=\"mat-select-value-5\"]")
	private WebElement selectType;

	@FindBy(xpath="//div[@class=\"card shadow-lg mt-1 pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div[2]/span")
	private WebElement warningForCaseIdType;

	public WebElement warningForCaseIdType() {
		return warningForCaseIdType;
	}

	@FindBy(xpath="//*[@id=\"asamDateOfService\"]/div/div[1]/div[3]/mat-date-range-input/div")
	private WebElement dateOfService;

	@FindBy(xpath="//div[contains(text(),' Start date required in mm/dd/yyyy format ')]")
	private WebElement warningFordateOfService;

	public WebElement warningFordateOfService() {
		return warningFordateOfService;
	}

	@FindBy(xpath="//*[@id=\"asamDateOfBirth\"]")
	private WebElement dob;

	@FindBy(xpath="//div[contains(text(),'Date of Birth required in mm/dd/yyyy format ')]")
	private WebElement warningForDob;

	public WebElement warningForDob() {
		return warningForDob;
	}

	@FindBy(xpath="//*[@id=\"asamMemberAgeType\"]/div")
	private WebElement memberAgeType;

	@FindBy(xpath="//input[@id=\"asamAdmissionDate\"]")
	private WebElement admissionDate;

	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-criteria-form/div[2]/div[2]/div/app-crc-form-asam/form/div[3]/div[1]/div[2]/input")
	private WebElement admissionDateUnknown;

	public WebElement admissionDate() {
		return admissionDate;
	}

	@FindBy(xpath="//div[@class=\"form-group col-lg-12 form-row\"]/div[@class=\"col-lg-3 mb-1\"]/div[contains(text(), 'Admission date required in mm/dd/yyyy format')]")
	private WebElement warningForAdmissiondate;

	public WebElement warningForAdmissiondate() {
		return warningForAdmissiondate;
	}

	@FindBy(xpath="//*[@id=\"asamNumOfSession\"]")
	private WebElement numberOfSession;

	@FindBy(xpath="//*[@id=\"asamSessionDetail\"]")
	private WebElement sessionDetails;

	@FindBy(xpath="//*[@id=\"asamRequestedCare\"]")
	private WebElement requestLevelOfCare;

	public WebElement requestLevelOfCare() {
		return requestLevelOfCare;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[1]/div/span")
	private WebElement warningForRlc;

	public WebElement warningForRlc() {
		return warningForRlc;
	}

	@FindBy(xpath="//*[@id=\"asamRequestedCare-panel\"]/div/mat-option/span")
	public List<WebElement> selectRequestLevelOfCare;

	public WebElement selectRequestLevelOfCare() {
		return selectRequestLevelOfCare.get(faker.number().numberBetween(0, selectRequestLevelOfCare.size()-1));
	}

	@FindBy(xpath="//*[@id=\"asamRequestedCareSubset\"]")
	private WebElement requestSubsetLevelOfCare;

	public WebElement requestSubsetLevelOfCare() {
		return requestSubsetLevelOfCare;
	}


	@FindBy(xpath="//*[@id=\"asamRequestedCareSubset-panel\"]/div/mat-option")
	public List<WebElement> selectRequestSubsetLevelOfCare;

	public WebElement selectRequestSubsetLevelOfCare() {
		return selectRequestSubsetLevelOfCare.get(faker.number().numberBetween(0, selectRequestSubsetLevelOfCare.size()-1));
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div/div[1]/mat-select")
	private WebElement acuteIntox;
	public WebElement acuteIntox() {
		return acuteIntox;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div/div[1]/span")
	private WebElement warningForAcuteIntox;
	public WebElement warningForAcuteIntox() {
		return warningForAcuteIntox;
	}

	@FindBy(xpath="//*[@id=\"mat-select-20-panel\"]/div/mat-option/span")
	private List<WebElement> selectAcuteIntox;
	public WebElement selectAcuteIntox() {
		return selectAcuteIntox.get(faker.number().numberBetween(0, selectAcuteIntox.size()-1));
	}

	//public WebElement acuteIntoxVal() {
	//	
	//	return selectAcuteIntox;
	//}


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[4]/div/div[1]/mat-select")
	private WebElement biomedicalComplications;
	public WebElement biomedicalComplications() {
		return biomedicalComplications;
	}
	@FindBy(xpath="//*[@id=\"mat-select-22-panel\"]/div/mat-option/span")
	private List<WebElement> selectBiomedicalComplications;
	public void selectBiomedicalComplications() {
		selectBiomedicalComplications.get(faker.number().numberBetween(0, selectBiomedicalComplications.size()-1)).click();
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[4]/div/div[1]/span")
	private WebElement warningForBiomedicalComplications;
	public WebElement warningForBiomedicalComplications() {
		return warningForBiomedicalComplications;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[4]/div/div[2]/input")
	private WebElement biomedicalComplicationsClinicalRotionle;

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/div[1]/mat-select")
	private WebElement psychiatricComplications;

	public WebElement psychiatricComplications() {
		return psychiatricComplications;
	}

	@FindBy(xpath="//*[@id=\"mat-select-24-panel\"]/div/mat-option/span")
	private List<WebElement> selectPsychiatricComplications;

	public void selectPsychiatricComplications() {
		selectPsychiatricComplications.get(faker.number().numberBetween(0, selectPsychiatricComplications.size())).click();
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/div[1]/span")
	private WebElement warningForPsychiatricComplications;
	public WebElement warningForPsychiatricComplications() {
		return warningForPsychiatricComplications;
	}


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/div[2]/input")
	private WebElement psychiatricComplicationsClinicalRotionle;

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/div[2]/span")
	private WebElement warningForClinicalRotationalePsychiatricComplications;
	public WebElement warningForClinicalRotationalePsychiatricComplications() {
		return warningForClinicalRotationalePsychiatricComplications;
	}


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[6]/div/div[1]/mat-select")
	private WebElement readinessToChange;

	public WebElement readinessToChange() {
		return readinessToChange;
	}

	@FindBy(xpath="//*[@id=\"mat-select-26-panel\"]/div/mat-option/span")
	private List<WebElement> selectReadinessToChange;

	public WebElement selectReadinessToChange() {
		return selectReadinessToChange.get(faker.number().numberBetween(0, selectReadinessToChange.size()));
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[6]/div/div[1]/span")
	private WebElement warningForReadinessToChange;
	public WebElement warningForReadinessToChange() {
		return warningForReadinessToChange;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[6]/div/div[2]/input")
	private WebElement readinessToChangeClinicalRotionle;

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[7]/div/div[1]/mat-select")
	private WebElement relapse;

	public WebElement relapse() {
		return relapse;
	}

	@FindBy(xpath="//*[@id=\"mat-select-28-panel\"]/div/mat-option/span")
	private List<WebElement> selectRelapse;

	public void selectRelapse() {
		selectRelapse.get(faker.number().numberBetween(0, selectRelapse.size()-1)).click();
	}
	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[7]/div/div[2]/span")
	private WebElement warningForRelapse;
	public WebElement warningForRelapse() {
		return warningForRelapse;
	}


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[7]/div/div[2]/input")
	private WebElement relapseClinicalRotionle;


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[8]/div/div[1]/mat-select")
	private WebElement recoveryEnv;

	public WebElement recoveryEnv() {
		return recoveryEnv;
	}

	@FindBy(xpath="//*[@id=\"mat-select-30-panel\"]/div/mat-option/span")
	private List<WebElement> selectRecoveryEnv;

	public void selectRecoveryEnv() {
		selectRecoveryEnv.get(faker.number().numberBetween(0, selectRecoveryEnv.size()-1)).click();
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[8]/div/div[1]/span")
	private WebElement warningForRecoveryEnv;
	public WebElement warningForRecoveryEnv() {
		return warningForRecoveryEnv;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[8]/div/div[2]/input")
	private WebElement recoveryEnvClinicalRotionle;

	@FindBy(xpath="//*[@id=\"asamAssignedTo\"]")
	private WebElement assignedTo;

	public WebElement assignedTo() {
		return assignedTo;
	}

	@FindBy(xpath="//*[@id=\"asamReviewType\"]")
	private WebElement reviewType;

	public WebElement reviewType() {
		return reviewType;
	}

	@FindBy(xpath="//*[@id=\"asamReviewType-panel\"]/mat-option/span")
	private List<WebElement> selectReviewType;
	public WebElement selectReviewType() {
		return selectReviewType.get(faker.number().numberBetween(0, selectReviewType.size()-1));
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary rounded\"]/div[3]/div/span")
	private WebElement warningForReviewType;

	public WebElement warningForReviewType() {
		return warningForReviewType;
	}

	@FindBy(xpath="//*[@id=\"asamRecommendedCare\"]")
	private WebElement recommendedLevelOfCare;

	public WebElement recommendedLevelOfCare() {
		return recommendedLevelOfCare;
	}
	@FindBy(xpath="//*[@id=\"asamRecommendedCare-panel\"]/div/mat-option/span")
	private List<WebElement> selectRecommendedLevelOfCare;

	public WebElement selectRecommendedLevelOfCare() {
		return selectRecommendedLevelOfCare.get(faker.number().numberBetween(0, selectRecommendedLevelOfCare.size()-1));
	}


	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary rounded\"]/div[4]/div[1]/span")
	private WebElement warningForRecommendedLevelOfCare;

	public WebElement warningForRecommendedLevelOfCare() {
		return warningForRecommendedLevelOfCare;
	}

	@FindBy(xpath="//*[@id=\"asamOutcome\"]")
	private WebElement outCome;

	public WebElement outCome() {
		return outCome;
	}

	@FindBy(xpath="//*[@id=\"asamOutcome-panel\"]/div/mat-option/span")
	private List<WebElement> selectOutCome;

	public WebElement selectOutCome() {
		return selectOutCome.get(faker.number().numberBetween(0, selectOutCome.size()-1));
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary rounded\"]/div[4]/div[2]/span")
	private WebElement warningForOutCome;

	public WebElement warningForOutCome() {
		return warningForOutCome;
	}

	@FindBy(xpath="//*[@id=\"asamApprovedCare\"]")
	private WebElement approvedLevelOfCare;

	public WebElement approvedLevelOfCare() {
		return approvedLevelOfCare;
	}

	@FindBy(xpath="//*[@id=\"asamApprovedCare-panel\"]/div/mat-option/span")
	private List<WebElement> selectApprovedLevelOfCare;

	public WebElement selectApprovedLevelOfCare() {
		return selectApprovedLevelOfCare.get(faker.number().numberBetween(0, selectApprovedLevelOfCare.size()-1));
	}
	/////////////////////////////
	@FindBy(xpath="//*[@id=\"asamApprovedCareSubset\"]")
	private WebElement approvedSubsetLevelOfCare;

	public WebElement approvedSubsetLevelOfCare() {
		return approvedSubsetLevelOfCare;
	}

	@FindBy(xpath="//*[@id=\"asamApprovedCareSubset\"]/div/mat-option/span")
	private List<WebElement> selectApprovedSubsetLevelOfCare;

	public WebElement selectApprovedSubsetLevelOfCare() {
		return selectApprovedSubsetLevelOfCare.get(faker.number().numberBetween(0, selectApprovedSubsetLevelOfCare.size()-1));
	}
	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary rounded\"]/div[5]/div[1]/span")
	private WebElement warningForApprovedLevelOfCare;

	public WebElement warningForApprovedLevelOfCare() {
		return warningForApprovedLevelOfCare;
	}
	/////////////////////////////////////////////////////////////

	@FindBy(xpath="//*[@id=\"asamClinicalRationale\"]")
	private WebElement clinicalRationaleForDetermination;

	public WebElement clinicalRationaleForDetermination(){

		return clinicalRationaleForDetermination;
	}

	@FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary rounded\"]/div[6]/div[1]/span")
	private WebElement warningForClinicalRationaleForDetermination;

	public WebElement warningForClinicalRationaleForDetermination(){

		return warningForClinicalRationaleForDetermination;
	}

	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[2]")
	private WebElement confirmationTextAfetrSubmitTheForm;

	public WebElement confirmationTextAfetrSubmitTheForm(){

		return confirmationTextAfetrSubmitTheForm;
	}
	@FindBy(xpath="//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]")
	private WebElement confirmationAfterSubmit;

	public WebElement confirmationAfterSubmit(){

		return confirmationAfterSubmit;
	}
	@FindBy(xpath="//div[@class='col-lg-2 mb-3 mx-auto']/button[@class='btn btn-primary btn-asam']")
	private WebElement saveButton;

	public WebElement saveButton(){
		return saveButton;
	}

	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[2]")
	private WebElement alertTextAfterClickedUponSaveButton;

	public WebElement alertTextAfterClickedUponSaveButton(){
		return alertTextAfterClickedUponSaveButton;
	}

	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[3]/button[2]")
	private WebElement submitAlertAfterClickedUponSaveButton;
	public WebElement submitAlertAfterClickedUponSaveButton(){
		return submitAlertAfterClickedUponSaveButton;
	}

	@FindBy(xpath="//div[@class=\"form-group col-lg-12 form-row\"]//div/button[contains(text(),' Submit ')]")
	private WebElement submitButton;

	public WebElement criteriaLink(){

		return criteriaLink;
	}
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement closethepopup;

	public WebElement closethepopup(){

		return closethepopup;
	}


	@FindBy(xpath="//*[@id=\"asamType\"]")
	WebElement caseType;
	public WebElement caseType() {
		return caseType;
	}

	@FindBy(xpath="//*[@id=\"asamType-panel\"]/mat-option/span")
	private List<WebElement> selectCaseIdType;
	public WebElement selectCaseIdType() {
		return selectCaseIdType.get(faker.number().numberBetween(0, selectCaseIdType.size()-1));
	}

	@FindBy(xpath="//input[@placeholder=\"Start Date :\"]")
	////input[@placeholder="Start Date :"]
	WebElement dateOfServiceFrom;

	public WebElement dateOfServiceFrom() {
		return dateOfServiceFrom;
	}

	@FindBy(xpath="//input[@placeholder=\"End Date :\"]")
	WebElement dateOfServiceTo;
	public WebElement dateOfServiceTo() {
		return dateOfServiceTo;
	}

	@FindBy(xpath="//input[@id=\"asamDateOfBirth\"]")
	private WebElement dobCalender;

	public WebElement dobCalender() {
		return dobCalender;
	}

	@FindBy(xpath="//*[@id=\"mat-datepicker-1\" or @class=\"mat-calendar ng-tns-c164-39 ng-trigger ng-trigger-fadeInCalendar\"]/mat-calendar-header/div/div/button[1]/span[1]/div")
	private WebElement dobCalenderYearDropDownOne;

	public WebElement dobCalenderYearDropDown() {
		return dobCalenderYearDropDownOne;
	}

	//@FindBy(xpath="")

	@FindBy(xpath="//*[@id=\"mat-datepicker-1\"]/mat-calendar-header/div/div/button[2]")
	private WebElement dobCalenderSelectYearBackButton;

	public WebElement dobCalenderSelectYearBackButton() {
		return dobCalenderSelectYearBackButton;
	}

	@FindBy(xpath="//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr[6]/td[4]/div[1]")
	private WebElement dobCalenderSelectYear;

	public WebElement dobCalenderSelectYear() {
		return dobCalenderSelectYear;
	}

	@FindBy(xpath="//*[@id=\"mat-datepicker-1\"]/div/mat-year-view/table/tbody/tr[2]/td[2]/div[1]")
	private WebElement dobCalenderSelectMonth;

	public WebElement dobCalenderSelectMonth() {
		return dobCalenderSelectMonth;
	}

	@FindBy(xpath="//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr[3]/td[4]/div[1]")
	private WebElement dobCalenderSelectDate;

	public WebElement dobCalenderSelectDate() {
		return dobCalenderSelectDate;
	}

	public void dobSelector(WebDriver driver) throws InterruptedException {

		//	dobCalender().click();
		//	dobCalenderYearDropDown().click();
		//	dobCalenderSelectYearBackButton().click();
		//	dobCalenderSelectYear().click();
		//	dobCalenderSelectMonth().click();
		//	dobCalenderSelectDate().click();

		driver.findElement(By.xpath("//*[@id=\"asamDateOfBirth\"]/div/div[1]/div[4]/mat-datepicker-toggle/button/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\" or @class=\"mat-calendar ng-tns-c164-39 ng-trigger ng-trigger-fadeInCalendar\"]/mat-calendar-header/div/div/button[1]/span[1]/div")).click();

		List<WebElement> yearList= driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr/td"));
		List<Integer> str=new ArrayList<Integer>();
		for (WebElement years : yearList) {
			//System.out.println("years are: "+years.getText());
			int intYear= Integer.parseInt(years.getText());
			//System.out.println(intYear==dobYear);
			str.add(intYear);
		}
		int year=Calendar.getInstance().get(Calendar.YEAR);
		int day=Calendar.getInstance().get(Calendar.DATE);

		//	    	LocalDate DobFrom = LocalDate.of(year - 50, 1, day);
		//	    	LocalDate DobTo = LocalDate.of(year, 1, day);

		int minDay = (int) LocalDate.of(year - 40, 1, day).toEpochDay();
		int maxDay = (int) LocalDate.of(year, 1, day).toEpochDay();
		long dobDay = minDay + random.nextInt(maxDay - minDay);

		LocalDate Dob = LocalDate.ofEpochDay(dobDay);

		int dobYear= Dob.getYear();

		if(str.contains(dobYear)) {

			driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr/td/div[1][contains(text(),'"+dobYear+"')]")).click();

			List<WebElement> monthList=driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-year-view/table/tbody/tr/td/div[1]"));
			monthList.get(random.nextInt(monthList.size()-1)).click();

			List<WebElement> dayList=driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr/td/div[1]"));

			dayList.get(random.nextInt(dayList.size()-1)).click();
		}
		else {
			driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/mat-calendar-header/div/div/button[2]")).click();

			List<WebElement> yearsBackList= driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr/td/div[1]"));
			List<Integer> backYearsList=new ArrayList<Integer>();
			for (WebElement yearsBack: yearsBackList) {
				int intYearList=Integer.parseInt(yearsBack.getText());
				backYearsList.add(intYearList);

			}
			if(backYearsList.contains(dobYear)) {
				driver.findElement(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-multi-year-view/table/tbody/tr/td/div[1][contains(text(), ' "+dobYear+"')]")).click();
				List<WebElement> monthList=driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-year-view/table/tbody/tr/td/div[1]"));
				monthList.get(random.nextInt(monthList.size()-1)).click();

				List<WebElement> dayList=driver.findElements(By.xpath("//*[@id=\"mat-datepicker-1\"]/div/mat-month-view/table/tbody/tr/td/div[1]"));

				dayList.get(random.nextInt(dayList.size()-1)).click();

			}
		}


	}

	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div/div[2]/input"))
	private WebElement clinicalRationaeForAcuteIntox;

	public WebElement clinicalRationaeForAcuteIntox() {
		return clinicalRationaeForAcuteIntox;
	}


	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div/div[2]/span"))
	private WebElement warningForclinicalRationaeForAcuteIntox;

	public WebElement warningForclinicalRationaeForAcuteIntox() {
		return warningForclinicalRationaeForAcuteIntox;
	}

	//		public void dob() {
	//			js.executeScript("document.getElemntById('asamDateOfBirth').value='12/10/1997'");
	//		}
	//public void memberAgeType() {
	//	WebElement select =driver.findElement(By.tagName("Select"));
	//
	//	Select sel= new Select(select);
	//	sel.selectByIndex(0);
	//}

	public void numberOfSession(){
		numberOfSession.click();
	}
	public void sessionDetails(){
		sessionDetails.sendKeys("Patient is good condition");
	}

	public WebElement biomedicalComplicationsClinicalRotionle() {
		return biomedicalComplicationsClinicalRotionle;
	}

	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[4]/div/div[2]/span"))
	private WebElement warningForclinicalRationaeForbiomedicalComplications;

	public WebElement warningForclinicalRationaeForbiomedicalComplications() {
		return warningForclinicalRationaeForbiomedicalComplications;
	}


	public WebElement psychiatricComplicationsClinicalRotionle() {
		return psychiatricComplicationsClinicalRotionle;
	}


	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/div[2]/span"))
	private WebElement warningForpsychiatricComplications;

	public WebElement warningForpsychiatricComplications() {
		return warningForpsychiatricComplications;
	}

	public WebElement readinessToChangeClinicalRotionle() {
		return readinessToChangeClinicalRotionle;
	}

	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[6]/div/div[2]/span"))
	private WebElement warningForreadinessToChangeCr;

	public WebElement warningForreadinessToChangeCr() {
		return warningForreadinessToChangeCr;
	}


	public WebElement relapseClinicalRotionle() {
		return relapseClinicalRotionle;
	}

	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[7]/div/div[2]/span"))
	private WebElement warningForRelapseCr;

	public WebElement warningForRelapseCr() {
		return warningForRelapseCr;
	}

	public WebElement recoveryEnvClinicalRotionle() {
		return recoveryEnvClinicalRotionle;
	}

	@FindBy(xpath=("//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[8]/div/div[2]/span"))
	private WebElement warningForRecoveryEnvCr;

	public WebElement warningForRecoveryEnvCr() {
		return warningForRecoveryEnvCr;
	}



	public void submitButton() {
		submitButton.click();
	}

	//@FindBy(xpath="//*[@id=\"asamAssignedTo\"]")
	//private WebElement assignedTo;

	@FindBy(xpath="//*[@id=\"asamAdmissionDate\"]/div/div[1]/div[4]/mat-datepicker-toggle/button/span[1]/svg")
	private WebElement calenderAdd;



	@FindBy(xpath="//*[@id=\"mat-datepicker-19\"]/div/mat-multi-year-view/table/tbody/tr[2]/td[2]/div[1]")
	private WebElement yearSelect;

	@FindBy(xpath="//*[@id=\"mat-datepicker-19\"]/div/mat-year-view/table/tbody/tr[4]/td[4]/div[1]")
	private WebElement monthSelect;

	@FindBy(xpath="//*[@id=\"mat-datepicker-19\"]/div/mat-month-view/table/tbody/tr[1]/td[2]/div[1]")
	private WebElement dateSelect;

	@FindBy(xpath="//*[@id=\"asamNumOfSession\"]")
	private WebElement sessionSelect;

	// @FindBy(xpath="//*[@id=\"asamSessionDetail\"]")
	// private WebElement sessionDetail;
	//
	//public WebElement addmissionDate()
	//{
	//return addmissionDate;
	//}
	public WebElement calenderAdd()
	{
		return calenderAdd;
	}
	public WebElement yearSelect()
	{
		return yearSelect;
	}
	public WebElement monthSelect()
	{
		return monthSelect;
	}
	public WebElement dateSelect()
	{
		return dateSelect;
	}
	public WebElement sessionSelect()
	{
		return sessionSelect;
	}
	// public WebElement sessionDetail()
	// {
	// return sessionDetail;
	// }
	public void date() {
		//addmissionDate.click();
		calenderAdd.click();
		yearSelect.click();
		monthSelect.click();
		dateSelect().click();
		sessionSelect().click();
	}

	@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[3]/button[2]")
	private WebElement submitButtonAfterSave;
	public WebElement submitButtonAfterSave()
	{
		return submitButtonAfterSave;
	}
	//@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[1]/div[1]/div")
	//private WebElement assignedByMe;
	//
	//public WebElement assignedByMe() {
	//return assignedByMe;
	//}
	//@FindBy(xpath="//*[@id=\\\"DataTables_Table_0\\\"]/tbody/tr[1]/td[2]/button")
	//private WebElement reviewId;
	//
	//public WebElement reviewId() {
	//return reviewId;
	//}
	//@FindBy(xpath="//*[@id=\\\"viewAsamFormDetails\\\"]/div/div/div[3]/button[2]")
	//private WebElement editButton;
	//
	//public WebElement editButton() {
	//return editButton;
	//}
	//@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/nav/div/ul[1]/li[1]/a/i")
	//private WebElement homeButton;
	//
	//public WebElement homeButton() {
	//return homeButton;
	//}

	public void warningsClickedUponSave(ExtentTest logger) {




		if(memberId().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for member id is: "+ warningForMemId().getText());
			//logger.log(LogStatus.INFO, "Warning for member id is: "+warningForMemId().getText());
		}

		if(lastName().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for last name field is: "+ warningForLastName().getText());
			//logger.log(LogStatus.INFO, "Warning for last name is: "+warningForLastName().getText());
		}

		if(firstName().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for first name field is: "+ warningForFirstName().getText());
			//logger.log(LogStatus.INFO, "Warning for first name is: "+warningForFirstName().getText());
		}

		if(caseId().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for case id field is: "+ warningForCaseId().getText());
			//logger.log(LogStatus.INFO, "Warning for case id is: "+warningForCaseId().getText());
		}

		if(caseType().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for case id type field is: "+ warningForCaseIdType().getText());
			//logger.log(LogStatus.INFO, "Warning for case id type is: "+warningForCaseIdType().getText());
		}

		if(dateOfServiceFrom().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for date of service field is: "+ warningFordateOfService().getText());
			//logger.log(LogStatus.INFO, "Warning for  date of service field is: "+warningFordateOfService().getText());
		}
		if(dobCalender().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for dob field is: "+ warningForDob().getText());
			//logger.log(LogStatus.INFO, "Warning for dob field is: "+warningForDob().getText());
		}


	}

	public void warningsClickedUponSubmit(ExtentTest logger) {

		warningsClickedUponSave(logger);


		if(admissionDate().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for admission date is: "+ warningForAdmissiondate().getText());
			//logger.log(LogStatus.INFO, "Warning for admission date is: "+warningForAdmissiondate().getText());
		}
		if(requestLevelOfCare().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for request level of care is: "+ warningForRlc().getText());
			//logger.log(LogStatus.INFO, "Warning for request level of care is: "+warningForRlc().getText());
		}

		if(acuteIntox().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for acute intox is: "+ warningForAcuteIntox().getText());
			//logger.log(LogStatus.INFO, "Warning for acute intox is: "+warningForAcuteIntox().getText());
		}

		if(clinicalRationaeForAcuteIntox().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- acute intox is: "+ warningForclinicalRationaeForAcuteIntox().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- acute intox is: "+warningForclinicalRationaeForAcuteIntox().getText());
		}

		if(biomedicalComplications().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for biomedical complications is: "+ warningForBiomedicalComplications().getText());
			//logger.log(LogStatus.INFO, "Warning for biomedical complications is: "+warningForBiomedicalComplications().getText());
		}

		if(biomedicalComplicationsClinicalRotionle().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- biomedical complications is: "+ warningForclinicalRationaeForbiomedicalComplications().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- biomedical complications is: "+warningForclinicalRationaeForbiomedicalComplications().getText());
		}

		if(psychiatricComplications().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for psychiartic complication is: "+ warningForpsychiatricComplications().getText());
			//logger.log(LogStatus.INFO, "Warning for psychiartic complication is: "+warningForpsychiatricComplications().getText());
		}

		if(psychiatricComplicationsClinicalRotionle().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- psychiartic complication is: "+ warningForClinicalRotationalePsychiatricComplications().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- psychiartic complication is: "+warningForclinicalRationaeForbiomedicalComplications().getText());
		}

		if(readinessToChange().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for readiness to change is: "+ warningForReadinessToChange().getText());
			//logger.log(LogStatus.INFO, "Warning for readiness to change is: "+warningForReadinessToChange().getText());
		}

		if(readinessToChangeClinicalRotionle().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- readiness to change is: "+ warningForreadinessToChangeCr().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- readiness to change is: "+warningForreadinessToChangeCr().getText());
		}

		if(relapse().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for relapse is: "+ warningForRelapse().getText());
			//logger.log(LogStatus.INFO, "Warning for relapse is: "+warningForRelapse().getText());
		}
		if(relapseClinicalRotionle().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- relapse is: "+ warningForRelapseCr().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- relapse is: "+warningForRelapseCr().getText());
		}

		if(recoveryEnv().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for recovery env is: "+ warningForRecoveryEnv().getText());
			//logger.log(LogStatus.INFO, "Warning for recovery env is: "+warningForRecoveryEnv().getText());
		}

		if(recoveryEnvClinicalRotionle().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for clinical rotationale- recovery env is: "+ warningForRecoveryEnvCr().getText());
			//logger.log(LogStatus.INFO, "Warning for clinical rotationale- recovery env is: "+warningForRecoveryEnvCr().getText());
		}
		if(reviewType().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for review type is: "+ warningForReviewType().getText());
			//logger.log(LogStatus.INFO, "Warning forreview type is: "+warningForReviewType().getText());
		}

		if(recommendedLevelOfCare().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for recommended levelof care is: "+ warningForRecommendedLevelOfCare().getText());
			//logger.log(LogStatus.INFO, "Warning for recommended levelof care is: "+warningForRecommendedLevelOfCare().getText());
		}

		if(outCome().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for outcome field is: "+ warningForOutCome().getText());
			//logger.log(LogStatus.INFO, "Warning for outcome is: "+warningForOutCome().getText());
		}

		if(approvedLevelOfCare().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for approved level of care field is: "+ warningForApprovedLevelOfCare().getText());
			//logger.log(LogStatus.INFO, "Warning for approved level of care is: "+warningForApprovedLevelOfCare().getText());
		}

		if(clinicalRationaleForDetermination().getAttribute("class").contains("ng-invalid")) {
			System.out.println("Warning for approved level of care field is: "+ warningForClinicalRationaleForDetermination().getText());
			//logger.log(LogStatus.INFO, "Warning for approved level of care is: "+warningForClinicalRationaleForDetermination().getText());
		}



	}

	//public void submitButton() {
	//    submitButton.click();
	//}
	//@FindBy(xpath="//*[@id=\"exampleModal1\"]/div/div/div[3]/button[2]")
	//private WebElement submitButtonAfterSave;
	//
	//public WebElement submitButtonAfterSave()
	//{
	//    return submitButtonAfterSave;
	//}
	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[1]/div[1]/div")
	private WebElement assignedByMe;

	public WebElement assignedByMe() {
		return assignedByMe;
	}
	@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[4]/td[2]/button")
	private WebElement reviewId;

	public WebElement reviewId() {
		return reviewId;
	}
	@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[2]/td[2]/button")
	private WebElement reviewIdForSub;

	public WebElement reviewIdForSub() {
		return reviewIdForSub;
	}
	@FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]/div/div/div[3]/button[2]")
	private WebElement editButton;

	public WebElement editButton() {
		return editButton;
	}
	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/nav/div/ul[1]/li[1]/a/i")
	private WebElement homeButton;

	public WebElement homeButton() {
		return homeButton;
	}
	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[1]/div[1]/div")
	private WebElement assignedToMeTab;


	public void assignedToMeTab() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assignedToMeTab.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FindBy(xpath="//*[@id=\"mat-option-36\"]/span")
	private WebElement editAcuteIntoxLevel;

	public WebElement editAcuteIntoxLevel() {
		return editAcuteIntoxLevel;
	}

	@FindBy(xpath="//*[@id=\"mat-option-41\"]/span")
	private WebElement editBiomedicalLevel;

	public WebElement editBiomedicalLevel() {
		return editBiomedicalLevel;
	}

	@FindBy(xpath="//*[@id=\"mat-option-47\"]/span")
	private WebElement editPsychiatricLevel;

	public WebElement editPsychiatricLevel() {
		return editPsychiatricLevel;
	}

	@FindBy(xpath="//*[@id=\"mat-option-50\"]/span")
	private WebElement editReadinessToChange;

	public WebElement editReadinessToChange() {
		return editReadinessToChange;
	}

	@FindBy(xpath="//*[@id=\"mat-select-27\"]")
	private WebElement editRelapse;

	public WebElement editRelapse() {
		return editRelapse;
	}

	@FindBy(xpath="//*[@id=\"mat-option-67\"]/span")
	private WebElement editRecoveryEnv;

	public WebElement editRecoveryEnv() {
		return editRecoveryEnv;
	}

	@FindBy(xpath="//*[@id=\"mat-option-38\"]/span")
	private WebElement editReviewType;

	public WebElement editReviewType() {
		return editReviewType;
	}
	@FindBy(xpath="//*[@id=\"mat-option-23\"]/span")
	private WebElement editRequestLevelOfCare;

	public WebElement editRequestLevelOfCare() {
		return editRequestLevelOfCare;
	}
	@FindBy(xpath="//*[@id=\"asamOutcome\"]/div/div[@class=\"mat-select-value ng-tns-c78-27\" or @id=\"mat-select-value-15\"]")
	private WebElement editOutcome;

	public WebElement editOutcome() {
		return editOutcome;
	}

	@FindBy(xpath="//div[@class=\"form-group col-lg-12 form-row\"]/div/button[contains(text(),' Submit ')]")
	private WebElement submitButtonAfterEdit;

	public WebElement submitButtonAfterEdit() {
		return submitButtonAfterEdit;
	}

	@FindBy(xpath="//*[@id=\"toast-container\"]/div/div")
	private WebElement catchReviewIdAfterSave;

	public String catchReviewIdAfterSave() {
		String reviewIdPopup= catchReviewIdAfterSave.getText();
		System.out.println("The review id popup is: "+reviewId);
		String[] arr= reviewIdPopup.split(": ");
		String reviewId= arr[arr.length-1];
		System.out.println("Reviewid is: "+arr[arr.length-1]);
		return reviewId;
	}
}