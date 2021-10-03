package com.autprodutos.steps;

import java.util.List;
import java.util.Map;

import com.autprodutos.pages.CadastroPage;
import com.autprodutos.pages.EstoquePage;
import com.autprodutos.pages.TelaInicialPage;
import com.autprodutos.utils.DriverSetup;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	AndroidDriver<MobileElement> driver;
	TelaInicialPage telaInicial;
	CadastroPage cadastro;
	EstoquePage estoque;
	String novaQuant;
	String quantAnterior;

	@Before
	public void setUp() throws Exception {
		driver = new DriverSetup().driverSetup();
		telaInicial = new TelaInicialPage(driver);
		cadastro = new CadastroPage(driver);
		estoque = new EstoquePage(driver);
	}

	@After
	public void tear() {
		driver.closeApp();
	}

	@Given("Que eu esteja na tela inicial")
	public void que_eu_esteja_na_tela_inicial() throws Exception {
		telaInicial.tratarPopUp();
		telaInicial.tratarPopUp();
		telaInicial.validaTelaInicial();
	}

	@When("Acessar a opcao novo")
	public void acessar_a_opcao_novo() {
		telaInicial.clicaAdicionar();
	}

	@When("Preencher com os dados")
	public void preencher_com_os_dados(DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
//		Map<String,String> columns = rows.get(0);
		for (Map<String, String> dados : rows) {
			cadastro.preencheDadosProduto(dados.get("Codigo"), dados.get("Descricao"), dados.get("Quantidade"),
					dados.get("Val.Unit."));
			cadastro.clicaSalvar();
			telaInicial.clicaAdicionar();
		}
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

	@Then("os produtos sao adicionados")
	public void os_produtos_sao_adicionados() {
		cadastro.validaCadastro();
	}

	@When("Alterar a quantidade de um produto para <{string}>")
	public void alterar_a_quantidade_de_um_produto_para(String operacao) {
		quantAnterior = telaInicial.quantidadeAtual();
		novaQuant = "1";
		if (operacao.equals("mais")) {
			telaInicial.clicaEntrada();
			estoque.adicionarQuant(novaQuant);
		} else if (operacao.equals("menos")) {
			telaInicial.clicaSaida();
			estoque.diminuirQuant(novaQuant);
			novaQuant = "-1";
		}
		estoque.clicaSalvar();
	}

	@Then("A quantidade e atualizada")
	public void a_quantidade_e_atualizada() {
		telaInicial.verificaQtde(quantAnterior, novaQuant);
	}

	@When("Pesquisar o produto {string}")
	public void pesquisar_o_produto(String produto) {
		telaInicial.pesquisa(produto);
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

	@Then("O produto {string} e encontrado")
	public void o_produto_e_encontrado(String produto) {
		telaInicial.verificaProduto(produto);
	}

}
