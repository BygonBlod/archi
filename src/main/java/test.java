import CRMIntern.ReadXml;
import model.LeadTo;

import java.util.ArrayList;

public class test {
    public static void main(String []args){
        ArrayList<LeadTo> list= ReadXml.getLeads("test.xml");
        for(LeadTo lead:list){
            System.out.println(lead.toString());
            System.out.println("-----------------");
        }
    }
}
