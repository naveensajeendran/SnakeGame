// GamePanel.java
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    // Constants for the game
    private static final int TILE_SIZE = 25;
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    // Game variables
    private final ArrayList<Point> snake = new ArrayList<>();
    private Point food;
    private char direction = 'R'; // U = Up, D = Down, L = Left, R = Right
    private boolean running = false;
    private Timer timer;
    private int score = 0;

    public GamePanel() {
        // Set panel properties
        setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        // Start the game
        startGame();
    }

    // Start the game by initializing variables and starting the timer
    public void startGame() {
        snake.clear();
        // Initialize the snake with three segments in the middle of the screen
        int startX = GAME_WIDTH / 2;
        int startY = GAME_HEIGHT / 2;
        snake.add(new Point(startX, startY));
        snake.add(new Point(startX - TILE_SIZE, startY));
        snake.add(new Point(startX - 2 * TILE_SIZE, startY));

        generateFood();
        direction = 'R';
        score = 0;
        running = true;

        // Set the game speed (delay in milliseconds)
        timer = new Timer(100, this);
        timer.start();
    }

    // Generate a new food position
    private void generateFood() {
        Random random = new Random();
        int x = random.nextInt(GAME_WIDTH / TILE_SIZE) * TILE_SIZE;
        int y = random.nextInt(GAME_HEIGHT / TILE_SIZE) * TILE_SIZE;
        food = new Point(x, y);
    }

    // Game update (called by the Timer)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkCollision();
            checkFood();
        }
        repaint(); // Repaint the screen
    }

    // Move the snake based on the current direction
    private void move() {
        // Get the head position
        Point head = new Point(snake.get(0));

        // Update the head position based on the direction
        switch (direction) {
            case 'U' -> head.y -= TILE_SIZE;
            case 'D' -> head.y += TILE_SIZE;
            case 'L' -> head.x -= TILE_SIZE;
            case 'R' -> head.x += TILE_SIZE;
        }

        // Add new head position to the front of the snake
        snake.add(0, head);
        // Remove the last segment of the snake (unless we just ate food)
        snake.remove(snake.size() - 1);
    }

    // Check if the snake has collided with the walls or itself
    private void checkCollision() {
        // Get the head position
        Point head = snake.get(0);

        // Check if the head collides with the walls
        if (head.x < 0 || head.x >= GAME_WIDTH || head.y < 0 || head.y >= GAME_HEIGHT) {
            running = false;
            timer.stop();
        }

        // Check if the head collides with any part of the snake's body
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
                timer.stop();
                break;
            }
        }
    }

    // Check if the snake has eaten the food
    private void checkFood() {
        // Get the head position
        Point head = snake.get(0);

        // Check if the head is at the same position as the food
        if (head.equals(food)) {
            // Increase the score
            score += 10;
            // Add a new segment to the snake
            snake.add(new Point(food));
            // Generate a new food position
            generateFood();
        }
    }

    // Draw the game components
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the food
        g.setColor(Color.RED);
        g.fillRect(food.x, food.y, TILE_SIZE, TILE_SIZE);

        // Draw the snake
        g.setColor(Color.GREEN);
        for (Point p : snake) {
            g.fillRect(p.x, p.y, TILE_SIZE, TILE_SIZE);
        }

        // Draw the score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString("Score: " + score, 10, 20);

        // If the game is over, display a game over message
        if (!running) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over", GAME_WIDTH / 2 - 100, GAME_HEIGHT / 2);
        }
    }

    // Handle keyboard input
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (direction != 'D') direction = 'U';
            }
            case KeyEvent.VK_DOWN -> {
                if (direction != 'U') direction = 'D';
            }
            case KeyEvent.VK_LEFT -> {
                if (direction != 'R') direction = 'L';
            }
            case KeyEvent.VK_RIGHT -> {
                if (direction != 'L') direction = 'R';
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }
}
