import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;


@WebServlet("/welcome")
public class WelcomeController extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String outPutScreen = "<html><body> " + "<h1> Welcome  </h1> " + "<p>Welcome to First Servlet Pages</p> "
				+ "</body></html>";

		PrintWriter pw = response.getWriter();
		
		
		
		pw.println(outPutScreen);
		pw.flush();
		pw.close();

	}

}
