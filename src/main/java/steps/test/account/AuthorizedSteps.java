package steps.test.account;

import static org.junit.Assert.assertTrue;

import controller.test.account.AuthorizedController;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.test.request.account.authorized.AuthorizedPostRequest;

public class AuthorizedSteps {
	
	private AuthorizedController authoController;
	private AuthorizedPostRequest authoPostRequest;
    
    public AuthorizedSteps() {
    	authoController = new AuthorizedController();
    	authoPostRequest = new AuthorizedPostRequest();
    }

    @Dado("que informo o UserName {string}")
    public void que_informo_o_UserName(String username) {
    	authoPostRequest.setUserName(username);
    }

    @Dado("o produto {string}")
    public void o_produto(String password) {
    	authoPostRequest.setPassword(password);
    }
    
    @Quando("faco uma solicitacao com o metodo POST")
    public void faco_uma_solicitacao_com_o_metodo_POST() {
        authoController.postAuthorizedWithUsernameAndPassword(authoPostRequest);
    }
    
    @Entao("o codigo de resposta deve ser {int}")
    public void o_codigo_de_resposta_deve_ser(Integer statusCode) {
    	assertTrue(authoController.isStatusCodeEquals(statusCode));
    }

    @E("com corpo de resposta com true")
    public void com_corpo_de_resposta_com_true() {
    	assertTrue(authoController.isValidPostAuthorizedSuccessWithSchema());
    	assertTrue(authoController.isValidPostAuthorizedSuccessWithModel());
    }
}
