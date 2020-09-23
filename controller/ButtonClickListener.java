package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import view.HangmanPanel;
import model.Hangman;

public class ButtonClickListener implements ActionListener {
    
    boolean healthFlag = false; 
    private HangmanPanel panel;
    private String key;
    String guess = ""; 

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
                    panel.resetSecret();
                    key = game.getKey();
                    panel.setKeyTextField(game.getKey());
                    panel.getCanvas().repaint();
                } else {
                    healthFlag = false;
                    guess = panel.getButton(i).getText();
                    for(int j = 0; j < key.length(); j++) {
                        if(guess.charAt(0) == key.charAt(j)) {
                            panel.updateSecretKey(j, guess.charAt(0));
                            healthFlag = true; 
                        }
                    }
                    if(panel.getSecret().equals(key)) {
                        JButton[] buttons = panel.getButtonArray();
                        for(int k = 0; k < buttons.length-1; k++) buttons[k].setEnabled(false);
                    }
                    if(!healthFlag) {
                        panel.getCanvas().subtractHealth();
                        if(panel.getCanvas().getHealth() == 0) {
                            panel.setWinLoss(false);
                            JButton[] buttons = panel.getButtonArray();
                            for(int k = 0; k < buttons.length-1; k++) buttons[k].setEnabled(false);
                            panel.setGameState(HangmanPanel.GameState.GAMEOVER);
                        }
                        panel.getCanvas().repaint();
                        panel.getButton(i).setEnabled(false);
                    } else {
                        panel.getButton(i).setEnabled(false);
                    }
                }
            }
        }
    }
}
