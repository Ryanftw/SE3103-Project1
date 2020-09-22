package controller;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import view.HangmanPanel.GameState;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import view.HangmanPanel;

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
                if(panel.getButtonText(i) == "new") {
                    // Start a new game here
                } else {
                    // Process the guess and continue further into the game. 
                }
            }
        }
    }
}
