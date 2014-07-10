package main.java;


import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Main {
	
	public static Process process;
	public static Commands command = Commands.getInstance();	
	public static Scanner scanner;
	public static String line;
	
	
	public static void main(String[] args)throws IOException
	{
			process = command.getJps().start();      
	     
	        scanner = new Scanner(process.getInputStream());
	        String line = null;
	        List<JavaProcess> jpsList = new LinkedList<JavaProcess>();
	        
	        while(scanner.hasNext()){
	        	line=scanner.nextLine();
	        	if(line.contains("Jps")|| line.contains("eclipse"))continue;
	        	String [] jps = line.split("\\s+");
	        	jpsList.add(new JavaProcess(jps[0],jps[1]));	        	
	        	
	        }
	        
	        while(true){
	        
		        process = command.getTop().start();
		        scanner = new Scanner(process.getInputStream());
		        
		        while(scanner.hasNext()){
		        	line=scanner.nextLine();
		        	String [] jps = line.split("\\s+");
		        	
		        	for(JavaProcess objects: jpsList){
			        	
		        		if(jps[0].equals(objects.getPID())){
		        			
		        			objects.setCPU(jps[jps.length-4]);
		        			objects.setMem(jps[jps.length-3]);       			
		        			
		        		}		        	
			        }       	
		        	
		        }
		        
		        for(JavaProcess objects: jpsList){
		        	
		        	System.out.println(String.format("%s%% CPU usage %s%% MEM usage by process %s ",objects.getCPU(),objects.getMem(),objects.getName()));
		        	
		        }
		        
		        try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }

		
	}
}
