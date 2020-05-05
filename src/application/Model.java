package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Model {
	private double xOffset = 0;
    private double yOffset = 0;
	public boolean performLogin( String username , String password )
	{
		if( username.equals("admin") && password.equals("password"))
			return true;
		return false;
	}
	
	public void openNewWindow(String file, Event e) throws IOException
	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(file));
        Parent mainUi = (Parent)fxmlLoader.load();
        Stage main = new Stage();
        Scene scene = new Scene(mainUi);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        main.initStyle(StageStyle.UNDECORATED);
        
        
        mainUi.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        mainUi.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                main.setX(event.getScreenX() - xOffset);
                main.setY(event.getScreenY() - yOffset);
            }
        });
        
        main.setScene(scene);
        main.show();
        ((Node) e.getSource()).getScene().getWindow().hide();
	}
}
