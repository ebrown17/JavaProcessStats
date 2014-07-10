package main.java;

public class JavaProcess {
	
	private String name,pid,cpu,mem;
	
	public JavaProcess(String pid, String name){
		this.name=name;
		this.pid=pid;
	}

	public String getName(){
		return name;		
	}
	
	public String getPID(){
		return pid;
	}
	
	public String getCPU(){
		return cpu;
	}
	
	public void setCPU(String cpu){
		this.cpu=cpu;
	}
	
	public String getMem(){
		return mem;
	}
	
	public void setMem(String mem){
		this.mem=mem;
	}
	
}
