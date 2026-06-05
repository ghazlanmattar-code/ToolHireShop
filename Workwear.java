import java.util.Scanner;

/**
 * Workwear represents a workwear accessory item e.g. gloves, jackets.
 * Extends Accessory by adding manufacturingStandard, colour and size.
 *
 * @author Ghazlan Matar
 * @version 17 March 2026
 */
public class Workwear extends Accessory
{
    private String manufacturingStandard;
    private String colour;
    private String size;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public Workwear()
    {
        super();
        manufacturingStandard = "";
        colour = "";
        size = "";
    }

    /**
     * Returns the manufacturing standard of this item
     * @return the manufacturing standard
     */
    public String getManufacturingStandard()
    { 
        return manufacturingStandard; 
    }
    
    /**
     * Returns the colour of this item.
     * @return the colour
     */
    public String getColour()
    { 
        return colour; 
    }
    
    /**
     * Returns the size of this item e.g. S, M, L.
     * @return the size
     */
    public String getSize()
    { 
        return size; 
    }
    
    /**
     * Sets the manufacturing standard of this item.
     * @param manufacturingStandard the manufacturing standard to set
     */
    public void setManufacturingStandard(String manufacturingStandard)
    { 
        this.manufacturingStandard = manufacturingStandard; 
    }

    /**
     * Sets the colour of this item.
     * @param colour the colour to set
     */
    public void setColour(String colour)
    { 
        this.colour = colour; 
    }

    /**
     * Sets the size of this item.
     * @param size the size to set
     */
    public void setSize(String size)
    { 
        this.size = size; 
    }

    /**
     * Reads Workwear fields from the scanner.
     * Calls super.readData() for isRecyclable and ShopItem fields first, then reads manufacturingStandard, colour and size.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        manufacturingStandard = scanner.next().trim();
        colour = scanner.next().trim();
        size = scanner.next().trim();
    }

    /**
     * Prints Workwear details, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        System.out.println("standard: " + manufacturingStandard + "; colour: " + colour + "; size: " + size);
    }
}