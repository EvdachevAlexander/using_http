package resources;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class ParseHttp {

    private Document doc = null;
    private Element element = null;
    private String HTML = null;

    public String get_values_on_elementById(String id){
        return doc.body().getElementById(id).text();
    }

    /*
    Сформировать Document HTML из response
     */
    public Document get_html_on_response(CloseableHttpResponse response){
        try {
           HTML = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc = Jsoup.parseBodyFragment(HTML);

        return doc;
    }
}
