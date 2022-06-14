package test.java8.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class ProductLaptop{  
    int id;  
    String name;  
    float price;  
    public ProductLaptop(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  

public class StreamFilterCollectionExample {
	
	public static void main(String[] args) {  
        List<ProductLaptop> productsList = new ArrayList<ProductLaptop>();  
        //Adding Products  
        productsList.add(new ProductLaptop(1,"HP Laptop",25000f));  
        productsList.add(new ProductLaptop(2,"Dell Laptop",30000f));  
        productsList.add(new ProductLaptop(3,"Lenevo Laptop",28000f));  
        productsList.add(new ProductLaptop(5,"Apple Laptop",90000f)); 
        productsList.add(new ProductLaptop(6,"Acer Laptop",25000f)); 
        
        List<Float> productPriceList1 =productsList.stream()
        .filter(p -> p.price < 30000) //filter data
        .map(p->p.price)// fetching data
        .collect(Collectors.toList());  //collecting as list
        System.out.println(productPriceList1);  
        
        
        //filtering and iterating
        System.out.println("------------------");
        productsList.stream().filter(p -> p.price < 30000).forEach(p->System.out.println(p.name));
        
        
        //reduce()-accumulate price
        System.out.println("reduce()");
        Float totalPrice=productsList.stream()
        .map(product->product.price)
        .reduce(0.0F,(sum,price)->sum+price);
        System.out.println("Total price----"+totalPrice); 
        
        
        //Using Float class  method
        System.out.println("Using Float class  method");
        Float totalPrice2=productsList.stream()
        .map(product->product.price)
        .reduce(0.0F,Float::sum);
        System.out.println("Total price----"+totalPrice2);
                
                
       //Using Collectors method
       System.out.println("Using Collectors  method");
       Double totalPrice3=productsList.stream()
          .collect(Collectors.summingDouble(product->product.price));
       System.out.println("Total price----"+totalPrice3);
       
                        
       // max() method to get max Product price               
       System.out.println("max product price");
       ProductLaptop p=productsList.stream()
       .max((product1,product2)->product1.price>product2.price?1:-1).get();
       System.out.println(p.price);
              
              
       
        ProductLaptop p1=productsList.stream()
        .min((product1,product2)->product1.price>product2.price?1:-1).get();
        System.out.println(p1.price);
        
        
        // product count               
        System.out.println("product count");
        long count = productsList.stream()  
                .filter(product->product.price<30000)  
                .count();  
        System.out.println(count); 
        
        
     // List to Set conversion count               
        System.out.println("List to Set");
       Set<Float> set= productsList.stream()
        .filter(product->product.price>2000)
        .map(product->product.price)
        .collect(Collectors.toSet());
       System.out.println(set);
       
       
       // Converting List into a Map  
       System.out.println("List to Map");
       Map<Integer,String> productPriceMap =   
    		   productsList.stream()  
                       .collect(Collectors.toMap(product->product.id, product->product.name));  
        
        System.out.println(productPriceMap);
        
              
                        
    }  

}
