package resources;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class InteractionsHttp {

    private CloseableHttpClient httpclient = HttpClients.createDefault();
    private HttpGet httpGet = null;
    private CloseableHttpResponse response = null;


    public CloseableHttpResponse getResponse() {
        return response;
    }

    /*
    Получить статус
     */

    public int get_status_code (){
       return this.response.getStatusLine().getStatusCode();
    }

    /*
    Выполнить GET запрос по указанному URL
     */
    public void execute_get_on_url(String url)  {
        httpGet = new HttpGet(getUri(url));

        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private URI getUri(String url) {
        URI uri = null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    public void close_conect(){
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
