package com.qa.web.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import com.github.javafaker.Faker;

public class DataUtils {

	Faker faker = new Faker(new Locale("en-US"));
	//Random rnd=new Random();

	Random random = new Random();
	int year=Calendar.getInstance().get(Calendar.YEAR);
	int day=Calendar.getInstance().get(Calendar.DATE);

	//	    	LocalDate DobFrom = LocalDate.of(year - 50, 1, day);
	//	    	LocalDate DobTo = LocalDate.of(year, 1, day);

	int minDay = (int) LocalDate.of(year - 40, 1, day).toEpochDay();
	int maxDay = (int) LocalDate.of(year, 1, day).toEpochDay();
	long dobDay = minDay + random.nextInt(maxDay - minDay);

	LocalDate admission = LocalDate.of(year - 1, 12, day);

	LocalDate dosFrom = LocalDate.of(year, 1, day);
	LocalDate dosTo = LocalDate.of(year, 5, day);

	long dosDays = dosFrom.until(dosTo, ChronoUnit.DAYS);

	long DosStart = ThreadLocalRandom.current().nextLong(dosDays);
	long DosEnd = ThreadLocalRandom.current().nextLong(dosDays + 3);

	LocalDate dosStartDate = dosFrom.plusDays(DosStart);
	LocalDate dosEndDate = dosTo.plusDays(DosEnd);

	long AdmDays = dosStartDate.until(admission, ChronoUnit.DAYS);
	LocalDate AdmDate = dosFrom.plusDays(AdmDays);

	//	    	long DobDays = DobFrom.until(DobTo, ChronoUnit.DAYS);
	//	    	LocalDate Dob = DobFrom.plusDays(DobDays);

	LocalDate Dob = LocalDate.ofEpochDay(dobDay);

	int dobYear= Dob.getYear();
	//String dobMonth= Dob.getMonth();


	//System.out.println("DosDays: " + DosDays + "  Adm: " + AdmDays + "  DobDays: " + DobDay);

public String randomMemberId() {
	return faker.number().digits(9);
}

public String randomLastName() {
	return faker.name().lastName();
}

public String randomFirstName() {
	return faker.name().firstName();
}

public String randomCaseId() {
	return "H"+faker.number().digits(5);
}



public String randomAdmissionDate() {
	//LocalDate AdmDate = dosFrom.plusDays(AdmDays);
	
	String randomAdmissionDate= AdmDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
	return randomAdmissionDate;
}


public String randomDateOfServiceFrom() {
	
	//LocalDate DosStartDate = dosFrom.plusDays(DosStart);
	String dateOfServiceFrom= dosStartDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
	return dateOfServiceFrom;
}

public String randomDateOfServiceTo() {
	LocalDate dosEndDate = dosTo.plusDays(DosEnd);
	String dateOfServiceTo= dosEndDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));
	return dateOfServiceTo;	
}

//public String randomDob() {
//	
//	
//	return null;
//	
//}

public String RandomDOB() {


Random random = new Random();

int minDay = (int) LocalDate.of(1891, 1, 1).toEpochDay();

int maxDay = (int) LocalDate.now().toEpochDay();

long randomDay = minDay + random.nextInt(maxDay - minDay);

LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);

String randomdob = randomBirthDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

return randomdob;

}

public String StartDateofservice() {


Random random = new Random();

int minDay = (int) LocalDate.now().minusDays(1825).toEpochDay();

int maxDay = (int) LocalDate.now().toEpochDay();

long randomDay =  minDay + random.nextInt(maxDay - minDay);

LocalDate randomStartDate = LocalDate.ofEpochDay(randomDay);

String randomstartdos = randomStartDate.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

return randomstartdos;


}

public static String EndDateofservice(LocalDate StartDateofservice) {


LocalDate endDate =  StartDateofservice;

LocalDate addValue = endDate.plusDays(365);

String randomenddos = addValue.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

return randomenddos;


}


public static String AdmissionDate(LocalDate StartDateofservice) {


LocalDate adminDate =  StartDateofservice;

LocalDate returnValue = adminDate.minusDays(90);

String randomadmissiondate = returnValue.format(DateTimeFormatter.ofPattern("M/d/yyyy"));

return randomadmissiondate;


}

public Map<String, String> getRandomData(){
	
	Map<String, String> dataMap=new HashMap<String, String>();
	
	dataMap.put("MemberId", randomMemberId());
	dataMap.put("CaseId", randomCaseId());
	dataMap.put("FirstName", randomFirstName());
	dataMap.put("LastName", randomLastName());
	dataMap.put("AdmissionDate", randomAdmissionDate());
	dataMap.put("DosFrom", StartDateofservice());
	dataMap.put("Dob", RandomDOB());
	
	return dataMap;
	
}

//public static void main(String[] args) {
//	DataUtils dataUtils=new DataUtils();
//	System.out.println(dataUtils.lanId());
//}

public String getLanId() {
	String username= System.getenv("USERNAME");
	String lanId;
	String arr[]= username.split("@");
	lanId=arr[0];
	return lanId;
}

}
