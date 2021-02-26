package useraccount;

// Import necessary modules
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class BusinessUser extends Account {
    private final String DatabaseName = "ACCOUNTS";
    private final String CollectionName = "BUSINESS_USER";
    private String BusinessName;
    private String BusinessOwner;
    private String BusinessLocation;
    private String SafetyPosting;

    public BusinessUser (String FirstName, String LastName, String UserName, String PhoneNumber,
                      String Email, String Address, String BusinessName, String BusinessOwner, String BusinessLocation){
        // Call constructor of super class
        super(FirstName, LastName, UserName, PhoneNumber, Email, Address);
        this.BusinessName = BusinessName;
        this.BusinessOwner = BusinessOwner;
        this.BusinessLocation = BusinessLocation;
    }

    // Setters and getters
    public String getBusinessName() {
        return BusinessName;
    }

    public void setBusinessName(String businessName) {
        BusinessName = businessName;
    }

    public String getBusinessOwner() {
        return BusinessOwner;
    }

    public void setBusinessOwner(String businessOwner) {
        BusinessOwner = businessOwner;
    }

    public String getBusinessLocation() {
        return BusinessLocation;
    }

    public void setBusinessLocation(String businessLocation) {
        BusinessLocation = businessLocation;
    }

    public String getSafetyPosting() {
        return SafetyPosting;
    }

    public void writeSafetyPosting(String safetyPosting) {
        SafetyPosting = safetyPosting;
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
            document.append("businessname", getBusinessName());
            document.append("businessowner", getBusinessOwner());
            document.append("businesslocation", getBusinessLocation());
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

    public void UpdateBusinessName(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update business's address
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("businessname",
                    getBusinessName()));

        } catch (Exception e){
            String error = "Failed to update business's name! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    public void UpdateBusinessOwner(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update business's owner
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("businessowner",
                    getBusinessOwner()));

        } catch (Exception e){
            String error = "Failed to update business's owner! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }

    public void UpdateBusinessLocation(){
        try {
            // Connect to database
            MongoClient mongoClient = getConn();
            MongoDatabase mongoDatabase = mongoClient.getDatabase(DatabaseName);

            // Get collection
            MongoCollection<Document> table = mongoDatabase.getCollection(CollectionName);

            // Update business's location
            table.updateOne(Filters.eq("userid", getAccountId()), Updates.set("businesslocation",
                    getBusinessLocation()));

        } catch (Exception e){
            String error = "Failed to update business's address! Check MongoDB instance.";
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
            String error = "Failed to retrieve business's account! Check MongoDB instance.";
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
            BasicDBObject query = new BasicDBObject("username", getAccountId());
            try (MongoCursor<Document> cursor = table.find(query).iterator()){
                if (cursor.hasNext()){
                    return cursor.next();
                }
            }
            return null;

        } catch (Exception e){
            String error = "Failed to retrieve business's account! Check MongoDB instance.";
            System.out.println(error);
            throw e;
        }
    }
}
