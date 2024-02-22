package week3.day2;

public class JavaConnection extends MySqlConnection{

	public void connect() {
		System.out.println("connect method from java connection concrete class");
		
	}

	public void disconnect() {
		System.out.println("disconnect method from java connection concrete class");
		
	}

	public void executeUpdate() {
		System.out.println("execute update method from java connection concrete class");
		
	}

	@Override
	public void executeQuery() {
		System.out.println("execute query from java connection concrete class");
		
	}
	
	public static void main(String[] args) {
		JavaConnection java = new JavaConnection();
		java.connect();
		java.disconnect();
		java.executeUpdate();
		java.executeQuery();
	}
	
}
