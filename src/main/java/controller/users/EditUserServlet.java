package controller.users;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TypeAttraction;
import model.User;
import services.TypeAttractionService;
import services.UserService;

@WebServlet("/users/edit.do")
public class EditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 7598291131560345626L;
	private UserService userService;
	private TypeAttractionService typeAttractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
		this.typeAttractionService = new TypeAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TypeAttraction> typeAttractions = typeAttractionService.list();
		Integer id = Integer.parseInt(req.getParameter("id"));
		
		User user = userService.find(id);
		req.setAttribute("user", user);
		req.setAttribute("typeAttractions", typeAttractions);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/edit.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String username = req.getParameter("username");
		String preference = req.getParameter("typeAttraction");
		Double coins = Double.parseDouble(req.getParameter("coins"));
		Double time = Double.parseDouble(req.getParameter("time"));

		User user = userService.update(id, username, preference, coins, time);
		
		if (user.isValid()) {
			resp.sendRedirect("/TierraMedia/users/index.do");
		} else {
			req.setAttribute("user", user);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/users/edit.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
