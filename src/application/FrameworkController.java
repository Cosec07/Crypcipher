package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FrameworkController implements Initializable {

    private Label label;
	@FXML
    private TextArea input_text;
	@FXML
	private TextArea output;
	@FXML
	private Button Encrypt;
	@FXML
	private Button Decrypt;
	@FXML
	private TextField key_input;
	@FXML
	private AnchorPane asd;
	@FXML
	private ChoiceBox<String> choice;
	@FXML
	private Button clear;
	@FXML
	private MenuBar mb;
	@FXML
	private void clear()
	{
		input_text.setText("");
		output.setText("");
		key_input.setText("");
	}
	@FXML
	private void alert1(ActionEvent event)
	{
		Alert a1=new Alert(Alert.AlertType.WARNING);
				a1.setContentText("Are you sure you want to exit?");
				a1.setHeaderText(null);
				a1.showAndWait();
				Platform.exit();
				System.exit(0);
	}
	@FXML
	private void aboutsec(ActionEvent event)
	{
		Alert a2=new Alert(Alert.AlertType.INFORMATION);
		a2.setHeaderText(null);
		a2.setContentText("About: \n App name=DENCRYPT \n Version=1.0 \n Warning=Requires javafx sdk");
		//a2.showAndWait();
		a2.show();
	}
	@FXML
	private void encrypt(ActionEvent event)
	{
		 Ceasars c = new Ceasars();

	        switch (choice.getValue()) {

	            case "Caeser Cipher":

	                try {
	                  
	                    int y = Integer.parseInt(key_input.getText());
	                    String s = c.encrypt2(input_text.getText(), y);

	                    output.setText("");
	                    input_text.setText("");

	                    output.setText(s);
	                } catch (Exception e) {

	                    
	                    System.out.println("err" + e);
	                }
	                break;
	                
	            case "Playfair Cipher":
	    			
	    			
	                PlayfairCipher x = new PlayfairCipher();

	            			
	            		   x.setKey(key_input.getText());
	            				
	                               x.KeyGen();
	            	String s =x.encryptMessage(input_text.getText());

	            		    
	                                output.setText("");
	                                input_text.setText("");

	                                output.setText(s);

	                       
	                           
	                            break;
	                
			 case "Vigenere Cipher":
	        	 try {
	        		 VigenereCipher v=new VigenereCipher();
	        		 String msga=v.msg(input_text.getText());
	        		 String key1=v.key(key_input.getText());
	        		 String mappedkey=v.map(key1,msga);
	        		 String s1=v.cipherEncryption(mappedkey, msga);
	        		 output.setText("");
	        		 input_text.setText("");	        		 
	                 output.setText(s1);
	        	 }
	        	 catch(Exception e){
	      
	        		 System.out.println("err"+e);
	        	 }
	        	 break;
			case "RailFence Cipher":
				RailFence rf=new RailFence();
				output.setText("");
				int k=Integer.parseInt(key_input.getText());
				String en4=rf.encrypt(input_text.getText(),k);
				output.setText(en4);
				break;
		}
		
	
	}
	@FXML
	private void decrypt(ActionEvent event)
	{
		Ceasars c=new Ceasars();
		PlayfairCipher pf2=new PlayfairCipher();
		RailFence rf2= new RailFence();
		
		switch(choice.getValue())
		{

        case "Caeser Cipher":

            try {
                int y = Integer.parseInt(key_input.getText());
                String s = c.decrypt2(input_text.getText(), y);
                output.setText(s);
            } catch (Exception e) {

               
                System.out.println("err" + e);

            }

            break;
        case "Playfair Cipher":
			 
        	  PlayfairCipher x2 = new PlayfairCipher();

        				
        			   x2.setKey(key_input.getText());
        					
        	                   x2.KeyGen();
        		String s1 =x2.decryptMessage(input_text.getText());

        			                        output.setText("");

        	                 

        	                    output.setText(s1);
        					 
        					                 break;

        	         
			 case "Vigenere Cipher":
				 try {
					 
	        		 VigenereCipher v=new VigenereCipher();
	        		 String msga1=v.msg(input_text.getText());
	        		 String key1=v.key(key_input.getText());
	        		 String mappedkey=v.map(key1,msga1);
	        		 String s2=v.cipherDecryption(mappedkey,msga1);
	        		 output.setText("");
	        		 input_text.setText("");
	                 output.setText(s2);
	        	 }
	        	 catch(Exception e){
	      
	        		 System.out.println("err"+e);
	        	 }
	        	 break;
			case "RailFence Cipher":
				output.setText("");
				int y4=Integer.parseInt(key_input.getText());
				String den4=rf2.decrypt(input_text.getText(), y4);
				output.setText(den4);
				break;
		}
	}    
	@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        choice.getItems().addAll("Caeser Cipher", "Playfair Cipher","Vigenere Cipher","RailFence Cipher");
        choice.setValue("Caeser Cipher");

        choice.getSelectionModel().selectedItemProperty().addListener((v, old, ne)
                -> {
            output.setText("");
            input_text.setText("");
            key_input.setText("");

           
            if (choice.getValue() == "Custom Cipher") {
                
                key_input.setVisible(true);
                output.setVisible(true);
            } else {
               
                key_input.setVisible(true);
                output.setVisible(true);
            }

        });
    }

}
