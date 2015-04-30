package lib.common;

public class StopWatch {
	private long begin;
	public StopWatch(){ begin = -1; }
	public void start(){ 
		begin = System.currentTimeMillis();
	}
	public long puase(){
		if(begin == -1) return 0;
		return System.currentTimeMillis() - begin;
	}
	public long stop(){
		if(begin == -1) return 0;
		long duration = System.currentTimeMillis() - begin;
		begin = -1;
		return duration;
	}
}
