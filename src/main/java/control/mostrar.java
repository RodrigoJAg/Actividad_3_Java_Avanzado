package control;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "mostrar", urlPatterns = {"/mostrar"})
public class mostrar extends HttpServlet{
		
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()){
					
					String a = request.getParameter("Altura");
					String b = request.getParameter("Base");
					
					
			
					try {
						double resultadoA = calculo.triangulo.Area(a, b);
						double resultadoP = calculo.triangulo.Perimetro(b);
						
						Cookie ck = new Cookie("a", a + "");
						response.addCookie(ck);
						ck = new Cookie("b", b + "");
						response.addCookie(ck);
						ck = new Cookie("resultadoA", resultadoA + "");
						response.addCookie(ck);
						ck = new Cookie("resultadoP", resultadoP + "");
						response.addCookie(ck);		
						
						
						request.setAttribute("AreaResuelta", resultadoA);
						request.setAttribute("PerimetroResuelto", resultadoP);
						request.getRequestDispatcher("/resultado.jsp").forward(request, response);
						
					}catch(NumberFormatException e) {
						request.setAttribute("AreaResuelta", 0.0);
						request.setAttribute("PerimetroResuelto", 0.0);
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
