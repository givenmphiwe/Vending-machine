import java.util.*;
public class Machine {
	private static Scanner in;
	private static float balance = 0; //initial balance for everyone
	private static int anotherTransaction;  
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		//call out transaction method
		transaction();

	}
	private static void transaction() {
		//most of work take place here
		
		int choice;
		
		System.out.println("Please select sn option");
		System.out.println("1. Withdraw");
		System.out.println("2. Deposit");
		System.out.println("3. Balance");
		
		choice = in.nextInt();
		
		switch(choice) {
		case 1:
			float amount;
			System.out.println("Please enter amount to withdraw: ");
			amount = in.nextFloat();
			if(amount > balance || amount == 0) {
				System.out.println("You have insufficient funds");
				anotherTransaction(); //ask they want to do another transaction
				
			}else {
				//they have some cash
				//update balance
				balance = balance - amount;
				System.out.println("You have withdrawn "+amount+"and your new balance is"+balance+"\n");
				anotherTransaction();
			}
			break;
		case 2:
			//option 2 for depositing
			float deposit;
			System.out.println("Please enter amount to deposit");
			deposit = in.nextFloat();
			//update balance
			balance = deposit + balance;
			System.out.println("You have deposited"+deposit+"new balance is "+balance+"\n");
			anotherTransaction();
			break;
		case 3:
			// this option is to check the balance
			System.out.println("Your balnce is"+balance+"\n");
			anotherTransaction();
			break;
		default:
			System.out.println("Invalid option:\n\n");
			
			anotherTransaction();
			break;
		}
		
		
	}
	private static void anotherTransaction() {
		System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 Exit");
		anotherTransaction = in.nextInt();
		if(anotherTransaction == 1) {
			transaction(); //calling the transaction method
		}else if(anotherTransaction == 2) {
			System.out.println("Good Bye!");
		}else {
			System.out.println("Invalid Option\n\n");
			anotherTransaction();
		}
	}

}
