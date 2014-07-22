package main.java;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class RunGUI  {
	
	static Interface gui;
	static ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	static ArrayList<String> setLabels=new ArrayList<String>();
	
	public static void startGUI(final int size){
		SwingUtilities.invokeLater(new Runnable() {
			
				public void run(){
					gui = new Interface(size);
				}
		});
	}
	
	public static void createLabels(String name){
		
		labelList.add(new JLabel(name,SwingConstants.CENTER));
		labelList.add(new JLabel("cpu...",SwingConstants.CENTER));
		labelList.add(new JLabel("mem...",SwingConstants.CENTER));
		labelList.add(new JLabel("time...",SwingConstants.CENTER));
		
	}
	
	public static void addLabels(){
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    	
		    	for(JLabel label : labelList){
		    		label.setBorder(BorderFactory.createEtchedBorder());
		    		gui.frame.add(label);
		    		
		    	}
		       
		   
		    }
		}); 		
	}
	
	public static void setText(ArrayList<String> test){
		setLabels = test;
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    	
		    	int i=0;
		    	for(JLabel label : labelList){
		    		
		    		label.setText(setLabels.get(i));
		    		i++;
		    		
		    	}
		       
		    	setLabels =null;
		   
		    }
		}); 	
		
	}
	
	
}
