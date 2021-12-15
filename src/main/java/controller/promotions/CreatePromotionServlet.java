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
import model.Promotion;
import model.PromotionPorcentual;
import model.TypeAttraction;
import model.TypePromotion;
import services.AttractionService;
import services.PromotionService;
import services.TypeAttractionService;
import services.TypePromotionService;

@WebServlet("/promotions/create.do")
public class CreatePromotionServlet extends HttpServlet{
	private static final long serialVersionUID = 3455721046062278592L;
	private PromotionService promotionService;
	private AttractionService attractionService;
	private TypePromotionService typePromotionService;
	private TypeAttractionService typeAttractionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promotionService = new PromotionService();
		this.attractionService = new AttractionService();
		this.typePromotionService = new TypePromotionService();
		this.typeAttractionService = new TypeAttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TypeAttraction> typeAttractions = typeAttractionService.list();
		req.setAttribute("typeAttractions", typeAttractions);
		List<TypePromotion> typePromotions = typePromotionService.list();
		req.setAttribute("typePromotions", typePromotions);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/create.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String type = req.getParameter("typeAttraction");
		String typePromotion = req.getParameter("typePromotion");
		if(req.getParameter("typePromotion").equals("PROMOCIONPORCENTUAL")) {
			PromotionPorcentual promotion = promotionService.createPorcentual(name, type, typePromotion);
			if(promotion.isValid()) {
				List<Attraction> attractionsList = attractionService.listByTypeAttraction(promotion.getType());
				req.setAttribute("attractionsList", attractionsList);
				req.setAttribute("promotion", promotion);
			}
		}else{
			Promotion promotion = promotionService.create(name, type, typePromotion);
			if(promotion.isValid()) {
				List<Attraction> attractionsList = attractionService.listByTypeAttraction(promotion.getType());
				req.setAttribute("attractionsList", attractionsList);
				req.setAttribute("promotion", promotion);
			}
		}
			
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/promotions/fill.jsp");
		dispatcher.forward(req, resp);
	}
}

