package controller.session;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import services.UserService;

@WebServlet("/sessions/itinerary.do")
public class ListItinenarioSerlet extends HttpServlet implements Servlet{
	private UserService userService;
	private static final long serialVersionUID = -8346640902238722429L;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<User> users = userService.list();
		req.setAttribute("users", users);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sessions/itinerary.jsp");
		dispatcher.forward(req, resp);

	}
}
