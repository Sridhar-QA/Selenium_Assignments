package week1.day2;

public class FibonacciSeries {
	
	public void printFibonacciSeries(int range) {
		int a = 0;
		int b = 1;
		if(range < 1) {
			return;
		}
		System.out.println(a);
		for(int i = 1; i<range; i++) {
			System.out.println(b);
			int c = a+b;
			a = b;
			b = c;
		}
	}

	public static void main(String[] args) {
		int range = 7;
		FibonacciSeries fs = new FibonacciSeries();
		fs.printFibonacciSeries(range);
	}

}
