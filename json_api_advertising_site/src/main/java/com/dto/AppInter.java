package com.dto;


import javax.swing.*;
import java.awt.*;

public class AppInter extends JFrame{

    public AppInter() {
        super("Administrate Panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Создание панели с двумя кнопками
        JPanel contents = new JPanel();
        contents.add(new JButton("Create new add"));
        contents.add(new JButton("Get specific add"));
        contents.add(new JButton("Get all adds"));
        // Замена панели содержимого
        setContentPane(contents);

        // Определение размера окна
        setSize(500, 500);
        // Открытие окна
        setVisible(true);
    }
}
