import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.FileDialog;
import java.util.Date;

/**
 * Represents the Tool Hire shop.
 * Maintains maps of ShopItem, Customer and ShopItemReservation objects,
 * reads and writes data from/to user-selected text files.
 *
 * @author Ghazlan Matar
 * @version 15 April 2026
 */
public class Shop
{
    // private ArrayList<ShopItem> toolList;
    // private List<ShopItem> toolList;
    // private List<Customer> customerList;

    private Map<String, ShopItem> itemsMap;
    private Map<String, Customer> customerMap;
    private Random randomGenerator;
    private Map<String, ShopItemReservation> itemReservationMap;
    private int reservationCounter;
    private Diary diary;

    /**
     * Creates an empty Shop with empty item, customer and reservation stores.
     */
    public Shop()
    {
        // toolList = new ArrayList<ShopItem>();
        itemsMap    = new HashMap<String, ShopItem>();
        customerMap = new HashMap<String, Customer>();
        randomGenerator = new Random();
        itemReservationMap = new HashMap<String, ShopItemReservation>();
        reservationCounter = 0;
        diary = new Diary();
    }

    /**
     * Adds a ShopItem to the item store.
     *
     * @param item the ShopItem to add
     */
    public void storeTool(ShopItem item)
    {
        itemsMap.put(item.getItemCode(), item);
    }

    /**
     * Prints details of every item currently stored.
     * Message is printed if the store is empty.
     */
    public void printAllDetails()
    {
        if (itemsMap.isEmpty())
        {
            System.out.println("No tools currently stored.");
            return;
        }
        System.out.println("Tool List (" + itemsMap.size() + " item(s))");
        for (ShopItem item : itemsMap.values())
        {
            item.printDetails();
            System.out.println();
        }
    }

