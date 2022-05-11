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
		return elements; 
	}

	@Override
	public void transformAll(MyTransformer mt) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				elements[i] = (E) mt.transformElement(elements[i]); 
			}
		}
		
	}

	@Override
	public void chooseAll(MyChooser mc) {
		int count = 0; 
		ArrayList<E> arrList = new ArrayList<>(); 
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null && mc.chooseElement(elements[i])) {
				arrList.add(elements[i]); 
				
				count++; 
			}
		}
		
		E[] newArr = (E[])(new Object[count+1]); 
		for (int j = 0; j < newArr.length;j++) {
			newArr[j] = arrList.get(0); 
			arrList.remove(arrList.get(0)); 
			
		}
		
		elements = newArr; 
		size = newArr.length; 
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return elements.length == 0;
	}

    // Fill in all required methods here
}