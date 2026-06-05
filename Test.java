/**
 * Test class for the Tool Hire application.
 *
 * @author Ghazlan Matar
 * @version 18 April 2026
 */
public class Test
{   
    public Test()
    {
        // Part 1 testing
        // Shop myShop = new Shop();
        // ElectricTool tool1 = new ElectricTool();
        // myShop.storeTool(tool1);
        // myShop.printAllDetails();

        // Part 2 testing
        // Shop myShop2 = new Shop();
        // myShop2.readToolData();
        // myShop2.printAllDetails();

        // Part 3 testing
        // Shop myShop3 = new Shop();
        // myShop3.readCustomerData();
        // myShop3.printAllCustomers();

        // Part 3 testing
        // Shop myShop4 = new Shop();
        // myShop4.readToolData();
        // myShop4.printAllDetails();
        // myShop4.readCustomerData();
        // myShop4.printAllCustomers();
        // myShop4.writeCustomerData();

        // Part 4 Step 1 testing - DateUtil
        // DateUtil class is already in the project
        // Calling convertStringToDate("25-03-2023") and calling convertStringToDate("30-03-2023")
        // Then calling daysBetween() with two dates to test

        // Part 4 Step 2 & 3 testing - reservations and diary
        Shop myShop = new Shop();
        myShop.readToolData();       // selecting items_all.txt
        myShop.printAllDetails();
        myShop.readCustomerData();   // selecting customer_data.txt
        myShop.printAllCustomers();

        // printing all reservations
        myShop.printItemReservations();

        // printing diary entries for a date range
        // myShop.printDiaryEntries("25-03-2023", "30-03-2023");

        // writing and reading back reservations
        // myShop.writeItemReservationData();
        // myShop.readItemReservationData();

        // deleting a reservation
        // myShop.deleteItemReservation("000001");

        // printing diary again to confirm deletion
        // myShop.printDiaryEntries("25-03-2023", "30-03-2023");
    }
}