package com.example.basicmatchshopping.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebCrawlerUtil {

	public static String getContent(String url) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(url);
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(2500);
		String content = driver.getPageSource();
		driver.quit();
		return content;
	}

	public static String getContentMarrisons(String url) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get(url);
		driver.manage().window().maximize();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1500);
		js.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2500);
		String content = driver.getPageSource();
		driver.quit();
		return content;
	}

}
