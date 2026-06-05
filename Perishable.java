import java.util.Scanner;

/**
 * Perishable represents a perishable accessory item e.g. cleaning liquids.
 * Extends Accessory by adding isIrritant, useByDate and volume.
 *
 * @author Ghazlan Matar
 * @version 17 March 2026
 */
public class Perishable extends Accessory
{
    private boolean isIrritant;
    private String useByDate;
    private int volume;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public Perishable()
    {
        super();
        isIrritant = false;
        useByDate = "";
        volume = 0;
    }

    /**
     * Returns whether this item is an irritant.
     * @return true if irritant, false otherwise
     */
    public boolean isIrritant()
    { 
        return isIrritant; 
    }
    
    /**
     * Returns the use by date of this item.
     * @return the use by date as a String
     */
    public String getUseByDate()
    { 
        return useByDate; 
    }
    
    /**
     * Returns the volume of this item in millilitres.
     * @return the volume
     */
    public int getVolume()
    { 
        return volume; 
    }

    /**
     * Sets whether this item is an irritant.
     * @param isIrritant true if irritant, false otherwise
     */
    public void setIrritant(boolean isIrritant)
    { 
        this.isIrritant = isIrritant; 
    }

    /**
     * Sets the use by date of this item.
     * @param useByDate the use by date to set
     */
    public void setUseByDate(String useByDate)
    { 
        this.useByDate = useByDate; 
    }

    /**
     * Sets the volume of this item.
     * @param volume the volume to set
     */
    public void setVolume(int volume)
    { 
        this.volume = volume; 
    }
    
    /**
     * Reads Perishable fields from the scanner.
     * Calls super.readData() for isRecyclable and ShopItem fields first, then reads isIrritant, useByDate and volume.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        isIrritant = Boolean.parseBoolean(scanner.next().trim());
        useByDate = scanner.next().trim();
        volume = Integer.parseInt(scanner.next().trim());
    }

    /**
     * Prints Perishable details, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        String irritantStatus;
        if (isIrritant)
        {
            irritantStatus = "yes";
        }
        else
        {
            irritantStatus = "no";
        }
        System.out.println("irritant: " + irritantStatus + "; useByDate: " + useByDate + "; volume: " + volume);
    }
}