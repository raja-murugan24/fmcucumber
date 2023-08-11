package com.qa.web.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.bsc.qa.framework.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CrcLandingPage extends BasePage {


	String expectedPageTitle="Blue Shield of California | Clinical Review Criteria";
	String assignedToMeTabTitle=" Assigned to me ";
	public boolean isLoggedIn (ExtentTest logger) {
		try {
		//logger.log(LogStatus.INFO, "Check if page title is "+pageTitle);
		String actualPageTitle= webDriver.getTitle();
		if(actualPageTitle.equals(expectedPageTitle) && landingPageHeader.getText().contains("Welcome")) {
			System.out.println ("Page title= "+actualPageTitle + " and home page header is: "+ landingPageHeader.getText());
			return true;
		}
		
		
		}
		catch(NoSuchElementException e){
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean isAssignedtometab (ExtentTest logger) {
		//logger.log(LogStatus.INFO, "Check if the tab is "+assignedToMeTabTitle);
		//waitForPageToLoad(5);
		return true;
	}
	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[1]/div[2]/div")
	private WebElement modifiedByMe;
	
	
	@FindBy(xpath="//*[@id=\"collapsibleNavbar\"]/ul[2]/li/a")
	private WebElement logoutButton;
	
	public WebElement logoutButton() {
		return logoutButton;
	}
	public void modified() {
		modifiedByMe.click();
	}
	
	
	//ExtentTest logger
	  public void waitForPageToLoad(int sec) {
			try {
				TimeUnit.SECONDS.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	  @FindBy(xpath="//app-crc-home/h5")
	  private WebElement landingPageHeader;
	  
	  public WebElement landingPageHeader() {
		  return landingPageHeader;
	  }
	  
	@FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th")
	 private List <WebElement> rowHeaderAssignedbyme;
	
	 @FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/table/thead/tr/th")
	  private List <WebElement> rowHeaderModifieddbyme;
	 
		@FindBy(xpath="//html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr")
        private List <WebElement> tableRowsForAssignedbyme;
	 
	 @FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr")
	 private List <WebElement> rowModifieddbyme;
	 
//	 @FindBy(xpath="/html/body/app-root/div/app-crc-scoring/app-crc-home/div/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/table/tbody/tr[\"+ i +\"]/td")
//	 private List<WebElement> tableData;
	 
	 public List<WebElement> rowHeaderAssignedbyme() {
		 
		 return rowHeaderAssignedbyme;
	 }
	 public List<WebElement> rowHeaderModifiedbyme() {
	 
	 return rowHeaderModifieddbyme;
	 }
	 public List<WebElement> tableRowsForAssignedbyme() {
		 
		 return tableRowsForAssignedbyme;
	 }
	 public List<WebElement> rowModifieddbyme() {
	 
	 return rowModifieddbyme;
	 }
//	 public void tableData(int i) {
//		 
//	 }
	 public void fetchTableDataForAssignedByMe(ExtentTest logger){
         List<Map<String, String>> tabledataforAssignedByme =new ArrayList<Map<String,String>>();
         System.out.println("row header size:"+rowHeaderAssignedbyme.size());
       
         int count= 1;
         for (WebElement rowData : tableRowsForAssignedbyme) {

             System.out.println("data in the row:"+count);
             System.out.println(rowData.getText());
             //logger.log(LogStatus.INFO, "Cases in assigned to me "+rowData.getText());
             count++;
        }
         //return tabledataforAssignedByme;
     }
     public void fetchTableDataForModifiedByMe(ExtentTest logger){
         List<Map<String, String>> tabledataforAssignedByme =new ArrayList<Map<String,String>>();
         System.out.println("row header size of Modifiedbyme:"+rowHeaderModifieddbyme.size());
//         for(int i=1;i<= rowModifieddbyme.size();i++) {
//             Map<String, String> map=new HashMap<String, String>();
//             for(int j=1;j< rowHeaderModifieddbyme.size();j++) {
//             List< WebElement > rawDataList= driver.findElements(By.xpath("//*[@id=\\\"DataTables_Table_3\\\"]/tbody/tr[\"+ i +\"]/td"));
//             map.put(rowHeaderModifieddbyme.get(j).getText(), rawDataList.get(j).getText());
//             }
//             tabledataforAssignedByme.add(map);
//             }
//             for (Map<String, String> map : tabledataforAssignedByme) {
//             for (String key : map.keySet()) {
//             System.out.println(key+" -- "+map.get(key));
//             }
//             System.out.println("-------------------------------------------------------");
//             }

         int count= 1;
         for (WebElement rowData : tableRowsForAssignedbyme) {

             System.out.println("data in the row:"+count);
             System.out.println(rowData.getText());
             //logger.log(LogStatus.INFO, "Cases in modified by me: "+rowData.getText());
             count++;
        }
        // return tabledataforAssignedByme;
     }
	 
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0_filter\"]/label/input")
	 private WebElement searchMemberId;
	 
	 public WebElement searchMemberId() {
		 return searchMemberId;
	 }
	 
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td[2]/button")
	 private WebElement reviewId;
	 
	 public WebElement reviewId() {
		 return reviewId;
	 }
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/button")
	 private WebElement reviewIdlink;
	 
	 public WebElement reviewIdlink() {
		 return reviewIdlink;
	 }
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[2]/button")
	 private WebElement searchedCase;
	 
	 public WebElement searchedCase() {
		 return searchedCase;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]/div/div/div[2]/div/form/div[3]/div[1]/div/p")
	 private WebElement saverlc;
	 
	 public WebElement saverlc() {
		 return saverlc;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[1]/div[1]/div/p")
	 private WebElement saveacute;
	 
	 public WebElement saveacute() {
		 return saveacute;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[2]/div[1]/div/p")
	 private WebElement savebiomedical;
	 
	 public WebElement savebiomedical () {
		 return savebiomedical;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[3]/div[1]/div/p")
	 private WebElement savepsychiatric;
	 
	 public WebElement savepsychiatric() {
		 return savepsychiatric;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[4]/div[1]/div/p")
	 private WebElement savereadiness;
	 
	 public WebElement savereadiness() {
		 return savereadiness;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[5]/div[1]/div/p")
	 private WebElement saverelapse;
	 
	 public WebElement saverelapse() {
		 return saverelapse;
	 }
	 
	 @FindBy(xpath="//*[@id=\"viewAsamFormDetails\"]//form/div[3]/div[3]/div[6]/div[1]/div/p")
	 private WebElement saverecovenv;
	 
	 public WebElement saverecovenv() {
		 return saverecovenv;
	 }
	 public boolean isRlcDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of rlc: "+saverlc.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isAcuteDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of acute intox: "+saveacute.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isBiomedicalDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of biomedical: "+savebiomedical.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isPsychiatricDimension(ExtentTest logger) {
			
			logger.log(LogStatus.INFO, "the dimension value of psychiatric: "+savepsychiatric.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isReadinesstochangeDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of Readiness to change: "+savereadiness.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isRelapsetochangeDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of Relapse: "+saverelapse.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 public boolean isRecovEnvDimension(ExtentTest logger) {
			//System.out.println("user in recommended level of care help field");
			logger.log(LogStatus.INFO, "the dimension value of Recov env: "+saverecovenv.getText());
			//waitForPageToLoad(5);
			return true;
	       }
	 
	 @FindBy(xpath="//*[@id=\"DataTables_Table_1_filter\"]/label/input")
	 private WebElement searchBar;
	 
	 public WebElement searchBar() {
		 return searchBar;
	 }
	 @FindBy(xpath="//*[@id=\"DataTables_Table_1_filter\"]/label/i")
	 private WebElement searchButton;
	 
	 public WebElement searchButton() {
		 return searchButton;
	 }
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[3]")
	 private WebElement copyMemberId;
	 
	 public WebElement copyMemberId() {
		 return copyMemberId;
	 }
	 @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[8]")
	 private WebElement copyAddmissionDate;
	 
	 public WebElement copyAddmissionDate() {
		 return copyAddmissionDate;
	 }
	 @FindBy(xpath="//*[@id=\"dimensionBlock\"]/div/button")
	 private WebElement pullCommentsButton;
	 
	 public WebElement pullCommentsButton() {
		 return pullCommentsButton;
	 }
	 @FindBy(xpath="//*[@id=\"asamCloneModal\"]/div/div/div[2]/div[2]/mat-table/mat-row/mat-cell[5]/button/i")
	 private WebElement copyPullCommentsButton;
	 
	 public WebElement copyPullCommentsButton() {
		 return copyPullCommentsButton;
	 }
	 //acute intox
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[3]/div/button[1]")
	 private WebElement expandAcuteIntox;
	 
	 public WebElement expandAcuteIntox() {
		 return expandAcuteIntox;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement acuteIntoxDetails;
	 
	 public WebElement acuteIntoxDetails() {
		 return acuteIntoxDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsAcuteIntoxDetails;
	 
	 public WebElement commentsAcuteIntoxDetails() {
		 return commentsAcuteIntoxDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closeCommentsAcuteIntoxDetails;
	 
	 public WebElement closeCommentsAcuteIntoxDetails() {
		 return closeCommentsAcuteIntoxDetails;
	 }
	 //biomedical
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[4]/div/button[1]")
	 private WebElement expandBiomedical;
	 
	 public WebElement expandBiomedical() {
		 return expandBiomedical;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement biomedicalDetails;
	 
	 public WebElement biomedicalDetails() {
		 return biomedicalDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsBiomedicalDetails;
	 
	 public WebElement commentsBiomedicalDetails() {
		 return commentsBiomedicalDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closecommentsBiomedicalDetails;
	 
	 public WebElement closecommentsBiomedicalDetails() {
		 return closecommentsBiomedicalDetails;
	 }
//Psychiatric
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[5]/div/button[1]")
	 private WebElement expandPsychiatric;
	 
	 public WebElement expandPsychiatric() {
		 return expandPsychiatric;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement psychiatricDetails;
	 
	 public WebElement psychiatricDetails() {
		 return psychiatricDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsPsychiatricDetails;
	 
	 public WebElement commentsPsychiatricDetails() {
		 return commentsPsychiatricDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closecommentsPsychiatricDetails;
	 
	 public WebElement closecommentsPsychiatricDetails() {
		 return closecommentsPsychiatricDetails;
	 }
	 //readiness to change
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[6]/div/button[1]")
	 private WebElement expandReadiness;
	 
	 public WebElement expandReadiness() {
		 return expandReadiness;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement readinessDetails;
	 
	 public WebElement readinessDetails() {
		 return readinessDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsReadinessDetails;
	 
	 public WebElement commentsReadinessDetails() {
		 return commentsReadinessDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closecommentsReadinessDetails;
	 
	 public WebElement closecommentsReadinessDetails() {
		 return closecommentsReadinessDetails;
	 }
	 //relapse
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[7]/div/button[1]")
	 private WebElement expandRelapse;
	 
	 public WebElement expandRelapse() {
		 return expandRelapse;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement relapseDetails;
	 
	 public WebElement relapseDetails() {
		 return relapseDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsRelapseDetails;
	 
	 public WebElement commentsRelapseDetails() {
		 return commentsRelapseDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closecommentsRelapseDetails;
	 
	 public WebElement closecommentsRelapseDetails() {
		 return closecommentsRelapseDetails;
	 }
	 //recovery env
	 @FindBy(xpath="//div[@class=\"card shadow pt-2 pb-1 mb-4 border border-primary\"]/div[8]/div/button[1]")
	 private WebElement expandRecoveryenv;
	 
	 public WebElement expandRecoveryenv() {
		 return expandRecoveryenv;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/div/div")
	 private WebElement recoveryenvDetails;
	 
	 public WebElement recoveryenvDetails() {
		 return recoveryenvDetails;
	 }
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[2]/textarea")
	 private WebElement commentsRecoveryenvDetails;
	 
	 public WebElement commentsRecoveryenvDetails() {
		 return commentsRecoveryenvDetails;
	 }
	
	 @FindBy(xpath="//*[@id=\"categoryClinicalRationaleExpandedTextView\"]/div/div/div[3]/button")
	 private WebElement closecommentsRecoveryenvDetails;
	 
	 public WebElement closecommentsRecoveryenvDetails() {
		 return closecommentsRecoveryenvDetails;
	 }
	 public boolean isAcuteIntoxDimensions(ExtentTest logger) {
		 String acutedetails=acuteIntoxDetails().getText();
		 //logger.log(LogStatus.INFO, "dimension details of acute intox "+acutedetails);
			//waitForPageToLoad(5);
			return true;
		}
	 public boolean isBiomedicalDimensions(ExtentTest logger) {
		 String biomedicaldetails=biomedicalDetails().getText();
		 //logger.log(LogStatus.INFO, "dimension details of biomedical "+biomedicaldetails);
			//waitForPageToLoad(5);
			return true;
		}
	 public boolean isPsychiatricDimensions(ExtentTest logger) {
		 String psychiatricdetails=psychiatricDetails().getText();
			return true;
		}
	 public boolean isReadinessDimensions(ExtentTest logger) {
		 String readinessdetails=readinessDetails().getText();
			return true;
		}
	 public boolean isRelapseDimensions(ExtentTest logger) {
		 String relapsedetails=relapseDetails.getText();
			return true;
		}
	 public boolean isRecovenvDimensions(ExtentTest logger) {
		 String recovenvetails=recoveryenvDetails().getText();
			return true;
		}

	
}
