package view;
import java.awt.Container;
import controller.ButtonClickListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class HangmanPanel {

    private JTextArea gameKey = new JTextArea();
    private JTextArea playGuess = new JTextArea();
    private JButton[] buttons;
    private JPanel[] buttonRows = new JPanel[4];
    private GameState state = GameState.READY; 

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
        northPanel.add(playGuess);
        

        JPanel southPanel = new JPanel(); 
        cp.add(BorderLayout.SOUTH, southPanel); 
        southPanel.setLayout(new GridLayout(4, 7)); 
        ButtonClickListener listener = new ButtonClickListener();
        JPanel buttonPanel1 = new JPanel();
        JPanel buttonPanel2 = new JPanel();
        JPanel buttonPanel3 = new JPanel();
        JPanel buttonPanel4 = new JPanel();
        char x = 97;
        for(int i = 0; i < 7; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(listener);   
            buttonPanel1.add(buttons[i]);
        }
        southPanel.add(buttonPanel1);
        for(int i = 7; i < 14; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(listener);
            buttonPanel2.add(buttons[i]);
        }
        southPanel.add(buttonPanel2);
        for(int i = 14; i < 21; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(listener);
            buttonPanel3.add(buttons[i]);
        }
        southPanel.add(buttonPanel3);
        for(int i = 21; i < 27; i++) {
            buttons[i] = new JButton();
            buttons[i].addActionListener(listener);
            buttonPanel4.add(buttons[i]);
        }
        for(int i = 0; i < 26; i++) {
            buttons[i].setText(Character.toString(x));
            x++;
        }
        southPanel.add(buttonPanel4);
        buttons[26].setText("New");
        
        HangmanCanvas canvas = new HangmanCanvas(this); 
        cp.add(BorderLayout.CENTER, canvas); 

        canvas.repaint();
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
}
