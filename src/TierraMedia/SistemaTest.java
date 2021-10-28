package TierraMedia;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class SistemaTest {
	
	
	
	@Test
	void testSeleccionYOrdenamientoSugerenciaSam() throws IOException, SQLException {
		Usuario sam = new Usuario("Sam", 36.5, 20.0, "DEGUSTACION");
		Sistema sistema = new Sistema();
		sistema.reset();
		ArrayList<Promocion> promocionesTest = new ArrayList<>();
		ArrayList<Atraccion> atraccionnesTest = new ArrayList<>();
		atraccionnesTest.add(sistema.seleccionarAtraccion("Lothlorien"));
		atraccionnesTest.add(sistema.seleccionarAtraccion("Fangorn"));
		promocionesTest.add(new PromocionPorcentual("Pack Degustacion V2", "DEGUSTACION",TipoPromocionEnum.PROMOCIONPORCENTUAL, atraccionnesTest, 35));
		Collections.sort(promocionesTest);
		assertTrue(promocionesTest.equals(sistema.construirListaPromociones(sam, sistema.cargarPromociones())));	
	}
	
	
	@Test
	void testSeleccionYOrdenamientoSugerenciaAlternativaSam() throws IOException, SQLException {
		Usuario sam = new Usuario("Sam", 36.5, 20.0, "DEGUSTACION");
		Sistema sistema = new Sistema();
		ArrayList<Promocion> promocionesTest = new ArrayList<>();
		ArrayList<Atraccion> atraccionnesTest = new ArrayList<>();
		
		atraccionnesTest.add(sistema.seleccionarAtraccion("Minas Tirith"));
		atraccionnesTest.add(sistema.seleccionarAtraccion("Abismo de Helm"));
		atraccionnesTest.add(sistema.seleccionarAtraccion("Erebor"));
		promocionesTest.add(new PromocionAxB("Pack Paisajes V1", "PAISAJE",TipoPromocionEnum.PROMOCIONAXB, atraccionnesTest));
		atraccionnesTest = new ArrayList<>();
		
		atraccionnesTest.add(sistema.seleccionarAtraccion("Rivendel"));
		atraccionnesTest.add(sistema.seleccionarAtraccion("Numeror"));
		promocionesTest.add(new PromocionAxB("Pack Paisaje V2", "PAISAJE",TipoPromocionEnum.PROMOCIONAXB, atraccionnesTest));
		atraccionnesTest = new ArrayList<>();
		
		atraccionnesTest.add(sistema.seleccionarAtraccion("Bosque Negro"));
		atraccionnesTest.add(sistema.seleccionarAtraccion("Mordor"));
		promocionesTest.add(new PromocionPorcentual("Pack Aventura V1", "AVENTURA",TipoPromocionEnum.PROMOCIONPORCENTUAL, atraccionnesTest, 20));
		
		Collections.sort(promocionesTest);
		assertTrue(promocionesTest.equals(sistema.construirListaPromocionesAlternas(sam, sistema.cargarPromociones())));	
	}
	
	@Test
	void testCargarUsuarios() throws IOException, SQLException {
		Sistema sistema = new Sistema();
		ArrayList<Usuario> usuariosTest = sistema.cargarUsuario();
		assertTrue(usuariosTest.equals(sistema.cargarUsuario()));
	}
	
	@Test
	void testCargarPromociones() throws IOException, SQLException {
		Sistema sistema = new Sistema();
		ArrayList<Promocion> promocionesTest = sistema.cargarPromociones();
		assertTrue(promocionesTest.equals(sistema.cargarPromociones()));
	}
	
	@Test
	void testSeleccionarAtraccion() throws IOException, SQLException {
		Sistema sistema = new Sistema();
		Atraccion atraccion = new Atraccion("Minas Tirith", 5.0, 2.5, 10, "PAISAJE");
		assertTrue(atraccion.equals(sistema.seleccionarAtraccion("Minas Tirith")));
	}
	
	@Test 
	void seleccionarTipoAtraccion() throws IOException, SQLException {
		Sistema sistema = new Sistema();
		String tipoAtraccion = "PAISAJE";
		assertTrue(tipoAtraccion.equals(sistema.getTipoAtraccion("PAISAJE")));
	}
	
}