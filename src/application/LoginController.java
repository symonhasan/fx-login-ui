package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class LoginController{
	@FXML
	private ImageView closeBtn;
	@FXML
	private Button signInBtn;
	@FXML
	private TextField userTextF;
	@FXML
	private PasswordField passTextF;
	@FXML
	private Label warnLabel;
	@FXML
	private Label warnLabelClose;
	
	@FXML
	private void closeBtnMouseEntered(MouseEvent e)
	{
		closeBtn.setCursor(Cursor.HAND);
	}
	@FXML
	private void closeBtnMouseClicked(MouseEvent e)
	{
		System.exit(0);
	}
	@FXML
	private void signInBtnAction(ActionEvent e ) throws IOException
	{
		/*** Create a model object ***/
		Model ob = new Model();
		
		String username = userTextF.getText();
		String password = passTextF.getText();
		
		if( ob.performLogin(username, password) )
		{
			warnLabel.setVisible(true);
			warnLabelClose.setVisible(true);
			warnLabel.setStyle("-fx-text-fill: white;-fx-background-color: #42A5F5;-fx-padding: 10 10 10 10;");
			warnLabel.setText("Login successful");
			
			/** If you want to open a new window after successful login
			 *  uncomment below line
			 * 	as parameter you have to pass fxml filename which you want to load
			 */
			 /**** ob.openNewWindow("filename.fxml" , e); ***/
		}else {
			warnLabel.setVisible(true);
			warnLabelClose.setVisible(true);
			warnLabel.setStyle("-fx-text-fill: white;-fx-background-color: #FF6978;-fx-padding: 10 10 10 10;");
			warnLabel.setText("Invalid username or password");
		}
	}
	@FXML
	private void warnLabelCloseMouseEntered(MouseEvent e)
	{
		warnLabelClose.setCursor(Cursor.HAND);
	}
	@FXML
	private void warnLabelCloseMouseClicked(MouseEvent e)
	{
		warnLabelClose.setVisible(false);
		warnLabel.setVisible(false);
	}
	@FXML
	private void textFieldMouseClicked(MouseEvent e)
	{
		if( warnLabel.isVisible() )
		{
			warnLabel.setVisible(false);
			warnLabelClose.setVisible( false );
		}
	}
	
}
