import java.util.Date;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Represents a reservation of a shop item by a customer.
 * Stores the reservation number, item ID, customer ID, start date and number of days for the reservation.
 *
 * @author Ghazlan Matar
 * @version 15 April 2026
 */
public class ShopItemReservation
{
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;

    /**
     * Constructor for a ShopItemReservation.
     * The startDate parameter is a String in the format dd-MM-yyyy which is converted to a Date object using DateUtil.
     *
     * @param reservationNo the unique reservation number e.g. "000001"
     * @param itemID the ID of the shop item being reserved
     * @param customerID the ID of the customer making the reservation
     * @param startDate the start date as a String e.g. "25-03-2023"
     * @param noOfDays the number of days for the reservation
     */
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays)
    {
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }

    /**
     * No-parameter constructor.
     * Initialises all fields to default values.
     */
    public ShopItemReservation()
    {
        reservationNo = "";
        itemID = "";
        customerID = "";
        startDate = null;
        noOfDays = 0;
    }

    /**
     * Returns the reservation number.
     * @return the reservation number
     */
    public String getReservationNo()
    { 
        return reservationNo; 
    }

    /**
     * Returns the item ID.
     * @return the item ID
     */
    public String getItemID()
    { 
        return itemID; 
    }

    /**
     * Returns the customer ID.
     * @return the customer ID
     */
    public String getCustomerID()
    { 
        return customerID; 
    }

    /**
     * Returns the start date of the reservation.
     * @return the start date as a Date object
     */
    public Date getStartDate()
    { 
        return startDate; 
    }

    /**
     * Returns the number of days for the reservation.
     * @return the number of days
     */
    public int getNoOfDays()
    { 
        return noOfDays; 
    }

    /**
     * Sets the reservation number.
     * @param reservationNo the reservation number to set
     */
    public void setReservationNo(String reservationNo)
    { 
        this.reservationNo = reservationNo; 
    }

    /**
     * Sets the item ID.
     * @param itemID the item ID to set
     */
    public void setItemID(String itemID)
    { 
        this.itemID = itemID; 
    }

    /**
     * Sets the customer ID.
     * @param customerID the customer ID to set
     */
    public void setCustomerID(String customerID)
    { 
        this.customerID = customerID; 
    }

    /**
     * Sets the start date from a String in the format dd-MM-yyyy.
     * @param startDate the start date as a String
     */
    public void setStartDate(String startDate)
    { 
        this.startDate = DateUtil.convertStringToDate(startDate); 
    }

    /**
     * Sets the number of days for the reservation.
     * @param noOfDays the number of days to set
     */
    public void setNoOfDays(int noOfDays)
    { 
        this.noOfDays = noOfDays; 
    }

    /**
     * Reads reservation data from the supplied Scanner.
     * Data order: reservationNo, itemID, customerID, startDate, noOfDays.
     *
     * @param scanner a Scanner using delimiter zero or more spaces, comma, zero or more spaces
     */
    public void readData(Scanner scanner)
    {
        reservationNo = scanner.next().trim();
        itemID = scanner.next().trim();
        customerID = scanner.next().trim();
        startDate = DateUtil.convertStringToDate(scanner.next().trim());
        noOfDays = Integer.parseInt(scanner.next().trim());
    }

    /**
     * Writes reservation data to the supplied PrintWriter in a format suitable for reading back in.
     *
     * @param pWriter the PrintWriter to write to
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(reservationNo + ", " + itemID + ", " + customerID + ", " + DateUtil.convertDateToShortString(startDate) + ", " + noOfDays);
    }

    /**
     * Prints full details of this reservation to the terminal window.
     */
    public void printDetails()
    {
        System.out.println("reservationNo: " + reservationNo + "; itemID: " + itemID + "; customerID: " 
                            + customerID + "; startDate: " + DateUtil.convertDateToShortString(startDate) + "; noOfDays: " + noOfDays);
    }

    /**
     * Returns a String representation of this reservation.
     * @return a String combining reservationNo, customerID and itemID
     */
    public String toString()
    {
        return "Reservation " + reservationNo + " (customer: " + customerID + ", item: " + itemID + ")";
    }
}