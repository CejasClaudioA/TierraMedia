package TierraMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ClienteTierraMedia {

	public static void main(String[] args) throws IOException {
		
		Atraccion minas = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccionEnum.PAISAJE);
		Atraccion comarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccionEnum.DEGUSTACION);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccionEnum.AVENTURA);
		Atraccion abismo = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccionEnum.PAISAJE);
		Atraccion lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoAtraccionEnum.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccionEnum.PAISAJE);
		Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 1, TipoAtraccionEnum.AVENTURA);
		
		ArrayList<Atraccion> atraccion1 = new ArrayList<>();
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, TipoPromocionEnum.PROMOCIONPORCENTUAL,atraccion1, 20);

		
		ArrayList<Atraccion> atraccion2 = new ArrayList<>();
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustación", TipoAtraccionEnum.DEGUSTACION, TipoPromocionEnum.PROMOCIONABSOLUTA,atraccion2);
		
		ArrayList<Atraccion> atraccion3 = new ArrayList<>();
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, TipoPromocionEnum.PROMOCIONAXB, atraccion3);

		
		ArrayList<Promocion> promociones = new ArrayList<>(); 
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		
		Usuario eowyn= new Usuario("Eowyn",100,80,TipoAtraccionEnum.AVENTURA);
		Usuario gandalf= new Usuario("Gandalf",100,50,TipoAtraccionEnum.PAISAJE);
		Usuario sam= new Usuario("Sam",72,16,TipoAtraccionEnum.DEGUSTACION);
		Usuario galadriel= new Usuario("Galadriel",120,100,TipoAtraccionEnum.PAISAJE);
		
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(sam);
		usuarios.add(galadriel);
		usuarios.add(eowyn);
		usuarios.add(gandalf);
		
		Sistema sistema = new Sistema();
		sistema.probarSistema();
		
	}

}
