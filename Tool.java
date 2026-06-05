import java.util.Scanner;

/**
 * Represents a tool available for hire in the Tool Hire shop.
 * Abstract superclass for ElectricTool and HandTool.
 * Holds fields common to all tools: timesBorrowed, onLoan and weight.
 *
 * @author Ghazlan Matar
 * @version 14 March 2026
 */
public abstract class Tool extends ShopItem
{
    private int timesBorrowed;
    private boolean onLoan;
    private int weight;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public Tool()
    {
        super();
        timesBorrowed = 0;
        onLoan = false;
        weight = 0;
    }

    /**
     * Returns the number of times this tool has been borrowed.
     * @return the number of times borrowed
     */
    public int getTimesBorrowed()
    { 
        return timesBorrowed;
    }
    
    /**
     * Returns whether this tool is currently on loan.
     * @return true if on loan, false otherwise
     */
    public boolean isOnLoan()
    { 
        return onLoan; 
    }
    
    /**
     * Returns the weight of this tool in grammes.
     * @return the weight in grammes
     */
    public int getWeight()
    { 
        return weight; 
    }

    /**
     * Sets the number of times this tool has been borrowed.
     * @param timesBorrowed the number of times borrowed to set
     */
    public void setTimesBorrowed(int timesBorrowed)
    { 
        this.timesBorrowed = timesBorrowed;
    }
    
    /**
     * Sets whether this tool is currently on loan.
     * @param onLoan true if on loan, false otherwise
     */
    public void setOnLoan(boolean onLoan)
    { 
        this.onLoan = onLoan; 
    }
    
    /**
     * Sets the weight of this tool.
     * @param weight the weight in grammes to set
     */
    public void setWeight(int weight)
    { 
        this.weight = weight; 
    }

    /**
     * Reads Tool fields from the scanner.
     * Calls super.readData() for ShopItem fields first, then reads timesBorrowed, onLoan and weight.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        timesBorrowed = Integer.parseInt(scanner.next().trim());
        onLoan = Boolean.parseBoolean(scanner.next().trim());
        weight = Integer.parseInt(scanner.next().trim());
    }

    /**
     * Prints Tool fields, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        String loanStatus;
        if (onLoan)
        {
            loanStatus = "yes";
        }
        else
        {
            loanStatus = "no";
        }
        System.out.println("timesBorrowed: " + timesBorrowed + "; onLoan: " + loanStatus + "; weight: " + weight);
    }
}