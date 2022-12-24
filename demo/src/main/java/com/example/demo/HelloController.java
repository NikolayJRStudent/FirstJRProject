package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField window_with_decrypt_message;

    @FXML
    private Label window_with_text_encrypt;

    @FXML
    void Button_decrypt(ActionEvent event) {
        Decrypt_class.decrypt_method(window_with_decrypt_message.getText());
        window_with_text_encrypt.setText(Decrypt_class.decrypt_method(window_with_decrypt_message.getText()).toString());
    }

}
