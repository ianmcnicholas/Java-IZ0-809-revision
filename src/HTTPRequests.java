import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;


public class HTTPRequests {

    private static HttpURLConnection connection;

    public static void main(String[] args) {
        // Method 1: java.net.HttpURLConnection

        // with HttpConnection, the response we get is of type InputStream.
        // in order to read this we need an InputReader, wrapped inside a BufferedReader.

        BufferedReader reader;
        String line; // for reading every line.
        StringBuffer responseContent = new StringBuffer(); // use to append each line and build our response content.

        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/albums");
            connection = (HttpURLConnection) url.openConnection();

            // Request setup
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();
//            System.out.println(status);

            if (status > 299) {
                // use the reader to read the error message.
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) { // this mean we still have things to read.
                    responseContent.append(line);
                }
                reader.close();
            } else {
                // use the reader to read the response.
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) { // this mean we still have things to read.
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        JSONArray array = new JSONArray(responseContent.toString());

        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            if (Objects.equals(object.get("id").toString(), "2")) {
                System.out.println(object.get("id"));
                System.out.println(object.get("title"));
            }
        }

        System.out.println("Completed!!!!");
    }

}

// URL - https://jsonplaceholder.typicode.com/albums
