package homework;

public class Philosoph implements Runnable  {
	private ChopStick left;
	private ChopStick right;
	private String name;
	public boolean philosophEat=false;
	public boolean mutex=true;
	
	public Philosoph(ChopStick left, ChopStick right, String name) {
		super();
		this.left = left;
		this.right = right;
		this.name = name;
	}
	@Override
	public void run(){
		while(!philosophEat) {
			synchronized(this) {
	 			if(ChopSticksAvailable()) {
					System.out.println("Philosoph "+this.name+" eating");
					System.out.println("Philosoph"+this.name+" back to thinking");

					dropChopStick();
					this.philosophEat=true;
			    }
	 			
				else {
					 try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}
		  
			}
		}	
	    
	 }
   	public synchronized void  dropChopStick() {
   		if(mutex) {
   			mutex=false;
   			right.dropChopStick();
   	   		left.dropChopStick();
   	   		mutex=true;
   	   		try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
   		}
   		
   	}
   


	
	public synchronized boolean ChopSticksAvailable() {
			if(mutex) {
				mutex=false;
				if(left.isChopStickAvailable()&&right.isChopStickAvailable()) {
					right.takeChopStick();
					left.takeChopStick();
				}
				mutex=true;
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
				}
			return false;
		}
		
}
