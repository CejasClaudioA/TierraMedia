package model;

public class PromotionAxB extends Promotion {
	protected double montoPromo;

	public PromotionAxB(Integer id, String name, String type, String typeProm, String attractionsId, double montoPromo) {
		super(id, name, type, typeProm, attractionsId, montoPromo);
		if(attractionsId != null) {
			this.montoPromo = getMontoPromo();
		}
	}
	
	public PromotionAxB(Integer id, String name, String type, String typeProm) {
		super(id, name, type, typeProm);
	}

	public boolean isValid() {
		return true;
	}
	
}
