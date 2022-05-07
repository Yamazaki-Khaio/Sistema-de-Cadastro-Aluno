package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class CadastroConfirmerdController {
   // AudioClip cavalo = new AudioClip(getClass().getResource("/view/audio/cavalo.mp3").toExternalForm());

    @FXML
    private Button btnConfIrmeRegister;

    @FXML
    private Pane confirmCadastro;
    
    

    @FXML
    void clicouBtnConfirmeRegister(ActionEvent event) {
    	//cavalo.play();
    	Stage stage = (Stage) btnConfIrmeRegister.getScene().getWindow();
        stage.close();
        
        
        
    }
}
