#Author: your.email@your.domain.com
Feature: Quantidade Produto

		@Quantidade
		Scenario: Aumentar a quantidade do produto
			Given Que eu esteja na tela inicial
			When Alterar a quantidade de um produto para <"mais">
			Then A quantidade e atualizada

		@Quantidade
		Scenario: Diminuir a quantidade do produto
			Given Que eu esteja na tela inicial
			When Alterar a quantidade de um produto para <"menos">
			Then A quantidade e atualizada