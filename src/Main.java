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


	public static Player playerSelection(int playerNumber) {
		Player player1 = null;
		Scanner userInput = new Scanner(System.in);
		while(player1 == null) {

			System.out.print("Choose player " + playerNumber + " ('human' or 'computer'): ");
			String player1Type = userInput.nextLine();
			player1 = Player.createPlayer(player1Type);
			if(player1 == null) {
				System.out.println("Invalid user, try again later.");
			}
		}
		player1.createName(playerNumber);
		return player1;
	}

	public static void play() {
		
		Player player1 = playerSelection(1);
		Player player2 = playerSelection(2);
		boolean finished = false;
		while(!finished){

			String player1Choice = player1.getChoice();
			String player2Choice = player2.getChoice();
			System.out.println(player1.getName() + " choice is: " + player1Choice);
			printASCII(player1Choice);
			System.out.println(player2.getName() + " choice is " + player2Choice);
			printASCII(player2Choice);

			if(player1Choice.equals(player2Choice)) { // If both moves are equal == TIE.
				System.out.println("You tied!");
			}
			else if((player1Choice.equals("rock") && player2Choice.equals("scissors")) 
					|| (player1Choice.equals("scissors") && player2Choice.equals("paper"))
					|| (player1Choice.equals("paper") && player2Choice.equals("rock"))){ // Winning conditions.
				System.out.println(player1.getName() + " has won the round!");
				player1.winsRound();
				System.out.println(player1.getName() + " has a total of " + player1.getWins() + " win(s)");
				System.out.println(player2.getName() + " has a total of " + player2.getWins() + " win(s)");	
				if(player1.getWins() == 3) {
					player1.printWinMessage();
					finished = true;
				}
			}

			else { //Lost
				System.out.println(player2.getName() + " has won the round!");
				player2.winsRound();
				System.out.println(player1.getName() + " has a total of " + player1.getWins() + " win(s)");
				System.out.println(player2.getName() + " has a total of " + player2.getWins() + " win(s)");		
				if(player2.getWins() == 3) {
					player2.printWinMessage();
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
