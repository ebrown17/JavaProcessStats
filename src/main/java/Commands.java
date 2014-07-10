package main.java;

import java.util.ArrayList;
import java.util.List;

public class Commands {
	
	private static final Commands INSTANCE = new Commands();
	
	private List<String> top = new ArrayList<String>();
	private List<String> jps = new ArrayList<String>();
	
	private static ProcessBuilder pTop;
	private static ProcessBuilder pJps;
	
	private Commands(){				
		top.add("/bin/bash");
       	top.add("-c");
		top.add("top -n1 -b | grep java");		
		pTop = new ProcessBuilder(top);
		pTop.redirectErrorStream(true);
		
		jps.add("/bin/bash");
		jps.add("-c");
		jps.add("jps");		
		pJps = new ProcessBuilder(jps);
		pJps.redirectErrorStream(true);
	}
	
	public static Commands getInstance(){
		return INSTANCE;
	}
	
	public  ProcessBuilder getTop(){
		return pTop;
	}
	
	public  ProcessBuilder getJps(){
		return pJps;
	}

}
