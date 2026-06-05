import java.util.Scanner;

/**
 * HandTool represents a hand tool available for hire.
 * Extends Tool by adding the sharpenable field.
 *
 * @author Ghazlan Matar
 * @version 14 March 2026
 */
public class HandTool extends Tool
{
    private boolean sharpenable;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public HandTool()
    {
        super();
        sharpenable = false;
    }

    /**
     * Returns whether this tool can be sharpened.
     * @return true if sharpenable, false otherwise
     */
    public boolean isSharpenable()
    { 
        return sharpenable; 
    }
    
    /**
     * Sets whether this tool can be sharpened.
     * @param sharpenable true if sharpenable, false otherwise
     */
    public void setSharpenable(boolean sharpenable)
    { 
        this.sharpenable = sharpenable; 
    }

    /**
     * Reads HandTool fields from the scanner.
     * Calls super.readData() for ShopItem and Tool fields first, then reads sharpenable.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        sharpenable = Boolean.parseBoolean(scanner.next().trim());
    }

    /**
     * Prints HandTool details, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        String sharpenStatus;
        if (sharpenable)
        {
            sharpenStatus = "yes";
        }
        else
        {
            sharpenStatus = "no";
        }
        System.out.println("sharpenable: " + sharpenStatus);
    }
}