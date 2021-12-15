package model;

public class PromotionAbsoluta extends Promotion {
	protected double montoPromo;

	public PromotionAbsoluta(Integer id, String name, String type, String typeProm, String attractionsId, double montoPromo) {
		super(id, name, type, typeProm, attractionsId, montoPromo);
		if(attractionsId != null) {
			this.montoPromo = getMontoPromo();
		}
	}
	
	public PromotionAbsoluta(Integer id, String name, String type, String typeProm) {
		super(id, name, type, typeProm);
	}
	
	public boolean isValid() {
		return true;
	}
}
