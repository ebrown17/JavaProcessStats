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
	public static JavaProcess jpsProcess;
	public static Scanner scanner;
	public static String line;
	public static StringBuilder formatted;
	public static String [] jps;		
	public static HashMap<String, JavaProcess> jpsMap = new HashMap<String, JavaProcess>();
	public static ArrayList<JavaProcess> test;
	public static String formattedTime;
	public static String pid,name,cpu,mem;
	
	public static void main(String[] args)throws IOException
	{
			process = command.getJps().start();      
	        scanner = new Scanner(process.getInputStream());	     
	        
	        while(scanner.hasNext()){
	        	line=scanner.nextLine();
	        	//System.out.println(line);
	        	if(line.contains("Jps"))continue;
	        	jps = line.trim().split("\\s+");
	        	pid=jps[0];
	        	if(jps[1].contains("eclipse"))name="eclipse";
	        	else name=jps[1];	
	        	for(int i=0;i<jps.length;i++){
	        			
	        		if(jps[i].contains("prefix")){
	        			jps=jps[i].split("=");
	        			name=jps[1];
	        			break;
	        		}
	        			
	        	}
	        	
	        	jpsMap.put(pid, new JavaProcess(pid,name));	        	
	        }
	
        	RunGUI.startGUI();

	        while(true){
	        	
	        	process = command.getFree().start();
	        	scanner = new Scanner(process.getInputStream());
	        	
	        	while(scanner.hasNext()){
		        	line=scanner.nextLine();	        	
		        	if(line.contains("+") || line.contains("Swap")||line.contains("total"))continue;
		        	jps = line.trim().split("\\s+");
		        	
		        	RunGUI.setMemText(jps[1], jps[2], jps[3]);
        	
		        }
	        	
	        	
	        	process = command.getJps().start();      
		        scanner = new Scanner(process.getInputStream());	     
		        
		        while(scanner.hasNext()){
		        	line=scanner.nextLine();	        	
		        	if(line.contains("Jps"))continue;
		        	jps = line.trim().split("\\s+");
		        	
		        		pid=jps[0];
		        		name=jps[1];
		        	 
		        	for(int i=0;i<jps.length;i++){
	        			
	        		if(jps[i].contains("prefix")){
	        			jps=jps[i].split("=");
	        			name=jps[1];
	        			break;
	        		}
	        			
	        	}
		        	
		        	if(!jpsMap.containsKey(pid)){
		        		jpsMap.put(pid, new JavaProcess(pid,name));
		        	}		        	
		        	        	
		        }
	        	
	        	
	        	//long start = System.nanoTime();
	        	test = new ArrayList<JavaProcess>();
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
		        	
		        	jpsProcess = jpsMap.get(jps[0]);
		        	jpsProcess.setCPU(jps[jps.length-4]);
		        	jpsProcess.setMaxCpu(jps[jps.length-4]);
		        	jpsProcess.setMem(jps[jps.length-3]);
		        	jpsProcess.setMaxMem(jps[jps.length-3]);
		        	jpsProcess.setTime(formattedTime);
		        	jpsMap.put(jps[0], jpsProcess);
		        	
		        	
		        	formatted.append(String.format("%s %s%% CPU usage %s%% MEM usage by process %s  \n",formattedTime,jpsProcess.getCPU(),jpsProcess.getMem(),jpsProcess.getName()));
		        	
		        	test.add(jpsProcess);
		        	jpsProcess=null;
		        	
		        }
		        //long end = System.nanoTime();
		       // System.out.println((end-start)/1000000);
		        System.out.println(formatted.toString());
		        RunGUI.setText(test);
	        	
	        	
		        try {
		        	test=null;
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
