// SnakeGame.java
import javax.swing.JFrame;

public class SnakeGame {
    public static void main(String[] args) {
        // Create a new JFrame (game window)
        JFrame frame = new JFrame("Snake Game");

        // Add the GamePanel to the frame
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        // Set the size of the window
        frame.setSize(800, 600);

        // Make sure the window closes when we click the close button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make the window not resizable
        frame.setResizable(false);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Make the window visible
        frame.setVisible(true);
    }
}
