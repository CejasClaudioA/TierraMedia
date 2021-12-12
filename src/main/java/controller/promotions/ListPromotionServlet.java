package controller.promotions;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Promotion;
import model.User;
import persistence.commons.DAOFactory;
import services.PromotionService;

@WebServlet("/promotions/index.do")
public class ListPromotionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -8346640902238722429L;
	private PromotionService promotionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promotionService = new PromotionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		List<Promotion> promotions = promotionService.list(user.getPreference());
		
		req.setAttribute("promotions", promotions);
		promotions = promotionService.alternativeList(user.getPreference());
		req.setAttribute("promotionsAlt", promotions);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/index.jsp");
		dispatcher.forward(req, resp);

	}

}
