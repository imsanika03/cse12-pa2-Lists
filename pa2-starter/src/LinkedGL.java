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
    	front = null; 
    	for (E e: contents) {
    		Node add = new Node(e, front); 
    		front = add;
    		
    	}
    	size = contents.length; 
       
    }

	@Override
	public E[] toArray() {
		int index = 0; 
		E[] newArr = (E[])(new Object[size]); 
		Node first = front; 
		while(first.next != null) {
			newArr[index] = first.value; 
			first = first.next; 
			index++; 
			
			
		}
		
		return newArr; 
		
	}

	@Override
	public void transformAll(MyTransformer mt) {
		E[] ret = this.toArray(); 
		for (int i = 0; i < ret.length; i++) {
			if (ret[i] != null) {
				ret[i] = (E) mt.transformElement(ret[i]); 
		
			}
		}
		
		front = null; 
    	for (E e: ret) {
    		Node add = new Node(e, front); 
    		front = add;
    		
    	}
    	size = ret.length;
		
	}

	@Override
	public void chooseAll(MyChooser mc) {
		E[] ret = this.toArray(); 
		ArrayList<E> arr = new ArrayList<>(); 
		int index = 0; 
		for (int i = 0; i < ret.length; i++) {
			if (ret[i] != null && mc.chooseElement(ret[i])) {
			
				index++; 
				arr.add(ret[i]); 
		
			}
		}
		
		E[] newr = (E[])(new Object[index+1]); 
		for (int j = 0; j < newr.length; j++) {
			newr[j] = arr.get(j); 
		}
		
		front = null; 
    	for (E e: newr) {
    		Node add = new Node(e, front); 
    		front = add;
    		
    	}
    	size = newr.length;
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

    // Fill in all methods

}