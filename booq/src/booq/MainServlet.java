//TO DO: 
// Statistics and admin page

package booq;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import booq.beans.CartItem;
import booq.beans.Customer;
import booq.model.DBConnectionPool;
import booq.model.SignupQueries;

//import booq.model.DBConnectionPool;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MainServlet() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("*** initializing controller servlet.");
        super.init(config);
         
//        try {
//        	DBConnectionPool connPool = new DBConnectionPool(url, username, passwd);
//        	System.out.println("connection created"); 
//        } catch (Exception e){ e.printStackTrace(); }
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
        	DBConnectionPool connPool = new DBConnectionPool("jdbc:mysql://127.0.0.1:3306/booqDB", "root", "1234");
        	System.out.println("connection created"); 
    
		System.out.println("Entering servlet code"); 
		
		String url = "/jsp/index1.jsp"; //default homepage
	   HttpSession session = request.getSession(); 
	   String productCode = "bookTest"; 
	   session.setAttribute("productCode", productCode); 
	    
	    String action = request.getParameter("action");
	    if (action != null) {
	    	System.out.println(action); 
	    	int custID;
	    	switch (action) {
	    	case "browse": 
	    		url = "/jsp/browse.jsp";
	    		break; 
	    	case "checkout":
	    		url = "/jsp/checkout.jsp"; 
	    		break; 
	    	case "rate" : 
	    	    url = "/jsp/rate.jsp"; 
	    	    break; 
	    	case "cart": 
	    		url = "/jsp/shoppingCart.jsp";
	    		break;
	    	case "test":
	    		url = "/jsp/test.jsp";
	    		break;
	    	case "signup":
	    		url = "/jsp/signup.jsp";
	    		System.out.println("case is signup"); 
	    		break;
	    	case "itemDetails" :
	    	    url = "/jsp/itemPage.jsp"; 
	    	    break; 
	    	case "completeSignup":
	    		String[] e = request.getParameterValues("Email");
	    		System.out.println(e[0]);
	    		
	    		Customer c = new Customer();
	    		c.setEmail(request.getParameter("Email"));
	    		c.setcName(request.getParameter("Name"));
	    		c.setPasswd(request.getParameter("Password"));
	    		c.setCcName(request.getParameter("ccName"));
	    		c.setCcNumber(request.getParameter("ccNumber"));
	    		c.setCcExpire(request.getParameter("ccExp. Date"));
	    		c.setStreetAddr(request.getParameter("Street Address"));
	    		c.setCity(request.getParameter("City"));
	    		c.setState(request.getParameter("State"));
	    		c.setCountry(request.getParameter("Country"));
	    		c.setZip(request.getParameter("Zip"));
	    		c.setApptNo(request.getParameter("Appt."));
	    		
	    		custID = SignupQueries.insert(connPool, c);
	    		if(custID > 0) {
	    			String custIDstring = Integer.toString(custID); 
	    			System.out.println("case is login"); 
	       			session.setAttribute("customerIDstring",custIDstring); 
	    			session.setAttribute("userEmail", request.getParameter("Email"));
	    		}
	    		url = "/jsp/index1.jsp";
	    		break;
	    	case "login":
	    		custID = SignupQueries.validateCredentials(connPool, request.getParameter("email"), request.getParameter("password"));
	    		
	    		System.out.println("cust id in servlet" + custID); 
	    		if(custID > 0) {
	    			String custIDstring = Integer.toString(custID);
	    			System.out.println("case is login"); 
	       			session.setAttribute("customerIDstring",custIDstring); 
	    			session.setAttribute("userEmail", request.getParameter("email"));
	    			
	    		}
	    		url = "/jsp/index1.jsp";
	    		break;
	    	case "logout" : 
	    		session.invalidate(); 
	    		url="/jsp/index1.jsp";
	    	     break; 
	    	case "search":
	    		System.out.println("search"); 
	    		url = "/jsp/searchResults.jsp";
	    		break;
	    	case "profile":
	    		url = "/jsp/profile.jsp";
	    		break;
	    	case "statistics":
	    		url = "/jsp/statistics.jsp";
	    		break;
	    	default: 
	    		System.out.println("default"); 
	    		break; 
	    
	    	}
	    
	    }
	    else {
    		System.out.println("Action is null"); 
    	}
	    System.out.println("Exiting servlet code"); 
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
	    rd.forward(request, response);
	    } catch (Exception e){ e.printStackTrace();	}
	}
}
