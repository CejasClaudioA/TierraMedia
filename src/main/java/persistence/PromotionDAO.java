package persistence;

import java.util.List;

import model.Promotion;
import persistence.commons.GenericDAO;

public interface PromotionDAO extends GenericDAO<Promotion>{

	List<Promotion> findByType(String type);

	List<Promotion> findByAlternativeType(String type);

}
