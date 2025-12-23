import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		// Here I am making an instance of the Scanner class and the FinanceManager class.
		Scanner keyboard = new Scanner(System.in);
		FinanceManager manager = new FinanceManager();

		int choice;
		double amountOfIncome;
		String categoryOfIncome;
		double amountOfExpense;
		String categoryOfExpense;
		String inputFile;
		String outputFile;
		String exitConfirmation;
		boolean quitProgram = false;
		// This while loop is used to display the menu unless the user selects the exit option and decides to exit the program. 
		while(!quitProgram)
		{
			clearScreen();
			System.out.println("Personal Finance Management System");
			System.out.println("-----------------------------------");
			System.out.println("1. Add Income");
			System.out.println("2. Add Expense");
			System.out.println("3. View Summary");
			System.out.println("4. Save Data to File");
			System.out.println("5. Load Data from File");
			System.out.println("6. Exit");
			System.out.print("\nEnter your choice (1-6): ");
			// This while loop is used for input validation to ensure the user does not enter something other than an Integer as their choice for a menu option.
			while (!keyboard.hasNextInt())
			{
    				System.out.println("Invalid input, enter a number between 1 and 6.");
    				System.out.print("Enter your choice (1-6): ");
   				keyboard.nextLine();
			}
			choice = keyboard.nextInt();
			keyboard.nextLine();
			// I used a switch to handle what the user selected as their choice from the main menu.
			switch (choice)
			{
				// The case 1 handles the selection of the Add Income option and first clears the screen of the menu to keep things organized and clean for the user.
		// Then it asks the user to input the income amount and uses while loops as input validation to ensure the user does not enter anything that is not a double or less than or equal to 0.
		// After the user enters a valid numeric value the case then asks the user to input the category of the income and also uses while loop as input validation.
		// The while loop ensures that the user does not enter nothing for the category. When the user is done inputting the data the case then asks the user if they want to add anymore income.
		// If the user enters yes then the while loop allows them to add another income.
				case 1:
					clearScreen();
					boolean moreIncome = true;
					while (moreIncome)
					{
						System.out.print("Enter the amount of income: $");
						while (!keyboard.hasNextDouble())
						{
    							System.out.println("Invalid input, enter a numeric value.");
    							System.out.print("Enter the amount of income: $");
    							keyboard.nextLine();
						}
						amountOfIncome = keyboard.nextDouble();
						keyboard.nextLine();
						while (amountOfIncome <= 0.0)
						{
							System.out.println("Amount must be greater than 0.");
							System.out.print("Enter the amount of income: $");
								while (!keyboard.hasNextDouble())
								{
    									System.out.println("Invalid input, enter a numeric value.");
    									System.out.print("Enter the amount of income: $");
    									keyboard.nextLine();
								}
								amountOfIncome = keyboard.nextDouble();
								keyboard.nextLine();
						}
						System.out.print("Enter the category of income: ");
						categoryOfIncome = keyboard.nextLine();
						while (categoryOfIncome.isEmpty())
						{
							System.out.println("Category cannot be empty.");
        						System.out.print("Enter the category of income: ");
        						categoryOfIncome = keyboard.nextLine();
    						}
						manager.addIncome(amountOfIncome, categoryOfIncome);
						System.out.print("Add another income? (Y/N): ");
						String again = keyboard.nextLine().toUpperCase();
						if (!again.equals("Y") && !again.equals("YES"))
						{
							moreIncome = false;
						}
					}
					break;
				// The case 2 handles the selection of the Add Expense option and first clears the screen of the menu to keep things organized and clean for the user.
		// Then it asks the user to input the expense amount and uses while loops as input validation to ensure the user does not enter anything that is not a double or less than or equal to 0.
		// After the user enters a valid numeric value the case then asks the user to input the category of the expense and also uses while loop as input validation.
		// The while loop ensures that the user does not enter nothing for the category. When the user is done inputting the data the case then asks the user if they want to add anymore expenses.
		// If the user enters yes then the while loop allows them to add another expense.
				case 2:
					clearScreen();
					boolean moreExpenses = true;
					while (moreExpenses)
					{
						System.out.print("Enter the amount of the expense: $");
						while (!keyboard.hasNextDouble())						
						{
    							System.out.println("Invalid input, enter a numeric value.");
    							System.out.print("Enter the amount of the expense: $");
    							keyboard.nextLine();
						}
						amountOfExpense = keyboard.nextDouble();
						keyboard.nextLine();
						while (amountOfExpense <= 0.0)
						{
							System.out.println("Amount must be greater than 0.");
							System.out.print("Enter the amount of the expense: $");
							while (!keyboard.hasNextDouble())
							{
    								System.out.println("Invalid input, enter a numeric value.");
    								System.out.print("Enter the amount of the expense: $");
    								keyboard.nextLine();
							}
							amountOfExpense = keyboard.nextDouble();
							keyboard.nextLine();
						}

						System.out.print("Enter the category of the expense: ");
						categoryOfExpense = keyboard.nextLine();
						while (categoryOfExpense.isEmpty())
						{
							System.out.println("Category cannot be empty.");
        						System.out.print("Enter the category of income: ");
        						categoryOfExpense = keyboard.nextLine();
    						}
						manager.addExpense(amountOfExpense, categoryOfExpense);
				 		System.out.print("Add another expense? (Y/N): ");
        					String again = keyboard.nextLine().trim().toUpperCase();
        					if (!again.equals("Y") && !again.equals("YES")) 
						{
            						moreExpenses = false;
        					}
					}
					break;
				// The case 3 handles the selection of the View Summary option and first clears the screen of the menu to keep things organized and clean for the user.
				// Then, it call the viewSummary function of the FinanceManager class for the instance manager. It let the user know after how to return back to the menu.
				// Then main reason for putting in the print statement and nextLine statement was to pause the program for the user.
 				// That way the user is able to see what the saveToFile function says before going back to the main menu.
				case 3:
					clearScreen();
					manager.viewSummary();
					System.out.println("Press Enter to return to the menu.");
					keyboard.nextLine();
					break;
				// The case 4 handles the selection of the Save Data to File option and first clears the screen of the menu to keep things organized and clean for the user.
				// It asks the user to specify what file they would like to save the data to.
				// Then, it calls the saveToFile function of the FinanceManager class for the instance manager. It lets the user know after how to return back to the menu.
				// Then main reason for putting in the print statement and nextLine statement was to pause the program for the user.
 				// That way the user is able to see what the saveToFile function says before going back to the main menu.
				case 4:
					clearScreen();
					System.out.print("Enter the filename to save data: ");
    					inputFile = keyboard.nextLine();
					manager.saveToFile(inputFile);
					System.out.println("Press Enter to return to the menu.");
                    			keyboard.nextLine();
					break;
				// The case 5 handles the selection of the Load Data from File option and first clears the screen of the menu to keep things organized and clean for the user.
				// It asks the user to specify what file they want to load data from.
				// Then, it calls the loadFromFile function of the FinanceManager class for the instance manager. It lets the user know after how to return back to the menu.
				// Then main reason for putting in the print statement and nextLine statement was to pause the program for the user.
 				// That way the user is able to see what the loadFromFile function says before going back to the main menu.
				case 5:
					clearScreen();
					System.out.print("Enter the filename to load data from: ");
   					outputFile = keyboard.nextLine();
					manager.loadFromFile(outputFile);
					System.out.println("Press Enter to return to the menu.");
                    			keyboard.nextLine();
					break;
				// The case 6 handles the selection of the Exit option and tries to make sure first that the user is meaning to exit the program before exiting. 
				// If the user answers yes then the boolean variable quitProgram is made true. 
				// Which causes the while loop that keep the menu going to stop since it now meets its condition.
				case 6:
					clearScreen();
					System.out.print("Are you sure you want to quit? (Y/N): ");
					exitConfirmation = keyboard.nextLine().toUpperCase();
					if (exitConfirmation.equals("Y") || exitConfirmation.equals("YES"))
					{
						quitProgram = true;
					}
					break;
				// The default helps catch if someone entered a number that wasn't between 1 and 6. It prints to the screen so the user can understand why no option was selected.
				default:
					System.out.println("Invalid input, you must choose a menu option that is (1-6).");
					System.out.print("Press Enter to continue.");
					keyboard.nextLine();
					break;
			}
		}
	}
	// This is a funtion that clears the screen.
	public static void clearScreen() 
	{
   		System.out.print("\033[H\033[2J");
    		System.out.flush();
	}
}