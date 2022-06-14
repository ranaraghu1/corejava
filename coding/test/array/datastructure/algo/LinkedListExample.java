package test.array.datastructure.algo;

class Node{
	Node next;//reference to the next node in this chain, null if there is no one.
	Object data;
	
	public Node(Object dataVal) {
		next=null;
		data=dataVal;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}
	
	}

class CustomLinkedList{
	private static int counter;
	private Node head;
	
	public CustomLinkedList() {
		
	}
	
	public void add(Object data) {
		
		if(head==null) {// initialize node if it is 1st element.
			head=new Node(data);
		}
		Node temp=new Node(data);
		Node current=head;
		
		if(current!=null) {
			// starting at the head node, go to the end of the list and then add element after last node
			while(current.getNext()!=null) {
				current=current.getNext();
			}
			// the last node's "next" reference set to our new node
			current.setNext(temp);
		}
		incrementCounter();
	}
	
	// inserts the specified element at the specified position in this list
		public void add(Object data, int index) {
			Node temp=new Node(data);
			Node current=head;
			if(current!=null) {
				// crawl to the requested index or the last element in the list, whichever comes first.
				for(int i=0;i<index  && current.getNext()!=null; i++ ) {
					current=current.getNext();
				}
			
			}
			
			// set the new node's(temp) next-node reference to this node's next-node reference
			temp.setNext(current.getNext());
	 
			// now set this node's next-node reference to the new node
			current.setNext(temp);
	 
			// increment the number of elements variable
			incrementCounter();
		}
	
		public Object get(int index) {
			if(index<0) 
				return null;
			Node current=null;
			if(head!=null) {
				current=head.getNext();
			
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;
 
				current = current.getNext();
			}
			return current.getData();
			}
			return current;
		}
		
		// removes the element at the specified position in this list.
		public boolean remove(int index) {
			if (index < 1 || index > size())
				return false;
			Node current=head;
			if(head!=null) {
				for(int i=0;i<index;i++) {
					if (current.getNext() == null)
						return false;
	 
					current = current.getNext();
				 }
				current.setNext(current.getNext().getNext());
				decrementCounter();
				return true;
				}
			return false;
			}
		
		public void reverse() {
			Node current = head;
	        Node prev = null;
	        Node next = null;
	 
	        while (current != null) {
	            // Store next
	            next = current.getNext();
	 
	            // Reverse current node's pointer
	           // current->next = prev;
	            current.setNext(prev);
	 
	            // Move pointers one position ahead.
	            prev = current;
	            current = next;
	            
	        }
	       head = prev;
			}

			
		public void print()
		{
		Node node = head;
		while (node != null) {
			System.out.print(node.getData() + " "); 
			node = node.getNext(); 
			}
		System.out.println("");
		}

		
		
	public int size() {
			return getCounter();
	}	
	private static int getCounter() {
		return counter;
	}
	
	private static void incrementCounter() {
		counter++;
	}
 
	public String toString() {
		String output = "";
 
		if (head != null) {
			Node current = head.getNext();
			while (current != null) {
				output += "[" + current.getData().toString() + "]";
				current = current.getNext();
			}
 
		}
		return output;
	}
	private void decrementCounter() {
		counter--;
	}
}
public class LinkedListExample {

	public static void main(String[] args) {
		CustomLinkedList list=new CustomLinkedList();
		list.add("5");
		list.add("6");
		list.add("3");
		list.add("1");
		
		System.out.println("List Size:"+list.size());
		
		list.add("9");
		System.out.println("List Size:"+list.size());
		System.out.println("List :"+list.toString());
		//list.remove(2);
		//System.out.println("List :"+list.toString());
		System.out.println("Get :"+list.get(3));
		System.out.println("Get :"+list.get(4));
	
	 
		list.reverse(); 
		System.out.println("List :"+list.toString());

	
		

	}

}
