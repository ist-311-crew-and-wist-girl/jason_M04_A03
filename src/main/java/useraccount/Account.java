package useraccount;

// Import necessary modules
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;

import utils.ConnectDB;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Abstract parent class for ActorUser and BusinessUser. Define getters and setters
 * as well as generate a Timestamp and get a Connection to the MongoDB instance.
 * @author Jason C. Nucciarone
 *
 */
public abstract class Account {
    private String FirstName;
    private String LastName;
    private String UserName;
    private String PhoneNumber;
    private String Email;
    private String Address;
    private MongoClient conn;
    private String timestamp;
    private String AccountId;

    public Account(String FirstName, String LastName, String UserName, String PhoneNumber,
                   String Email, String Address){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserName = UserName;
        this.PhoneNumber = PhoneNumber;
        this.Email = Email;
        this.Address = Address;

        // Not passed as parameters
        this.conn = ConnectDB.getConnection();

        // Generate timestamp to mark account creation
        Calendar calendar = Calendar.getInstance();
        Timestamp temp_timestamp = new Timestamp(calendar.getTime().getTime());
        this.timestamp = temp_timestamp.toString();

        // Generate AccountID
        this.AccountId = new ObjectId().toString();
    }

    // Getters and Setters for Account values
    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public MongoClient getConn() {
        return conn;
    }

    public void setConn(MongoClient conn) {
        this.conn = conn;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    // Declaring methods for children to override
    public abstract void CreateAccount();

    public abstract void DeleteAccount();

    public abstract void UpdateFirstName();

    public abstract void UpdateLastName();

    public abstract void UpdateUserName();

    public abstract void UpdatePhoneNumber();

    public abstract void UpdateEmail();

    public abstract void UpdateAddress();

    public abstract DBObject RetrieveAccountByUserName();

    public abstract DBObject RetrieveAccountByUserId();
}
