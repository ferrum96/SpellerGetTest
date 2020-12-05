import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class GetRequest {

    public static String sURL = "http://speller.yandex.net/services/spellservice";

    public static void main(String[] args) throws IOException, ParseException {
        CloseableHttpResponse resp1 = null;

        /*try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=синхрафазтрон+в+дубне");

            resp1 = httpClient.execute(httpGet);

            System.out.println(EntityUtils.toString(resp1.getEntity(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resp1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(sURL + "/checkTexts");
            ContentType contentType = ContentType.create("text/plain", "UTF-8");
            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
            entityBuilder.addTextBody("text", "Dogg", contentType);
            entityBuilder.addTextBody("text", "Literaru", contentType);
            httpPost.setEntity(entityBuilder.build());
            resp1 = httpClient.execute(httpPost);

            System.out.println(EntityUtils.toString(resp1.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                resp1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
