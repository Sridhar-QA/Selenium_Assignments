package week3.day1;

public class Elements extends Button{
	public static void main(String[] args) {
		
		// create object for button class
		Button button = new Button();
		System.out.println("<------Methods accessible from Button Class------>");
		button.click();
		button.setText("Button parameter from Elements class");
		button.submit();
		
		// create object for textfield class
		TextField textField = new TextField();
		System.out.println("<------Methods accessible from TextField Class------>");
		textField.click();
		textField.setText("Button parameter from Elements class");
		textField.getText();
		
		// create object for checkbox class
		Checkbox checkBox = new Checkbox();
		System.out.println("<------Methods accessible from checkbox Class------>");
		checkBox.click();
		checkBox.setText("Button parameter from Elements class");
		checkBox.submit();
		checkBox.clickCheckButton();
		
		// create object for radio button class
		RadioButton radioButton = new RadioButton();
		System.out.println("<------Methods accessible from radio button Class------>");
		radioButton.click();
		radioButton.setText("Button parameter from Elements class");
		radioButton.submit();
		radioButton.selectRadioButton();
	}
}
