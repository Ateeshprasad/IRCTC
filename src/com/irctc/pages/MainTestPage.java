package com.irctc.pages;

import org.openqa.selenium.support.ui.Select;

import com.irctc.beans.ReservationFormDataBean;
import com.irctc.utils.AppUtils;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;

/**
 * 
 * @author ateeshprasad.palla
 *
 */

public class MainTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {
	ReservationFormDataBean bean;
	
	public MainTestPage() {
		bean=new ReservationFormDataBean();
	}
	
	@FindBy(locator = "main.btn.type.travel")
	private QAFWebElement mainBtnTypeTravel;
	
	@FindBy(locator = "main.radio.trip.type")
	private QAFWebElement mainRadioTripType;
	
//	@FindBy(locator = "main.input.origin")
//	private QAFWebElement mainInputOrigin;
	
	@FindBy(locator = "main.input.destination")
	private QAFWebElement mainInputDestination;
	
	/*@FindBy(locator = "main.input.departure")
	private QAFWebElement mainInputDeparture;
	
	@FindBy(locator = "main.input.return")
	private QAFWebElement mainInputReturn;*/
	
	@FindBy(locator = "main.select.adults.no")
	private Select mainSelectAdultsNo;
	
	@FindBy(locator = "main.select.children.no")
	private Select mainSelectChildrenNo;
	
	@FindBy(locator = "main.select.infants.no")
	private Select mainSelectInfantsNo;
	
	@FindBy(locator = "main.select.class.type")
	private Select mainSelectClassType;
	
	@FindBy(locator = "main.select.airline.preference")
	private Select mainSelectAirlinePreference;
	
	@FindBy(locator = "main.btn.submit")
	private QAFWebElement mainBtnSubmit;
	
	@FindBy(locator = "main.date.picker.comp")
	private QAFWebElement maindatePickerComp;
	
	@FindBy(locator = "main.date.picker.comp.first")
	private QAFWebElement mainDatePickerCompFirst;
	
	@FindBy(locator = "main.date.picker.comp.last")
	private QAFWebElement mainDatePickerCompLast;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
		
		driver.get("/");
		//driver.manage().window().maximize();
	}

	public QAFWebElement getMainBtnTypeTravel() {
		return mainBtnTypeTravel;
	}

	public QAFWebElement getMainRadioTripType(String tripType) {
		return mainRadioTripType=AppUtils.createElement("main.radio.trip.type", tripType);
	}

//	public QAFWebElement getMainInputOrigin() {
//		return mainInputOrigin;
//	}

	public QAFWebElement getMainInputDestination() {
		return mainInputDestination;
	}

	/*public QAFWebElement getMainInputDeparture() {
		return mainInputDeparture;
	}

	public QAFWebElement getMainInputReturn() {
		return mainInputReturn;
	}*/

	public Select getMainSelectAdultsNo() {
		return mainSelectAdultsNo;
	}

	public Select getMainSelectChildrenNo() {
		return mainSelectChildrenNo;
	}

	public Select getMainSelectInfantsNo() {
		return mainSelectInfantsNo;
	}

	public Select getMainSelectClassType() {
		return mainSelectClassType;
	}

	public Select getMainSelectAirlinePreference() {
		return mainSelectAirlinePreference;
	}

	public QAFWebElement getMainBtnSubmit() {
		//QAFExtendedWebElement eleDestination=new QAFExtendedWebElement("main.input.destination");
		try {
			if(!mainBtnSubmit.isDisplayed()) {
				mainBtnSubmit=new QAFExtendedWebElement("main.btn.submit.inter");
			}
		}catch(Exception e) {
			Reporter.log(e.getMessage());
		}
		return mainBtnSubmit;
	}
	
	
	public void fillForm() {
		waitForPageToLoad();
		bean.fillFromConfig("domestic.data");
	//	bean.fillDepartureDate();
		System.out.println(bean);
		bean.fillUiElements();
		QAFTestBase.pause(3000);
		getMainBtnSubmit().click();
		QAFTestBase.pause(10000);
		System.out.println("Success------------------------->");
	}
	
	
	
	
}
