package com.irctc.components;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class FlightDetailsComp extends QAFWebComponent {

	@FindBy(locator="searchresults.rt.lbl.flightno")
	private QAFWebElement flightNumber;
	
	@FindBy(locator="searchresults.rt.lbl.journeyFare")
	private QAFWebElement journeyFare;
	
	@FindBy(locator="searchresults.rt.lbl.journey.time")
	private QAFWebElement journeyTime;
	
	public FlightDetailsComp(String locator) {
		super(locator);
	}

	public QAFWebElement getFlightNumber() {
		return flightNumber;
	}

	public QAFWebElement getJourneyFare() {
		return journeyFare;
	}

	public QAFWebElement getJourneyTime() {
		return journeyTime;
	}

	

}
