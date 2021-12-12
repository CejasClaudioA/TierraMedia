package model;

import java.util.ArrayList;

public class PromotionAxB extends Promotion {
	protected double montoPromo;

	public PromotionAxB(Integer id, String name, String type, String typeProm, String attractionsId) {
		super(id, name, type, typeProm, attractionsId);
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMontoPromo() {
		return getCost() - this.attractions.get(this.attractions.size() - 1).getCapacity();
	}

}
