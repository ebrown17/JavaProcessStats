package main.java;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Interface {
	
	JFrame frame;
	JLabel jTotalV, jUsedV, jFreeV, jFree,recordLabel; 
	JButton record;
	boolean pressed=false;
		
	Interface(){
		
		
		frame = new JFrame("Running Java Processes");
		frame.setLayout(new GridLayout(0,6,0,0));
		frame.setSize(800,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel empty = new JLabel(" ",SwingConstants.CENTER);
		empty.setBorder(BorderFactory.createRaisedBevelBorder());
		empty.setBackground(Color.DARK_GRAY);
		empty.setOpaque(true);
		
		JLabel empty1 = new JLabel(" ",SwingConstants.CENTER);
		empty1.setBorder(BorderFactory.createRaisedBevelBorder());
		empty1.setBackground(Color.DARK_GRAY);
		empty1.setOpaque(true);
		
		JLabel empty2 = new JLabel(" ",SwingConstants.CENTER);
		empty2.setBorder(BorderFactory.createRaisedBevelBorder());
		
		recordLabel = new JLabel(" ",SwingConstants.CENTER);
		recordLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		record = new JButton("Record");
		record.setBackground(Color.DARK_GRAY);
		record.setForeground(Color.WHITE);
		
		record.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e)
            {
            	//System.out.println("pressed");
        		if(e.getActionCommand().equals("Record") && !pressed){
        			record.setText("Recording");
        			recordLabel.setText("Recording to file");
        			pressed=true;
        		}
        		else {
        			pressed=false;
        			recordLabel.setText("Saved to file");
        			record.setText("Record");
        		}
            }
		});      
	
		JLabel jTotal = new JLabel(" Total ",SwingConstants.CENTER);
		jTotal.setBorder(BorderFactory.createRaisedBevelBorder());
		jTotal.setBackground(Color.DARK_GRAY);
		jTotal.setForeground(Color.WHITE);
		jTotal.setOpaque(true);
		
		JLabel jUsed = new JLabel(" Used ",SwingConstants.CENTER);
		jUsed.setBorder(BorderFactory.createRaisedBevelBorder());
		jUsed.setBackground(Color.DARK_GRAY);
		jUsed.setForeground(Color.WHITE);
		jUsed.setOpaque(true);
		
		jFree = new JLabel(" Free ",SwingConstants.CENTER);
		jFree.setBorder(BorderFactory.createRaisedBevelBorder());
		jFree.setBackground(Color.DARK_GRAY);
		jFree.setForeground(Color.WHITE);
		jFree.setOpaque(true);
		
		jTotalV = new JLabel(" Total ",SwingConstants.CENTER);
		jTotalV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				
		jUsedV = new JLabel(" Used ",SwingConstants.CENTER);
		jUsedV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			
		jFreeV = new JLabel(" Free ",SwingConstants.CENTER);
		jFreeV.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jFreeV.setOpaque(true); 
		
		JLabel jMem = new JLabel(" Memory ",SwingConstants.CENTER);
		jMem.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		
		
		JLabel processName = new JLabel(" Process Name ",SwingConstants.CENTER);
		processName.setBorder(BorderFactory.createRaisedBevelBorder());
		processName.setBackground(Color.DARK_GRAY);
		processName.setForeground(Color.WHITE);
		processName.setOpaque(true);
		
		JLabel cpuAvg = new JLabel(" Current CPU Use ",SwingConstants.CENTER);
		cpuAvg.setBorder(BorderFactory.createRaisedBevelBorder());
		cpuAvg.setBackground(Color.DARK_GRAY);
		cpuAvg.setForeground(Color.WHITE);
		cpuAvg.setOpaque(true);
		
		JLabel cpuMax = new JLabel(" Max CPU Use ",SwingConstants.CENTER);
		cpuMax.setBorder(BorderFactory.createRaisedBevelBorder());
		cpuMax.setBackground(Color.DARK_GRAY);
		cpuMax.setForeground(Color.LIGHT_GRAY);
		cpuMax.setOpaque(true);
		
		JLabel memAvg = new JLabel(" Current Memory Use ",SwingConstants.CENTER);
		memAvg.setBorder(BorderFactory.createRaisedBevelBorder());
		memAvg.setForeground(Color.WHITE);
		memAvg.setBackground(Color.DARK_GRAY);
		memAvg.setOpaque(true);
		
		JLabel memMax = new JLabel(" Max Memory Use ",SwingConstants.CENTER);
		memMax.setBorder(BorderFactory.createRaisedBevelBorder());
		memMax.setForeground(Color.LIGHT_GRAY);
		memMax.setBackground(Color.DARK_GRAY);
		memMax.setOpaque(true);
		
		JLabel time = new JLabel(" Current Time ",SwingConstants.CENTER);
		time.setBorder(BorderFactory.createRaisedBevelBorder());
		time.setForeground(Color.WHITE);
		time.setBackground(Color.DARK_GRAY);
		time.setOpaque(true);
		
		
		frame.add(empty);
		frame.add(jTotal);
		frame.add(jUsed);
		frame.add(jFree);
		frame.add(empty1);
		frame.add(record);
		
		frame.add(jMem);
		frame.add(jTotalV);
		frame.add(jUsedV);
		frame.add(jFreeV);
		frame.add(empty2);
		frame.add(recordLabel);
		
		frame.add(processName);
		frame.add(cpuAvg);
		frame.add(memAvg);
		frame.add(time);
		frame.add(cpuMax);		
		frame.add(memMax);				
		//frame.setVisible(true);
		
		
	}

	

}