    /**
     * Reads shop item data from a user-selected text file.
     * A FileDialog is used to select the file.
     */
    public void readToolData()
    {
        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Open", FileDialog.LOAD);
        fileDialog.setDirectory(System.getProperty("user.dir"));
        fileDialog.setVisible(true);

        String filename  = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        System.out.println(filename);

        try
        {
            File dataFile = new File(directory, filename);
            Scanner fileScanner = new Scanner(dataFile);

            String typeOfData = "";

            while (fileScanner.hasNextLine())
            {
                String lineOfText = fileScanner.nextLine().trim();

                if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                {
                    // skip blank lines and comments
                }
                else if (lineOfText.startsWith("["))
                {
                    typeOfData = lineOfText.toLowerCase();
                }
                else
                {
                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter("\\s*,\\s*");

                    if (typeOfData.contains("electrictool"))
                    {
                        ElectricTool tool = new ElectricTool();
                        tool.readData(lineScanner);
                        storeTool(tool);
                    }
                    else if (typeOfData.contains("handtool"))
                    {
                        HandTool tool = new HandTool();
                        tool.readData(lineScanner);
                        storeTool(tool);
                    }
                    else if (typeOfData.contains("perishable"))
                    {
                        Perishable item = new Perishable();
                        item.readData(lineScanner);
                        storeTool(item);
                    }
                    else if (typeOfData.contains("workwear"))
                    {
                        Workwear item = new Workwear();
                        item.readData(lineScanner);
                        storeTool(item);
                    }
                    else
                    {
                        System.out.println("Warning: unknown data type '" + typeOfData + "' - line skipped: " + lineOfText);
                    }
                }
            }

            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // public ArrayList<ShopItem> getToolList()
    // {
    //     return toolList;
    // }

    /**
     * Adds a Customer to the customer store.
     * If the customer's ID is "unknown", a new unique ID is generated before storing.
     *
     * @param customer the Customer to add
     */
    public void storeCustomer(Customer customer)
    {
        if (customer.getCustomerID().equals("unknown"))
        {
            String newID = generateCustomerID("AB-", 6);
            customer.setCustomerID(newID);
        }

        customerMap.put(customer.getCustomerID(), customer);
    }

    /**
     * Prints details of every customer currently stored.
     */
    public void printAllCustomers()
    {
        if (customerMap.isEmpty())
        {
            System.out.println("No customers currently stored.");
            return;
        }
        System.out.println("Customer List (" + customerMap.size() + " customer(s))");
        for (Customer customer : customerMap.values())
        {
            customer.printDetails();
        }
    }

    /**
     * Reads customer data from a user-selected text file via FileDialog.
     */
    public void readCustomerData()
    {
        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Open", FileDialog.LOAD);
        fileDialog.setDirectory(System.getProperty("user.dir"));
        fileDialog.setVisible(true);

        String filename  = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        System.out.println(filename);

        try
        {
            File dataFile = new File(directory, filename);
            Scanner fileScanner = new Scanner(dataFile);

            while (fileScanner.hasNextLine())
            {
                String lineOfText = fileScanner.nextLine().trim();

                if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                {
                    // skip blank lines and comments
                }
                else
                {
                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter("\\s*,\\s*");

                    Customer customer = new Customer();
                    customer.readData(lineScanner);
                    storeCustomer(customer);
                }
            }

            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Writes all customer data to a user-selected text file via FileDialog, in a format similar to customer_data.txt.
     */
    public void writeCustomerData()
    {
        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Save As", FileDialog.SAVE);
        fileDialog.setDirectory(System.getProperty("user.dir"));
        fileDialog.setVisible(true);

        String filename  = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (filename == null)
        {
            System.out.println("No file selected.");
            return;
        }

        try
        {
            PrintWriter pWriter = new PrintWriter(directory + filename);

            for (Customer customer : customerMap.values())
            {
                customer.writeData(pWriter);
            }

            pWriter.close();
            System.out.println("Customer data written to " + filename);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Generates a unique customer ID consisting of a prefix followed by a random number with the specified number of digits.
     * Checks that the generated ID is not already in use.
     *
     * @param prefix the prefix for the ID
     * @param numDigits the number of random digits to append
     * @return a unique customer ID string
     */
    public String generateCustomerID(String prefix, int numDigits)
    {
        int upperBound = 1;
        for (int i = 0; i < numDigits; i++)
        {
            upperBound = upperBound * 10;
        }

        String newID = prefix + randomGenerator.nextInt(upperBound);

        while (customerMap.containsKey(newID))
        {
            newID = prefix + randomGenerator.nextInt(upperBound);
        }

        return newID;
    }

    /**
     * Returns the ShopItem corresponding to the given item code, or null if no such item exists.
     *
     * @param itemCode the item code to search for
     * @return the corresponding ShopItem or null
     */
    public ShopItem getItem(String itemCode)
    {
        return itemsMap.get(itemCode);
    }

    /**
     * Returns the Customer corresponding to the given customer ID, or null if no such customer exists.
     *
     * @param customerID the customer ID to search for
     * @return the corresponding Customer or null
     */
    public Customer getCustomer(String customerID)
    {
        return customerMap.get(customerID);
    }

    /**
     * Returns the map of all items stored in the shop.
     * @return the itemsMap
     */
    public Map<String, ShopItem> getItemsMap()
    {
        return itemsMap;
    }

    /**
     * Returns the map of all customers stored in the shop.
     * @return the customerMap
     */
    public Map<String, Customer> getCustomerMap()
    {
        return customerMap;
    }

    /**
     * Adds a ShopItemReservation to the reservation store and the diary.
     *
     * @param reservation the ShopItemReservation to add
     */
    public void storeItemReservation(ShopItemReservation reservation)
    {
        itemReservationMap.put(reservation.getReservationNo(), reservation);
        diary.addReservation(reservation);
    }

    /**
     * Generates a unique sequential reservation number padded with zeros to produce six digits.
     *
     * @return a unique reservation number String
     */
    public String generateReservationNo()
    {
        reservationCounter++;
        String number = Integer.toString(reservationCounter);
        while (number.length() < 6)
        {
            number = "0" + number;
        }
        return number;
    }

    /**
     * Returns the ShopItemReservation corresponding to the given reservation number, or null if no such reservation exists.
     *
     * @param reservationNo the reservation number to search for
     * @return the corresponding ShopItemReservation or null
     */
    public ShopItemReservation getItemReservation(String reservationNo)
    {
        return itemReservationMap.get(reservationNo);
    }

    /**
     * Attempts to make a reservation for a customer.
     * Validates all parameters before creating the reservation.
     *
     * @param customerID the ID of the customer
     * @param itemID the ID of the shop item
     * @param startDate the start date as a String
     * @param noOfDays the number of days for the reservation
     * @return true if reservation was successful, false otherwise
     */
    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays)
    {
        if (!customerMap.containsKey(customerID))
        {
            System.out.println("Error: customer ID '" + customerID + "' not found.");
            return false;
        }

        if (!itemsMap.containsKey(itemID))
        {
            System.out.println("Error: item ID '" + itemID + "' not found.");
            return false;
        }

        if (!DateUtil.isValidDateString(startDate))
        {
            System.out.println("Error: start date '" + startDate + "' is not valid.");
            return false;
        }

        if (noOfDays <= 0)
        {
            System.out.println("Error: number of days must be greater than zero.");
            return false;
        }

        Date checkDate = DateUtil.convertStringToDate(startDate);
        for (int day = 0; day < noOfDays; day++)
        {
            ShopItemReservation[] reservations = diary.getReservations(checkDate);
            if (reservations != null)
            {
                for (ShopItemReservation existing : reservations)
                {
                    if (existing.getItemID().equals(itemID))
                    {
                        System.out.println("Error: item '" + itemID + "' is already reserved on " + DateUtil.convertDateToShortString(checkDate));
                        return false;
                    }
                }
            }
            checkDate = DateUtil.nextDate(checkDate);
        }

        String reservationNo = generateReservationNo();
        ShopItemReservation reservation = new ShopItemReservation(reservationNo, itemID, customerID, startDate, noOfDays);
        storeItemReservation(reservation);

        System.out.println("Reservation " + reservationNo + " created successfully.");
        return true;
    }

    /**
     * Prints details of all reservations currently stored.
     */
    public void printItemReservations()
    {
        if (itemReservationMap.isEmpty())
        {
            System.out.println("No reservations currently stored.");
            return;
        }
        System.out.println("Reservation List (" + itemReservationMap.size() + " reservation(s))");
        for (ShopItemReservation reservation : itemReservationMap.values())
        {
            reservation.printDetails();
        }
    }

    /**
     * Writes all reservation data to a user-selected text file via FileDialog.
     */
    public void writeItemReservationData()
    {
        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Save As", FileDialog.SAVE);
        fileDialog.setDirectory(System.getProperty("user.dir"));
        fileDialog.setVisible(true);

        String filename  = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (filename == null)
        {
            System.out.println("No file selected.");
            return;
        }

        try
        {
            PrintWriter pWriter = new PrintWriter(directory + filename);

            for (ShopItemReservation reservation : itemReservationMap.values())
            {
                reservation.writeData(pWriter);
            }

            pWriter.close();
            System.out.println("Reservation data written to " + filename);
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Reads reservation data from a user-selected text file via FileDialog.
     */
    public void readItemReservationData()
    {
        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Open", FileDialog.LOAD);
        fileDialog.setDirectory(System.getProperty("user.dir"));
        fileDialog.setVisible(true);

        String filename  = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        System.out.println(filename);

        try
        {
            File dataFile = new File(directory, filename);
            Scanner fileScanner = new Scanner(dataFile);

            while (fileScanner.hasNextLine())
            {
                String lineOfText = fileScanner.nextLine().trim();

                if (lineOfText.isEmpty() || lineOfText.startsWith("//"))
                {
                    // skip blank lines and comments
                }
                else
                {
                    Scanner lineScanner = new Scanner(lineOfText);
                    lineScanner.useDelimiter("\\s*,\\s*");

                    ShopItemReservation reservation = new ShopItemReservation();
                    reservation.readData(lineScanner);
                    storeItemReservation(reservation);
                }
            }

            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Prints diary entries for the specified date range.
     *
     * @param startDate the start date as a String
     * @param endDate the end date as a String
     */
    public void printDiaryEntries(String startDate, String endDate)
    {
        Date start = DateUtil.convertStringToDate(startDate);
        Date end = DateUtil.convertStringToDate(endDate);
        diary.printEntries(start, end);
    }

    /**
     * Deletes the reservation with the given reservation number from both the reservation map and the diary.
     *
     * @param reservationNo the reservation number to delete
     */
    public void deleteItemReservation(String reservationNo)
    {
        ShopItemReservation reservation = itemReservationMap.get(reservationNo);
        if (reservation == null)
        {
            System.out.println("Error: reservation '" + reservationNo + "' not found.");
            return;
        }
        diary.deleteReservation(reservation);
        itemReservationMap.remove(reservationNo);
        System.out.println("Reservation " + reservationNo + " deleted.");
    }
}