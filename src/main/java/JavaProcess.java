package main.java;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JavaProcess {
	
	private String name,pid,cpu,mem, time, maxCpu="0", maxMem="0";
	
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
	
	public String getTime(){
		return time;
	}
	
	public void setTime(String time){
		this.time=time;
	}
	
	public void setMaxCpu(String mcpu){
		if(Double.parseDouble(maxCpu)<Double.parseDouble(mcpu)){
			this.maxCpu=mcpu;
		}
	}

	public String getMaxCpu(){
		return maxCpu;
	}
	
	public void setMaxMem(String mmex){
		if(Double.parseDouble(maxMem)<Double.parseDouble(mmex)){
			this.maxMem=mmex;
		}
	}

	public String getMaxMem(){
		return maxMem;
	}


	
}
