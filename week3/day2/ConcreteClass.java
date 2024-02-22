package week3.day2;

public class ConcreteClass implements DatabaseConnection {

	public void connect() {
		System.out.println("Connect method - Concrete class");
		
	}

	public void disconnect() {
		System.out.println("Disconnect method - Concrete class");
		
	}

	public void executeUpdate() {
		System.out.println("execute update method - Concrete class");
		
	}
	
	public static void main(String[] args) {
		ConcreteClass cc = new ConcreteClass();
		cc.connect();
		cc.disconnect();
		cc.executeUpdate();
	}
}
