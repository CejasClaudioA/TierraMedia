package model;

import java.util.ArrayList;

public class PromotionPorcentual extends Promotion {
	private int descuento;
	protected double montoPromo;
	
	public PromotionPorcentual(Integer id, String name, String type, String typeProm,
			String attractionsId, int descuento) {
		super(id, name, type, typeProm, attractionsId);
		this.descuento = descuento;
		this.montoPromo = getMontoPromo();
	}

	@Override
	public double getMontoPromo() {
		return getCost() - (getCost() * this.descuento) / 100;
	}
	
}
