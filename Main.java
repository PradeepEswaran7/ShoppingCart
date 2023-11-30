package shoppingCart;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Products> products = new ArrayList<>();
	static ArrayList<ShoppingCart> shoppingCart = new ArrayList<>();
	static ArrayList<String> write = new ArrayList<String>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			Products product1 = new Products("Apple", 50.0f);
			products.add(product1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Products product2 = new Products("Orange", 100.0f);
			products.add(product2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Products product3 = new Products("Mango", 150.0f);
			products.add(product3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Products product4 = new Products("Banana", 200.0f);
			products.add(product4);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			for (;;) {
				System.out.println("\t\t\tWelcome To Pradeep Shopping Market");
				System.out.println("\n\t1.List of Products");
				System.out.println("\t2.Add Product to cart");
				System.out.println("\t3.Update Product in cart");
				System.out.println("\t4.Remove Product in cart");
				System.out.println("\t5.Your Cart");
				System.out.println("\t6.Exit");
				System.out.print("\n Enter your choice : ");
				int choice = input.nextInt();
				if (choice == 1) {
					try {
						showProduct();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (choice == 2) {
					try {
						addProducts();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}  else if (choice == 3) {
					try {
						updateProducts();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if (choice == 4) {
					try {
						removeProducts();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else if (choice == 5) {
					try {
						cart(true);
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}else if (choice == 6) {
					try {
						cart(false);
						break;
					}catch (Exception e) {
						e.printStackTrace();
					}
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void showProduct() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\tProducts\n");
		Iterator<Products> ite = products.iterator();
		while (ite.hasNext()) {
			Products obj = ite.next();
			System.out.print(
					"\n" + obj.getProductId() + "\t" + obj.getProductName() + "\t" + obj.getProductPrice() + "\n");
		}
		System.out.print("\n\nPress Enter to go Main Menu");
		input.nextLine();
		System.out.println("\n");
	}
	
	static int sameId[] = new int[4];
	static int k=0;
	
	private static void addProducts() {
		Scanner input = new Scanner(System.in);

	    // Initialize sameId after the products list is populated

	    System.out.print("\n\n\tProducts\n");
	    Iterator<Products> ite = products.iterator();
	    int counter = 1;

	    while (ite.hasNext()) {
	        Products obj = ite.next();
	        System.out.print("\nID : " + obj.getProductId() + "\tName : " + obj.getProductName() + "\tPrice : "
	                + obj.getProductPrice() + "\n");
	    }
		for (;;) {
		    boolean flag = true;
		    System.out.print("\nEnter the Product ID to add into your cart : ");
		    int id = input.nextInt();
		    
		    if (id <= products.size()) {
		        for (int i = 0; i < products.size(); i++) {
		            if (id == products.get(i).getProductId()) {
		                System.out.print("Enter the Quantity of the " + products.get(i).getProductName() + " : ");
		                int qty = input.nextInt();
		                
		                if (qty > 0) {
		                    for (int j = 0; j < k; j++) {
		                        if (id == sameId[j]) {
		                            flag = false;
		                            ShoppingCart cartToUpdate = shoppingCart.get(j);
		                            cartToUpdate.setProductQty(qty+cartToUpdate.getProductQty());
		                            cartToUpdate.setProductPrice(cartToUpdate.getProductQty()*products.get(i).getProductPrice());		                            break; // Exit the loop after updating quantity
		                        }
		                    }

		                    if (flag) {
		                        ShoppingCart cart = new ShoppingCart(products.get(i).getProductId(),products.get(i).getProductName(), qty, products.get(i).getProductPrice());
		                        shoppingCart.add(cart);
		                        sameId[k++] = id;
		                    }
		                } else {
		                    System.out.print("\nQuantity must be greater than 0");
		                }
		            }
		        }

		        System.out.print("\nDo you want to add some other products? Press 'y' for yes or 'n' for no : ");
		        String con = input.next();
		        if (con.equals("y")) {
		            continue;
		        } else if (con.equals("n")) {
		            System.out.println();
		            cart(true);
		            break;
		        }
		    } else {
		        System.out.print("\nID is not matching");
		    }
		}
	}
	private static void cart(boolean mainMenu) {
		if(mainMenu == true) {
			Scanner input = new Scanner(System.in);
			 if(shoppingCart.size() >= 1) {
				System.out.print("\n\n\tYour Cart\n");
				Iterator<ShoppingCart> ite = shoppingCart.iterator();
				int counter = 1;
				double total = 0.0;
				while (ite.hasNext()) {
					ShoppingCart obj = ite.next();
					System.out.print(
							"\n" + counter + "\t" + obj.getProductName()+ "\t" + obj.getProductQty() + "\t" + obj.getProductPrice() + "\n");
					total += obj.getProductPrice();
					counter++;
				}
				System.out.print("\n\t\tTotal = "+total);
				System.out.print("\n\nPress Enter to go Main Menu");
				input.nextLine();
				System.out.println("\n");
			 }else {
				 System.err.println("\nYour Cart is Empty");
			 }
		}else {
	        PrintWriter out = null;
	        try {
	            out = new PrintWriter(new FileWriter("C:/JavaTraining/Java/src/shoppingCart/OutFile.txt"));

	            if (shoppingCart.size() >= 1) {
	                System.out.print("\n\n\tYour Cart\n");
	                Iterator<ShoppingCart> ite = shoppingCart.iterator();
	                int counter = 1;
	                double total = 0.0;

	                while (ite.hasNext()) {
	                    ShoppingCart obj = ite.next();
	                    String cartDetails = "\n" + counter + "\t" + obj.getProductName() + "\t" + obj.getProductQty() + "\t"
	                            + obj.getProductPrice() + "\n";
	                    System.out.print(cartDetails);
	                    write.add(cartDetails); // Add details to the write ArrayList
	                    out.println(cartDetails); // Write to the file
	                    total += obj.getProductPrice();
	                    counter++;
	                }

	                System.out.print("\n\t\tTotal = " + total);
	                out.print("\n\tTotal"+total);
	            } else {
	                System.err.println("\nYour Cart is Empty");
	            }
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        } finally {
	            if (out != null) {
	                out.close();
	            } else {
	                System.out.println("PrintWriter is not open");
	            }
	        }
	    }
		
	}
	private static void updateProducts() {
	    Scanner input = new Scanner(System.in);
	    if(shoppingCart.size() >= 1) {
	    	 System.out.print("\n\n\tYour Cart\n");
	 	    Iterator<ShoppingCart> ite = shoppingCart.iterator();
	 	    int counter = 1;
	 	    while (ite.hasNext()) {
	 	        ShoppingCart obj = ite.next();
	 	        System.out.print(
	 	                "\nSNo: "+counter+"\tID : " + obj.getProductId() + "\tName : " + obj.getProductName() + "\t Quantity : " + obj.getProductQty() + "\tPrice : "
	 	                        + obj.getProductPrice() + "\n");
	 	        counter++;
	 	    }
	 	    for (;;) {
	 	        System.out.print("\nEnter the ID to update into your cart : ");
	 	        int id = input.nextInt();
		        for (int j = 0; j < shoppingCart.size(); j++) {
		            if (id == shoppingCart.get(j).getProductId()) {
 	       
		 	            ShoppingCart cartToUpdate = shoppingCart.get(j);
		 	            System.out.print("Enter the new Quantity for " + cartToUpdate.getProductName() + " : ");
		 	            int newQty = input.nextInt();
		 	            if(newQty>0) {
		 	            	 cartToUpdate.setProductQty(newQty);
		 
		 		 	 	     cartToUpdate.setProductPrice(cartToUpdate.getProductQty()*products.get(id-1).getProductPrice());
		 			            
		 	            	
		 	 	            System.out.println("Quantity for " + cartToUpdate.getProductName() + " updated successfully.");
		 	            }else {
							System.out.print("\nQuatity must greater than 0");
		 	            }
 	           
		 	        }
		        }
	 	        System.out.print("\nDo you want to update some other products? Press 'y' for yes or 'n' for no : ");
	 	        String con = input.next();
	 	        if (con.equals("y")) {
	 	            continue;
	 	        } else if (con.equals("n")) {
	 	            System.out.println();
	 	            cart(true);
	 	            break;
	 	        }
	 	    
	        
	 	}
	 }else {
     	System.out.println("\nYour Cart is Empty");
     }
	   
	}
	private static void removeProducts() {
	    Scanner input = new Scanner(System.in);
	    if(shoppingCart.size() >= 1) {
		    System.out.print("\n\n\tYour Cart\n");
		    Iterator<ShoppingCart> ite = shoppingCart.iterator();
		    int counter = 1;
		    while (ite.hasNext()) {
		        ShoppingCart obj = ite.next();
		        System.out.print(
		                "\nS.No : " + counter + "\tName : " + obj.getProductName() + "\t Quantity : " + obj.getProductQty() + "\tPrice : "
		                        + obj.getProductPrice() + "\n");
		        counter++;
		    }
		    for (;;) {
		        System.out.print("\nEnter the S.No to remove from your cart : ");
		        int sNo = input.nextInt();
		        if (sNo >= 1 && sNo <= shoppingCart.size()) {
		            ShoppingCart removedProduct = shoppingCart.remove(sNo - 1);
		            System.out.println("Removed " + removedProduct.getProductName() + " from the cart.");
		        } else {
		            System.out.println("Invalid S.No. Please enter a valid S.No.");
		        }
	
		        System.out.print("\nDo you want to remove some other products? Press 'y' for yes or 'n' for no : ");
		        String con = input.next();
		        if (con.equals("y")) {
		            continue;
		        } else if (con.equals("n")) {
		            System.out.println();
		            cart(true);
		            break;
		        }
		    }
	    }else {
	    	System.out.println("\nYour Cart is Empty");
	    }
	}


}
