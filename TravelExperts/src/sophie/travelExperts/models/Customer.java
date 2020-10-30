package sophie.travelExperts.models;


public class Customer {
	    protected int CustomerId;
	    protected String CustFirstName;
	    protected String CustLastName;
	    protected String CustAddress;
	    protected String CustCity;
	    protected String CustProv;
	    protected String CustPostal;
	    protected String CustCountry;
	    protected String CustHomePhone;
	    protected String CustBusPhone;
	    protected String CustEmail;
	    protected int AgentId;

    // Getters and Setters
    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public String getCustFirstName() {
        return CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        CustFirstName = custFirstName;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public void setCustLastName(String custLastName) {
        CustLastName = custLastName;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        CustAddress = custAddress;
    }

    public String getCustCity() {
        return CustCity;
    }

    public void setCustCity(String custCity) {
        CustCity = custCity;
    }

    public String getCustProv() {
        return CustProv;
    }

    public void setCustProv(String custProv) {
        CustProv = custProv;
    }

    public String getCustPostal() {
        return CustPostal;
    }

    public void setCustPostal(String custPostal) {
        CustPostal = custPostal;
    }

    public String getCustCountry() {
        return CustCountry;
    }

    public void setCustCountry(String custCountry) {
        CustCountry = custCountry;
    }

    public String getCustHomePhone() {
        return CustHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        CustHomePhone = custHomePhone;
    }

    public String getCustBusPhone() {
        return CustBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        CustBusPhone = custBusPhone;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }

    public int getAgentId() {
        return AgentId;
    }

    public void setAgentId(int agentId) {
        AgentId = agentId;
    }

    // Constructor
    public Customer() {
    }
    
    public Customer(int customerId, String custFirstName, String custLastName, 
    		String custAddress, String custCity, String custProv, String custPostal, 
    		String custCountry, String custHomePhone, String custBusPhone, String custEmail,int agentId) {
        super();
    	CustomerId = customerId;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustAddress = custAddress;
        CustCity = custCity;
        CustProv = custProv;
        CustPostal = custPostal;
        CustCountry = custCountry;
        CustHomePhone = custHomePhone;
        CustBusPhone = custBusPhone;
        CustEmail = custEmail;
        AgentId=agentId;
    }
    

    public Customer(int customerId, String custFirstName, String custLastName, 
    		String custAddress, String custCity, String custProv, String custPostal, 
    		String custCountry, String custHomePhone, String custBusPhone, String custEmail) {
        super();
    	CustomerId = customerId;
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustAddress = custAddress;
        CustCity = custCity;
        CustProv = custProv;
        CustPostal = custPostal;
        CustCountry = custCountry;
        CustHomePhone = custHomePhone;
        CustBusPhone = custBusPhone;
        CustEmail = custEmail;
    }
    
    public Customer(String custFirstName, String custLastName, String custAddress, 
    		String custCity, String custProv, String custPostal, 
    		String custCountry, String custHomePhone, String custBusPhone, String custEmail) {
    	super();
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustAddress = custAddress;
        CustCity = custCity;
        CustProv = custProv;
        CustPostal = custPostal;
        CustCountry = custCountry;
        CustHomePhone = custHomePhone;
        CustBusPhone = custBusPhone;
        CustEmail = custEmail;
    }

    @Override
    public String toString() {
        return  CustFirstName + " " + CustLastName;
    }

}
