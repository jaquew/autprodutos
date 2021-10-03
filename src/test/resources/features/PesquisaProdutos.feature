#Author: eng.jaquesilva@gmail.com

Feature: Pesquisa Produtos
@Pesquisar
	Scenario: Realizar a pesquisa de um produto
	Given Que eu esteja na tela principal
	When Pesquisar o produto pelo nome <nome>
	Then O produto e encontrado

	Examples:
	|nome	|
	|fone |
	|mouse|