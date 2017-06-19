package com.irctc.utils;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Reporter;

public class AppUtils {

	public static QAFExtendedWebElement createElement(String loc,String replaceString) {
		if(replaceString==null)
			return new QAFExtendedWebElement(loc);
		else
			return new QAFExtendedWebElement(getStringLoc(loc, replaceString));
	}
	
	public static String getStringLoc(String loc,String replaceString) {
		return String.format(ConfigurationManager.getBundle().getString(loc),replaceString);
	}
	
	public static void clickOnVisibleElement(String[] locators) {
		for(String loc:locators) {
			try {
				QAFExtendedWebElement ele=new QAFExtendedWebElement(loc);
				if(ele.isDisplayed())
					ele.click();
			}catch(Exception e) {
				Reporter.log(e.getMessage());
			}
		}
	}
}
