package test.java8.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Item{  
    int id;  
    String name;  
    float price;  
      
    public Item(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
          
    public int getId() {  
        return id;  
    }  
    public String getName() {  
        return name;  
    }  
    public float getPrice() {  
        return price;  
    }  
    
    
    @Override
    public String toString() {
    	
    	return name;
    }
}  
public class SteamMethodReferenceExample {
	public static void main(String[] args) {
	
	 List<Item> itemList = new ArrayList<Item>();  
     //Adding Products  
	 itemList.add(new Item(1,"HP Laptop",25000f));
	 itemList.add(new Item(2,"Dell Laptop",30000f));  
	 itemList.add(new Item(3,"Lenevo Laptop",28000f));  
	 itemList.add(new Item(5,"Apple Laptop",90000f)); 
	 itemList.add(new Item(6,"Acer Laptop",25000f)); 

     //operations
	 System.out.println("Method reference in stream");
	 List<Float> list=itemList.stream()
	 .filter(item->item.price>20000)
	 .map(Item::getPrice)
	 .collect(Collectors.toList());
	 System.out.println(list);

}
}
