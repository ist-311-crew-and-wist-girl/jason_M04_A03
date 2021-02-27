package main;

// Import local packages
import org.bson.Document;
import useraccount.ActorUser;
import useraccount.BusinessUser;
import utils.ConnectDB;
import utils.GetPublicIP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Junit test class to verify that my three classes are functioning properly!
 * @author Jason C. Nucciarone
 *
 */
public class MainTest {
    /* Verify the GetPublicIP class can correctly identify my computer's public IP address. */
    @Test
    void verifyCorrectIP() throws Exception {
        String MyIPHardcoded = "174.54.69.159";
        String AcquiredIP = GetPublicIP.getPublicIPAddress();
        Assertions.assertEquals(MyIPHardcoded, AcquiredIP);
    }

    /* Verify the ConnectDB can successfully find my MongoDB instance */
    @Test
    void checkConnection() {
        ConnectDB.getConnection();
    }

    /* Verify that ActorUser class can correctly identify my location.
    *  Specifically looking for latitude and longitude. */
    @Test
    void verifyCorrectLocation() {
        ArrayList<Double> MyCurrentLocation = new ArrayList<>();
        MyCurrentLocation.add(40.7957);
        MyCurrentLocation.add(-77.8618);

        // Create instance of ActorUser
        String firstname = "Jason";
        String lastname = "Nucciarone";
        String username = "guccinucci";
        String phonenumber = "814-867-5309";
        String email = "jcn23@psu.edu";
        String address = "167 Some Lane, Penn State, 16801";
        try {
            ActorUser jason = new ActorUser(firstname, lastname, username, phonenumber, email, address);
            // Location grabbed when Account is first created
            ArrayList<Double> ApproximatedLocation = jason.getLocation();

            // Location grabbed when specifically called from function
            ArrayList<Double> ApproximatedLocation2 = jason.GetUserLocation();

            // Assertions
            Assertions.assertEquals(MyCurrentLocation, ApproximatedLocation);
            Assertions.assertEquals(MyCurrentLocation, ApproximatedLocation2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Check that important setters and getters are working properly. */
    @Test
    public void checkSettersAndGetters() {
        // Create regular user
        String firstname = "Jason";
        String lastname = "Nucciarone";
        String username = "guccinucci";
        String phonenumber = "814-867-5309";
        String email = "jcn23@psu.edu";
        String address = "167 Some Lane, Penn State, 16801";
        try {
            ActorUser jason = new ActorUser(firstname, lastname, username, phonenumber, email, address);
            Assertions.assertEquals(firstname, jason.getFirstName());
            Assertions.assertEquals(lastname, jason.getLastName());
            Assertions.assertEquals(username, jason.getUserName());
            Assertions.assertEquals(phonenumber, jason.getPhoneNumber());
            Assertions.assertEquals(email, jason.getEmail());
            Assertions.assertEquals(address, jason.getAddress());

            // Create a new slew of values

            String firstname_new = "Kayla";
            String lastname_new = "Arujo";
            String username_new = "Kaj";
            String phonenumber_new = "123-456-7890";
            String email_new = "kayla.arujo@gmail.com";
            String address_new = "217 Somewhere, Ohio State, 17845";

            jason.setFirstName(firstname_new);
            jason.setLastName(lastname_new);
            jason.setUserName(username_new);
            jason.setPhoneNumber(phonenumber_new);
            jason.setEmail(email_new);
            jason.setAddress(address_new);

            Assertions.assertEquals(firstname_new, jason.getFirstName());
            Assertions.assertEquals(lastname_new, jason.getLastName());
            Assertions.assertEquals(username_new, jason.getUserName());
            Assertions.assertEquals(phonenumber_new, jason.getPhoneNumber());
            Assertions.assertEquals(email_new, jason.getEmail());
            Assertions.assertEquals(address_new, jason.getAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create business user
        String firstname2 = "Kyle";
        String lastname2 = "Montenucci";
        String username2 = "kmonster";
        String phonenumber2 = "814-802-9567";
        String email2 = "kzm1277@business.com";
        String address2 = "854 Neverland, Albert Ville, 26897";
        String businessname = "Kyle's Wares";
        String businessowner = "Kyle Montenucci";
        String businesslocation = "153 Neverland, Albert Ville, 26897";
        try {
            BusinessUser kyle = new BusinessUser(firstname2, lastname2, username2, phonenumber2, email2,
                    address2, businessname, businessowner, businesslocation);
            Assertions.assertEquals(firstname2, kyle.getFirstName());
            Assertions.assertEquals(lastname2, kyle.getLastName());
            Assertions.assertEquals(username2, kyle.getUserName());
            Assertions.assertEquals(phonenumber2, kyle.getPhoneNumber());
            Assertions.assertEquals(email2, kyle.getEmail());
            Assertions.assertEquals(address2, kyle.getAddress());
            Assertions.assertEquals(businessname, kyle.getBusinessName());
            Assertions.assertEquals(businessowner, kyle.getBusinessOwner());
            Assertions.assertEquals(businesslocation, kyle.getBusinessLocation());

            // Create a new slew of values
            String firstname2_new = "Abby";
            String lastname2_new = "Centerfield";
            String username2_new = "abby24";
            String phonenumber2_new = "967-321-4256";
            String email2_new = "abby.centerfield@abbysgoods.com";
            String address2_new = "619 Neverland, Albert Ville, 26897";
            String businessname_new = "Abby's Goods";
            String businessowner_new = "Abby Centerfield";
            String businesslocation_new = "152 Neverland, Albert Ville, 26897";

            kyle.setFirstName(firstname2_new);
            kyle.setLastName(lastname2_new);
            kyle.setUserName(username2_new);
            kyle.setPhoneNumber(phonenumber2_new);
            kyle.setEmail(email2_new);
            kyle.setAddress(address2_new);
            kyle.setBusinessName(businessname_new);
            kyle.setBusinessOwner(businessowner_new);
            kyle.setBusinessLocation(businesslocation_new);

            Assertions.assertEquals(firstname2_new, kyle.getFirstName());
            Assertions.assertEquals(lastname2_new, kyle.getLastName());
            Assertions.assertEquals(username2_new, kyle.getUserName());
            Assertions.assertEquals(phonenumber2_new, kyle.getPhoneNumber());
            Assertions.assertEquals(email2_new, kyle.getEmail());
            Assertions.assertEquals(address2_new, kyle.getAddress());
            Assertions.assertEquals(businessname_new, kyle.getBusinessName());
            Assertions.assertEquals(businessowner_new, kyle.getBusinessOwner());
            Assertions.assertEquals(businesslocation_new, kyle.getBusinessLocation());

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /* Check that the important database functions are working properly */
    @Test
    public void checkDatabaseFunctions(){
        // Create regular user
        String firstname = "Jason";
        String lastname = "Nucciarone";
        String username = "guccinucci";
        String phonenumber = "814-867-5309";
        String email = "jcn23@psu.edu";
        String address = "167 Some Lane, Penn State, 16801";

        // Create business user
        String firstname2 = "Kyle";
        String lastname2 = "Montenucci";
        String username2 = "kmonster";
        String phonenumber2 = "814-802-9567";
        String email2 = "kzm1277@business.com";
        String address2 = "854 Neverland, Albert Ville, 26897";
        String businessname = "Kyle's Wares";
        String businessowner = "Kyle Montenucci";
        String businesslocation = "153 Neverland, Albert Ville, 26897";

        try {
            ActorUser regular_user = new ActorUser(firstname, lastname, username, phonenumber, email, address);
            BusinessUser business_user = new BusinessUser(firstname2, lastname2, username2, phonenumber2, email2,
                    address2, businessname, businessowner, businesslocation);

            // Create accounts
            regular_user.CreateAccount();
            business_user.CreateAccount();

            Document doc1 = regular_user.RetrieveAccountByUserId();
            Document doc2 = regular_user.RetrieveAccountByUserName();
            Document doc3 = business_user.RetrieveAccountByUserId();
            Document doc4 = business_user.RetrieveAccountByUserName();

            System.out.println(doc1);
            System.out.println(doc2);
            System.out.println(doc3);
            System.out.println(doc4);

            Assertions.assertEquals(doc1, doc2);
            Assertions.assertEquals(doc3, doc4);

            // Update first names
            String firstname_new = "Kayla";
            String firstname2_new = "Abby";
            regular_user.setFirstName(firstname_new);
            business_user.setFirstName(firstname2_new);
            regular_user.UpdateFirstName();
            business_user.UpdateFirstName();

            // Update last names
            String lastname_new = "Arujo";
            String lastname2_new = "Centerfield";
            regular_user.setLastName(lastname_new);
            business_user.setLastName(lastname2_new);
            regular_user.UpdateLastName();
            business_user.UpdateLastName();

            // Update user names
            String username_new = "Kaj";
            String username2_new = "abby24";
            regular_user.setUserName(username_new);
            business_user.setUserName(username2_new);
            regular_user.UpdateUserName();
            business_user.UpdateUserName();

            // Update phone numbers
            String phonenumber_new = "123-456-7890";
            String phonenumber2_new = "967-321-4256";
            regular_user.setPhoneNumber(phonenumber_new);
            business_user.setPhoneNumber(phonenumber2_new);
            regular_user.UpdatePhoneNumber();
            business_user.UpdatePhoneNumber();

            // Update emails
            String email_new = "kayla.arujo@gmail.com";
            String email2_new = "abby.centerfield@abbysgoods.com";
            regular_user.setEmail(email_new);
            business_user.setEmail(email2_new);
            regular_user.UpdateEmail();
            business_user.UpdateEmail();

            // Update addresses
            String address_new = "217 Somewhere, Ohio State, 17845";
            String address2_new = "619 Neverland, Albert Ville, 26897";
            regular_user.setAddress(address_new);
            business_user.setAddress(address2_new);
            regular_user.UpdateAddress();
            business_user.UpdateAddress();

            // Update business name
            String businessname_new = "Abby's Goods";
            business_user.setBusinessName(businessname_new);
            business_user.UpdateBusinessName();

            // Update business owner
            String businessowner_new = "Abby Centerfield";
            business_user.setBusinessOwner(businessowner_new);
            business_user.UpdateBusinessOwner();

            // Update business location
            String businesslocation_new = "152 Neverland, Albert Ville, 26897";
            business_user.setBusinessLocation(businesslocation_new);
            business_user.UpdateBusinessLocation();

            // Test retrieval methods
            Document doc5 = regular_user.RetrieveAccountByUserId();
            Document doc6 = regular_user.RetrieveAccountByUserName();
            Document doc7 = business_user.RetrieveAccountByUserId();
            Document doc8 = business_user.RetrieveAccountByUserName();

            System.out.println(doc5);
            System.out.println(doc6);
            System.out.println(doc7);
            System.out.println(doc8);

            Assertions.assertEquals(doc5, doc6);
            Assertions.assertEquals(doc7, doc8);

            // Delete accounts
            regular_user.DeleteAccount();
            business_user.DeleteAccount();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /* Check that write business safety posting is functioning properly */
    @Test
    public void checkWriteSafetyPosting(){
        // Create business account
        String firstname2 = "Kyle";
        String lastname2 = "Montenucci";
        String username2 = "kmonster";
        String phonenumber2 = "814-802-9567";
        String email2 = "kzm1277@business.com";
        String address2 = "854 Neverland, Albert Ville, 26897";
        String businessname = "Kyle's Wares";
        String businessowner = "Kyle Montenucci";
        String businesslocation = "153 Neverland, Albert Ville, 26897";

        try {
            BusinessUser business_user = new BusinessUser(firstname2, lastname2, username2, phonenumber2, email2,
                    address2, businessname, businessowner, businesslocation);

            // Write very rough safety posting
            String safety_posting = "My business follows all the guidelines. Forgot your mask? " +
                    "We'll provide you with one for absolutely no extra charge!";
            business_user.writeSafetyPosting(safety_posting);

            Assertions.assertEquals(safety_posting, business_user.getSafetyPosting());

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
