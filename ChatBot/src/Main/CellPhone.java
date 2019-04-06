package Main;
public class CellPhone extends Product implements Comparable<CellPhone> {

	private int cameraSize;
	private String ramSize;
	private double displaySize;

	public CellPhone(int pid, String brand, String model, double price,double point, int cameraSize, String ramSize, double displaySize) {
		super(pid, brand, model,price,point);
		this.cameraSize = cameraSize;
		this.ramSize = ramSize;
		this.displaySize = displaySize;
	}
	
	public CellPhone() {}
	public int getCameraSize() {
		return cameraSize;
	}

	public void setCameraSize(int cameraSize) {
		this.cameraSize = cameraSize;
	}
	
	public double getDisplaySize() {
		return displaySize;
	}
	
	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}
	
	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	public int compareTo(CellPhone cellPhone)
	{
		return (int) (cellPhone.getPpoint()*1000 - this.getPpoint()*1000);
	}
	public String toString() {
		return super.toString() + " CameraSize=" + cameraSize + ", RamSize=" + ramSize;
	}
}
