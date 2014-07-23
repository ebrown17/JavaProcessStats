package main.java;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class RunGUI  {
	
	static Interface gui;
	static ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	static ArrayList<String> setLabels=new ArrayList<String>();
	
	public static void startGUI(){
		SwingUtilities.invokeLater(new Runnable() {
			
				public void run(){
					gui = new Interface();
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
		    	gui.frame.pack();
		   
		    }
		}); 		
	}
	
	public static void setText(ArrayList<String> test){
		setLabels = test;
		//System.out.println(setLabels.size() + " "+ labelList.size());
		
		if(setLabels.size() < labelList.size()){
			
			SwingUtilities.invokeLater(new Runnable(){
			    public void run(){
			    	int old = labelList.size();
			
					for(int i=0; i<(old-setLabels.size());i++){
						gui.frame.remove(labelList.get(i));
						labelList.remove(i);
						
					}
				}
			}); 
		}
		
		if(setLabels.size() > labelList.size()){
			
			SwingUtilities.invokeLater(new Runnable(){
			    public void run(){
			    	int old = labelList.size();
			
					for(int i=0; i<(setLabels.size()-old);i++){
						labelList.add(new JLabel("",SwingConstants.CENTER));			
					}
					
					for(int i=old; i <labelList.size();i++){
						labelList.get(i).setBorder(BorderFactory.createEtchedBorder());
						gui.frame.add(labelList.get(i));
						
					}
					
				}
			}); 
		}
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    	
		    	int i=0,j=1;
		    	for(JLabel label : labelList){
		    		
		    		/*if(j%4==0){
		    			
		    		}*/
		    		
		    		label.setText(setLabels.get(i));
		    		i++;
		    		
		    	}
		    	gui.frame.pack();
		    	setLabels =null;
		   
		    }
		}); 	
		
	}
	
	
}
