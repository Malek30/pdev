package frames;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class mailController {

    @FXML
    private JFXTextField to;

    @FXML
    private JFXTextField object;

    @FXML
    private JFXTextArea content;

    @FXML
    private JFXButton sendmail;

	// Event Listener on Button[#sendmail].onAction
	@FXML
	public void SEND(ActionEvent event) {
		
	    	
	    	 String user = "pdevesprit2017@gmail.com";
				String password = "esprit2017";

				String email = to.getText();
				//String email= "sirine.hichri@esprit.tn";

				Properties prop = new Properties();
				prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
				prop.put("mail.smtp.auth", true);
				prop.put("mail.smtp.starttls.enable", true);
				prop.put("mail.smtp.host", "smtp.gmail.com");
				prop.put("mail.smtp.port", "587");
				Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
					@Override
					protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
						return new javax.mail.PasswordAuthentication(user, password);
					}
				});
				try {
					MimeMessage msgg = new MimeMessage(session);
					msgg.setFrom(new InternetAddress("pdevesprit2017@gmail.com"));
					msgg.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(email));
					msgg.setSubject(object.getText());
					msgg.setText(content.getText());
					Transport.send(msgg);

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("Email");
					alert.setContentText("Your email is sent successfully ");
					alert.setHeaderText(null);
					alert.showAndWait();

				} catch (Exception e) {
					System.out.println(e);
				}
		    }
	}

