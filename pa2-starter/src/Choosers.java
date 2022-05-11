
class LongWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.length() > 5;
	}

} 

class AppleWordChooser implements MyChooser<String> {

	@Override
	public boolean chooseElement(String s) {
		return s.indexOf("apple") != -1;
	}

} 

class TwoDigitChooser implements MyChooser<Integer> {

	@Override
	public boolean chooseElement(Integer s) {
		if (s.toString().length() <= 2) {
			System.out.println(s + "is num"); 
			return true; 
		}
		
		return false;
		
	}

} 

// Add your choosers here