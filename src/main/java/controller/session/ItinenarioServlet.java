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
import model.Attraction;
import model.User;
import services.AttractionService;

@WebServlet("/sessions/index.do")
public class ItinenarioServlet extends HttpServlet implements Servlet {
	private AttractionService attractionService;
	private static final long serialVersionUID = -8346640902238722429L;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<Attraction> attractions = attractionService.listByAttractionsId(user.getAttractionsId());
		req.setAttribute("attractions", attractions);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/sessions/index.jsp");
		dispatcher.forward(req, resp);

	}
}
