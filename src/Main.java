import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			menu();			

		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}

	public static void play() {
		String player1Type, player2Type;
		String player1Choice, player2Choice;
		String player1Name = null, player2Name = null;
		Player player1, player2;
		boolean finished = false;
		Scanner playerType1 = new Scanner(System.in);
		System.out.print("Choose the first player ('human' or 'computer'): ");
		player1Type = playerType1.nextLine();
		if(!player1Type.equals("human") && !player1Type.equals("computer")){ // The input of the user has to be between 0 and 2.
			System.out.println("Invalid input.");			
		}

		if(player1Type.equals("human")) {	
			player1 = new HumanPlayer();
			player1Name = player1.getName();

		}
		else {
			player1 = new ComputerPlayer();
		}

		Scanner playerType2 = new Scanner(System.in);
		System.out.print("Choose the second player ('human' or 'computer'): ");
		player2Type = playerType2.nextLine();

		if(!player2Type.equals("human") && !player2Type.equals("computer")){ // The input of the user has to be between 0 and 2.
			System.out.println("Invalid input.");

		}

		if(player2Type.equals("human")) {
			player2 = new HumanPlayer();
			player2Name = player2.getName();

		}
		else {
			player2 = new ComputerPlayer();
		}

		while(!finished){

			player1Choice = player1.getChoice();
			player2Choice = player2.getChoice();
			System.out.println("The player 1 choice is: " + player1Choice);
			printASCII(player1Choice);
			System.out.println("The player 2 choice is " + player2Choice);
			printASCII(player2Choice);

			if(player1Choice.equals(player2Choice)) { // If both moves are equal == TIE.
				System.out.println("You tied!");
			}
			else if((player1Choice.equals("rock") && player2Choice.equals("scissors")) || (player1Choice.equals("scissors") && player2Choice.equals("paper")) || (player1Choice.equals("paper") && player2Choice.equals("rock"))){ // Winning conditions.
				System.out.println("Player 1 has won !");
				player1.winsRound();
				System.out.println("Player 1 has a total of " + player1.wins + " win(s)");
				System.out.println("Player 2 has a total of " + player2.wins + " win(s)");
				if(player1.wins == 3) {
					if(player1Type.equals("human")) {
						System.out.println(player1Name + " HAS WON!");
					}else {
						System.out.println("Computer 1 HAS WON!");
					}
					finished = true;
				}
			}

			else { //Lost
				System.out.println("Player 2 has won !");
				player2.winsRound();
				System.out.println(" Player 1 has a total of " + player1.wins + " win(s)");
				System.out.println(" Player 2 has a total of " + player2.wins + " win(s)");		
				if(player2.wins == 3) {
					if(player2Type.equals("human")) {
						System.out.println(player2Name + " HAS WON!");
					}else {
						System.out.println("Computer 2 HAS WON!");
					}
					finished = true;
				}
			}
		}
	}

	public static void printASCII(String choice) { //Print the ASCII equivalent to the playerChoice or the computerChoice.

		if(choice.equals("rock")){

			System.out.println("    _______");
			System.out.println("---'   ____)");
			System.out.println("      (_____)");
			System.out.println("      (_____)");
			System.out.println("      (____)");
			System.out.println("---.__(___)");
			System.out.println("");

		}
		else if (choice.equals("paper")) {
			System.out.println("    _______");
			System.out.println("---'   ____)____");
			System.out.println("          ______)");
			System.out.println("          _______)");
			System.out.println("         _______)");
			System.out.println("---.__________)");
			System.out.println("");

		}
		else {
			System.out.println("    _______");
			System.out.println("---'   ____)____");
			System.out.println("          ______)");
			System.out.println("       __________)");
			System.out.println("      (____)");
			System.out.println("---.__(___)");
			System.out.println("");

		}

	}

	public static void menu() { // Simple menu functionality, can be expanded easily.

		Scanner sn = new Scanner(System.in);
		boolean exit = false;

		int option; //We save the option of the user.

		while(!exit){

			System.out.println("");
			System.out.println("1: Play the game");
			System.out.println("2: Exit");

			System.out.print("Type your option: ");
			option = sn.nextInt();

			switch(option){
			case 1:
				play();				
				break;
			case 2:
				exit = true;
				break;
			default:
				System.out.println("Type a number between 1 and 2.");
			}

		}
	}

}
