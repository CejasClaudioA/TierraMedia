package model;

import java.util.ArrayList;

public class PromotionAbsoluta extends Promotion {
	protected double montoPromo;

	public PromotionAbsoluta(Integer id, String name, String type, String typeProm, String attractionsId) {
		super(id, name, type, typeProm, attractionsId);
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMontoPromo() {
		return getCost();
	}

}
