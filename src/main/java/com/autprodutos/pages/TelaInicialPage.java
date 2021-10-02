package com.autprodutos.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TelaInicialPage {
	AppiumDriver<MobileElement> driver;
	int y;

	public TelaInicialPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);

	}

	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	MobileElement btnPermitir;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Cadastro de Produtos']")
	MobileElement txtCadProdutos;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/Button1")
	MobileElement btnNovo;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/Button3")
	MobileElement btnMenu;

	@AndroidFindBy(id = "android:id/search_button")
	MobileElement btnPesquisar;

	public void tratarPopUp() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (!driver.findElementsByXPath("//*[@resource-id='com.android.packageinstaller:id/dialog_container']")
				.isEmpty()) {
			btnPermitir.click();
		}
	}

	public void validaTelaInicial() {
		assertTrue("Texto Cadastro de Produtos", txtCadProdutos.isDisplayed());
		assertTrue("Botao Novo", btnNovo.isDisplayed());

	}

	public void clicaAdicionar() {
		btnNovo.click();
	}

}
