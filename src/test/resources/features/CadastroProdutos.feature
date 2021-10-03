#Author: eng.jaquesilva@gmail.com
Feature: Cadastro Produtos
		@Cadastrar1
		Scenario: Cadastrar novo produto
			Given Que eu esteja na tela inicial
			When Acessar a opcao novo
 			And Preencher com os dados
				|Codigo	|Descricao	|Quantidade	|Val.Unit.	|
				|001F		|Fone 			|2					|100				|
				|002M		|Mouse			|1					|50					|
			Then os produtos sao adicionados