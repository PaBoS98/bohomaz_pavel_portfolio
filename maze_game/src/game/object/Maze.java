package game.object;

import game.MazeMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static game.MazeMain.SCALE;

public class Maze {

    public static int[][] maze;
    public static int actorPosX;
    public static int actorPosY;
    public static int exitX;
    public static int exitY;
    public static int[] mazeX;
    public static int[] mazeY;

    public static List<Integer> stack = new ArrayList<>();
    public static int countNeighbours = 0;
    public static int currentCellX = 0;
    public static int currentCellY = 0;

    public Maze(int size) {

        mazeX = new int[size];
        mazeY = new int[size];
        for (int i = 1; i < mazeX.length; i++) {
            mazeX[i] = mazeX[i-1] + 28; // cord array
        }
        for (int i = 1; i < mazeY.length; i++) {
            mazeY[i] = mazeY[i-1] + 28;
        }
        int visit = 3;

        maze = new int[size][size];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i % 2 != 0 && j % 2 != 0) {
                    maze[i][j] = 1; // hall
                    countNeighbours++;
                } else maze[i][j] = 0; // wall
            }
        }

        int startX;
        int startY;
        while (true) {
            startX = (int) Math.round(Math.random() * (maze.length - 1));
            startY = (int) Math.round(Math.random() * (maze.length - 1));
            if (maze[startX][startY] == 1) {
                break;
            }
        }
        int move = (int) Math.round(Math.random() * 1);
        if (move == 0) {
            startY = 0;
//            MazeMain.direction = 0;
        } else if (move == 1) {
            startY = maze.length - 1;
//            MazeMain.direction = 2;
        }
        maze[startY][startX] = 2;

        currentCellX = startX;
        currentCellY = 0;
        if (startY == 0) {
            maze[startY + 1][startX] = visit;
            currentCellY = startY + 1;
        } else {
            maze[startY - 1][startX] = visit;
            currentCellY = startY - 1;
        }
        addStack(currentCellY, currentCellX);
        actorPosX = currentCellX;
        actorPosY = currentCellY;

        while (countNeighbours != 0) {

            if ((currentCellY - 1 != 0 && maze[currentCellY - 2][currentCellX] == 1) ||
                    (currentCellX + 1 != maze.length - 1 && maze[currentCellY][currentCellX + 2] == 1) ||
                    (currentCellY + 1 != maze.length - 1 && maze[currentCellY + 2][currentCellX] == 1) ||
                    (currentCellX - 1 != 0 && maze[currentCellY][currentCellX - 2] == 1)) {

                Direction direction = null;
                while (true) {
                    move = ThreadLocalRandom.current().nextInt(1, 5);

                    if (move == 1) {
                        if (currentCellY - 1 != 0) {
                            direction = Direction.UP;
                            break;
                        }
                    } else if (move == 2) {
                        if (currentCellX + 1 != maze.length - 1) {
                            direction = Direction.RIGHT;
                            break;
                        }
                    } else if (move == 3) {
                        if (currentCellY + 1 != maze.length - 1) {
                            direction = Direction.DOWN;
                            break;
                        }
                    } else if (move == 4) {
                        if (currentCellX - 1 != 0) {
                            direction = Direction.LEFT;
                            break;
                        }
                    }
                }
                move = (int) Math.round(Math.random() * 10);
                switch (direction) {
                    case UP:
                        if (move % 2 != 0) {
                            maze[currentCellY - 1][currentCellX] = visit;
                        }
                        if (maze[currentCellY - 2][currentCellX] == 1) {

                            maze[currentCellY - 1][currentCellX] = visit;
                            maze[currentCellY - 2][currentCellX] = visit;
                            currentCellY -= 2;
                            addStack(currentCellY, currentCellX);
                        }

                        break;
                    case RIGHT:
                        if (move % 2 != 0) {
                            maze[currentCellY][currentCellX + 1] = visit;
                        }
                        if (maze[currentCellY][currentCellX + 2] == 1) {

                            maze[currentCellY][currentCellX + 1] = visit;
                            maze[currentCellY][currentCellX + 2] = visit;
                            currentCellX += 2;
                            addStack(currentCellY, currentCellX);
                        }
                        break;
                    case DOWN:
                        if (move % 2 != 0) {
                            maze[currentCellY + 1][currentCellX] = visit;
                        }
                        if (maze[currentCellY + 2][currentCellX] == 1) {

                            maze[currentCellY + 1][currentCellX] = visit;
                            maze[currentCellY + 2][currentCellX] = visit;
                            currentCellY += 2;
                            addStack(currentCellY, currentCellX);
                        }
                        break;
                    case LEFT:
                        if (move % 2 != 0) {
                            maze[currentCellY][currentCellX - 1] = visit;
                        }
                        if (maze[currentCellY][currentCellX - 2] == 1) {

                            maze[currentCellY][currentCellX - 1] = visit;
                            maze[currentCellY][currentCellX - 2] = visit;
                            currentCellX -= 2;
                            addStack(currentCellY, currentCellX);
                        }
                        break;
                }
            } else {
                removeStack();
            }
        }

        while (true) {
            move = ThreadLocalRandom.current().nextInt(1, maze.length - 1);
            if (startY == 0) { // exit
                if (maze[maze.length - 2][move] != 0) {
                    maze[maze.length - 1][move] = -1;
                    exitY = maze.length - 1;
                    exitX = move;
                    break;
                }
            } else { // exit
                if (maze[1][move] != 0) {
                    maze[0][move] = -1;
                    exitY = 0;
                    exitX = move;
                    break;
                }
            }
        }

        maze[actorPosY][actorPosX] = 4; // actor


        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void addStack(int currentCellY, int currentCellX) {
        stack.add(currentCellY);
        stack.add(currentCellX);
        countNeighbours--;
    }

    public static void removeStack() {
        for (int i = 0; i < 2; i++) {
            stack.remove(stack.size() - 1);
        }
        currentCellX = stack.get(stack.size() - 1);
        currentCellY = stack.get(stack.size() - 2);
    }

}

enum Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

