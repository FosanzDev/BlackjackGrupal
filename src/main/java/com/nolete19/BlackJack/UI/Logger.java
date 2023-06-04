package com.nolete19.BlackJack.UI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Logger extends JPanel{

    private JTextArea textArea;

    public Logger(){
        super(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        this.add(textArea, BorderLayout.CENTER);
    }

    public void log(String message){
        String preText = textArea.getText();
        textArea.setText("");
        textArea.append(message + "\n" + preText);
        if (textArea.getText().length() > 300){
            textArea.setText(textArea.getText().substring(0, 300));
        }
    }
}
