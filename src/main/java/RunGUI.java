package main.java;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;



public class RunGUI {
	
	static Interface gui;
	static ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	static ArrayList<JavaProcess> newLabels=new ArrayList<JavaProcess>();
	public static HashMap<String, JavaProcess> jpsMap;
	static int labelListValue,newLabelsValue;
	static boolean firstRun = true;
	static String totals, useds, frees;
	static double freeMemP;
	public static void startGUI(){
		SwingUtilities.invokeLater(new Runnable() {
			
				public void run(){
					gui = new Interface();
				}
		});
	}

	public static void setMemText(String total, String used, String free){
		totals=total;
		useds=used;
		frees=free;
		freeMemP = ((Double.parseDouble(frees)/Double.parseDouble(totals))*100);
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		
		    			    	
		    	if(freeMemP<5){
		    		gui.jFreeV.setBackground(Color.red);
		    		gui.jFree.setText(" Less than 5% memory free ");
		    	}
		    	else if (freeMemP<10){
		    		gui.jFreeV.setBackground(Color.ORANGE);
		    		gui.jFree.setText(" Less than 10% memory free ");
		    	}
		    	else if (freeMemP<15){
		    		gui.jFreeV.setBackground(Color.yellow);
		    		gui.jFree.setText(" Less than 15% memory free ");
		    	} else {
		    		gui.jFreeV.setBackground(Color.green);
		    		gui.jFree.setText(" Free ");
		    	}
	
		    	gui.jTotalV.setText(totals);
		    	gui.jUsedV.setText(useds);
		    	gui.jFreeV.setText(frees);
		    }
		});   
	}
	
	
	public static void setText(ArrayList<JavaProcess> newLabel){
		
		newLabels = newLabel;
		labelListValue = labelList.size()/6;
		newLabelsValue = newLabels.size();	
		
		//System.out.println(newLabels.size() + " "+ labelList.size());
		
		if(newLabelsValue < labelListValue){
			
			SwingUtilities.invokeLater(new Runnable(){
			    public void run(){
			  
					for(int i=((labelListValue-newLabels.size())*6); i>0;i--){
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
						labelList.add(new JLabel("",SwingConstants.CENTER));
						labelList.add(new JLabel("",SwingConstants.CENTER));
					}
					
					for(int i=labelListValue; i <labelList.size();i++){
						//labelList.get(i).setBorder(BorderFactory.createEtchedBorder());
						labelList.get(i).setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
						gui.frame.add(labelList.get(i));
						
					}
					
				}
			}); 
		}
		
		SwingUtilities.invokeLater(new Runnable(){
		    public void run(){
		    	
		    	int i=0;int j=1;
		    	for(JavaProcess jps: newLabels){
		    	
		    		if(j==1){
		    			labelList.get(i).setOpaque(false);
		    			labelList.get(i++).setText(jps.getName());
		    			labelList.get(i).setOpaque(false);
			    		labelList.get(i++).setText(jps.getCPU());
			    		labelList.get(i).setOpaque(false);
			    		labelList.get(i++).setText(jps.getMem());
			    		labelList.get(i).setOpaque(false);
			    		labelList.get(i++).setText(jps.getTime());
			    		labelList.get(i).setOpaque(false);
			    		labelList.get(i++).setText(jps.getMaxCpu());
			    		labelList.get(i).setOpaque(false);
			    		labelList.get(i++).setText(jps.getMaxMem());
			    		
			    		j++;
		    		} else { 

			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getName());
			    		
			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getCPU());
			    		
			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getMem());
			    		
			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getTime());
			    		
			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getMaxCpu());
			    		
			    		labelList.get(i).setBackground(Color.LIGHT_GRAY);
			    		labelList.get(i).setOpaque(true);
			    		labelList.get(i++).setText(jps.getMaxMem());
			    				    		
		    			j=1;
		    		}
		    	}
		    	newLabels=null;
		    	gui.frame.pack();
		    	
		   
		    }
		}); 	
		
		if(firstRun){
			firstRun=false;
			gui.frame.setVisible(true);
		}
		
	}
	
	
}
