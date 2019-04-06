package Main;
public class Fridge extends Product implements Comparable<Fridge>{
	
	private String energyClass;
	private String litre;
	
	public Fridge(int pid, String brand, String model, double price,double point, String energyClass, String litre) {
		super(pid, brand, model,price,point);
		this.energyClass = energyClass;
		this.litre = litre;
	}
	
	public Fridge() {}
	
	public String getEnergyClass() {
		return energyClass;
	}
	
	public void setEnergyClass(String energyClass) {
		this.energyClass = energyClass;
	}
	
	public String getLitre() {
		return litre;
	}
	
	public void setLitre(String litre) {
		this.litre = litre;
	}
	
	public int compareTo(Fridge fridge)
	{
		return (int) (fridge.getPpoint()*1000 - this.getPpoint()*1000);
	}
	
	public String toString() {
		return super.toString() + " EnergyClass =" +energyClass + ", Litre =" + litre;
	}
}
