import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FinanceManager
{
	// This is an ArrayList of instances of the Transaction class that holds all the transactions including both income and expense.
	private ArrayList<Transaction> transactions;
	private double totalIncome;
	private double totalExpenses;
	private double netBalance;
	// This is the Constructor for the class and initializes the transaction list.
	public FinanceManager()
	{
		transactions = new ArrayList<>();
	}
	// This function adds a new income transaction to the ArrayList.
	public void addIncome(double amount, String category)
	{
		transactions.add(new Transaction(amount, category, "Income"));
	}
	// This function adds a new expense transaction to the ArrayList.
	public void addExpense(double amount, String category)
	{
		transactions.add(new Transaction(amount, category, "Expense"));
	}
	// These functions calculate a value and assign the value to a variable. The calcTotalIncome add all the income transactions and the calcTotalExpenses adds all the expense transactions.
	// The calcNetBalance subtrancts the total income by the total of the expenses.
	public void calcTotalIncome()
	{
		double total = 0;
		for (Transaction transaction : transactions)
		{
			if (transaction.getType().equals("Income"))
			{
				total += transaction.getAmount();
			}
		}
		totalIncome = total;
	}
	public void calcTotalExpenses()
	{
		double total = 0;
		for (Transaction transaction : transactions)
		{
			if (transaction.getType().equals("Expense"))
			{
				total += transaction.getAmount();
			}
		}
		totalExpenses = total;
	}
	public void calcNetBalance()
	{
		netBalance = totalIncome - totalExpenses;
	}	
	// These functions just return values
	public double getTotalIncome()
	{
		return totalIncome;
	}
	public double getTotalExpenses()
	{
		return totalExpenses;
	}
	public double getNetBalance()
	{
		return netBalance;
	}
	// This function prints to the screen a summary of what the total income, total expenses, and net balance are at the time of the user pressing the view summary option on the main menu.
	public void viewSummary()
	{
		calcTotalIncome();
		calcTotalExpenses();
		calcNetBalance();
		System.out.println("Financial Summary");
		System.out.println("--------------------------");
		System.out.printf("Total Income: $%,.2f", totalIncome);
		System.out.printf("\nTotal Expenses: $%,.2f", totalExpenses);
		System.out.printf("\nNet Balance: $%,.2f", netBalance);
		System.out.println("\n--------------------------");
	}
	// This function saves all of the transactions to the text file.
	public void saveToFile(String fileName)
	{
		// This try-catch clause opens up the file and writes each transaction in the ArrayList to the file.
		try (PrintWriter outputFile = new PrintWriter(fileName))
		{
			for (Transaction transaction : transactions)
			{
				outputFile.println(transaction.getType() + "," + transaction.getAmount() + "," + transaction.getCategory() + "," + transaction.getDate());
			}
			System.out.println("Successfully saved data to " + fileName);
		}
		// The catch is in case an error happens when trying to save data to the file.
		catch (IOException ex)	
		{
			System.out.println("Error: error with saving data to " + fileName);
		}
	}
	// This function loads all of the transactions from the text file.
	public void loadFromFile(String fileName)
	{	// This makes sure that no duplicates happen when loading the transactions from the file.
		transactions.clear();
		// This try-catch clause opens up the file and reads each line in the file into a string array called fields and splits the line into different fields. 
		// Then it assigns the type, amount, and category of each transaction into its designated variable. It creates an instance of a Transaction then and adds that transaction to the ArrayList.
		try (Scanner inputFile = new Scanner(new File(fileName)))
		{
			while (inputFile.hasNextLine())
			{
				String line = inputFile.nextLine();
				String[] fields = line.split(",");
				String type = fields[0];
				double amount = Double.parseDouble(fields[1]);
				String category = fields[2];
				transactions.add(new Transaction(amount, category, type));
			}
			System.out.println("Successfully loaded data from " + fileName);
		}
		// The catch is in case an error happens when trying to load data from this file.
		catch (IOException ex)
		{
			System.out.println("Error: error with loading " + fileName);
		}
	}
}