package game;

import game.object.Actor;
import game.object.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeMain extends JPanel implements ActionListener {

    public static JFrame jFrame;

    public static final int SCALE = 28;
    public static final int WINDOW_WIDTH = 33;
    public static final int WINDOW_HEIGHT = 31;

    public static int width = 3;
    public static int height = 3;
    public static int speed = 8;
    public static int direction = -1;

    public static int different = WINDOW_WIDTH - width;
    public static int differentX = 0;
    public static int differentY = 0;
    public static int changesX = Math.abs(different);
    public static int changesY = Math.abs(different);

    Maze maze = new Maze(width);
    Actor actor = new Actor(Maze.actorPosX, Maze.actorPosY);

    Timer timer = new Timer(1000 / speed, this);

    public MazeMain() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics graphics) {

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WINDOW_WIDTH * SCALE, WINDOW_HEIGHT * SCALE);

//        for (int x = 0; x < width * SCALE; x = x + SCALE) {
//            graphics.setColor(Color.GREEN);
//            graphics.drawLine(x, 0, x, height * SCALE);
//        }
//        for (int y = 0; y < height * SCALE; y = y + SCALE) {
//            graphics.setColor(Color.GREEN);
//            graphics.drawLine(0, y, width * SCALE, y);
//        }
//        for (int i = 0; i < tableY.length; i++) {
//            for (int j = 0; j < tableX.length; j++) {
//                graphics.setColor(Color.GREEN);
//                graphics.fillRect(j, i, SCALE, SCALE);
//            }
//        }

        for (int i = 0; i < Maze.maze.length; i++) {
            for (int j = 0; j < Maze.maze.length; j++) {
                if (Maze.maze[i][j] == 0) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2 - differentX) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2 - differentY) - height * SCALE / 2), SCALE + 1, SCALE + 1);
//                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2) - height * SCALE / 2), SCALE + 1, SCALE + 1);
                } else if (Maze.maze[i][j] == 2) {
                    graphics.setColor(Color.ORANGE);
                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2 - differentX) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2 - differentY) - height * SCALE / 2), SCALE + 1, SCALE + 1);
//                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2) - height * SCALE / 2), SCALE + 1, SCALE + 1);
                } else if (Maze.maze[i][j] == -1) {
                    graphics.setColor(Color.GREEN);
                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2 - differentX) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2 - differentY) - height * SCALE / 2), SCALE + 1, SCALE + 1);
//                    graphics.fillRect(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2) - width * SCALE / 2), Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2) - height * SCALE / 2), SCALE + 1, SCALE + 1);
                } else if (Maze.maze[i][j] == 4) {
                    graphics.setColor(Color.CYAN);
                    graphics.fillOval(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2 - differentX) - width * SCALE / 2) + 2, Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2 - differentY) - height * SCALE / 2) + 2, SCALE - 5, SCALE - 5);
