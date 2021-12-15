package model;

public class PromotionPorcentual extends Promotion {
	private Integer discount;
	protected double montoPromo;
	
	public PromotionPorcentual(Integer id, String name, String type, String typeProm,
			String attractionsId, double montoPromo, int descuento) {
		super(id, name, type, typeProm, attractionsId, montoPromo);
		this.discount = descuento;
		if(attractionsId != null) {
			this.montoPromo = getMontoPromo();
		}
	}
	
	public PromotionPorcentual(Integer id, String name, String type, String typeProm) {
		super(id, name, type, typeProm);
	}
	public PromotionPorcentual(Integer id, String name, String typeProm, String type, Integer discount) {
		super(id, name, type, typeProm, discount);
	}
	
	
	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public boolean isValid() {
		return true;
	}

	
}
