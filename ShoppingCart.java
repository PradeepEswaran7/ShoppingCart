package shoppingCart;

public class ShoppingCart {
	
    private String productName;
	private float productPrice;
	private int productQty;
    private int productId;
	
	
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

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public ShoppingCart(int productId,String productName,int productQty,float productPrice){
		this.productName = productName;
		this.productQty = productQty;
        this.productPrice = productPrice*productQty;
        this.productId = productId;
	}
}
