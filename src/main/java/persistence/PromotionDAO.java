package persistence;

import java.util.List;

import model.Promotion;
import model.PromotionAbsoluta;
import model.PromotionAxB;
import model.PromotionPorcentual;
import persistence.commons.GenericDAO;

public interface PromotionDAO extends GenericDAO<Promotion>{

	public List<Promotion> findByType(String type);

	public List<Promotion> findByAlternativeType(String type);

	public Promotion findByName(String name);

	public Promotion findByNameAxB(String name);

	public Promotion findByNameAbsolute(String name);

	public Promotion findByNamePorcentual(String name);

	public int updateAbsoluta(PromotionAbsoluta promotionAbsoluta);

	public int updatePorcentual(PromotionPorcentual promotionPorcentual);

	public int updateAxB(PromotionAxB promotionAxB);

	public Promotion findByIdPorcentual(Integer id);

	public Promotion findByIdAbsolute(Integer id);

	public Promotion findByIdAxB(Integer id);

	public int delete(Integer id);
}
