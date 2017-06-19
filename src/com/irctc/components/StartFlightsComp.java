package com.irctc.components;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;

public class StartFlightsComp extends QAFWebComponent{
	
	@FindBy(locator="searchresults.rt.sub.comp.flights")
	private List<FlightDetailsComp> startFlights;

	public StartFlightsComp(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public List<FlightDetailsComp> getStartFlights() {
		return startFlights;
	}

	
}
