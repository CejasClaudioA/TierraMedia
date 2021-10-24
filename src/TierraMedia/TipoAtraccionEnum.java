package TierraMedia;

public enum TipoAtraccionEnum {
	AVENTURA("Aventura"), PAISAJE("Paisaje"), DEGUSTACION("Degustación");

	private String descripcion;

	private TipoAtraccionEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}
}
