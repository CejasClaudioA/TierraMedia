package services;

import java.util.List;

import model.Attraction;
import model.Promotion;
import model.PromotionAbsoluta;
import model.PromotionAxB;
import model.PromotionPorcentual;
import persistence.AttractionDAO;
import persistence.PromotionDAO;
import persistence.commons.DAOFactory;

public class PromotionService {
	
	public List<Promotion> list(String type) {
		return DAOFactory.getPromotionDAO().findByType(type);
	}
	
	public List<Promotion> alternativeList(String type) {
		return DAOFactory.getPromotionDAO().findByAlternativeType(type);
	}
	
	public Promotion find(Integer id) {
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		return promotionDAO.find(id);
	}
	
	public Promotion create(String name, String type, String typeProm) {
		Promotion promotion = null;
		switch (typeProm) {
		case "PROMOCIONABSOLUTA":
			promotion = new PromotionAbsoluta(-1, name, type, typeProm);
		case "PROMOCIONPORCENTUAL":
			promotion = new PromotionPorcentual(-1, name, type, typeProm);
		case "PROMOCIONAXB":
			promotion = new PromotionAxB(-1, name, type, typeProm);
		}

		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		promotionDAO.insert(promotion);	
		return promotion;
	}
	
	public PromotionPorcentual createPorcentual(String name, String type, String typeProm) {
		PromotionPorcentual promotion = new PromotionPorcentual(-1, name, type, typeProm);;
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		promotionDAO.insert(promotion);	
		return promotion;
	}
	
	public void delete(Integer id) {
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		promotionDAO.delete(id);
	}
	
	public PromotionPorcentual addAttractionsPorcentual(String name, String[] attractionsid, Integer discount) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionPorcentual promotion = (PromotionPorcentual) promotionDAO.findByNamePorcentual(name);
		promotion.setDiscount(discount);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (Attraction attraction : promotion.getAttraction()) {
			aux += attraction.getCost();
		}
		aux = aux - (aux * discount) / 100;
		promotion.setMontoPromo(aux);
		promotionDAO.updatePorcentual(promotion);
		return promotion;
	}
	
	public PromotionAbsoluta addAttractionsAbsoluta(String name, String[] attractionsid) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionAbsoluta promotion = (PromotionAbsoluta) promotionDAO.findByNameAbsolute(name);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (Attraction attraction : promotion.getAttraction()) {
			aux += attraction.getCost();
		}
		promotion.setMontoPromo(aux);
		promotionDAO.updateAbsoluta(promotion);
		return promotion;
	}
	
	public PromotionAxB addAttractionsAxB(String name, String[] attractionsid) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionAxB promotion = (PromotionAxB) promotionDAO.findByNameAxB(name);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (int i = 0; i < promotion.getAttraction().size() - 1; i++) {
			aux = promotion.getAttraction().get(i).getCost();
		}
		promotion.setMontoPromo(aux);
		promotionDAO.updateAxB(promotion);
		return promotion;
	}
	
	public PromotionPorcentual updatePorcentual(Integer id, String name, String[] attractionsid) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionPorcentual promotion = (PromotionPorcentual) promotionDAO.findByIdPorcentual(id);
		promotion.setName(name);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (Attraction attraction : promotion.getAttraction()) {
			aux += attraction.getCost();
		}
		aux = aux - (aux * promotion.getDiscount()) / 100;
		promotion.setMontoPromo(aux);
		promotionDAO.updatePorcentual(promotion);
		return promotion;
	}
	
	public PromotionAbsoluta updateAbsoluta(Integer id, String name, String[] attractionsid) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionAbsoluta promotion = (PromotionAbsoluta) promotionDAO.findByIdAbsolute(id);
		promotion.setName(name);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (Attraction attraction : promotion.getAttraction()) {
			aux += attraction.getCost();
		}
		promotion.setMontoPromo(aux);
		promotionDAO.updateAbsoluta(promotion);
		return promotion;
	}
	
	public PromotionAxB updateAxB(Integer id, String name, String[] attractionsid) {
		String Attractions = "";
		for (int i = 0; i < attractionsid.length; i++) {
			Attractions += attractionsid[i]+ "|";
		}
		PromotionDAO promotionDAO = DAOFactory.getPromotionDAO();
		PromotionAxB promotion = (PromotionAxB) promotionDAO.findByIdAxB(id);
		promotion.setName(name);
		promotion.setAttractionsId(Attractions);
		double aux = 0;
		for (int i = 0; i < promotion.getAttraction().size() - 1; i++) {
			aux = promotion.getAttraction().get(i).getCost();
		}
		promotion.setMontoPromo(aux);
		promotionDAO.updateAxB(promotion);
		return promotion;
	}
	
	

	

}
