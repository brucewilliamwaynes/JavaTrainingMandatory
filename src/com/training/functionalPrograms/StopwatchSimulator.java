package com.training.functionalPrograms;
import com.training.utility.InputScanner;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StopwatchSimulator {

    private long startTime;
    private long stopTime;

    StopwatchSimulator(){
        final Frame frameForDisplay = new Frame();

        frameForDisplay.setTitle("Stopwatch Simulator");
        frameForDisplay.setSize(500,300);

        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop!");
//        Button exitFrame = new Button("Exit Frame!!");

        final TextField displayTextObj = new TextField();
        displayTextObj.setBounds(75,100, 300,75);

        startButton.setBounds(100,250,150,75);
        stopButton.setBounds(300,250,150,75);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTime = InputScanner.getTimeInMilisec();
                System.out.println(startTime);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTime = InputScanner.getTimeInMilisec();
                System.out.println(stopTime);
                displayTextObj.setText(String.valueOf(stopTime-startTime) + "Milliseconds!");
            }
        });

        frameForDisplay.add(displayTextObj);
        frameForDisplay.add(startButton);
        frameForDisplay.add(stopButton);

        frameForDisplay.setLayout(null);
        frameForDisplay.setVisible(true);

        frameForDisplay.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                frameForDisplay.dispose();
                System.exit(0);
            }
        });
    }

    public static void main(String args[]){
        new StopwatchSimulator();
    }

}
