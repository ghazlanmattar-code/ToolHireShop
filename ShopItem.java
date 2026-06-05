import java.util.Scanner;

/**
 * ShopItem is the abstract superclass for all items in the shop.
 * Holds fields common to every item: itemName, itemCode and cost.
 *
 * @author Ghazlan Matar
 * @version 16 March 2026
 */
public abstract class ShopItem
{
    private String itemName;
    private String itemCode;
    private int cost;

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public ShopItem()
    {
        itemName = "";
        itemCode = "";
        cost = 0;
    }

    /**
     * Returns the name of this item.
     * @return the item name
     */
    public String getItemName()
    { 
        return itemName; 
    }
    
    /**
     * Returns the code of this item.
     * @return the item code
     */
    public String getItemCode()
    { 
        return itemCode; 
    }

    /**
     * Returns the cost of this item.
     * @return the cost in pence
     */
    public int getCost()
    { 
        return cost; 
    }

    /**
     * Sets the name of this item.
     * @param itemName the item name to set
     */
    public void setItemName(String itemName)
    { 
        this.itemName = itemName; 
    }
    
    /**
     * Sets the code of this item.
     * @param itemCode the item code to set
     */
    public void setItemCode(String itemCode)
    { 
        this.itemCode = itemCode; 
    }
    
    /**
     * Sets the cost of this item.
     * @param cost the cost to set
     */
    public void setCost(int cost)
    { 
        this.cost = cost; 
    }

    /**
     * Reads itemName, itemCode and cost from the scanner.
     * Subclasses call super.readData(scanner) then read their own fields.
     *
     * @param scanner a Scanner using delimiter \s*,\s*
     */
    public void readData(Scanner scanner)
    {
        itemName = scanner.next().trim();
        itemCode = scanner.next().trim();
        cost = Integer.parseInt(scanner.next().trim());
    }

    /**
     * Prints the common fields of this shop item.
     * Subclasses call super.printDetails() then print their own fields.
     */
    public void printDetails()
    {
        System.out.println("Item name: " + itemName + "; code: " + itemCode + "; cost: " + cost);
    }
}