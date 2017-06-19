package com.irctc.pages;

import java.util.List;

import com.irctc.components.FlightDetailsComp;
import com.irctc.components.ReturnFlightsComp;
import com.irctc.components.StartFlightsComp;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class SearchResultsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchresults.search.info")
	private QAFWebElement searchresultsSearchInfo;

	@FindBy(locator = "searchresults.rt.comp.flights")
	private List<FlightDetailsComp> search;
	
	@FindBy(locator="searchresults.rt.comp.startTrip")
	private List<StartFlightsComp> startFlights;
	
	@FindBy(locator="searchresults.rt.comp.returnTrip")
	private List<ReturnFlightsComp> returnFlights;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSearchresultsSearchInfo() {
		return searchresultsSearchInfo;
	}

	public List<FlightDetailsComp> getSearch() {
		return search;
	}

	public List<StartFlightsComp> getStartFlights() {
		return startFlights;
	}

	public List<ReturnFlightsComp> getReturnFlights() {
		return returnFlights;
	}

	public void getFlightDetails() {
		waitForPageToLoad();
		QAFTestBase.pause(5000);
		for(StartFlightsComp comp:getStartFlights()) {
			for(FlightDetailsComp flights:comp.getStartFlights()) {
				System.out.println("Flight number: "+flights.getFlightNumber().getText());
				System.out.println("Journey fare: "+flights.getJourneyFare().getText());
				System.out.println("Journey time: "+flights.getJourneyTime().getText());
				System.out.println();
			}
		}
	}
	
}
