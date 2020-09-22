package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import view.HangmanPanel.GameState;
import java.awt.event.ActionEvent;
import view.HangmanPanel;
import model.Hangman;

public class ButtonClickListener implements ActionListener {
    
    private HangmanPanel panel; 

    public ButtonClickListener(HangmanPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var button = e.getSource();
        for(int i = 0; i < 27; i++) {
            if(button == panel.getButton(i)) {
                if(panel.getButtonText(i) == "New") {
                    Hangman game = new Hangman(); 
                    panel.setGameState(HangmanPanel.GameState.PLAYING);
                    JButton[] buttons = panel.getButtonArray();
                    for(int j = 0; j < buttons.length; j++) buttons[j].setEnabled(true);
                    panel.getCanvas().setHealth(game.getHealth());
                    panel.getCanvas().repaint();
                } else {

                    // Process the guess and continue further into the game. 
                }
            }
        }
    }
}
