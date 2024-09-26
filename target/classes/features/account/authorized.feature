#language: pt

@Regressivo @Authorized
Funcionalidade: Validar autorização com UserName e Password
	 Como Usuario
	 Quero me autenticar no sistema
	 Para ver se tenho autorizacao de acesso

	@Sucesso @200
  Esquema do Cenario: Consulta de autorizacao com sucesso [200]
    Dado que informo o UserName "<username>"
    E o produto "<password>"
    Quando faco uma solicitacao com o metodo POST
    Entao o codigo de resposta deve ser 200
    E com corpo de resposta com true
		
    Exemplos: 
 		| 			username   			|					password 				|
  	|NickFirmino 						|F!rm!no@24111994		    	| 
