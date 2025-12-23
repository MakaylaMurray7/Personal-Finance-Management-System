import java.time.LocalDate;

public class Transaction
{
	private double amount;
	private String category;
	private LocalDate date;
	private String type;
	// This is the Constructor of the class and initializes all of the fields.
	public Transaction(double amount, String cat, String type)
	{
		this.amount = amount;
		category = cat;
		// This gets the current date and asigns it to date.
		this.date = LocalDate.now();
		this.type = type;
	}
	// These function return values.
	public double getAmount()
	{
        	return amount;
    	}
   	public String getCategory()
	{
        	return category;
    	}

    	public LocalDate getDate()
	{
        	return date;
    	}

    	public String getType()
	{
        	return type;
    	}
}