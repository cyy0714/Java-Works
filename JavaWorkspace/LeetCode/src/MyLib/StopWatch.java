package MyLib;

public class StopWatch {
	public long startTime;
	
	public void start() {
		startTime = System.currentTimeMillis();
	}

	public String stop() {
		long duration = System.currentTimeMillis() - startTime;
		return Long.toString(duration);
	}

}
