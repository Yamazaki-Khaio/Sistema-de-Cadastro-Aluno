
package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import model.Alunos;
import model.AlunosDAO;



/** Controller responsavél pela edição e adição dos Alunos.
 * @author Kaio Geovan
 * @version 1.17
 * @since Aplicado desde o inicio da codificação
 */


public class CadastroAlunoController implements Initializable {

    @FXML
    private Button btnRegister;

    @FXML
    private TextField cpfRegister;

    @FXML
    private TextField cursoRegister;

    @FXML
    private DatePicker dateNascimento;

    @FXML
    private TextField emailRegister;

    @FXML
    private Label lblAviso;

    @FXML
    private TextField matriculaRegister;

    @FXML
    private TextField nomeRegister;
    
    
    private boolean update = false;
    
    AudioClip ratinhoooo = new AudioClip(getClass().getResource("/view/ratinhooo.mp3").toExternalForm());
    

    

    
    @FXML
    void userCadastro(ActionEvent event) {
    	ratinhoooo.play();
    	if(nomeRegister.getText().isBlank() == false && cpfRegister.getText().isBlank() == false && emailRegister.getText().isBlank() == false 
    			&& matriculaRegister.getText().isBlank() == false && cursoRegister.getText().isBlank() == false ){
    		
    		
            	String matricula, nome, cpf, email, dataNascimento, curso;
            	
            	matricula = matriculaRegister.getText();
            	nome = nomeRegister.getText();
            	cpf = cpfRegister.getText();        	
            	email = emailRegister.getText();
            	dataNascimento = dateNascimento.getValue().toString(); 
            	curso = cursoRegister.getText();
            	
            	Alunos alunos = new Alunos();
            	
            	alunos.setMatricula(matricula);
            	alunos.setNome(nome);
            	alunos.setNascimento(dataNascimento);
            	alunos.setCpf(cpf);
            	alunos.setCurso(curso);
            	alunos.setEmail(email);
            	
            	AlunosDAO alunosDAO = new AlunosDAO();         	
            	if(update == false) {
            		alunosDAO.registerAlunos(alunos);
            	}else {
            		alunosDAO.alterarAlunos(alunos);
            	}
            
				
                Stage stage = (Stage) btnRegister.getScene().getWindow();
                stage.close();
                
                
    		
    	} else {
    		lblAviso.setText("Cadastre os dados do Aluno!");
    	}
    		}
        


    
    public void initialize(URL location, ResourceBundle resources) {

    }


	public void setTextField(String matricula, String nome,String cpf, String curso, String email ) {
		matriculaRegister.setText(matricula);
		nomeRegister.setText(nome);
		
		cpfRegister.setText(cpf);
		cursoRegister.setText(curso);
		emailRegister.setText(email);
		
		
		
		
	}
 
	void setUpdate(boolean b) {
        this.update = b;

    }


}
