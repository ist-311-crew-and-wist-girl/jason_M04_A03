package main;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CityResponse;
import utils.GetPublicIP;

import java.io.File;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        String tmp = "Place holder text for later development!";
        System.out.println(tmp);

        // Get devices current IP address
        String IpAddress = GetPublicIP.getPublicIPAddress();
        String dbLocation = "D:\\git_projects_school\\geolite\\GeoLite2-City_20210223\\GeoLite2-City.mmdb";

        // Open connection to GeoLite database
        File database = new File(dbLocation);
        DatabaseReader reader = new DatabaseReader.Builder(database).build();
        InetAddress ip = InetAddress.getByName(IpAddress);

        // Query database
        CityResponse response = reader.city(ip);

        System.out.println(response.getLocation().getLatitude());
        System.out.println(response.getLocation().getLongitude());
    }
}
