package com.irctc.suite;

import org.testng.annotations.Test;

import com.irctc.pages.MainTestPage;
import com.irctc.pages.SearchResultsTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

/**
 * 
 * @author ateeshprasad.palla
 *
 */

public class MainTestSuite extends WebDriverTestCase {

	@Test(description = "fill domestic form data and search for flights")
	public void fillDomesticFormData() {
		MainTestPage mainTestPage=new MainTestPage();
		mainTestPage.launchPage(null);
		//getDriver().manage().window().maximize();
		mainTestPage.fillForm();
		System.out.println("Form filled");
		SearchResultsTestPage searchResultsTestPage=new SearchResultsTestPage();
		System.out.println("Getting search results");
		searchResultsTestPage.getFlightDetails();
		System.out.println("There are no more search results left...");
	}

}
