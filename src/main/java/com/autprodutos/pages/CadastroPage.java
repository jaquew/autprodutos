package com.autprodutos.pages;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CadastroPage {
	AndroidDriver<MobileElement> driver;

	public CadastroPage(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
	}

	@AndroidFindBy(xpath = "//*[@text = 'br.com.pztec.estoque:id/txt_codigo']")
	MobileElement txtAccDet;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_codigo")
	MobileElement fldCodigo;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_descricao")
	MobileElement fldDescricao;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_unidade")
	MobileElement fldUnidade;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_quantidade")
	MobileElement fldQuant;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_valunit")
	MobileElement fldValorUn;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/txt_lote")
	MobileElement fldLote;

	@AndroidFindBy(id = "br.com.pztec.estoque:id/btn_gravar_assunto")
	MobileElement btnSalvar;

	public void preencheDadosProduto(String codigo, String descricao, String quantidade, String valor) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.hideKeyboard();
		fldCodigo.sendKeys(codigo);
		fldDescricao.sendKeys(descricao);
		fldQuant.sendKeys(quantidade);
		fldValorUn.sendKeys(valor);

	}

	public void clicaSalvar() {
		btnSalvar.click();
	}

	public void validaCadastro() {
		assertTrue("Valida tabela produtos",
				!driver.findElementsByXPath("//*[@resource-id='br.com.pztec.estoque:id/tabela_itens']").isEmpty());

	}
}
