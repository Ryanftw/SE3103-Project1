import javax.swing.JFrame;
import view.HangmanPanel;
public class Main {
    public static void main(String[] args) {
      JFrame window = new JFrame();
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setLocation(550, 20);
      var startScreen = new HangmanPanel(window); 
      window.pack();
      window.setVisible(true);
    }
  }
  