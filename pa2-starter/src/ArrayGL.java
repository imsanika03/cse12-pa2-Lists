import java.util.ArrayList;

public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

	@Override
	public E[] toArray() {
		E[] newArr = (E[])new Object[size]; 
		for (int i = 0; i < size; i++) {
			newArr[i] = elements[i]; 
		}
		return newArr; 
	}

	@Override
	public void transformAll(MyTransformer mt) {
		for (int i = 0; i < size; i++) {
			if (elements[i] != null) {
				elements[i] = (E) mt.transformElement(elements[i]); 
			}
		}
		
	}

	@Override
	public void chooseAll(MyChooser mc) {
		int count = 0; 
		
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
		
		elements = newArr; 
		size = count; 
		
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elements.length == 0;
	}

    // Fill in all required methods here
}