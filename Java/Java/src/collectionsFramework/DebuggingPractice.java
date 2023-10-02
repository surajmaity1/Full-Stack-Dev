package collectionsFramework;

public class DebuggingPractice {

	public static void main(String[] args) {
		int val = 371;
		
		boolean res =isArmstrong(val);

		System.out.println("This program for Debugging");

		val *= 32;

		System.out.println(val + "" + res);

		val %= 93;

		val++;
		++val;

		System.out.println(val);
	}

	static boolean isArmstrong(int n) {
		int temp, digits = 0, last = 0, sum = 0;
		// assigning n into a temp variable
		temp = n;
		// loop execute until the condition becomes false
		while (temp > 0) {
			temp = temp / 10;
			digits++;
		}
		temp = n;
		while (temp > 0) {
			// determines the last digit from the number
			last = temp % 10;
			// calculates the power of a number up to digit times and add the resultant to
			// the sum variable
			sum += (Math.pow(last, digits));
			// removes the last digit
			temp = temp / 10;
		}
		// compares the sum with n
		if (n == sum)
			// returns if sum and n are equal
			return true;
		// returns false if sum and n are not equal
		else
			return false;
	}

}
