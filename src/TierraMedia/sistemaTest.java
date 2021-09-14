package TierraMedia;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class sistemaTest {
	Atraccion minas = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccionEnum.PAISAJE);
	Atraccion comarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccionEnum.DEGUSTACION);
	Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccionEnum.AVENTURA);
	Atraccion abismo = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccionEnum.PAISAJE);
	Atraccion lothlorien = new Atraccion("Lothlorien", 35, 1, 30, TipoAtraccionEnum.DEGUSTACION);
	Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccionEnum.PAISAJE);
	Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 1, TipoAtraccionEnum.AVENTURA);
	ArrayList<Atraccion> atraccion1 = new ArrayList<>();
	ArrayList<Atraccion> atraccion2 = new ArrayList<>();
	ArrayList<Atraccion> atraccion3 = new ArrayList<>();
	ArrayList<Promocion> promociones = new ArrayList<>();
	Usuario eowyn= new Usuario("Eowyn",100,80,TipoAtraccionEnum.AVENTURA);
	Usuario gandalf= new Usuario("Gandalf",100,50,TipoAtraccionEnum.PAISAJE);
	Usuario sam= new Usuario("Sam",72,16,TipoAtraccionEnum.DEGUSTACION);
	Usuario galadriel= new Usuario("Galadriel",120,100,TipoAtraccionEnum.PAISAJE);	
	ArrayList<Usuario> usuarios = new ArrayList<>();
	
	@Test
	void testSugerenciaSam() throws IOException {
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, TipoPromocionEnum.PROMOCIONPORCENTUAL,atraccion1, 20);	
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustacion", TipoAtraccionEnum.DEGUSTACION, TipoPromocionEnum.PROMOCIONABSOLUTA,atraccion2);
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, TipoPromocionEnum.PROMOCIONAXB, atraccion3);
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		usuarios.add(sam);
		usuarios.add(gandalf);
		usuarios.add(eowyn);
		usuarios.add(galadriel);
		
		Sistema sistema = new Sistema(usuarios, promociones);
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		promocionesAux.add(PromocionAbsoluta);
		assertEquals(sistema.seleccionarPromociones(sam, promociones), promocionesAux);
	}
	
	@Test
	void testSugerenciaAlternativaSam() throws IOException {
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, TipoPromocionEnum.PROMOCIONPORCENTUAL,atraccion1, 20);	
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustacion", TipoAtraccionEnum.DEGUSTACION, TipoPromocionEnum.PROMOCIONABSOLUTA,atraccion2);
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, TipoPromocionEnum.PROMOCIONAXB, atraccion3);
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		usuarios.add(sam);
		usuarios.add(gandalf);
		usuarios.add(eowyn);
		usuarios.add(galadriel);
		
		Sistema sistema = new Sistema(usuarios, promociones);
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		promocionesAux.add(PromocionPorcentual);
		promocionesAux.add(PromocionAxB);
		assertEquals(sistema.seleccionarPromocionesAlternativas(sam, promociones), promocionesAux);
	}
	
	@Test
	void testCargarUsuarios() throws IOException {
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, TipoPromocionEnum.PROMOCIONPORCENTUAL,atraccion1, 20);	
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustacion", TipoAtraccionEnum.DEGUSTACION, TipoPromocionEnum.PROMOCIONABSOLUTA,atraccion2);
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, TipoPromocionEnum.PROMOCIONAXB, atraccion3);
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		usuarios.add(sam);
		usuarios.add(gandalf);
		usuarios.add(eowyn);
		usuarios.add(galadriel);
		
		Sistema sistema = new Sistema();
		assertEquals(sistema.cargarUsuarios(), usuarios);
	}
	
	@Test
	void testCargarPromociones() throws IOException {
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, TipoPromocionEnum.PROMOCIONPORCENTUAL,atraccion1, 20);	
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustacion", TipoAtraccionEnum.DEGUSTACION, TipoPromocionEnum.PROMOCIONABSOLUTA,atraccion2);
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, TipoPromocionEnum.PROMOCIONAXB, atraccion3);
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		usuarios.add(sam);
		usuarios.add(gandalf);
		usuarios.add(eowyn);
		usuarios.add(galadriel);

		Sistema sistema = new Sistema();
		ArrayList<Promocion> promocionesAux = new ArrayList<>();
		promocionesAux.add(PromocionPorcentual);
		promocionesAux.add(PromocionAbsoluta);
		promocionesAux.add(PromocionAxB);
		sistema.cargarAtracciones();
		assertEquals(sistema.cargarPromociones(), promocionesAux);
	}
	
	
	
	
	
	
	
	

}
