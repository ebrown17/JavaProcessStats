package main.java;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class RunGUI  {
	
	static Interface gui;
	static ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	static ArrayList<JavaProcess> newLabels=new ArrayList<JavaProcess>();
	public static HashMap<String, JavaProcess> jpsMap;
	static int labelListValue,newLabelsValue;
	
	public static void startGUI(){
		SwingUtilities.invokeLater(new Runnable() {
			
				public void run(){
					gui = new Interface();
				}
		});
	}
	
		
	public static void addLabels(HashMap<String, JavaProcess> jpsMaps){
		
		jpsMap = jpsMaps;
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    		    		    	
		    	for(JavaProcess value: jpsMap.values()){	        		
		    		labelList.add(new JLabel(value.getName(),SwingConstants.CENTER));
		    		labelList.add(new JLabel("updating...",SwingConstants.CENTER));
		    		labelList.add(new JLabel("updating...",SwingConstants.CENTER));
		    		labelList.add(new JLabel("updating...",SwingConstants.CENTER));	        		
	        	}
		    	
		    	for(JLabel label : labelList){
		    		label.setBorder(BorderFactory.createEtchedBorder());
		    		gui.frame.add(label);		    		
		    	}
		    	
		    	gui.frame.pack();
		   
		    }
		}); 		
	}
	
	public static void setText(ArrayList<JavaProcess> newLabel){
		newLabels = newLabel;
		labelListValue = labelList.size()/4;
		newLabelsValue = newLabels.size();	
		System.out.println(newLabels.size() + " "+ labelList.size());
		
		if(newLabelsValue < labelListValue){
			
			SwingUtilities.invokeLater(new Runnable(){
			    public void run(){
			  
					for(int i=0; i<((labelListValue-newLabels.size())*4);i++){
						gui.frame.remove(labelList.get(i));
						labelList.remove(i);
						
					}	
					
				}
			}); 
		}
		
		if(newLabelsValue > labelListValue){
			
			SwingUtilities.invokeLater(new Runnable(){
			    public void run(){
			    	
			
					for(int i=0; i<(newLabelsValue-labelListValue);i++){
						labelList.add(new JLabel("",SwingConstants.CENTER));
						labelList.add(new JLabel("",SwingConstants.CENTER));
						labelList.add(new JLabel("",SwingConstants.CENTER));
						labelList.add(new JLabel("",SwingConstants.CENTER));
					}
					
					for(int i=labelListValue; i <labelList.size();i++){
						labelList.get(i).setBorder(BorderFactory.createEtchedBorder());
						gui.frame.add(labelList.get(i));
						
					}
					
				}
			}); 
		}
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    	
		    	int i=0;
		    	for(JavaProcess jps: newLabels){
		    	
		    		labelList.get(i++).setText(jps.getName());
		    		labelList.get(i++).setText(jps.getCPU());
		    		labelList.get(i++).setText(jps.getMem());
		    		labelList.get(i++).setText(jps.getTime());
		    		
		    		
		    	}
		    	newLabels=null;
		    	gui.frame.pack();
		    	
		   
		    }
		}); 	
		
		
		
	}
	
	
}
