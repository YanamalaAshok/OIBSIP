import java.util.Scanner;
import java.util.Random;

//class Randomgame

class Randomgame {
	
	int sysInput;
	int userInput;
	int noOfGuesses = 0;
	
	// default constructor-generating random number 

	Randomgame() {
		Random random = new Random();
		this.sysInput = random.nextInt(100) + 1;
	}
	
	
	// take user guesses
	
	public boolean takeUserInput() {
		if ( noOfGuesses < 10 ) {
			System.out.print("Can you Guess the number : ");
			this.userInput = GuessNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished!!!Better luck! for next time\n");
			return true;
		}
	}
	
	
	//method to check user guess status
	
	public boolean isCorrectGuess() {
		
		if ( sysInput == userInput ) {
			System.out.println("Congratulations!You got it!, you guess the number " + sysInput +
			" in " + noOfGuesses + " guesses");
			switch(noOfGuesses) {
				case 1:
				System.out.println("Your score : 100");
				break;
				case 2:
				System.out.println("Your score : 90");
				break;
				case 3:
				System.out.println("Your score : 80");
				break;
				case 4:
				System.out.println("Your score : 70");
				break;
				case 5:
				System.out.println("Your score : 60");
				break;
				case 6:
				System.out.println("Your score : 50");
				break;
				case 7:
				System.out.println("Your score : 40");
				break;
				case 8:
				System.out.println("Your score : 30");
				break;
				case 9:
				System.out.println("Your score : 20");
				break;
				case 10:
				System.out.println("Your score : 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if ( noOfGuesses < 10 && userInput > sysInput ) {
			if ( userInput - sysInput > 10 ) {
				System.out.println("Extremely High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if ( noOfGuesses < 10 && userInput < sysInput ) {
			if ( sysInput - userInput > 10 ) {
				System.out.println("Extremely low");
			}
			else {
				System.out.println("Little low");
			}
		}
		return false;
	}
}

// Main class


public class GuessNumber {
	
	// static method to take integer input without any limit and exception error
	// exception handling and input limit handling
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Select the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Please!! Enter integer value only");
				flag = false;
			}
		};
		return input;
	}
	
	// Main method
	
	public static void main(String[] args) {
		
		// input for start the game
		
		System.out.println("1. Start Game \n2. Exit");
		System.out.print("Enter your option : ");
		int choice = takeIntegerInput(2);
		int nextRound = 1;
		int noOfRound = 0;
		
		if ( choice == 1 ) {
			
			// to check next round is there or not
			
			
			while ( nextRound == 1 ) {
			
				// creating object of Randomgame class
				
				Randomgame game = new Randomgame();
				boolean isMatched = false;
				boolean isLimitCross = false;
				System.out.println("\nRound " + ++noOfRound + " starts...");
				
				// correct guess and limit cross to check
				
				
				while ( !isMatched && !isLimitCross) {
					isLimitCross = game.takeUserInput();
					isMatched = game.isCorrectGuess();
				}
				
				// input for new round
				
				System.out.println("1. New Round \n2. Exit");
				System.out.println("Enter your option: ");
				nextRound = takeIntegerInput(2);
				if ( nextRound != 1 ) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}