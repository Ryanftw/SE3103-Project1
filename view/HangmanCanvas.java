package view;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class HangmanCanvas extends JPanel {

    private HangmanPanel panel;
    private HangmanPanel.GameState state;
    
    public HangmanCanvas(HangmanPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.WHITE);
    }
    
    @Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if(panel.getGameState() == HangmanPanel.GameState.READY){
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 36));
            g2.drawString("Press <new> to Start", 80, 300);
        }

    }
}
