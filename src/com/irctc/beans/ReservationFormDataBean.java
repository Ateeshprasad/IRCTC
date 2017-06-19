package com.irctc.beans;

import org.openqa.selenium.Keys;

import com.irctc.components.DatePickerComp;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.data.BaseFormDataBean;
import com.qmetry.qaf.automation.ui.annotations.UiElement;
import com.qmetry.qaf.automation.ui.annotations.UiElement.Type;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Randomizer;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * 
 * @author ateeshprasad.palla
 *
 */

public class ReservationFormDataBean extends BaseFormDataBean {
	//@Randomizer(dataset={"domestic","international","ltc"})
	@UiElement(fieldLoc="main.btn.type.travel",required=true,order=1)
	private String travelType;

	@UiElement(fieldLoc="main.radio.trip.type",required=true,order=2)
	private String tripType;
	
//	@UiElement(fieldLoc="main.radio.trip.type.inter",required=true,order=2,dependingValue="international")
//	private String tripTypeInter;

	@UiElement(fieldLoc="main.input.origin",fieldType=Type.textbox,required=true,order=3)
	private String origin;

	@UiElement(fieldLoc="main.input.destination",fieldType=Type.textbox,required=true,order=4)
	private String destination;
	
	@UiElement(fieldLoc="main.input.departure",fieldType=Type.textbox,required=true,order=5)
	private String departureDate;
	
	@UiElement(fieldLoc="main.input.return",fieldType=Type.textbox,required=true,dependsOnField="tripType",dependingValue="Round Trip",order=6)
	private String returnDate;
	
	@UiElement(fieldLoc="main.select.adults.no",fieldType=Type.selectbox,order=7,dependsOnField="travelType",dependingValue= "domastic")
	private int adults;
	
	@UiElement(fieldLoc="main.select.children.no",fieldType=Type.selectbox,order=8,dependsOnField="travelType",dependingValue="domastic")
	private int children;
	
	@UiElement(fieldLoc="main.select.infants.no",fieldType=Type.selectbox,order=9,dependsOnField="travelType",dependingValue="domastic")
	private int infants;
	
	@UiElement(fieldLoc="main.select.class.type",fieldType=Type.selectbox,order=10,dependsOnField="travelType",dependingValue="domastic")
	private String travelClass;
	
	@UiElement(fieldLoc="main.select.airline.preference",fieldType=Type.selectbox,order=11,dependsOnField="travelType",dependingValue="domastic")
	private String airlinePreference;
	
	@UiElement(fieldLoc="main.select.adults.no.inter",fieldType=Type.selectbox,order=7,dependsOnField="travelType",dependingValue="international")
	private int adultsInter;
	
	@UiElement(fieldLoc="main.select.children.no.inter",fieldType=Type.selectbox,order=8,dependsOnField="travelType",dependingValue="international")
	private int childrenInter;
	
	@UiElement(fieldLoc="main.select.infants.no.inter",fieldType=Type.selectbox,order=9,dependsOnField="travelType",dependingValue="international")
	private int infantsInter;
	
	@UiElement(fieldLoc="main.select.class.type.inter",fieldType=Type.selectbox,order=10,dependsOnField="travelType",dependingValue="international")
	private String travelClassInter;
	
	public void fillTravelType() {
		String newTravelTypeLoc=String.format(ConfigurationManager.getBundle().getString("main.btn.type.travel"),travelType);
		QAFExtendedWebElement eleTripType=new QAFExtendedWebElement(newTravelTypeLoc);
		eleTripType.click();
	}
	
	public void fillTripType() {
		//AppUtils.clickOnVisibleElement(new String[]{"main.radio.trip.type","main.radio.trip.type.inter"});
		
		String newTripTypeLoc=String.format(ConfigurationManager.getBundle().getString("main.radio.trip.type"),tripType);
		QAFExtendedWebElement eleTripType=new QAFExtendedWebElement(newTripTypeLoc);
		try {
			if(!eleTripType.isDisplayed()) {
				newTripTypeLoc=String.format(ConfigurationManager.getBundle().getString("main.radio.trip.type.inter"),tripType);
				eleTripType=new QAFExtendedWebElement(newTripTypeLoc);
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		eleTripType.click();
	}
	
	public void fillOrigin() {
		//AppUtils.clickOnVisibleElement(new String[]{"main.input.origin","main.input.origin.inter"});
		
		QAFExtendedWebElement eleOrigin=new QAFExtendedWebElement("main.input.origin");
		try {
			if(!eleOrigin.isDisplayed()) {
				eleOrigin=new QAFExtendedWebElement("main.input.origin.inter");
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		eleOrigin.sendKeys(origin,Keys.ARROW_DOWN,Keys.TAB);
	}
	
	public void fillDestination() {
		//AppUtils.clickOnVisibleElement(new String[]{"",""});
		
		QAFExtendedWebElement eleDestination=new QAFExtendedWebElement("main.input.destination");
		try {
			if(!eleDestination.isDisplayed()) {
				eleDestination=new QAFExtendedWebElement("main.input.destination.inter");
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		eleDestination.sendKeys(destination,Keys.ARROW_DOWN,Keys.TAB);
	}
	
	public void fillDepartureDate() {
		//AppUtils.clickOnVisibleElement(new String[]{"",""});
		
		QAFExtendedWebElement eleDeparture=new QAFExtendedWebElement("main.input.departure");
		try {
			if(!eleDeparture.isDisplayed()) {
				eleDeparture=new QAFExtendedWebElement("main.input.departure.inter");
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		eleDeparture.click();
		DatePickerComp dpc=new DatePickerComp();
		dpc.setDate(departureDate);
	}
	
	public void fillReturnDate() {		
		//AppUtils.clickOnVisibleElement(new String[]{"",""});
		
		QAFExtendedWebElement eleReturn=new QAFExtendedWebElement("main.input.return");
		try {
			if(!eleReturn.isDisplayed()) {
				eleReturn=new QAFExtendedWebElement("main.input.return.inter");
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		eleReturn.click();
		DatePickerComp dpc=new DatePickerComp();
		dpc.setDate(returnDate);
	}
}
