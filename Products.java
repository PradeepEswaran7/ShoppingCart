package shoppingCart;

public class Products {
	private static int productIdCounter = 1;
    private int productId;
    private String productName;
	private float productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public Products(String productName,float productPrice) {
		this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productIdCounter++;
	}
}
