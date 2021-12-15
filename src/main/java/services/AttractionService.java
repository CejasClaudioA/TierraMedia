package services;

import java.util.List;

import model.Attraction;
import persistence.AttractionDAO;
import persistence.commons.DAOFactory;

public class AttractionService {

	public List<Attraction> list() {
		return DAOFactory.getAttractionDAO().findAll();
	}
	
	public List<Attraction> listByAttractionsId(String attractionsId){
		return DAOFactory.getAttractionDAO().findByAttractionsId(attractionsId);
	}
	
	public List<Attraction> listByTypeAttraction(String TypeAttraction){
		return DAOFactory.getAttractionDAO().findByTypeAttraction(TypeAttraction);
	}

	public Attraction create(String name, String type, Double cost, Double duration, Integer capacity) {

		Attraction attraction = new Attraction(-1, name ,type ,cost, duration, capacity);

		if (attraction.isValid()) {
			AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
			attractionDAO.insert(attraction);
		}

		return attraction;
	}

	public Attraction update(Integer id, String name, String type ,Double cost, Double duration, Integer capacity) {

		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		Attraction attraction = attractionDAO.find(id);

		attraction.setName(name);
		attraction.setType(type);
		attraction.setCost(cost);
		attraction.setDuration(duration);
		attraction.setCapacity(capacity);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public void delete(Integer id) {
		Attraction attraction = new Attraction(id, null, null, null, null, null, null, null);
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		attractionDAO.delete(attraction);
	}

	public Attraction find(Integer id) {
		AttractionDAO attractionDAO = DAOFactory.getAttractionDAO();
		return attractionDAO.find(id);
	}

}
