package persistence;

import java.util.List;

import model.Attraction;
import persistence.commons.GenericDAO;

public interface AttractionDAO extends GenericDAO<Attraction> {

	public List<Attraction> findByAttractionsId(String attractionsId);

	public List<Attraction> findByTypeAttraction(String TypeAttraction);

}
