
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public void choosenAllDigits() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3, 100, 30001};
		Integer[] int_output = {1, 2, 3};
		
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input); 
		ArrayGL<Integer> output = new ArrayGL<Integer>(int_output); 
		input.chooseAll(new TwoDigitChooser());
		assertArrayEquals(input.toArray(), output.toArray());
		
		
	}
	
	@Test
	public void choosenAllDigitsFirst() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {100, 2, 3, 100, 30001};
		Integer[] int_output = {2, 3};
		
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input); 
		ArrayGL<Integer> output = new ArrayGL<Integer>(int_output); 
		input.chooseAll(new TwoDigitChooser());
		assertArrayEquals(input.toArray(), output.toArray());
		
		
	}
	
	
	@Test
	public void choosenAllDigitsLinked() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 200, 3};
		Integer[] int_output = {1, 3};
		
		LinkedGL<Integer> input = new LinkedGL<Integer>(int_input); 
		LinkedGL<Integer> output = new LinkedGL<Integer>(int_output); 
		input.chooseAll(new TwoDigitChooser());
		assertArrayEquals(input.toArray(), output.toArray());
		assertEquals(input.size, output.size);
		
		
	}
	
	
	
	@Test
	public void choosenAllDigitsLinkedEverything() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 200, 3, 4000, 5000};
		Integer[] int_output = {1, 3};
		
		LinkedGL<Integer> input = new LinkedGL<Integer>(int_input); 
		LinkedGL<Integer> output = new LinkedGL<Integer>(int_output); 
		input.chooseAll(new TwoDigitChooser());
		assertArrayEquals(input.toArray(), output.toArray());
		assertEquals(input.size, 2);
		
		
	}
	
	
	
	@Test
	public void doWhile() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {};
		
		
		LinkedGL<Integer> input = new LinkedGL<Integer>(int_input); 
		
	
		assertArrayEquals(input.toArray(), int_input);
		
		
		
	}
	
	@Test
	public void doWhileTransform() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {};
	
		
		
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input); 
		input.transformAll(new AtLeastTwoDigitTransformer());
	
		assertArrayEquals(input.toArray(), int_input);
		
		
		
	}
	
	@Test
	public void isEmptyTest() {
		Integer[] int_input = {1};
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input);
		LinkedGL<Integer> input2 = new LinkedGL<Integer>(int_input);
		assertEquals(input.isEmpty(), false);
		assertEquals(input2.isEmpty(), false);
		
	}
	
	@Test
	public void isFixedTest() {
		Integer[] int_input = {100, 400, 500, 600, 200};
		
		LinkedGL<Integer> input2 = new LinkedGL<Integer>(int_input);
		
		assertArrayEquals(input2.toArray(), int_input);
		
	}
	
	@Test
	public void isEmpty3() {
		Integer[] int_input = {1,2,3,4};
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input);
		LinkedGL<Integer> input2 = new LinkedGL<Integer>(int_input);
		assertEquals(input.isEmpty(), false);
		assertEquals(input2.isEmpty(), false);
	
		
	}
	
	@Test
	public void transformTwoDigitsLinked() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3, 100, 30001};
		Integer[] int_output = {100, 200, 300, 10000, 3000100};
		
		LinkedGL<Integer> input = new LinkedGL<Integer>(int_input); 
		LinkedGL<Integer> output = new LinkedGL<Integer>(int_output); 
		input.transformAll(new AtLeastTwoDigitTransformer());
		assertArrayEquals(input.toArray(), output.toArray());
		assertEquals(input.size, output.size);
		
		
	}
	
	
	

	@Test
	public void transformTwoDigits() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3, 100, 30001};
		Integer[] int_output = {100, 200, 300, 10000, 3000100};
		
		ArrayGL<Integer> input = new ArrayGL<Integer>(int_input); 
		ArrayGL<Integer> output = new ArrayGL<Integer>(int_output); 
		input.transformAll(new AtLeastTwoDigitTransformer());
		assertArrayEquals(input.toArray(), output.toArray());
		
		
	}


}