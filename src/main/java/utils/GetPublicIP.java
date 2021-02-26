package utils;

// Necessary modules
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Simple class to retrieve device's Public IP address using
 * http://bot.whatismyipaddress.com.
 * @author Jason C. Nucciarone
 *
 */
public class GetPublicIP {
    public static String getPublicIPAddress() throws Exception{
        try {
            URL url = new URL("http://bot.whatismyipaddress.com");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            // Read in and return the device's public IP address
            return reader.readLine().trim();

        } catch (Exception e){
            String error = "Failed to retrieve device's Public IP address";
            System.out.println(error);
            throw e;
        }
    }
}
