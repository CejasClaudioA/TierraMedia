package controller.promotions;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Attraction;
import model.PromotionAbsoluta;
import model.PromotionAxB;
import model.PromotionPorcentual;
import services.AttractionService;
import services.PromotionService;

@WebServlet("/promotions/fill.do")
public class fillAttractionToPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 7598791131560342622L;
	private PromotionService promotionService;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.promotionService = new PromotionService();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Attraction> attractionsList = attractionService.listByTypeAttraction(req.getParameter("type"));
		req.setAttribute("attractionsList", attractionsList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/fill.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String typeP = req.getParameter("typeP");
		String[] attractionsid = req.getParameterValues("myselect");
		if(typeP.equals("PROMOCIONPORCENTUAL")) {
			Integer discount = Integer.parseInt(req.getParameter("discount"));
			PromotionPorcentual promotionPorcentual = promotionService.addAttractionsPorcentual(name, attractionsid, discount);
			if (promotionPorcentual.isValid()) {
				resp.sendRedirect("/TierraMedia/promotions/index.do");
			} else {
				req.setAttribute("promotion", promotionPorcentual);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
		if(typeP.equals("PROMOCIONABSOLUTA")) {
			PromotionAbsoluta promotionAbsoluta = promotionService.addAttractionsAbsoluta(name, attractionsid);
			if (promotionAbsoluta.isValid()) {
				resp.sendRedirect("/TierraMedia/promotions/index.do");
			} else {
				req.setAttribute("promotion", promotionAbsoluta);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
				dispatcher.forward(req, resp);
			}
		}
		
		if(typeP.equals("PROMOCIONAXB")) {
			PromotionAxB promotionAxB = promotionService.addAttractionsAxB(name, attractionsid);
			if (promotionAxB.isValid()) {
				resp.sendRedirect("/TierraMedia/promotions/index.do");
			} else {
				req.setAttribute("promotion", promotionAxB);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
				dispatcher.forward(req, resp);
			}
		}
	}
}
