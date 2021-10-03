#Author: eng.jaquesilva@gmail.com

Feature: Pesquisa Produtos
@Pesquisar
	Scenario Outline: Realizar a pesquisa de um produto
	Given Que eu esteja na tela inicial
	When Pesquisar o produto <nome>
	Then O produto <nome> e encontrado

	Examples:
	|nome		|
	|"Fone" |
	|"Mouse"|