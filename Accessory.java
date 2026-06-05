import java.util.Scanner;

/**
 * Accessory is the abstract superclass for shop items that are for sale only.
 * Extends ShopItem by adding the isRecyclable field.
 *
 * @author Ghazlan Matar
 * @version 16 March 2026
 */
public abstract class Accessory extends ShopItem
{
    private boolean isRecyclable;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public Accessory()
    {
        super();
        isRecyclable = false;
    }

    /**
     * Returns whether this item is recyclable.
     * @return true if recyclable, false otherwise
     */
    public boolean isRecyclable()
    { 
        return isRecyclable; 
    }

    /**
     * Sets whether this item is recyclable.
     * @param isRecyclable true if recyclable, false otherwise
     */
    public void setRecyclable(boolean isRecyclable)
    { 
        this.isRecyclable = isRecyclable; 
    }

    /**
     * Reads Accessory fields from the scanner.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        isRecyclable = Boolean.parseBoolean(scanner.next().trim());
        super.readData(scanner);
    }

    /**
     * Prints Accessory details, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        String recycleStatus;
        if (isRecyclable)
        {
            recycleStatus = "yes";
        }
        else
        {
            recycleStatus = "no";
        }
        System.out.println("recyclable: " + recycleStatus);
    }
}