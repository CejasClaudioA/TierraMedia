package services;

import java.util.List;

import model.TypePromotion;
import persistence.TypeAttractionDAO;
import persistence.TypePromotionDAO;
import persistence.commons.DAOFactory;

public class TypePromotionService {
	public List<TypePromotion> list() {
		return DAOFactory.getTypePromotionDAO().findAll();
	}
	
	public TypePromotion create(String desc) {

		TypePromotion typePromotion = new TypePromotion(-1, desc);

		if (typePromotion.isValid()) {
			TypePromotionDAO typePromotionDAO = DAOFactory.getTypePromotionDAO();
			typePromotionDAO.insert(typePromotion);
		}

		return typePromotion;
	}
	
	public TypePromotion find(Integer id) {
		TypePromotionDAO typePromotionDAO = DAOFactory.getTypePromotionDAO();
		return typePromotionDAO.find(id);
	}

}
