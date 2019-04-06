package Main;
public class WashingMachine extends Product implements Comparable<WashingMachine>{
	
	private String washingCapacity;
	private String energyClass;
	private int rotationSpeed;
	
	public WashingMachine(int pid, String brand, String model, double price,double point, String washingCapacity, String energyClass, int rotationSpeed) {
		super(pid,brand,model, price , point);
		this.washingCapacity = washingCapacity;
		this.energyClass = energyClass;
		this.rotationSpeed = rotationSpeed;		
	}
	
	public WashingMachine() {}
	
	public String getWashingCapacity() {
		return washingCapacity;
	}
	
	public void setWashingCapacity(String washingCapacity) {
		this.washingCapacity = washingCapacity;
	}
	
	public String getEnergyClass() {
		return energyClass;
	}
	
	public void setEnergyClass(String energyClass) {
		this.energyClass = energyClass;
	}
	
	public int getRotationSpeed() {
		return rotationSpeed;
	}
	
	public void setRotationSpeed(int rotationSpeed) {
		this.rotationSpeed = rotationSpeed;
	}
	
	public int compareTo(WashingMachine washingMachine)
	{
		return (int) (washingMachine.getPpoint()*1000 - this.getPpoint()*1000);
	}
	
	public String toString() {
		return super.toString() + " WashingCapacity =" + washingCapacity + ", EnergyClass =" + energyClass + 
				", RotationSpeed =" + rotationSpeed;
	}	
}
