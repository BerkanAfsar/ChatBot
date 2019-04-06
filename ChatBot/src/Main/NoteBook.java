package Main;
public class NoteBook extends Product implements Comparable<NoteBook> {
	
	private String ramSize;
	private String processor;
	private String displaySize;
	private String graphicCard;
	private String motherBoard;
	private String storageSpace;
	
	public NoteBook(int pid, String brand, String model, double price,double point, String ramSize, String processor, String displaySize, String graphicCard, String motherBoard, String storageSpace) {
		super(pid,brand,model,price,point);
		this.ramSize = ramSize;
		this.processor = processor;
		this.displaySize = displaySize;
		this.graphicCard = graphicCard;
		this.motherBoard = motherBoard;
		this.storageSpace = storageSpace;
		
	}
	
	public NoteBook() {}
	
	public String getRamSize() {
		return ramSize;
	}
	
	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}
	
	public String getProcessor() {
		return processor;
	}
	
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	public String getDisplaySize() {
		return displaySize;
	}
	
	public void setDisplaySize(String displaySize) {
		this.displaySize = displaySize;
	}
	
	public String getGraphicCard() {
		return graphicCard;
	}
	
	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	
	public String getMotherBoard() {
		return motherBoard;
	}
	
	public void setMotherBoard(String motherBoard) {
		this.motherBoard = motherBoard;
	}
	
	public String getStorageSpace() {
		return storageSpace;
	}
	
	public void setStorageSpace(String storageSpace) {
		this.storageSpace = storageSpace;
	}
	
	public int compareTo(NoteBook noteBook)
	{
		return (int) (noteBook.getPpoint()*1000 - this.getPpoint()*1000);
	}
	
	public String toString() {
		return super.toString() + " RamSize =" + ramSize + ", Processor =" + processor + 
				", DisplaySize =" + displaySize + "\nGraphicCard=" + graphicCard + ", MotherBoard=" + motherBoard + 
				", StorageSpace=" + storageSpace;
	}
}
