package com.maze_algorithm.service;

import com.maze_algorithm.dto.enums.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateMaze {

    private String[][] maze;
    private List<Integer> stack = new ArrayList<>();
    private int countNeighbours = 0;
    private int currentCellX = 0;
    private int currentCellY = 0;

    public GenerateMaze(int length, int height) {
        generateMaze(length, height);
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
                res += maze[i][j] + " ";
            }
            System.out.println();
            res += "\n";
        }
        System.out.println(maze.length +"v" + maze[0].length + " Maze created");
        res += maze.length +"v" + maze[0].length + " Maze created\n" +
                "--------------------------------------------------\n";
        return res;
    }

    private void generateMaze(int length, int height) {
        this.maze = new String[length][height];

        String visit = "*"; // passage point
        String start = "▒"; // start pont
        String exit = "@"; // finish point
        int move;

        for (int i = 0; i < maze.length; i++) {         // lattice create    #############
            for (int j = 0; j < maze[i].length; j++) {                   //  # # # # # # #
                if (i % 2 != 0 && j % 2 != 0) {                          //  #############
                    maze[i][j] = " ";                                    //  # # # # # # #
                    countNeighbours++;                                   //  #############
                } else maze[i][j] = "█";                                 //  # # # # # # #
            }                                                            //  #############
        }

        int startX;
        int startY;
        while (true) { // choice of enter to the maze
            startX = (int) Math.round(Math.random() * (maze[0].length - 1));
            startY = (int) Math.round(Math.random() * (maze.length - 1));
            if (maze[startY][startX].equals(" ")) {
                break;
            }
        }
        startY = maze.length - 1;
        maze[startY][startX] = start;

        currentCellX = startX;
        currentCellY = startY - 1;
        maze[currentCellY][currentCellX] = visit; // creation of the first point of visit
        addStack(currentCellY, currentCellX);

        while (countNeighbours != 0) { // punching walls and creating passages
            if ((currentCellY - 1 != 0 && maze[currentCellY - 2][currentCellX].equals(" ")) ||
                    (currentCellX + 1 != maze[0].length - 1 && maze[currentCellY][currentCellX + 2].equals(" ")) ||
                    (currentCellY + 1 != maze.length - 1 && maze[currentCellY + 2][currentCellX].equals(" ")) ||
                    (currentCellX - 1 != 0 && maze[currentCellY][currentCellX - 2].equals(" "))) {

                Direction direction;
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
                        if (maze[currentCellY - 2][currentCellX].equals(" ")) {

                            maze[currentCellY - 1][currentCellX] = visit;
                            maze[currentCellY - 2][currentCellX] = visit;
                            currentCellY -= 2;
                            addStack(currentCellY, currentCellX);
                        }

                        break;
                    case RIGHT:
                        if (currentCellX + 1 != maze[0].length - 1 && move % 2 != 0) {
                            maze[currentCellY][currentCellX + 1] = visit;
                        }
                        if (currentCellX + 1 != maze[0].length - 1 && maze[currentCellY][currentCellX + 2].equals(" ")) {

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
                        if (maze[currentCellY + 2][currentCellX].equals(" ")) {

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
                        if (maze[currentCellY][currentCellX - 2].equals(" ")) {

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

        while (true) { // choice of exit from the maze
            move = ThreadLocalRandom.current().nextInt(1, maze[0].length - 1);
            if (!maze[1][move].equals("█")) {
                maze[0][move] = exit;
                break;
            }
        }
    }



    private void addStack(int currentCellY, int currentCellX) {
        stack.add(currentCellY);
        stack.add(currentCellX);
        countNeighbours--;
    }

    private void removeStack() {
        for (int i = 0; i < 2; i++) {
            stack.remove(stack.size() - 1);
        }
        currentCellX = stack.get(stack.size() - 1);
        currentCellY = stack.get(stack.size() - 2);
    }

}
