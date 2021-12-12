package services;

import java.util.List;

import model.Promotion;
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

public class PromotionService {
	
	public List<Promotion> list(String type) {
		return DAOFactory.getPromotionDAO().findByType(type);
	}
	
	public List<Promotion> alternativeList(String type) {
		return DAOFactory.getPromotionDAO().findByAlternativeType(type);
	}
	
	public Promotion update(Integer id, String name) {

		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		Promotion promotion = promotionDAO.find(id);
		promotion.setName(name);
		if (promotion.isValid()) {
			promotionDAO.update(promotion);
		}
		return promotion;
	}

	public Promotion find(Integer id) {
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		return promotionDAO.find(id);
	}

}
