import java.util.Scanner;

class Account {
	
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	
	//User Registration
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name : ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username : ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password : ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number : ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration completed Successfully!!..!!kindly login to your Account");
	}
	//User Login
	
	
	public boolean login() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\n!!Logined successful!!");
						isLogin = true;
					}
					else {
						System.out.println("\n@Incorrect Password@");
					}
				}
			}
			else {
				System.out.println("\n##Username not found##");
			}
		}
		return isLogin;
	}
	//Functions user can perform
	
      //withdraw method
	  
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdrawal Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance!!!");
			}
			
		}
		catch ( Exception e) {
		}
	}
      //Deposit method
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry!!...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	
	//Transfer method
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name - ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry!!...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\n!!Insufficient Balance!!");
			}
		}
		catch ( Exception e) {
		}
	}
      
	//Check Balance method
	
	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\n@@Empty@@");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}

//class InterfaceOfAtm 


public class InterfaceOfAtm {
	
	
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
				System.out.println("Enter integer value only");
				flag = false;
			}
		};
		return input;
	}
	
	//Main method
	
	
	public static void main(String[] args) {
		
		System.out.println("\n!!!!WELCOME TO SBI ATM SYSTEM!!!!\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Option - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			Account b = new Account();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Option - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n*!!!WELCOME BACK " + b.name + " *!!!\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Deposit \n2.Withdraw \n3.Transfer \n4.Transaction History \n5.Check Balance \n6.Exit");
							System.out.print("\nEnter Your Option - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
                                b.deposit();
								break;
								case 2:
								b.withdraw();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
                                b.transHistory();
								break;
								case 5:
								b.checkBalance();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
			
	}
}