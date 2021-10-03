package com.autprodutos.utils;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverSetup {
	public AndroidDriver<MobileElement> driverSetup() throws Exception {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("DeviceName", "Celular");
		dc.setCapability("udid", "8S00Q7103011ZN1199R00HP");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("noReset", "true");
		dc.setCapability("fullReset", "false");
		dc.setCapability("newCommandTimeout", "600");
		dc.setCapability("appPackage", "br.com.pztec.estoque");
		dc.setCapability("appActivity", "br.com.pztec.estoque.Inicio");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, dc);
		return driver;

	}

}
