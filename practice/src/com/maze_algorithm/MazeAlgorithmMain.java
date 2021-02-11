package com.maze_algorithm;

import com.maze_algorithm.service.GenerateMaze;
import com.maze_algorithm.service.SizeSelection;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;


public class MazeAlgorithmMain {

    public static void main(String[] args){
        String appDirectory = FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString() + "\\practice\\src\\com\\maze_algorithm\\";

        SizeSelection mazeSize = new SizeSelection();

        try (FileWriter listOfMazeCreated = new FileWriter(appDirectory + "\\listOfMazeCreated.txt",true)){
            listOfMazeCreated.write(String.valueOf(new GenerateMaze(mazeSize.getHeight(), mazeSize.getLength())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
