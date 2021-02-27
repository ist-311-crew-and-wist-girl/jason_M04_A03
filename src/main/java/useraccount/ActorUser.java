package useraccount;

// Import local modules
import utils.GetPublicIP;

// Import necessary modules
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;

public class ActorUser extends Account {
    private final String DatabaseName = "ACCOUNTS";
    private final String CollectionName = "ACTOR_USER";
    private ArrayList<Double> location;
    private ArrayList<Document> history;
    private ArrayList<Document> bookmarks;
    private ArrayList<String> preferences;

    public ActorUser (String FirstName, String LastName, String UserName, String PhoneNumber,
                      String Email, String Address) throws Exception {
        // Call constructor of super class
        super(FirstName, LastName, UserName, PhoneNumber, Email, Address);
        this.location = GetUserLocation();
        this.history = new ArrayList<>();
        this.bookmarks = new ArrayList<>();
        this.preferences = new ArrayList<>();
    }

    // Setters and Getters
    public ArrayList<Double> getLocation() {
        return location;
    }

    public void UpdateUserLocation(ArrayList<Double> location) {
        this.location = location;
    }

    public ArrayList<String> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<String> preferences) {
        this.preferences = preferences;
    }

    public ArrayList<Document> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(ArrayList<Document> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public ArrayList<Document> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Document> history) {
        this.history = history;
    }

    @Override
    public void CreateAccount(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Create Document
            Document document = new Document("_id", getAccountId());

            // Append data to document
            document.append("userid", getAccountId());
            document.append("firstname", getFirstName());
            document.append("lastname", getLastName());
            document.append("username", getUserName());
            document.append("phonenumber", getPhoneNumber());
            document.append("email", getEmail());
            document.append("address", getAddress());
            document.append("history", "");
            document.append("bookmarks", "");
            document.append("preferences", "");
            document.append("account-creation-time", getTimestamp());

            // Add account to database
            table.insertOne(document);

        } catch (Exception e){
            String error = "Failed to create user account! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void DeleteAccount(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Delete document
            table.deleteOne(Filters.eq("userid", getAccountId()));

        } catch (Exception e){
            String error = "Failed to delete user's account! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdateFirstName(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's first name
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("firstname", getFirstName()));

        } catch (Exception e){
            String error = "Failed to update user's first name! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdateLastName(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's last name
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("lastname", getLastName()));

        } catch (Exception e){
            String error = "Failed to update user's last name! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdateUserName(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's user name
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("username", getUserName()));

        } catch (Exception e){
            String error = "Failed to update user's user name! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdatePhoneNumber(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's phone number
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("phonenumber",
                    getPhoneNumber()));

        } catch (Exception e){
            String error = "Failed to update user's phone number! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdateEmail(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's email
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("email", getEmail()));

        } catch (Exception e){
            String error = "Failed to update user's email! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public void UpdateAddress(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update user's address
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("address", getAddress()));

        } catch (Exception e){
            String error = "Failed to update user's address! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public Document RetrieveAccountByUserName(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Grab user's document in collection
            BasicDBObject query = new BasicDBObject("username", getUserName());
            try (MongoCursor<Document> cursor = table.find(query).iterator()){
                if (cursor.hasNext()){
                    return cursor.next();
                }
            }
            return null;

        } catch (Exception e){
            String error = "Failed to retrieve user's account! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    @Override
    public Document RetrieveAccountByUserId(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Grab user's document in collection
            BasicDBObject query = new BasicDBObject("userid", getAccountId());
            try (MongoCursor<Document> cursor = table.find(query).iterator()){
                if (cursor.hasNext()){
                    return cursor.next();
                }
            }
            return null;

        } catch (Exception e){
            String error = "Failed to retrieve user's account! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    public ArrayList<Double> GetUserLocation() throws Exception {
        // Get devices current IP address
        String IpAddress = GetPublicIP.getPublicIPAddress();
        String dbLocation = "D:\\git_projects_school\\geolite\\GeoLite2-City_20210223\\GeoLite2-City.mmdb";

        // Open connection to GeoLite database
        File database = new File(dbLocation);
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        InetAddress ip = InetAddress.getByName(IpAddress);

        // Query database
        CityResponse response = reader.city(ip);

        // Return array list with latitude and longitude
        ArrayList<Double> temp = new ArrayList<>();
        temp.add(response.getLocation().getLatitude());
        temp.add(response.getLocation().getLongitude());
        return temp;
    }
}
