import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TelegramPublisher extends Publisher {

    private String channelName;
    private  String apiToken;
    private String urlFormat = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";

    public TelegramPublisher(String channelName, String apiToken){
        this.channelName = channelName;
        this.apiToken = apiToken;
    }

    void Publish(Item item) throws Exception {
        String message = item.toString();
        String urlString = String.format(urlFormat, apiToken, channelName,
                            java.net.URLEncoder.encode(message, "UTF-8"));

        URL url = new URL(urlString);
        URLConnection conn = url.openConnection();

        StringBuilder sb = new StringBuilder();
        InputStream is = new BufferedInputStream(conn.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String inputLine = "";
        while ((inputLine = br.readLine()) != null) {
            sb.append(inputLine);
        }
    }
}

