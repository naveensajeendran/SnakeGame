# Snake Game

A simple Snake game implemented in Java using the Swing library for GUI. The game involves moving a snake around the screen, eating food, and avoiding collisions with the walls or itself. This project is still under development as there are some bugs Im still trying to fix

## Table of Contents
1. [Game Description](#game-description)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Prerequisites](#prerequisites)
5. [Installation](#installation)
6. [How to Play](#how-to-play)
7. [Code Overview](#code-overview)

## Game Description
In this Snake game, the player controls a snake that grows longer as it eats food. The game ends if the snake collides with the walls or itself. The player's goal is to get the highest score possible by eating as much food as they can.

## Features
- Simple, classic Snake gameplay.
- Score tracking.
- Game Over message when the player loses.

## Technologies Used
- **Java**: The programming language used to create the game.
- **Swing**: A part of the Java Foundation Classes (JFC) used for building graphical user interfaces.

## Prerequisites
To compile and run the game, you need:
- JDK (Java Development Kit) installed on your system.

## Installation
1. **Clone the repository**:
    ```bash
    git clone https://github.com/your-username/snake-game-java.git
    cd snake-game-java
    ```

2. **Compile the code**:
    ```bash
    javac SnakeGame.java GamePanel.java
    ```

3. **Run the game**:
    ```bash
    java SnakeGame
    ```

## How to Play
- Use the arrow keys to control the direction of the snake.
- Eat the red food to increase your score.
- Avoid colliding with the walls or the snake's body.
- The game ends when the snake collides with a wall or itself.

## Code Overview
- **SnakeGame.java**: The main class that initializes the game window.
- **GamePanel.java**: Contains the game logic, including movement, collision detection, and rendering.
    - The `Timer` class is used to update the game
