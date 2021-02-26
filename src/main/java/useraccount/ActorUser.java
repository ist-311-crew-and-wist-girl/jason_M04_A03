package useraccount;

// Import necessary modules
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ActorUser extends Account {
    private final String DatabaseName = "ACCOUNTS";
    private final String CollectionName = "ACTOR_USER";

    public ActorUser (String FirstName, String LastName, String UserName, String PhoneNumber,
                      String Email, String Address){
        // Call constructor of super class
        super(FirstName, LastName, UserName, PhoneNumber, Email, Address);
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
            BasicDBObject query = new BasicDBObject("username", getAccountId());
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


}