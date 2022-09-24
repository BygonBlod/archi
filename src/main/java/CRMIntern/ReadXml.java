package CRMIntern;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.LeadTo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Util.Util;

public class ReadXml {
    public static ArrayList<LeadTo> getLeads(String args){
        ArrayList<LeadTo> leads=new ArrayList<>();
        Document document = null;
        DocumentBuilderFactory factory = null;
        DocumentTraversal traversal = null;
        try {
            factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(args);
            traversal = (DocumentTraversal) document;
        } catch (Exception e) {
            System.out.println("échec du parsing du document :");
            e.printStackTrace();
        }
        if (traversal != null) {
            Node racine = document.getLastChild();
            if (racine.getNodeType() == Node.ELEMENT_NODE) {
                Element racineE = (Element) racine;
                NodeList listRacine = racineE.getChildNodes();
                ArrayList<Element> racineL = Util.getElements(listRacine);
                for (Element element : racineL) {
                    Element name=Util.getElementNamed(element.getElementsByTagName("name"));
                    Element revenue=Util.getElementNamed(element.getElementsByTagName("annualRevenue"));
                    Element phone=Util.getElementNamed(element.getElementsByTagName("phone"));
                    Element street=Util.getElementNamed(element.getElementsByTagName("street"));
                    Element postalCode=Util.getElementNamed(element.getElementsByTagName("postalCode"));
                    Element city=Util.getElementNamed(element.getElementsByTagName("city"));
                    Element country=Util.getElementNamed(element.getElementsByTagName("country"));
                    Element creationDate=Util.getElementNamed(element.getElementsByTagName("creationDate"));
                    Element company=Util.getElementNamed(element.getElementsByTagName("company"));
                    Element state=Util.getElementNamed(element.getElementsByTagName("state"));
                    String[] nameS=name.getTextContent().split(",");
                    String firstName=nameS[0];
                    String lastName=nameS[1];
                    double revenueS= Double.parseDouble(revenue.getTextContent());
                    String phoneS=phone.getTextContent();
                    String streetS=street.getTextContent();
                    String postalCodeS=postalCode.getTextContent();
                    String cityS=city.getTextContent();
                    String countryS=country.getTextContent();
                    Calendar date=getDate(creationDate);
                    String companyS=company.getTextContent();
                    String stateS=state.getTextContent();
                    LeadTo lead=new LeadTo(firstName,lastName,revenueS,phoneS,streetS,postalCodeS,cityS,countryS,date,companyS,stateS);
                    leads.add(lead);
                }
            }
        }
        return leads;
    }

    private static Calendar getDate(Element creationDate) {
        String dateCrea=creationDate.getTextContent();
        String []date=dateCrea.split("/");
        int day= Integer.parseInt(date[0]);
        int month= Integer.parseInt(date[1])-1;
        int year= Integer.parseInt(date[2]);
        return new GregorianCalendar(year,month,day);

    }
}
