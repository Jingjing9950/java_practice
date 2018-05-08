import java.util.Random;
import java.util.Scanner;

public class Calculation{
	
	public static void main(String [] args){
		Random r = new Random();
		int compareValue = r.nextInt(101);

		System.out.println("Guess a number between 1 and 100: ");
		Scanner scanner = new Scanner(System.in);
		int address = scanner.nextInt();
		for(int inputCount = 1;inputCount < 11;inputCount++){
			if (address == compareValue){
				System.out.println("You win");
				break;
			}else if (address > compareValue){
				System.out.println("Your number is too big.");			
			}else if (address < compareValue){
				System.out.println("Your number is too small.");
			}
			System.out.println("One more guess, you still hava chance of " + (10-inputCount));
			address = scanner.nextInt();
		}		

	}

}