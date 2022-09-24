package model;

import geographic.GeographicPointTo;

import java.util.Calendar;
import java.util.Date;

public class LeadTo {
    String firstName;
    String lastName;
    double annualRevenue;
    String phone;
    String street;
    String postalCode;
    String city;
    String country;
    Date creationDate;
    GeographicPointTo geographicPointTo;
    String company;
    String state;

    public LeadTo(String fn,String ln,double ar,String ph,String st,String pc,String ci,String co,Date da,String comp,String sta){
        firstName=fn;
        lastName=ln;
        annualRevenue=ar;
        phone=ph;
        street=st;
        postalCode=pc;
        city=ci;
        country=co;
        creationDate=da;
        company=comp;
        state=sta;
        geographicPointTo=new GeographicPointTo(street,city,country,postalCode);
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public String getStreet() {
        return street;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public GeographicPointTo getGeographicPointTo() {
        return geographicPointTo;
    }

    public String getCity() {
        return city;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }
}
