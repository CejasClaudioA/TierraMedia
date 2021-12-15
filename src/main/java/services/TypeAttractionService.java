package services;

import java.util.List;

import model.TypeAttraction;
import persistence.TypeAttractionDAO;
import persistence.commons.DAOFactory;

public class TypeAttractionService {
	public List<TypeAttraction> list() {
		return DAOFactory.getTypeAttractionDAO().findAll();
	}
	
	public TypeAttraction create(String desc) {

		TypeAttraction typeAttraction = new TypeAttraction(-1, desc);

		if (typeAttraction.isValid()) {
			TypeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttractionDAO();
			typeAttractionDAO.insert(typeAttraction);
		}

		return typeAttraction;
	}
	
	public TypeAttraction find(Integer id) {
		TypeAttractionDAO typeAttractionDAO = DAOFactory.getTypeAttractionDAO();
		return typeAttractionDAO.find(id);
	}

}
