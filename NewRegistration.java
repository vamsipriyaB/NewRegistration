package playablo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewRegistration extends Utils{

@Test(priority=1)
public void signUpScreen() throws Exception{
	browserSelect("chrome");
	driver.manage().window().maximize();
	driver.get("http://52.90.214.144:8080/web/childLogin.php");
	clickOnElement("id", "txtSignUp");
	waitUntilElementIsStable(driver.findElement(By.id("txtSignUpEmail")));
	enterTextFieldValue("id","txtSignUpEmail","newtes6@gmail.com");
	clickOnElement("id","btnSignup");
	
}

@Test(priority=2)
public void childSignup(){

	try {
		WebElement ele= driver.findElement(By.id("rdgenderF"));
		WebDriverWait(ele);
		clickOnElement("id", "rdgenderF");
		Thread.sleep(3000);
		clickOnElement("xpath","//p[text()='ICSE']");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		waitUntilElementIsStable(driver.findElement(By.xpath(".//*[@id='lbGrade1']/p")));
		Thread.sleep(3000);
		clickOnElement("id","lbGrade1");
		enterTextFieldValue("id", "childName", "child1");
		enterTextFieldValue("id","parentPasscode", "11111");
		enterTextFieldValue("id", "selectCity1", "chittoor");
		enterTextFieldValue("id","selectSchool1", "new school");
		clickOnElement("id","btnStartFreeTrail");
		} catch (Exception e) {
			e.printStackTrace();
			screenShot();
		}
}

@AfterTest
public void closeProgram(){
	driver.close();
}
}
