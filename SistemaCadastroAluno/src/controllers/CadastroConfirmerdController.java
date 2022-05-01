package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CadastroConfirmerdController {

    @FXML
    private Button btnConfIrmeRegister;

    @FXML
    private Pane confirmCadastro;
    
    

    @FXML
    void clicouBtnConfirmeRegister(ActionEvent event) {
    	Stage stage = (Stage) btnConfIrmeRegister.getScene().getWindow();
        stage.close();
        
        
        
    }
}
