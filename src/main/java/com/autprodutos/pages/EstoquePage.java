package com.autprodutos.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EstoquePage {
	AndroidDriver<MobileElement> driver;
	int y;

	public EstoquePage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(8)), this);

	}

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_qtdentrada")
	MobileElement fldAdicionarEst;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_qtdsaida")
	MobileElement fldDiminuirEst;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_motivo")
	MobileElement fldMotivo;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/btn_salvar")
	MobileElement btnSalvar;
	
	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_qtdatual")
	MobileElement qtdAtual;


	public void clicaSalvar() {
		btnSalvar.click();
	}
	
	public void adicionarQuant(String quant) {
		fldAdicionarEst.sendKeys(quant);
		fldMotivo.sendKeys("reposição");
	}
	
	public void diminuirQuant(String quant) {
		fldDiminuirEst.sendKeys(quant);
		fldMotivo.sendKeys("venda");
	}
	
}
