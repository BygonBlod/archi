package VirtualCRM;

import model.LeadTo;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.List;


public class VirtualCRM implements VirtualCRMService{
    private String key;
    private static VirtualCRM singleton;

    private VirtualCRM(){
        connect();
    }

    private void connect() {
        /*---------------------------------------------------------------en test de requete---------------------------------------------------------*/
        HttpGet request = new HttpGet("https://httpbin.org/get");

        // add request headers
        request.addHeader("custom-key", "mkyong");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static VirtualCRM getInstance() {
        if(singleton==null){
            singleton=new VirtualCRM();
        }
        return singleton;
    }

    @Override
    public List<LeadTo> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state) {
        return null;
    }

    @Override
    public List<LeadTo> findLeadsByDate(Calendar startDate, Calendar endDate) {
        return null;
    }
}
