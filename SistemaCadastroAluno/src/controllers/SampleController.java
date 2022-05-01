package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Alunos;
import model.AlunosDAO;

public class SampleController implements Initializable {

    @FXML
    private Button btnEditAluno;

    @FXML
    private Button btnNovoAluno;
    
    @FXML
    private Button btnRemoverAluno;
    
    @FXML
    private Button btnAtualizarAluno;


    @FXML
    private Pane panePrincipal;

    @FXML
    private TableColumn<Alunos, String> tcCpf;

    @FXML
    private TableColumn<Alunos, String> tcCurso;

    @FXML
    private TableColumn<Alunos, String> tcMatricula;

    @FXML
    private TableColumn<Alunos, String> tcNascimento;

    @FXML
    private TableColumn<Alunos, String> tcNome;
    
    @FXML
    private TableColumn<Alunos, String> tcEmail;

    @FXML
    private TableView<Alunos> tvAluno;
    
        
    private List<Alunos> listAlunos;
    
    private final AlunosDAO alunosDAO = new AlunosDAO();
    
    private ObservableList<Alunos> data;
   
   
    public static Stage pStage;
    AudioClip dramatic = new AudioClip(getClass().getResource("/view/dramatic.swf.mp3").toExternalForm());
    AudioClip pare = new AudioClip(getClass().getResource("/view/pare.mp3").toExternalForm());
    AudioClip uepa = new AudioClip(getClass().getResource("/view/uepa-mp3cut.mp3").toExternalForm());
    AudioClip rapaiiz = new AudioClip(getClass().getResource("/view/vinheta-xaropinho-rapaz_dx3f4Be.mp3").toExternalForm());
     public void showAsDialog(String fxml) {
        try {
            Parent parent = (Parent) FXMLLoader.load(this.getClass().getResource("/view/" + fxml + ".fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
			stage.setX(pStage.getX() + 50);
            stage.setY(pStage.getY() + 50);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }
    


	@FXML
    void handleButtonAction(ActionEvent event) {
    	if(event.getSource() == btnNovoAluno) {
    		uepa.play();
    		showAsDialog("cadastroAluno-view");    	
    	
    	}else if(event.getSource() == btnEditAluno) {
    		rapaiiz.play();
    		alterarAlunos(); 	

    	}else if(event.getSource() == btnRemoverAluno) {
    		pare.play();
    		deleteAlunos();
    	
    	
    	}else if(event.getSource() == btnAtualizarAluno) {
    		dramatic.play();
    		listAlunos.clear();
    		carregarTela();
    	}
    	

    }
  	public void alterarAlunos() {  		
  		Alunos alunos = tvAluno.getSelectionModel().getSelectedItem();
  		if (alunos != null) {
  			FXMLLoader loader = new FXMLLoader();
  			loader.setLocation(getClass().getResource("/view/cadastroAluno-view.fxml"));
  			try {
  				loader.load();
  				
  			} catch (Exception e) {
  				e.printStackTrace();
  	            e.getCause();
			}
  			CadastroAlunoController cadastroAlunoController = loader.getController();
  			cadastroAlunoController.setUpdate(true);
  			cadastroAlunoController.setTextField(alunos.getMatricula(), alunos.getNome(),
  					alunos.getCpf(), alunos.getCurso(), alunos.getEmail());
  			
  			Parent parent = loader.getRoot();
  			Stage stage = new Stage();
  			stage.setScene(new Scene(parent));
  			stage.initModality(Modality.WINDOW_MODAL);
  			stage.setAlwaysOnTop(true);
  			stage.toFront();
  			stage.show();
  			
  			
  			
  			
  	}
  	}
  	    
    public void deleteAlunos() {
    	
    	Alunos alunos = tvAluno.getSelectionModel().getSelectedItem();
    	
    	
    	if (alunos != null){
    		tvAluno.getItems().removeAll(tvAluno.getSelectionModel().getSelectedItems());
    		alunosDAO.excluirAlunos(alunos);	  		
    		
    	} 

    }
     	
    public void carregarTela() {
    		
        	tcMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        	tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        	tcNascimento.setCellValueFactory(new PropertyValueFactory<>("nascimento"));
        	tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        	tcCurso.setCellValueFactory(new PropertyValueFactory<>("curso"));
        	tcEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        	
        	listAlunos = alunosDAO.listarAlunos();
        	data = FXCollections.observableArrayList(listAlunos);
        	tvAluno.setItems(data);
    		
    	}
      	
    
    
    public void initialize(URL url, ResourceBundle resoucerBundler) {
    	
    	carregarTela();

    	

    	
    }
    

}
