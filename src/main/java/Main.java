package main.java;


import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	public static Process process;
	public static Commands command = Commands.getInstance();	
	public static Scanner scanner;
	public static String line;
	public static  StringBuilder formatted;
	public static Calendar calendar;
	public static Timestamp currentTimestamp;
	public static SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
	
	public static void main(String[] args)throws IOException
	{
			process = command.getJps().start();      
	     
	        scanner = new Scanner(process.getInputStream());
	        String line = null;
	        List<JavaProcess> jpsList = new LinkedList<JavaProcess>();
	        
	        while(scanner.hasNext()){
	        	line=scanner.nextLine();
	        	
	        	if(line.contains("Jps")|| line.contains("eclipse"))continue;
	        	String [] jps = line.trim().split("\\s+");
	        	jpsList.add(new JavaProcess(jps[0],jps[1]));	        	
	        	
	        }
	        
	        while(true){
	        
		        process = command.getTop().start();
		        scanner = new Scanner(process.getInputStream());
		        
		        while(scanner.hasNext()){
		        	line=scanner.nextLine();
		        	String [] jps = line.trim().split("\\s+");
		        	//System.out.println(line);
		        	for(JavaProcess objects: jpsList){
		        		
		        		if(jps[0].trim().equals(objects.getPID().trim())){
		        		
		        			objects.setCPU(jps[jps.length-4]);
		        			objects.setMem(jps[jps.length-3]);       			
		        			
		        		}		        	
			        }       	
		        	
		        }
		        calendar = Calendar.getInstance();
		        formatted = new StringBuilder();
		        currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		        String formatedTime = format.format(currentTimestamp);
		        for(JavaProcess objects: jpsList){
		        	
		        	formatted.append(String.format("%s %s%% CPU usage %s%% MEM usage by process %s  \n",formatedTime,objects.getCPU(),objects.getMem(),objects.getName()));
		        			        	
		        }
		        
		        System.out.println(formatted.toString());
		        
		        try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

		
	}
}
