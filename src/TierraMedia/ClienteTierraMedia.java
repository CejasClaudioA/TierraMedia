package TierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClienteTierraMedia {

	public static void main(String[] args) {
		
		Atraccion moria = new Atraccion("Moria", 10, 2, 6, TipoAtraccionEnum.AVENTURA);
		Atraccion minas = new Atraccion("Minas Tirith", 5, 2.5, 25, TipoAtraccionEnum.PAISAJE);
		Atraccion comarca = new Atraccion("La Comarca", 3, 6.5, 150, TipoAtraccionEnum.DEGUSTACION);
		Atraccion mordor = new Atraccion("Mordor", 25, 3, 4, TipoAtraccionEnum.AVENTURA);
		Atraccion abismo = new Atraccion("Abismo de Helm", 5, 2, 15, TipoAtraccionEnum.PAISAJE);
		Atraccion lothlorien = new Atraccion("Lothlórien", 35, 1, 30, TipoAtraccionEnum.DEGUSTACION);
		Atraccion erebor = new Atraccion("Erebor", 12, 3, 32, TipoAtraccionEnum.PAISAJE);
		Atraccion bosque = new Atraccion("Bosque Negro", 3, 4, 12, TipoAtraccionEnum.AVENTURA);
		
		ArrayList<Atraccion> atraccion1 = new ArrayList<>();
		atraccion1.add(bosque);
		atraccion1.add(mordor);
		
		PromocionPorcentual PromocionPorcentual = new PromocionPorcentual("Pack aventura", TipoAtraccionEnum.AVENTURA, atraccion1, 20);
		System.out.println(PromocionPorcentual.getMonto());
		
		ArrayList<Atraccion> atraccion2 = new ArrayList<>();
		atraccion2.add(lothlorien);
		atraccion2.add(comarca);
		
		PromocionAbsoluta PromocionAbsoluta = new PromocionAbsoluta("Pack degustación", TipoAtraccionEnum.DEGUSTACION, atraccion2);
		System.out.println(PromocionAbsoluta.getMonto());
		
		ArrayList<Atraccion> atraccion3 = new ArrayList<>();
		atraccion3.add(minas);
		atraccion3.add(abismo);
		atraccion3.add(erebor);
		
		PromocionAxB PromocionAxB = new PromocionAxB("Pack paisajes", TipoAtraccionEnum.PAISAJE, atraccion3);
		System.out.println(PromocionAxB.getMonto());
		
		ArrayList<Promocion> promociones = new ArrayList<>(); 
		promociones.add(PromocionPorcentual);
		promociones.add(PromocionAbsoluta);
		promociones.add(PromocionAxB);
		Collections.sort(promociones);
		System.out.println(promociones);
		
		
		Sistema Sistema = new Sistema();
		System.out.println(Sistema.menu());
		
//		Scanner sc = new Scanner(System.in);
//		boolean salir = false;
//		int opcion;
//		System.out.println("¡Bienvenido/a a Tierra Media!");
//		System.out.println("Ingresar nombre completo:");
//    	String nombre =sc.nextLine();
//        System.out.println("Ingresar presupuesto:");
//        int presupuesto =sc.nextInt();
//        System.out.println("Ingresar tiempo disponible:");
//        double tiempoDisponible =sc.nextDouble();
//        System.out.println("Ingresar preferencia:");
//        System.out.println("1."+TipoAtraccionEnum.AVENTURA);
//        System.out.println("2."+TipoAtraccionEnum.DEGUSTACION);
//        System.out.println("3."+TipoAtraccionEnum.PAISAJE);
//        TipoAtraccionEnum tipoAtraccion=TipoAtraccionEnum.AVENTURA;
//            switch(sc.nextInt()) {
//            case 1:
//            	 tipoAtraccion= TipoAtraccionEnum.AVENTURA;
//            	break;
//            case 2:
//            	tipoAtraccion = TipoAtraccionEnum.DEGUSTACION;
//            	break;
//            case 3:
//            	tipoAtraccion = TipoAtraccionEnum.PAISAJE;
//            	break;
//        	default:
//        		sc.close();
//            }
//            
//        Usuario usuario = new Usuario(nombre,presupuesto,tiempoDisponible,tipoAtraccion);
//        System.out.println(usuario);
//		
		
		
		
		
//		while (!salir) {
//			 
//            System.out.println("1. Cargar datos de Usuario");
//            System.out.println("2. Promociones");
//            System.out.println("3. Sugerencias");
//            System.out.println("4. Salir");
// 
//            try {
//                System.out.println("Escribe una de las opciones");
//                opcion = sc.nextInt();
//                
//                switch (opcion) {
//                    case 1:
//                    	System.out.println("Ingresar nombre completo");
//                    	String nombre =sc.nextLine();
//                    	String nombre2 =sc.nextLine();
//                        System.out.println("Ingresar presupuesto");
//                        int presupuesto =sc.nextInt();
//                        System.out.println("Ingresar tiempo disponible");
//                        double tiempoDisponible =sc.nextDouble();
//                        System.out.println("Ingresar preferencia");
//                        System.out.println("1."+TipoAtraccionEnum.AVENTURA);
//                        System.out.println("2."+TipoAtraccionEnum.DEGUSTACION);
//                        System.out.println("3."+TipoAtraccionEnum.PAISAJE);
//                        TipoAtraccionEnum tipoAtraccion=TipoAtraccionEnum.AVENTURA;
//	                        switch(sc.nextInt()) {
//	                        case 1:
//	                        	 tipoAtraccion= TipoAtraccionEnum.AVENTURA;
//	                        	break;
//	                        case 2:
//	                        	tipoAtraccion = TipoAtraccionEnum.DEGUSTACION;
//	                        	break;
//	                        case 3:
//	                        	tipoAtraccion = TipoAtraccionEnum.PAISAJE;
//	                        	break;
//	                        }
//                        Usuario usuario = new Usuario(nombre2,presupuesto,tiempoDisponible,tipoAtraccion);
//                        System.out.println(usuario);
//                        break;
//                    case 2:
//                    	System.out.println("Has seleccionado la opcion 2");
//                        break;
//                    case 3:
//                        System.out.println("Has seleccionado la opcion 3");
//                        break;
//                    case 4:
//                        salir = true;
//                        sc.close();
//                        break;
//                    default:
//                        System.out.println("Solo números entre 1 y 4");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Debes insertar un número");
//                sc.next();
//            }
//		}
		
		
		
		
//		String nombre =sc.nextLine();
//		System.out.println("ingresar costo de visita");
//		double costoDeVisita = sc.nextDouble();
//		System.out.println("ingresar tiempo");
//		double tiempo = sc.nextDouble();
//		System.out.println("ingresar Tipo atraccion");
//		String tipoAtraccion = sc.nextLine();
//		System.out.println("ingresar otra atraccion");
//		String nombre =sc.nextLine();
//		System.out.println(nombre);
//		Atraccion moria = new Atraccion(nombre, 0, 0, 0, null);
		
		
		
		//Tanto las atracciones como los usuarios va a haber que cargarlos por Scanner
		//Atracciones
//		Atraccion moria = new Atraccion("Moria",10, 2.0,6, TipoAtraccionEnum.AVENTURA);
//		Atraccion minas = new Atraccion("Minas Tirith",5, 2.5,25, TipoAtraccionEnum.PAISAJE);
//		Atraccion comarca = new Atraccion("La Comarca",3, 6.5,150, TipoAtraccionEnum.DEGUSTACION);
//		Atraccion mordor = new Atraccion("Mordor",25, 3,4, TipoAtraccionEnum.AVENTURA);
//		Atraccion abismo = new Atraccion("Abismo de Helm",5, 2.0,15, TipoAtraccionEnum.PAISAJE);
		
//		System.out.println(moria.toString());
//		System.out.println("");
		
		//Usuarios
//		Usuario eowyn= new Usuario("Eowyn",10,8,TipoAtraccionEnum.AVENTURA);
//		Usuario gandalf= new Usuario("Gandalf",100,5,TipoAtraccionEnum.PAISAJE);
//		Usuario sam= new Usuario("Sam",36,8,TipoAtraccionEnum.DEGUSTACION);
		//Usuario galadriel= new Usuario("Galadriel",120,1,TipoAtraccionEnum.PAISAJE);
//		System.out.println(sam.toString());
	}

}
