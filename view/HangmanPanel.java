package view;

import java.awt.Container;
import controller.ButtonClickListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

public class HangmanPanel {

    public class myChar{
        public char x; 
        public char y = '*'; 
        boolean flag = false; 

        public myChar(char x) {
            this.x = x; 
        }

        public char getChar() {
            if(flag) {
                return x; 
            } else {
                return y; 
            }
        }
    }

    private boolean winFlag; 
    private String hPanelKey; 
    private myChar[] charArray;
    private String secret = "";
    private JTextArea gameKey = new JTextArea();
    private JTextArea secretKey = new JTextArea();
    private JButton[] buttons;
    private GameState state = GameState.READY; 
    private HangmanCanvas canvas;

    public enum GameState {
        READY, PLAYING, GAMEOVER
    }

    public HangmanPanel(JFrame window) {
        buttons = new JButton[27];
        Container cp = window.getContentPane();
        JPanel northPanel = new JPanel();
        cp.add(BorderLayout.NORTH, northPanel);
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(gameKey);
        northPanel.add(secretKey);

        gameKey.setEditable(false);
        secretKey.setEditable(false);
        gameKey.setVisible(true);

        TitledBorder emptyBorder = BorderFactory.createTitledBorder("");
        gameKey.setBorder(emptyBorder);
        secretKey.setBorder(emptyBorder);

        JPanel southPanel = new JPanel(); 
        cp.add(BorderLayout.SOUTH, southPanel); 
        southPanel.setLayout(new GridLayout(4, 7)); 
        ButtonClickListener listener = new ButtonClickListener(this);
        char x = 97;
        for(int i = 0; i < 27; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(listener);   
            buttons[i].setEnabled(false);
            southPanel.add(buttons[i]);
            buttons[i].setText(Character.toString(x));
            x++;
        }
        buttons[26].setText("New");
        buttons[26].setEnabled(true);
                
        canvas = new HangmanCanvas(this); 
        cp.add(BorderLayout.CENTER, canvas); 

        canvas.repaint();
    }

    public void setKeyTextField(String key) {
        gameKey.setText(key);
        hPanelKey = key;
        Font font = new Font("Arial", Font.BOLD, 18);
        gameKey.setFont(font); 
        gameKey.setForeground(Color.RED);   
        for(int i = 0; i < key.length(); i++) {
            secret += "*";
        }
        charArray = new myChar[key.length()];
        for(int j = 0; j < key.length(); j++) {
            charArray[j] = new myChar(key.charAt(j));
        }
        secretKey.setFont(font); 
        secretKey.setText(secret);
    }

    public void updateSecretKey(int index, char letter) {
        charArray[index].flag = true;
        secret = ""; 
        for(int i = 0; i < gameKey.getText().length(); i++){
            secret += charArray[i].getChar();
        }
        secretKey.setText(secret);
        if(secret.equals(hPanelKey)) {
            this.state = HangmanPanel.GameState.GAMEOVER;
            this.winFlag = true;
            canvas.repaint();
        }
    }
    
    public GameState getGameState() {
        return state;
    }

    public void setGameState(HangmanPanel.GameState state) {
        this.state = state; 
    }

    public JButton getButton(int i) {
        return buttons[i]; 
    }

    public String getButtonText(int i) {
        return buttons[i].getText();
    }

    public JButton[] getButtonArray() {
        return buttons;
    }

    public HangmanCanvas getCanvas() {
        return canvas; 
    }

    public void resetSecret() {
        secret = ""; 
    }

    public String getSecret() {
        return secret; 
    }

    public void setWinLoss(boolean flag) {
        winFlag = flag; 
    }

    public boolean getWinFlag() {
        return winFlag;
    }
}
