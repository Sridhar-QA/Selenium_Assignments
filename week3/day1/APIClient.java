package week3.day1;

public class APIClient {
	
	public void sendRequest(String endpoint) {
		System.out.println("Send request method with 1 argument - endpoint");
	}
	
	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("Send request method with 3 argument - endpoint, request body and request status");
	}
	
	public static void main(String[] args) {
		APIClient api = new APIClient();
		api.sendRequest("https://api.example.com/v1/users");
		api.sendRequest("https://api.example.com/v1/users", "data", true);
	}

}
