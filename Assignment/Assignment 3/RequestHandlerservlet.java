
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class RequestHandlerservlet
 */
@WebServlet("/RequestHandlerservlet")
public class RequestHandlerservlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Welcome.....!!!!!!!!!!");
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName=req.getParameter("un");
		String Password= req.getParameter("pass");
		Cookie cookie=new Cookie(userName, Password);
		cookie.setMaxAge(24*365*7);
		resp.addCookie(cookie);
		RequestDispatcher rd= req.getRequestDispatcher("/CookieHandler2");
		rd.forward(req, resp);
		}
}