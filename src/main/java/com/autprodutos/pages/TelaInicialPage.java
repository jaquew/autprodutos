package com.autprodutos.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TelaInicialPage {
	AndroidDriver<MobileElement> driver;
	int y;

	public TelaInicialPage(AndroidDriver<MobileElement> driver) {
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
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/entrada")
	MobileElement btnEntrada;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/saida")
	MobileElement btnSaida;
	
	@AndroidFindBy(xpath = "//*[@resource-id= 'br.com.pztec.estoque:id/txt_quantidade']")
	MobileElement txtQtd;

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
	
	public void clicaEntrada() {
		btnEntrada.click();
	}
	public void clicaSaida() {
		btnSaida.click();
	}
	
	public String quantidadeAtual() {
		return txtQtd.getText().substring(0,1);
	}

	public void verificaQtde(String quantAnterior, String novaQuant) {
		System.out.println(quantidadeAtual());
		assertTrue("Quantidade correta", (Integer.parseInt(quantAnterior) + Integer.parseInt(novaQuant)) == Integer.parseInt(quantidadeAtual()));
		
	}
	

}
