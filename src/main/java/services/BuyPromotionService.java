package services;

import java.util.HashMap;
import java.util.Map;

import model.Attraction;
import model.Promotion;
import model.User;
import persistence.AttractionDAO;
import persistence.PromotionDAO;
import persistence.UserDAO;
import persistence.commons.DAOFactory;

public class BuyPromotionService {
	AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
	PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
	UserDAO userDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer promotionId) {
		Map<String, String> errors = new HashMap<String, String>();

		User user = userDAO.find(userId);
		Promotion promotion = promotionDAO.find(promotionId);
		
		if (!promotion.hasCapacity()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!user.allreadyHavePromotion(promotion)) {
			errors.put("user", "Ya has comprado alguna de las atracion incluidas en la promocion");
		}
		
		if (!user.canAffordPromotion(promotion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!user.canAffordPromotion(promotion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			user.addPromotionToItinerary(promotion);
			promotion.host(1);
			for (Attraction attraction : promotion.getAttraction()) {
				attractionDAO.update(attraction);
			}
			userDAO.update(user);
		}
		return errors;

	}

}
