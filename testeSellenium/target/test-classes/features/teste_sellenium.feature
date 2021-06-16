# language: pt
# encoding: utf-8

Funcionalidade: Acessar site e preencher formulários

	Cenario: Preenchimento de cadastro 
	Dado que estou na pagina da aplicacao
    E preencho a aba Vehicle Data
    E preencho a aba Insurant Data
    E preencho a aba Product Data
    E preencho a aba Select Price Option
    E preencho a aba Send Quote e submeto o formulario
    Entao devo ver a mensagem: "Sending e-mail success!"
	
	
