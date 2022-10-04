package VirtualCRM;

import model.LeadTo;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class VirtualCRM implements VirtualCRMService{
    private String key;
    private static VirtualCRM singleton;

    private VirtualCRM(){
        connect();
    }

    private void connect() {

        NameValuePair[] data={
            new BasicNameValuePair("grant_type","password"),
            new BasicNameValuePair("client_id","3MVG9t0sl2P.pByrs.jGfyp11wt7Fiy9Yn3u25AIkaXJpYI.p2QXil_ABYdhTo7DLO7M5IAG5CEXorcpihO8V"),
            new BasicNameValuePair("client_secret","A4C48893CC6CBD865B2DF2183D9760E266A40161225D0E1ADD0EB87BE73E25A7"),
            new BasicNameValuePair("username","antonin@project.com"),
            new BasicNameValuePair("password","SuperProject1")
        };
        HttpPost request = new HttpPost("https://login.salesforce.com/services/oauth2/token");

        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        try {
            request.setEntity(new UrlEncodedFormEntity(Arrays.asList(data)));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONObject jsonObject = null;

                jsonObject = (JSONObject) new JSONTokener(result).nextValue();
                key = jsonObject.getString("access_token");


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
        requete();
    }

    public static VirtualCRM getInstance() {
        if(singleton==null){
            singleton=new VirtualCRM();
        }
        return singleton;
    }
    public void requete(){
        String uri="https://archiproject-dev-ed.my.salesforce.com/services/data/v45.0//query?";
        //requete sur toutes les informations demander des leads
        uri+="q=Select+Id+,+FirstName+,+LastName+,+AnnualRevenue+,+Phone+,+Street+,+PostalCode+,+City+,+Country+,+Company+,+State+From+Lead";
        HttpGet request = new HttpGet(uri);

        request.addHeader("Content-Type", "application/x-www-form-urlencoded");
        request.addHeader("Authorization","Bearer "+key);
        request.addHeader("Accept","application/json");
        request.addHeader("X-PrettyPrint", "1");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                //System.out.println(result);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
