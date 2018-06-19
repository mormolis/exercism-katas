class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		int temp = numberToCheck;
		int numberOfDigits = 0;
		while (temp > 0){
			numberOfDigits++;
			temp /= 10;
		}
		int sum = 0;
		temp = numberToCheck;
		while(temp > 0){
			sum += Math.pow(temp%10,numberOfDigits);
			temp /=10;
		}
		return sum == numberToCheck;
	}

}
