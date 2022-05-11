import java.util.ArrayList;

public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
    	this.init(contents); 
    }
    
    public void init(E[] contents) {
    	front = new Node(null, null); 
    	Node current = front; 
    	
    	for (E e: contents) {
    		
    		Node add = new Node(e, null); 
    		current.next = add;
    		current = current.next; 
    		
    		
    	}
    	size = contents.length; 
       
    }

	@Override
	public E[] toArray() {
		int index = 0; 
		E[] newArr = (E[])(new Object[size]); 
		Node first = front; 
		while(first.next != null) {
			newArr[index] = first.next.value; 
			first = first.next; 
			index++; 
			
			
		}
		
		return newArr; 
		
	}

	@Override
	public void transformAll(MyTransformer mt) {
		E[] ret = this.toArray(); 
		for (int i = 0; i < size; i++) {
			if (ret[i] != null) {
				ret[i] = (E) mt.transformElement(ret[i]); 
			}
		}
		
		init(ret); 
		
		
	}

	@Override
	public void chooseAll(MyChooser mc) {
		int count = 0; 
		E[] elements = this.toArray(); 
		
		for (int i = 0; i < size; i++) {
			if (elements[i] != null && mc.chooseElement(elements[i])) {
				
				
				count++; 
			}
		}
		
		
		
		E[] newArr = (E[])(new Object[count]); 
		int count2 = 0; 
		for (int j = 0; j < size ;j++) {
			if (elements[j] != null && mc.chooseElement(elements[j])) {
				newArr[count2] = elements[j];  
				
				count2++; 
			}
			
		}
		
		front = new Node(null, null); 
    	Node current = front; 
    	
    	for (E e: newArr) {
    		
    		Node add = new Node(e, null); 
    		current.next = add;
    		current = current.next; 
    		
    		
    	}
    	size = newArr.length; 
		
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

    // Fill in all methods

}