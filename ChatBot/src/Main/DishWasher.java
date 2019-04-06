package Main;
public class DishWasher extends Product implements Comparable<DishWasher>{
	private String energyClass;
	private int programNumber;
	
	public DishWasher(int pid, String brand, String model, double price,double point, String energyClass, int programNumber) {
		super(pid,brand,model,price,point);
		this.energyClass = energyClass;
		this.programNumber = programNumber;
	}
	
	public DishWasher() {}
	
	public String getEnergyClass() {
		return energyClass;
	}
	
	public void setEnergyClass(String energyClass) {
		this.energyClass = energyClass;
	}
	
	public int getProgramNumber() {
		return programNumber;
	}
	
	public void setProgramNumber(int programNumber) {
		this.programNumber = programNumber;
	}
	public int compareTo(DishWasher dishWasher)
	{
		return (int) (dishWasher.getPpoint()*1000 - this.getPpoint()*1000);
	}
	
	public String toString() {
		return super.toString() + " EnergyClass =" + energyClass + ", ProgramNumber =" + programNumber;
	}
}
