package keywords.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import utils.Common;

public class InputManager extends BaseTest implements Input {

	@Override
	public void input(By by, String text) {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriver.findElement(by).sendKeys(text);
	}

	@Override
	public void inputAndPressEnter(By by, String text) {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriver.findElement(by).sendKeys(text);
		webDriver.findElement(by).sendKeys(Keys.RETURN);
		if (getBrower().equals("firefox")) { 
			waitForLoad(webDriver);
		} 
	}

	@Override
	public void inputAndClear(By by, String text) {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		webDriver.findElement(by).clear();
		webDriver.findElement(by).sendKeys(text);
	}
	
	private static void waitForLoad(WebDriver driver) {
    	Common.sleep(500);
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