//                    graphics.fillOval(Maze.mazeX[j] + ((WINDOW_WIDTH * SCALE / 2) - width * SCALE / 2) + 2, Maze.mazeY[i] + ((WINDOW_HEIGHT * SCALE / 2) - height * SCALE / 2) + 2, SCALE - 5, SCALE - 5);
                }
            }
        }
    }

    public static void main(String[] args) {
        showScreen();
    }

    public static void showScreen() {
        jFrame = new JFrame("Maze Game");
        jFrame.setSize(WINDOW_WIDTH * SCALE + 7, WINDOW_HEIGHT * SCALE + 30);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new MazeMain());
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move(direction);
        dynamics();
        if (Maze.maze[actor.actorY][actor.actorX] == Maze.maze[Maze.exitY][Maze.exitX]) {
            timer.stop();
            JOptionPane.showMessageDialog(null, "YOU Win. Try again?");
            jFrame.setVisible(false);
            differentX = 0;
            differentY = 0;
            width = width + 10;
            height = height + 10;
            different = WINDOW_WIDTH - width;
            direction = -1;
            Maze maze = new Maze(width);
            actor.actorX = Maze.actorPosX;
            actor.actorY = Maze.actorPosY;
            jFrame.setVisible(true);
            timer.start();
        }
        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_UP) {
//                Maze.maze[actor.actorY - 1][actor.actorX] = 4;
//                Maze.maze[actor.actorY][actor.actorX] = 3;
//                actor.actorY--;
                direction = 0;
            } else if (key == KeyEvent.VK_RIGHT) {
//                Maze.maze[actor.actorY][actor.actorX + 1] = 4;
//                Maze.maze[actor.actorY][actor.actorX] = 3;
//                actor.actorX++;
                direction = 1;
            } else if (key == KeyEvent.VK_DOWN) {
//                Maze.maze[actor.actorY + 1][actor.actorX] = 4;
//                Maze.maze[actor.actorY][actor.actorX] = 3;
//                actor.actorY++;
                direction = 2;
            } else if (key == KeyEvent.VK_LEFT) {
//                Maze.maze[actor.actorY][actor.actorX - 1] = 4;
//                Maze.maze[actor.actorY][actor.actorX] = 3;
//                actor.actorX--;
                direction = 3;
            } else if (key == KeyEvent.VK_SPACE) {
                direction = -1;
            }
        }

    }

    public void move(int direction) {
        if (Maze.maze[actor.actorY - 1][actor.actorX] != 0 && Maze.maze[actor.actorY - 1][actor.actorX] != 2 && direction == 0) {
            Maze.maze[actor.actorY - 1][actor.actorX] = 4;
            Maze.maze[actor.actorY][actor.actorX] = 3;

            actor.actorY--;
        } else if (Maze.maze[actor.actorY][actor.actorX + 1] != 0 && Maze.maze[actor.actorY][actor.actorX + 1] != 2 && direction == 1) {
            Maze.maze[actor.actorY][actor.actorX + 1] = 4;
            Maze.maze[actor.actorY][actor.actorX] = 3;
            actor.actorX++;
        } else if (Maze.maze[actor.actorY + 1][actor.actorX] != 0 && Maze.maze[actor.actorY + 1][actor.actorX] != 2 && direction == 2) {
            Maze.maze[actor.actorY + 1][actor.actorX] = 4;
            Maze.maze[actor.actorY][actor.actorX] = 3;
            actor.actorY++;
        } else if (Maze.maze[actor.actorY][actor.actorX - 1] != 0 && Maze.maze[actor.actorY][actor.actorX - 1] != 2 && direction == 3) {
            Maze.maze[actor.actorY][actor.actorX - 1] = 4;
            Maze.maze[actor.actorY][actor.actorX] = 3;
            actor.actorX--;
        }
    }

    public void dynamics() {

        if (different < 0) {
            if (actor.actorY >= Maze.maze.length - (-different) && actor.actorY >= Maze.maze.length - changesY && changesY != 5 && (direction == 2 || direction == -1)) {
                differentY += 5 * SCALE;
                changesY -= 5;
            } else if (actor.actorY >= Maze.maze.length - (-different) && actor.actorY < Maze.maze.length - changesY && changesY != (-different) && direction == 0) {
                differentY -= 5 * SCALE;
                changesY += 5;
            } else if (actor.actorY < Maze.maze.length - (-different) && actor.actorY > (-different)) differentY = 0;
            if (actor.actorY <= (-different) && actor.actorY <= changesY && changesY != 5 && (direction == 0 || direction == -1)) {
                differentY -= 5 * SCALE;
                changesY -= 5;
            } else if (actor.actorY <= (-different) && actor.actorY > changesY && changesY != (-different) && direction == 2) {
                differentY += 5 * SCALE;
                changesY += 5;
            }
            if (actor.actorX >= Maze.maze.length - (-different) && actor.actorX >= Maze.maze.length - changesX && changesX != 5 && (direction == 1 || direction == -1)) {
                differentX += 5 * SCALE;
                changesX -= 5;
            } else if (actor.actorX >= Maze.maze.length - (-different) && actor.actorX < Maze.maze.length - changesX && changesX != (-different) && direction == 3) {
                differentX -= 5 * SCALE;
                changesX += 5;
            }
            if (actor.actorX <= (-different) && actor.actorX <= changesX && changesX != 5 && (direction == 3 || direction == -1)) {
                differentX -= 5 * SCALE;
                changesX -= 5;
            } else if (actor.actorX <= (-different) && actor.actorX > changesX && changesX != (-different) && direction == 1) {
                differentX += 5 * SCALE;
                changesX += 5;
            }
        }
    }
}
