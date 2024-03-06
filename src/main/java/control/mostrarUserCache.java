package control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mostrarUserCache", urlPatterns = {"/mostrarUserCache"})
public class mostrarUserCache extends HttpServlet{
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()){

					String a = request.getParameter("Altura");
					String b = request.getParameter("Base");
					String user = request.getParameter("Username");
					
					HttpSession sesion = request.getSession(false);
					
					try {
						double resultadoA = calculo.triangulo.Area(a, b);
						double resultadoP = calculo.triangulo.Perimetro(b);
						
						sesion.setAttribute("a", a);
						sesion.setAttribute("b", b);
						sesion.setAttribute("resultadoA", resultadoA);
						sesion.setAttribute("resultadoP", resultadoP);
						sesion.setAttribute("Username", user);
						
						
						request.setAttribute("AreaResuelta", resultadoA);
						request.setAttribute("PerimetroResuelto", resultadoP);
						request.getRequestDispatcher("/resultado.jsp").forward(request, response);
						
					}catch(NumberFormatException e) {
						request.setAttribute("AreaResuelta", 0.0);
						request.setAttribute("PerimetroResuelto", 0.0);
						sesion.setAttribute("a", 0.0);
						sesion.setAttribute("b", 0.0);
						sesion.setAttribute("resultadoA", 0.0);
						sesion.setAttribute("resultadoP", 0.0);
						sesion.setAttribute("Username", user);
						request.getRequestDispatcher("/resultado.jsp").forward(request, response);
					}
						
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
