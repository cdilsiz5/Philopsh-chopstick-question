package homework;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads=new Thread[5];
		
		Philosoph[] philosophs=new Philosoph [5];
		
		ChopStick [] chopsticks=new ChopStick[philosophs.length];
		
		String [] names={"1", "2", "3", "4","5"};
		
		for(int i=0;i<chopsticks.length;i++) {
			
			chopsticks[i]=new ChopStick(i);
			
		}
	  for (int i = 0; i < philosophs.length; i++) {
		  	ChopStick  left=chopsticks[i];
		  	ChopStick right=chopsticks[(i+1)%chopsticks.length];
		  	Thread th=new Thread(new Philosoph(right, left,names[i]));
		  	threads[i]=th;
		  	th.start();
 		    }
	  for(int i=0;i<threads.length;i++) {
		  threads[i].join();
	  }
	  
		 
	}

}
