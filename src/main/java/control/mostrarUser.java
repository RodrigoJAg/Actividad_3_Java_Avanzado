package control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mostrarUser", urlPatterns = {"/mostrarUser"})
public class mostrarUser extends HttpServlet{
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()){
					
					HttpSession sesion = request.getSession(false);
					String user = request.getParameter("Username");
					
					sesion.setAttribute("Username", user);

					
					request.setAttribute("Username", user);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
						
				}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
			processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		processRequest(request, response);
	}
	
	@Override 
	public String getServletInfo() {
		return "Descripcion corta";
	}
	
	
	
}
