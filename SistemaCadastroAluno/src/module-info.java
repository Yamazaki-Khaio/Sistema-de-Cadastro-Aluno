module SistemaCadastroAluno {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.web;
	requires javafx.base;
	requires javafx.media;
	requires java.desktop;
    
	opens controllers to javafx.graphics, javafx.fxml, javafx.base;
	opens model to javafx.graphics, javafx.fxml, javafx.base;
	

	
	  
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	

}
