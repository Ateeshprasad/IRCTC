package com.irctc.components;

import java.util.List;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

/**
 * 
 * @author ateeshprasad.palla
 *
 */

public class DatePickerComp extends QAFWebComponent {
	
	@FindBy(locator = "main.date.picker.btn.prev")
	private QAFWebElement mainDatePickerBtnPrev;
	
	@FindBy(locator = "main.date.picker.btn.next")
	private QAFWebElement mainDatePickerBtnNext;
	
	@FindBy(locator = "main.date.picker.lbl.month")
	private QAFWebElement mainDatePickerLblMonth;
	
	@FindBy(locator = "main.date.picker.lbl.year")
	private QAFWebElement mainDatePickerLblYear;
	
	@FindBy(locator = "main.date.picker.lbl.date")
	private List<QAFWebElement> mainDatePickerLblDate;

	public DatePickerComp(String locator) {
		super(locator);
	}

	public DatePickerComp() {
		super("main.date.picker.comp.first");
	}
	
	public QAFWebElement getMainDatePickerBtnPrev() {
		return mainDatePickerBtnPrev;
	}

	public QAFWebElement getMainDatePickerBtnNext() {
		return mainDatePickerBtnNext;
	}

	public QAFWebElement getMainDatePickerLblMonth() {
		return mainDatePickerLblMonth;
	}

	public QAFWebElement getMainDatePickerLblYear() {
		return mainDatePickerLblYear;
	}

	public List<QAFWebElement> getMainDatePickerLblDate() {
		return mainDatePickerLblDate;
	}
	
	public void setDate(String date) {
		setMonthAndYear(date.split(" ")[1],date.split(" ")[2]);
		for(QAFWebElement ele:getMainDatePickerLblDate())
		{
			if(ele.getText().trim().contentEquals(date.split(" ")[0])) {
				ele.click();
				break;
			}
		}
		// Date d;
		// try {
		// d = DateUtil.parseDate(date,"dd MMMM yyyy");
		// String strDate=DateUtil.getFormatedDate(d,format);
		// } catch (ParseException e) {
		// Reporter.log(e.getMessage());
		// }
	}
	
	private void setMonthAndYear(String month,String year) {
		if(getMainDatePickerLblYear().getText().trim().contains(year)) {
			if(!getMainDatePickerLblMonth().getText().trim().contains(month)) {
				getMainDatePickerBtnNext().click();
			}
		}
	}
}
