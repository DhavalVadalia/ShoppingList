package ca.sait.shoppinglist;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String user = (String)session.getAttribute("user");
        
        if(user == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
        else {
            String query = request.getQueryString();
        
            if(query != null && query.contains("logout")) {
                session.invalidate();
                
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
                
        String action = request.getParameter("action");
        
        if(action != null && action.equals("add")) {
            String item = request.getParameter("item");
            
            ArrayList<String> list = (ArrayList<String>)session.getAttribute("items");
            
           list.add(item);
            
            session.setAttribute("items", list);
        }
        else if(action != null && action.equals("delete")) {
             String item = request.getParameter("item");
             
             
            ArrayList<String> list = (ArrayList<String>)session.getAttribute("items");      
            list.remove(item);
            session.setAttribute("items", list);    
        }
        else if(action != null && action.equals("register")) {
            String user = request.getParameter("user");

            ArrayList<String> items = new ArrayList<>();
            
            session.setAttribute("user", user);
            session.setAttribute("items", items);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
}
