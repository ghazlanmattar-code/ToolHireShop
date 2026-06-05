import java.util.Scanner;

/**
 * ElectricTool represents an electric hireable tool.
 * Extends Tool by adding rechargeable and power fields.
 *
 * @author Ghazlan Matar
 * @version 14 March 2026
 */
public class ElectricTool extends Tool
{
    private boolean rechargeable;
    private String power;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public ElectricTool()
    {
        super();
        rechargeable = false;
        power = "";
    }

    /**
     * Returns whether this tool is rechargeable.
     * @return true if rechargeable, false otherwise
     */
    public boolean isRechargeable()
    { 
        return rechargeable; 
    }
    
    /**
     * Returns the power of this tool e.g. 18V or 1350W.
     * @return the power as a String
     */
    public String getPower()
    { 
        return power; 
    }

    /**
     * Sets whether this tool is rechargeable.
     * @param rechargeable true if rechargeable, false otherwise
     */
    public void setRechargeable(boolean rechargeable)
    { 
        this.rechargeable = rechargeable; 
    }
    
    /**
     * Sets the power of this tool.
     * @param power the power to set e.g. 18V or 1350W
     */
    public void setPower(String power)
    { 
        this.power = power; 
    }

    /**
     * Reads ElectricTool fields from the scanner.
     * Calls super.readData() for ShopItem and Tool fields first, then reads rechargeable and power.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        super.readData(scanner);
        rechargeable = Boolean.parseBoolean(scanner.next().trim());
        power = scanner.next().trim();
    }

    /**
     * Prints ElectricTool details, calling super.printDetails() first.
     */
    public void printDetails()
    {
        super.printDetails();
        String rechargeStatus;
        if (rechargeable)
        {
            rechargeStatus = "yes";
        }
        else
        {
            rechargeStatus = "no";
        }
        System.out.println("rechargeable: " + rechargeStatus + "; power: " + power);
    }
}