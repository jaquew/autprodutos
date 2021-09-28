#Author: eng.jaquesilva@gmail.com

Feature: Cadastrar Produto
@Cadastrar1
	Scenario: Cadastrar novo produto
	Given Que eu esteja na tela inicial
	When Acessar a opcao novo
	And Preencher com os dados
	|Codigo	|Descricao	|Quantidade	|Val.Unit.	|
	|001F		|Fone 			|2					|100				|
	|002M		|Mouse			|1					|50					|
	|003N		|Notebook		|1					|2000				|
	Then os produtos sao adicionados
	
	
@Cadastrar2
	Scenario: Alterar a quantidade do produto
	Given Que eu esteja na tela inicial
	When Alterar a quantidade do produto "001F" 
	Then A quantidade e atualizada
	