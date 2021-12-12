package homework;

public class ChopStick {
	private int id;
	private boolean available=true;
	
	public ChopStick(int id) {
		this.id=id;
	}
	public boolean isChopStickAvailable() {
		  return this.available; 
	}
	public void takeChopStick() {
		 this.available=false;
	}
	@Override
	public String toString() {
		return "ChopStick [id=" + id + ", available=" + available + "]";
	}
	public void dropChopStick() {
		 this.available=true;
	}
	

}
