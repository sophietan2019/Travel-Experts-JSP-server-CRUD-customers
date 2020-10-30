package sophie.travelExperts.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sophie.travelExperts.dao.CustomerDAO;
import sophie.travelExperts.models.Customer;

@WebServlet("/")
public class CustomerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L ;
	private CustomerDAO cusDAO;
	
	public void init() {
		cusDAO=new CustomerDAO();
	}
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        doGet(request, response);
			    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			        String action = request.getServletPath();

			        try {
			            switch (action) {
			                case "/new":
			                    showNewForm(request, response);
			                    break;
			                case "/insert":
			                    insertCustomer(request, response);
			                    break;
			                case "/delete":
			                    deleteCustomer(request, response);
			                    break;
			                case "/edit":
			                    showEditForm(request, response);
			                    break;
			                case "/update":
			                    updateCustomer(request, response);
			                    break;
			                default:
			                    listCustomer(request, response);
			                    break;
			            }
			        } catch (SQLException ex) {
			            throw new ServletException(ex);
			        }
			    }
			    
			    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			    	    throws ServletException, IOException {
			    	        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
			    	        dispatcher.forward(request, response);
			    	    }
			    
			    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, ServletException, IOException {
			    	        int aId = Integer.parseInt(request.getParameter("id"));
			    	       Customer existingCustomer= CustomerDAO.getInstance().selectCustomerById(aId);
			    	        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
			    	        request.setAttribute("customer", existingCustomer);
			    	        dispatcher.forward(request, response);

			    	    }
			    
			    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException, ServletException {
			        List <Customer> listCustomer= cusDAO.getAllCustomers();
			        request.setAttribute("listCustomer", listCustomer);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
			        dispatcher.forward(request, response);
			    }

			    private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException {
			    	        String firstname = request.getParameter("custFirstName");
			    	        String lastname = request.getParameter("custLastName");
			    	        String address = request.getParameter("custAddress");
			    	        String city = request.getParameter("custCity");
			    	        String prov = request.getParameter("custProv");
			    	        String postal = request.getParameter("custPostal");
			    	        String country = request.getParameter("custCountry");
			    	        String homephone = request.getParameter("custHomePhone");
			    	        String busphone = request.getParameter("custBusPhone");
			    	        String email = request.getParameter("custEmail");
			    	        Customer cus=new Customer(firstname,lastname,address,city,prov,postal,country,
			             		   homephone,busphone,email);
			    	       CustomerDAO.getInstance().insertCustomer(cus);
			    	        response.sendRedirect("list");
			    	    }
			    
			    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException {
			    	        int id = Integer.parseInt(request.getParameter("customerId"));
			    	        String firstname = request.getParameter("custFirstName");
			    	        String lastname = request.getParameter("custLastName");
			    	        String address = request.getParameter("custAddress");
			    	        String city = request.getParameter("custCity");
			    	        String prov = request.getParameter("custProv");
			    	        String postal = request.getParameter("custPostal");
			    	        String country = request.getParameter("custCountry");
			    	        String homephone = request.getParameter("custHomePhone");
			    	        String busphone = request.getParameter("custBusPhone");
			    	        String email = request.getParameter("custEmail");

			    	        Customer cus=new Customer(id,firstname,lastname,address,city,prov,postal,country,
				             		   homephone,busphone,email);
			    	        CustomerDAO.getInstance().updateCustomer(cus);
			    	        response.sendRedirect("list");
			    	    }
			    
			    
			    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, IOException{
			    	int aId = Integer.parseInt(request.getParameter("id"));
			       CustomerDAO.getInstance().deleteCustomer(aId);
			        response.sendRedirect("list");
			    }
	

}
