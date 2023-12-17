package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HW2 {
	
	ChromeDriver driver;
  @Test
  public void f() {
	  WebElement advanced = driver.findElement(By.id("details-button"));
	  advanced.click();
	  
	  WebElement proceed = driver.findElement(By.id("proceed-link"));
	  proceed.click();
	  
	  WebElement logo = driver.findElement(By.className("logo-anchor"));
      Assert.assertTrue(logo.isDisplayed(), "Logo is not displayed");
      WebElement loginLink = driver.findElement(By.id("loginMyAccount"));
      loginLink.click();
      WebElement welcomeMessage = driver.findElement(By.cssSelector("#BDLoginMessageNormal > p:nth-child(1)"));
      String message = welcomeMessage.getText();
      Assert.assertTrue(message.equals("Welcome back! To access your account, please enter your email address and password and click Sign In."), "User not navigated to sign in page");
      WebElement emailField = driver.findElement(By.id("logonId"));
      WebElement passwordField = driver.findElement(By.id("logonPassword"));
      WebElement loginButton = driver.findElement(By.id("logonButton"));
      

      emailField.sendKeys("test@live.com");
      passwordField.sendKeys("test@123");
      loginButton.click();
      
      WebElement myAccount = driver.findElement(By.cssSelector("#myAccount > a > span"));
      Assert.assertTrue(myAccount.isDisplayed(), "User logged in failed");
      
      WebElement welcomeUser = driver.findElement(By.cssSelector("#welcome"));
      String welcomeText = welcomeUser.getText();
      Assert.assertTrue(welcomeText.contains("Welcome, Test"), "User name is not correct");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\New folder\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://devwcs.ballarddesigns.com/");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
