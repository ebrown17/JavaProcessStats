package main.java;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Interface {
	
	
	Interface(int size){
		
		JFrame frame = new JFrame("Running Java Processes");
		frame.setLayout(new GridLayout(size,4,4,4));
		frame.setSize(800,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel processName = new JLabel(" Process Name ",SwingConstants.CENTER);
		processName.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel cpuAvg = new JLabel(" Average CPU Use ",SwingConstants.CENTER);
		cpuAvg.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel memAvg = new JLabel(" Average Memory Use ",SwingConstants.CENTER);
		memAvg.setBorder(BorderFactory.createEtchedBorder());
		
		JLabel time = new JLabel(" Current Time ",SwingConstants.CENTER);
		time.setBorder(BorderFactory.createEtchedBorder());
		
		frame.add(processName);
		frame.add(cpuAvg);
		frame.add(memAvg);
		frame.add(time);
		
		
		frame.setVisible(true);
		
		
	}

}