package week3.day1;

public class LoginPage extends BasePage {
	public void performCommonTasks() {
		System.out.println("Perform common tasks method from Login page");
	}
	
	public static void main(String[] args) {
		LoginPage login = new LoginPage();
		login.clickElement();
		login.findElement();
		login.enterText();
		// overriden method from Base class
		login.performCommonTasks();
	}
}
