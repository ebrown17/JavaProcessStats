package main.java;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.SwingUtilities;


public class JavaProcessUsage {
	
	public static final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public static Process process;
	public static Commands command = Commands.getInstance();
	
	public static Scanner scanner;
	public static String line;
	public static StringBuilder formatted;
	public static String [] jps;		
	public static HashMap<String, String> jpsMap = new HashMap<String, String>();
	public static ArrayList<String> test;
	public static String formattedTime;
	public static String pid,name,cpu,mem;
	
	public static void main(String[] args)throws IOException
	{
			process = command.getJps().start();      
	        scanner = new Scanner(process.getInputStream());	     
	        
	        while(scanner.hasNext()){
	        	line=scanner.nextLine();	        	
	        	if(line.contains("Jps")|| line.contains("eclipse"))continue;
	        	jps = line.trim().split("\\s+");
	        	pid=jps[0];
	        	name=jps[1];
	        	;
	        	jpsMap.put(pid, name);	        	
	        }
	        
	    /*  SwingUtilities.invokeLater(new Runnable() {
				
				public void run(){
					new Interface(jpsMap.size());
				}
				
			});*/
        	
        	RunGUI.startGUI(jpsMap.size());
	        
        	for(String value: jpsMap.values()){
        		System.out.println(value);
        		RunGUI.createLabels(value);
        	}
        	RunGUI.addLabels();
        	
	        while(true){
	        	//long start = System.nanoTime();
	        	test = new ArrayList<String>();
		        process = command.getTop().start();
		        scanner = new Scanner(process.getInputStream());
		        
		        formattedTime = formatTime.format(new Date());
		        formatted = new StringBuilder();		        
		        
		        while(scanner.hasNext()){
		        	line=scanner.nextLine();
		        	jps = line.trim().split("\\s+");
		        	if(jpsMap.get(jps[0])==null){
		        		line=null;
		        		jps=null; 
		        		continue;
		        	}
		        	pid = jps[0];
		        	cpu = jps[jps.length-4];
		        	mem = jps[jps.length-3];	
		        	name = jpsMap.get(pid);
		        	formatted.append(String.format("%s %s%% CPU usage %s%% MEM usage by process %s  \n",formattedTime,cpu,mem,name));
		        	test.add(name);
		        	test.add(cpu);
		        	test.add(mem);
		        	test.add(formattedTime);
		        	
		        }
		        //long end = System.nanoTime();
		       // System.out.println((end-start)/1000000);
		        System.out.println(formatted.toString());
		        RunGUI.setText(test);
	        	
	        	
		        try {
		        	
		        	line=null;
					formattedTime = null;
		        	formatted =null;
		        	scanner = null;
		        	process=null;
		        	pid=null;
		        	name=null;
		        	cpu=null;
		        	mem=null;
		        	System.gc();
					Thread.sleep(2000);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

		
	}
}
