package VirtualCRM;

import model.LeadTo;

import java.util.Calendar;
import java.util.List;

public interface VirtualCRMService {
    public List<LeadTo> findLeads(double lowAnnualRevenue, double highAnnualRevenue, String state);
    public List<LeadTo> findLeadsByDate(Calendar startDate,Calendar endDate);
}
