package Main;

public class Product {
	
	private int pId;
	private String pBrand;
	private String pModel;
	private double pPrice;
	private double pPoint;

	public Product() {

	}

	public Product(int pId, String pBrand, String pModel, double pPrice,double pPoint) {
		super();
		this.pId = pId;
		this.pBrand = pBrand;
		this.pModel = pModel;
		this.pPrice = pPrice;
		this.pPoint = pPoint;
		
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpModel() {
		return pModel;
	}

	public void setpModel(String pModel) {
		this.pModel = pModel;
	}
	
	public double getPprice() {
		return pPrice;
	}
	
	public void setPprice(double pPrice) {
		this.pPrice = pPrice;
	}
	
	public double getPpoint() {
		return pPoint;
	}
	
	public void setPpoint(double pPoint) {
		this.pPoint = pPoint;
	}

	public String toString() {
		return " Id=" + pId + ", Brand=" + pBrand + ", Model=" + pModel + ", Price =" + pPrice+", Point="+ pPoint;
	}
}
