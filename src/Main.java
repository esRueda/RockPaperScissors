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

	public static void playerVsComputer() {
		Player player = new Player();
		Scanner playerName = new Scanner(System.in); // User input for the name.
		System.out.print("What is your name?: ");
		player.name = playerName.nextLine();
		boolean finished = false;
		
		while(!finished){
		int rand = (int) (Math.random() * 3); // Random number between 0 and 2.
		System.out.println(player.name  + ", enter your choice ('rock', 'paper', 'scissors' or 'exit' to quit the game): ");
		Scanner playerMove = new Scanner(System.in); // User input for the move.
		String playerChoice = playerMove.nextLine();
		String computerChoice = null;
		
		if(playerChoice.equals("exit")) { // I check if the move is exit.
			finished = true;	
			break;
		}
		if(!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) { // The input of the user has to be between 0 and 2.
			System.out.println("Invalid input.");
			
		}
		else {
			switch(rand) { // Assign the computer move depending on the randomly generated number.
			case 0:
				computerChoice = "rock";
				break;			
			case 1:
				computerChoice = "paper";
				break;		

			case 2:
				computerChoice = "scissors";
				break;		
			}
		}
		System.out.println("The player's choice is: " + playerChoice);
		printASCII(playerChoice);
		System.out.println("The computer's choice is " + computerChoice);
		printASCII(computerChoice);

		if(playerChoice.equals(computerChoice)) { // If both moves are equal == TIE.
			System.out.println("You tied!");
		}
		else if((playerChoice.equals("rock") && computerChoice.equals("scissors")) || (playerChoice.equals("scissors") && computerChoice.equals("paper")) || (playerChoice.equals("paper") && computerChoice.equals("rock"))){ // Winning conditions.
			System.out.println(player.name + " has won !");
			player.winsRound();
			System.out.println(player.name + " has a total of " + player.wins + " win(s)");
			if(player.wins == 3) {
				System.out.println(player.name + " HAS WON!");
				finished = true;
				
			}
			
		}else { //Lost
			System.out.println(player.name + " has lost !");
			player.reduceLives();
			System.out.println(player.name + " has a total of " + player.lives + " lives");			
			if(player.lives == 0) {
				System.out.println("GAME OVER, " + player.name + " has lost the game.");
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
			System.out.println("1: Player vs Computer");
			System.out.println("2: Exit");

			System.out.print("Type your option: ");
			option = sn.nextInt();

			switch(option){
			case 1:
				playerVsComputer();				
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
