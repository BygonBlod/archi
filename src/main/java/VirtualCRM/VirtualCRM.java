package VirtualCRM;

import model.LeadTo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.Calendar;
import java.util.List;


public class VirtualCRM implements VirtualCRMService{
    String key;
    private VirtualCRM singleton;

    private VirtualCRM(){
        connect();
    }

    private void connect() {

    }

    public VirtualCRM getSingleton() {
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
