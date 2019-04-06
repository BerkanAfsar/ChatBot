package Main;
public class Camera extends Product implements Comparable<Camera>{
	
	private String zoom;
	private String diaphragm;
	private String megaPixel;
	
	public Camera(int pid, String brand, String model, double price, double point, String zoom, String diaphragm, String megaPixel) {
		super(pid,brand,model,price,point);
		this.zoom = zoom;
		this.diaphragm = diaphragm;
		this.megaPixel = megaPixel;
	}
	
	public Camera() {}
	
	public String getZoom() {
		return zoom;
	}
	
	public void setZoom(String zoom) {
		this.zoom = zoom;
	}
	
	public String getDiaphragm() {
		return diaphragm;
	}
	
	public void setDiaphragm(String diaphragm) {
		this.diaphragm = diaphragm;
	}
	
	public String getMegaPixel() {
		return megaPixel;
	}
	
	public void setMegaPixel(String megaPixel) {
		this.megaPixel = megaPixel;
	}
	
	public int compareTo(Camera camera)
	{
		return (int) (camera.getPpoint()*1000 - this.getPpoint()*1000);
	}
	
	public String toString() {
		return super.toString() + " Zoom =" +zoom + ", Diaphragm =" + diaphragm + ", MegaPixel =" + megaPixel;
	}
}
