
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s.toUpperCase();
	}

}

// Add your transformers here

class SadTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		return s + ":(";
	}

}

class AtLeastTwoDigitTransformer implements MyTransformer<Integer> {

	public Integer transformElement(Integer s) {
		return s*100;
	}

}