import java.util.Scanner;
import java.io.PrintWriter;

/**
 * Represents a customer of the Tool Hire shop.
 * Stores the customer's ID, surname, first name, other initials and title.
 *
 * @author Ghazlan Matar
 * @version 7 April 2026
 */
public class Customer
{
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    /**
     * Constructor that sets customerID to "unknown".
     * Used for new customers who have not yet been allocated an ID.
     *
     * @param surname the customer's surname
     * @param firstName the customer's first name
     * @param otherInitials the customer's other initials
     * @param title the customer's title e.g. Dr, Mr, Ms
     */
    public Customer(String surname, String firstName, String otherInitials, String title)
    {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }

    /**
     * No-parameter constructor.
     * Initialises all fields to empty strings.
     */
    public Customer()
    {
        customerID = "";
        surname = "";
        firstName = "";
        otherInitials = "";
        title = "";
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
     * Returns the customer's surname.
     * @return the surname
     */
    public String getSurname()
    { 
        return surname; 
    }

    /**
     * Returns the customer's first name.
     * @return the first name
     */
    public String getFirstName()
    { 
        return firstName; 
    }

    /**
     * Returns the customer's other initials.
     * @return the other initials
     */
    public String getOtherInitials()
    { 
        return otherInitials; 
    }

    /**
     * Returns the customer's title.
     * @return the title e.g. Dr, Mr, Ms
     */
    public String getTitle()
    { 
        return title; 
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
     * Sets the customer's surname.
     * @param surname the surname to set
     */
    public void setSurname(String surname)
    { 
        this.surname = surname; 
    }

    /**
     * Sets the customer's first name.
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName)
    { 
        this.firstName = firstName; 
    }

    /**
     * Sets the customer's other initials.
     * @param otherInitials the other initials to set
     */
    public void setOtherInitials(String otherInitials)
    { 
        this.otherInitials = otherInitials; 
    }

    /**
     * Sets the customer's title.
     * @param title the title to set
     */
    public void setTitle(String title)
    { 
        this.title = title; 
    }

    /**
     * Reads customer data from the supplied Scanner.
     * Data order: customerID, surname, firstName, otherInitials, title.
     *
     * @param scanner a Scanner using delimiter \\s*,\\s*
     */
    public void readData(Scanner scanner)
    {
        customerID = scanner.next().trim();
        surname = scanner.next().trim();
        firstName = scanner.next().trim();
        otherInitials = scanner.next().trim();
        title = scanner.next().trim();
    }

    /**
     * Writes customer data to the supplied PrintWriter in the same format as customer_data.txt.
     *
     * @param pWriter the PrintWriter to write to
     */
    public void writeData(PrintWriter pWriter)
    {
        pWriter.println(customerID + ", " + surname + ", " + firstName + ", " + otherInitials + ", " + title);
    }

    /**
     * Prints full details of this customer to the terminal window.
     */
    public void printDetails()
    {
        System.out.println("customerID: " + customerID + "; surname: " + surname + "; firstName: " + firstName + "; initials: " + otherInitials + "; title: " + title);
    }
}