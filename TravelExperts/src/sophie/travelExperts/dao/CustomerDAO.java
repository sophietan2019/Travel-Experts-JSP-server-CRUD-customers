package sophie.travelExperts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sophie.travelExperts.models.*;

public class CustomerDAO {
	

    private static final String SELECT_ALL_CUSTOMERS ="SELECT * FROM customers";
    
    private static final String SELECT_CUSTOMER_BY_ID="SELECT * FROM customers WHERE CustomerId=?";
    
    private static final String INSERT_CUSTOMER="INSERT INTO customers"+" (CustFirstName,"
    		+ "CustLastName,CustAddress,CustCity,CustProv,CustPostal,CustCountry,CustHomePhone,"
    		+ "CustBusPhone,CustEmail) VALUES  (?,?,?,?,?,?,?,?,?,?)";
    
    private static final String UPDATE_CUSTOMER_BY_ID="UPDATE customers SET CustFirstName=?,"
    		+ "CustLastName=?,CustAddress=?,CustCity=?,CustProv=?,CustPostal=?,CustCountry=?,"
    		+ "CustHomePhone=?,CustBusPhone=?,CustEmail=? WHERE CustomerId=?";
    
    private static final String DELETE_CUSTOMER_BY_ID="DELETE FROM customers WHERE CustomerId=?";
    
    public CustomerDAO() {}
    
    private static CustomerDAO instance = new CustomerDAO();

    public static CustomerDAO getInstance() {
        return instance;
    }
    
    private Connection conn=DBConnection.connectDB();
    

    
    public List<Customer> getAllCustomers(){
    	List<Customer> customers=new ArrayList<>();
    	try {
    		ResultSet result = conn.prepareStatement(SELECT_ALL_CUSTOMERS).executeQuery();
    		
    		while (result.next())
            {
                customers.add(new Customer(result.getInt(1), result.getString(2), result.getString(3), 
                		result.getString(4), result.getString(5), result.getString(6), 
                		result.getString(7), result.getString(8), 
                		result.getString(9), result.getString(10), result.getString(11)));
            }
    	}
    	catch (SQLException throwables) {
            throwables.printStackTrace();}
         
    	return customers;    			
    			
    }
    
    
    public Customer selectCustomerById(int id)throws SQLException {
    	Customer cus=null;
    	
    	try 
           (PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	int customerId=rs.getInt(1);
                String firstname = rs.getString(2);
                String lastname = rs.getString(3);
                String address = rs.getString(4);
                String city = rs.getString(5);
                String prov= rs.getString(6);
                String postal = rs.getString(7);
                String country = rs.getString(8);
                String homephone = rs.getString(9);
                String busphone= rs.getString(10);
                String email = rs.getString(11);
             
               cus= new Customer(customerId,firstname,lastname,address,city,prov,postal,country,
            		   homephone,busphone,email);          
            }
            return cus;
           
        }
    	
    	
    	}
    
    
    public boolean insertCustomer(Customer cus)throws SQLException {
    	boolean rowInserted;
    	try(PreparedStatement ps=conn.prepareStatement(INSERT_CUSTOMER);){
    	ps.setString(1, cus.getCustFirstName());
    	ps.setString(2, cus.getCustLastName());
    	ps.setString(3, cus.getCustAddress());
    	ps.setString(4, cus.getCustCity());
    	ps.setString(5, cus.getCustProv());
    	ps.setString(6, cus.getCustPostal());
    	ps.setString(7, cus.getCustCountry());
    	ps.setString(8, cus.getCustHomePhone());
    	ps.setString(9, cus.getCustBusPhone());
    	ps.setString(10, cus.getCustEmail());
        rowInserted=ps.executeUpdate()>0;
    	
    } 
        return rowInserted;
    }
    
    
    public boolean updateCustomer(Customer cus) throws SQLException {
    	boolean rowUpdated;
    	try(PreparedStatement ps=conn.prepareStatement(UPDATE_CUSTOMER_BY_ID)){
    		ps.setString(1, cus.getCustFirstName());
        	ps.setString(2, cus.getCustLastName());
        	ps.setString(3, cus.getCustAddress());
        	ps.setString(4, cus.getCustCity());
        	ps.setString(5, cus.getCustProv());
        	ps.setString(6, cus.getCustPostal());
        	ps.setString(7, cus.getCustCountry());
        	ps.setString(8, cus.getCustHomePhone());
        	ps.setString(9, cus.getCustBusPhone());
        	ps.setString(10, cus.getCustEmail());
        	ps.setInt(11, cus.getCustomerId());
        	
        	rowUpdated=ps.executeUpdate()>0;
    	}
    	return rowUpdated;
    }
    
    public boolean deleteCustomer(int id) throws SQLException {
    	boolean rowDeleted;
    	try(PreparedStatement ps=conn.prepareStatement(DELETE_CUSTOMER_BY_ID)){
    		ps.setInt(1, id);
    		rowDeleted=ps.executeUpdate()>0;
    	}
    	return rowDeleted;
    }
    
 }



	

