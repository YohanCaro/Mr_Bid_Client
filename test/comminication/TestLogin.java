package comminication;

import java.util.Scanner;

import com.prg3.mr_bid.model.entity.BidDate;
import com.prg3.mr_bid.model.entity.BidTime;
import com.prg3.mr_bid.model.entity.Product;
import com.prg3.mr_bid.model.entity.TypeProduct;
import com.prg3.mr_bid.model.manager.Manager;

public class TestLogin {
	
	public static Manager manager;
	public static boolean isRegist;
	public static String option;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		isRegist = false;
		System.out.println("Para ingresar escribe cualquier cosa");
		option = sc.next();
		manager = null;
		
		while (!option.toLowerCase().equals("salir") && !option.toLowerCase().equals("out")) {
			if (!isRegist) {
				showMenuRegist();
				option = sc.next();
				menuRegist(sc);
			} else {
				showMenu();
				option = sc.next();
				menuBidding(sc);
			}
		}
		System.out.println("Programa cerrado");
	}
	
	public static void showMenu() {
		System.out.println("Menu de usuario");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Agregar");
		System.out.println("2 - Ver mis subastas");
		System.out.println("Escribe 'salir' o 'out' para salir");
	}
	
	public static void showMenuRegist() {
		System.out.println("Login");
		System.out.println("Elija una opcion:");
		System.out.println("1 - Registarse");
		System.out.println("2 - Loguearse");
		System.out.println("Escribe 'salir' o 'out' para salir");
	}
	
	public static void menuRegist(Scanner sc) {
		switch (option) {
		case "1":
			System.out.println("Nombre y apellido (separado por guion(-))");
			String[] name = sc.next().split("-");
			System.out.println("Correo");
			String email = sc.next();
			System.out.println("Contraseña");
			String passd = sc.next();
			System.out.println("Fecha de nacimiento (DD/MM/YYYY)");
			String date = sc.next();
			System.out.println("Genero (M o F)");
			char gender = sc.next().charAt(0);
			manager = new Manager(name[0], name[1], email, passd, new BidDate(date), (gender=='F'?true:false), null);
			break;
		case "2":
			System.out.println("Correo");
			String email2 = sc.next();
			System.out.println("Contraseña");
			String passd2 = sc.next();
			if (!email2.isEmpty() && email2 != null) {
				if (email2.equals(manager.getUser().getEmail()) && passd2.equals(manager.getUser().getPassword())) {
					isRegist = true;
				} else {
					System.out.println("Usuario o contraseña incorrectos!");
				}
			} else {
				System.out.println("Ingrese un valor correcto! (vuleva)");
			}
			break;
		case "salir":
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Escriba algo valido!");
			break;
		}
	}
	
	public static void menuBidding(Scanner sc) {
		switch (option) {
		case "1":
			System.out.println("Nombre de la publicacion:");
			String publi = sc.next();
			System.out.println("Tipo de producto:");
			String tipo = sc.next();
			System.out.println("Nombre de Producto");
			String prod = sc.next();
			System.out.println("Descripcion de Producto");
			String desc = sc.next();
			System.out.println("Fecha de publicacion (DD/MM/YYYY)");
			String date = sc.next();
			System.out.println("Hora de publicacion");
			short hora = sc.nextShort();;
			System.out.println("Fecha de inicio (DD/MM/YYYY)");
			String date2 = sc.next();
			System.out.println("Hora de publicacion");
			short hora2 = sc.nextShort();
			System.out.println("Fecha de fin (DD/MM/YYYY)");
			String date3 = sc.next();
			System.out.println("Hora de publicacion");
			short hora3 = sc.nextShort();
			manager.addBidding(publi, TypeProduct.APPLIANCES, new Product(prod, desc),
					new BidTime(new BidDate(date), hora), new BidTime(new BidDate(date2), hora2),
					new BidTime(new BidDate(date3), hora3), true, true);
			break;
		case "2":
			System.out.println(manager.showUserBiddings());
			break;
		case "salir":
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Escriba algo valido!");
			break;
		}
	}

}
