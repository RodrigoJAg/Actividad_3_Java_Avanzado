package tags;

import java.io.*;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class tagUser extends SimpleTagSupport{
	
	StringWriter sw = new StringWriter();
	
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(sw);
		getJspContext().getOut().println("Hola! " + sw.toString());
		
		
	}
	
}
