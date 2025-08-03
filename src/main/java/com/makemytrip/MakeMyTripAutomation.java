package com.makemytrip;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		WebDriver wd = new ChromeDriver(chromeOptions);
		wd.get("https://www.makemytrip.com/");

		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
		By closeModalButtonLocator = By.xpath("//span[@data-cy='closeModal']");
		WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(closeModalButtonLocator));
		closeModalButton.click();

		// Clicking on From City
		By forCityLabelLocator = By.xpath("//label[@for='fromCity']");
		WebElement forCityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(forCityLabelLocator));
		forCityLabel.click();

		By forCityInputTextBoxLocator = By.xpath("//input[@placeholder='From']");
		WebElement forCityInputTextBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(forCityInputTextBoxLocator));
		forCityInputTextBox.sendKeys("Pune");

		By fromCitySuggestionListLocator = By
				.xpath("//*[text()='SUGGESTIONS ']/ancestor::div[contains(@class,'react-autosuggest')]/ul/li");

		boolean state = wait.until(
				ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(fromCitySuggestionListLocator),
						ExpectedConditions.numberOfElementsToBeLessThan(fromCitySuggestionListLocator, 12)));

		List<WebElement> fromCitySuggestionList = null;

		if (state) {

			fromCitySuggestionList = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fromCitySuggestionListLocator));
		}

		System.out.println(fromCitySuggestionList.size());

		for (WebElement suggestion : fromCitySuggestionList) {
			System.out.println(suggestion.getText());
			;
		}

		fromCitySuggestionList.get(0).click();

		// Clicking on To City
		By toCityLabelLocator = By.xpath("//label[@for='toCity']");
		WebElement toCityLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(toCityLabelLocator));
		toCityLabel.click();

		By toCityInputTextBoxLocator = By.xpath("//input[@placeholder='To']");
		WebElement toCityTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(toCityInputTextBoxLocator));
		toCityTextBox.sendKeys("Hyderabad");

		By toSuggestionListLocator = By.xpath(
				"//p[contains(text(),'SUGGESTIONS')]//ancestor::div[contains(@class,'react-autosuggest')]/ul/li");
		state = wait
				.until(ExpectedConditions.and(ExpectedConditions.visibilityOfElementLocated(toSuggestionListLocator),
						ExpectedConditions.numberOfElementsToBeMoreThan(toSuggestionListLocator, 11)));

		List<WebElement> toSuggestionList = null;

		if (state) {
			toSuggestionList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(toSuggestionListLocator));
		}

		System.out.println(toSuggestionList.size());

		for (WebElement suggestion : toSuggestionList) {
			System.out.println(suggestion.getText());
			;
		}

		toSuggestionList.get(0).click();

		// Get taget date, year and month
		LocalDate targetDate = LocalDate.now();
		targetDate = targetDate.plusDays(6);
		int targetDay = targetDate.getDayOfMonth();
		System.out.println(targetDate);

		String targetMonth = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
		System.out.println(targetMonth);

		int targetYear = targetDate.getYear();
		System.out.println(targetYear);

		// System.out.println("//div[text()='August
		// 2025']//ancestor::div[@class='DayPicker-Month']");
		System.out.println(
				"//div[text()='" + targetMonth + " " + targetYear + "']//ancestor::div[@class='DayPicker-Month']");

		By calendarMonthLocator = By.xpath(
				"//div[text()='" + targetMonth + " " + targetYear + "']//ancestor::div[@class='DayPicker-Month']");
		WebElement calendarMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(calendarMonthLocator));

		By dateLocator = By.xpath(".//p[text()='" + targetDay + "']//ancestor::div[contains(@class,'DayPicker-Day')]");
		WebElement date = calendarMonth.findElement(dateLocator);
		date.click();

	}

}
