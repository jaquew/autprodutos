package com.autprodutos.steps;

import com.autprodutos.utils.DriverSetup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	AppiumDriver<MobileElement> driver;

	@Before
	public void setUp() throws Exception {
		driver = new DriverSetup().driverSetup();
	}

	@After
	public void tear() {
		driver.closeApp();
	}
	
	@Given("Que eu esteja na tela inicial")
	public void que_eu_esteja_na_tela_inicial() {
	
	}
	
	@When("Acessar a opcao novo")
	public void acessar_a_opcao_novo() {

	}
	
	@When("Preencher com os dados")
	public void preencher_com_os_dados(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	}
	
	@Then("os produtos sao adicionados")
	public void os_produtos_sao_adicionados() {

	}

	@When("Alterar a quantidade do produto {string}")
	public void alterar_a_quantidade_do_produto(String produto) {
		
	}
	
	@Then("A quantidade e atualizada")
	public void a_quantidade_e_atualizada() {

	}


}
