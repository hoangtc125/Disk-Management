package hust.soict.globalict.aims;

public class MemoryDaemon implements java.lang.Runnable {
	
	private long memoryUsed = 0;
	public MemoryDaemon() {
		super();
	}
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
			used = rt.totalMemory() - rt.freeMemory();
			if(used != memoryUsed) {
				System.out.println("\tmemory used = " + used);
				memoryUsed = used;
			}
			
	}
}
