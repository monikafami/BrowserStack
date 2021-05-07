package browser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectBrowserStack {

	public static void main(String[] args) {
		
		System.out.println("We are starting");
	    System.setProperty("webdriver.chrome.driver","C:\\Users\\ASUS\\Downloads\\chromedriver_win32 (2)\\Chromedriver.exe");
	       
//	    Create object type WebDriver
	       
	    WebDriver driver = new ChromeDriver();
	          
	    String url = "https://www.browserstack.com/";
	       
//		Open website
	    System.out.println("STEP 1 - Open website");
	    
	    driver.get(url);
	    
	    driver.manage().window().maximize();
	       
//      The correctness of the page title
	    
	    String title = driver.getTitle();
	    
	    if (title.equals("Most Reliable App & Cross Browser Testing Platform | BrowserStack")) {
	    	System.out.println("Title is correctly set to: '" + title + "'");
	    } else {
	    	System.out.format("Title is set to '%s', instead of 'Most Reliable App & Cross Browser Testing Platform | BrowserStack'\n", title);
	    }
	    
	    System.out.println(" Find element by Id=accept-cookie-notification ");
	    
	    WebElement cookie = driver.findElement(By.id("accept-cookie-notification"));
	    
	    cookie.click();
	    
//     Find element by text 'Sign in'
	    
	    System.out.println("STEP 2 Find element by text - Sign in");

	    
	    WebElement signIn = driver.findElement(By.linkText("Sign in"));
   
        signIn.click();
        
//      Entering incorrect data, Business Email: monika@gmail.com Password: monika123
        
        System.out.println("STEP 3 Login ");
        
        WebElement BusinessEmail = driver.findElement(By.id("user_email_login"));
		if (BusinessEmail != null) 
		{
			System.out.println("Field email is displayed");
		} 
		else 
		{
			System.err.println("Field email is not displayed\n");
		}
        
		BusinessEmail.sendKeys("monika@gmail.com");
		
		String tmpPb = "";
		
		tmpPb = BusinessEmail.getAttribute("value");
		if (tmpPb.equals("monika@gmail.com")) {
			System.out.println("Business email is correctly set to: '" + tmpPb + "'" );
		}
		else {
			System.err.format("Business email is set to '%s', instead of 'monika@gmail.com'\n", tmpPb);
		}
 
        WebElement password = driver.findElement(By.id("user_password"));		
		if (password != null) {
			System.out.println("Field password is displayed");
		}
		else {
			System.err.println("Field password is not displayed\n");
		}
		
		password.sendKeys("monika123");
		
		
		tmpPb = password.getAttribute("value");
		if (tmpPb.equals("monika123")) {
			System.out.println("User password is correctly set to: '" + tmpPb + "'" );
		}
		else {
			System.err.format("User password is set to '%s', instead of 'monika123'\n", tmpPb);
		}
		
//      Click on the 'Sign me in' button
		
		WebElement signMeIn = driver.findElement(By.id("user_submit"));
		   
		signMeIn.click();
		
// 		Check if an error message appears
		
	    System.out.println("STEP 4 Validation of the displayed message");
	    
        WebElement errMsg = driver.findElement(By.className("msg-body"));	    
        tmpPb = errMsg.getText();              
        verifyText(tmpPb, "Invalid password");
        
        System.out.println("STEP 5 Close website ");
        
        driver.close();
	}

	
	public static void verifyText(String text, String expectedText) {
		if(text.equals(expectedText))
		{
			System.out.println("Text is correctly set to: '" + text + "'");
		}
		else
		{
			System.err.format("Text is set to '%s', instead of '%s'\n", text, expectedText);
		}	
		
	}
}
	
	
	

