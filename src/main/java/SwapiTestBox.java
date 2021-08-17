import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SwapiTestBox {
    private String url;
    private String xpath;


    public String apiTestBox(String url, String xpath) throws IOException, JSONException {
        this.url = url;
        this.xpath = xpath;
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String result = JsonPath.from(response.toString()).getString(xpath);
        return result;
    }


}
