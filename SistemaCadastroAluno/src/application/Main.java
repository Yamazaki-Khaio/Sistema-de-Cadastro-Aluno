package application;
	
import controllers.SampleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
    double x, y = 0;


    @Override
    public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/Sample.fxml"));
        Scene sc = new Scene(root);
        SampleController.pStage = stage;
        stage.setTitle("Sistema de Cadastro");
        Image icon = new Image(getClass().getResourceAsStream("/view/imagem/cadastro.png"));
        stage.getIcons().add(icon);
        stage.initStyle(StageStyle.DECORATED);
        String css = this.getClass().getResource("/view/css/application.css").toExternalForm();
        sc.getStylesheets().add(css);
        
        
        
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });
                
        stage.setScene(sc);
        for(Screen sn : Screen.getScreens()) {
        	Rectangle2D bounds = sn.getBounds();
        	double x = bounds.getMinX() + (bounds.getWidth() - sc.getWidth()) * 0.2;
        	double y = bounds.getMinY() + (bounds.getHeight() - sc.getHeight()) * 0.2;
        	stage.setX(x);
        	stage.setY(y);
        }
        stage.show();



        }



    public static void main(String[] args) {
        launch();
    }
}