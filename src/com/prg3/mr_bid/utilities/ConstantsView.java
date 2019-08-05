package com.prg3.mr_bid.utilities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

/**
 * Clase ConstantsView - Constantes que los valores que se utilizan en la vista
 * como textos, fuentes, colores ...
 *
 * @version 1.0 - 4/08/2019
 * @author Yohan Caro
 */
public class ConstantsView {
	
	//Splash
	public static final Color COLOR_BACKGROUD_SPLASH = new Color(0, 0, 0, 94);
	public static final Dimension SIZE_SPLASH = new Dimension(700, 600);
	public static final String TEXT_SPALSH_RESET = "Reintentando...!";
	public static final String TEXT_SPALSH_CONECT = "Conexión exitosa!";
	public static final String TEXT_SPALSH_CONECT_INIT = "Conectando con el servidor!";
	public static final Font FONT_SPLASH = new Font("Tahoma", 1, 15);
	public static final Font FONT_PERCENT_SPLASH = new Font("Tahoma", Font.PLAIN, 14);
	public static final Font FONT_LABEL_SPLASH = new Font("Tahoma", Font.PLAIN, 18);
	public static final Color COLOR_CONECT_TEXT = new Color(255, 255, 255);
	public static final String PATH_SPLASH_ICON_IMG = "data/images/logo.jpg"; 
	
	//JPanelPrincipalLogin
	public static final String BTN_JPRINCPAL_LOGIN = "INGRESAR";
	public static final String PATH_JPRINCIPAL_USER_IMG = "data/images/usuario.png"; 
	public static final String PATH_JPRINCIPAL_BACK_IMG = "data/images/fondoLogin.jpg"; 
	public static final Color COLOR_BACKGROUD_JPRINCIPAL = Color.RED;
	public static final Color COLOR_BACKGROUD_JPRINCIPAL_CENTER = new Color(59, 232, 183);
	public static final Color COLOR_BACKGROUD_JPRINCIPAL_CENTER_IMG = new Color(0,0,0,64);
	public static final Color COLOR_BACKGROUD_JPRINCIPAL_PASSWORD = new Color(244, 244, 244);
	
	//JPanelRobotCenter
	public static final String TEXT_NO_ROBOT = "No soy un robot";
	public static final String PATH_RECAPTCHA_ROBOT = "data/images/reCaptcha.png";
	public static final Font FONT_CHECK_ROBOT = new Font("Nunito Sams",0,20);
	public static final Color COLOR_BACKGROUD_ROBOT = Color.WHITE;
	
	//JPanelOptionMenu
	public static final Color BACKGROUD_MENU = new Color(48, 48, 48);
	public static final Color BACKGROUD_MENU_2 = Color.BLACK;
	public static final String PATH_ICON_CAR_MENU = "data/images/carro.png";
	public static final Font FONT_SIGNIN_MENU = new Font("Arial", 1, 13);
	public static final Font FONT_ITEM_HOME_MENU = new Font("Arial", 1, 15);
	public static final Color COLOR_FOREGROUND_MENU = Color.WHITE;
	public static final String PATH_ICON_USER_MENU = "data/images/usuario.png";
	
	//JPaneMainWindowMyBiddings
	public static final String PATH_USER_IMAGE = "data/images/usuario.png";
	public static final String TEXT_PARTICIPATIONS_BID_WD = "MIS PARTICIPACIONES";
	public static final String TEXT_BIDDINGS_BID_WID = "MIS SUBASTAS";
	public static final Color COLOR_COMPONENT_BID_WD = new Color(0, 0, 0, 94);
	public static final Color COLOR_ATRIBUTE_BACK_BID_WD = new Color(244, 244, 244);
	public static final Color COLOR_ATRIBUTE_FORE_BID_WD = new Color(48, 48, 48);
	public static final String PATH_BACK_IMG = "data/images/fondoLogin.jpg"; 
	
	//JPanelMainWindowAcount
	public static final Color COLOR__FORE_WD = new Color(244, 244, 244);
	public static final Color COLOR__BACK_WD = new Color(48, 48, 48);
	public static final String PATH_BLOC_IMG = "data/images/bloc.png"; 
	public static final String PATH_VENT_IMG = "data/images/venta.png"; 
	public static final String PATH_AJUST_IMG = "data/images/ajuste.png"; 
	public static final Font FONT_LABEL_NAME_WD = new Font("Arian", 1, 30);
	public static final String TEXT_NOT_LOGIN = "Not login yet";
	
	//JPanelMainWindow
	public static final String PATH_PUBLI_IMG = "data/images/publicidad1.png";
	
	//JPanelMainProduct
	public static final String PATH_TV_IMG = "data/images/tv.jpg";
	public static final Color COLOR_BACK_MP = new Color(0, 0, 0, 94);
	public static final Color COLOR_COMP_MP = new Color(224, 224, 224);
	public static final Color COLOR_COMP_2_MP = new Color(255, 0, 0);
	public static final Font FONT_LABEL_MP = new Font("Andale Mono", 3, 15);
	public static final Font FONT_LABEL_R_MP = new Font("Andale Mono", 1, 14);
	public static final String TEXT_MORE_HOURS = " horas";
	public static final String TEXT_ZERO = "0";
	public static final String TEXT_CONECTED_MP = "Conectados";
	public static final String TEXT_PRIVATE_MP = "PRIVATE";
	public static final String TEXT_PARTI_MP = "Participantes";
	
	//JPanelMainAddProduct
	public static final String BT_ADD_IMG_MAP = "Agregar imagen";
	public static final String TEXT_DATA_PRODUCT = "DATOS DEL PRODUCTO";
	public static final String TEXT_DESCRIPTION = "DESCRIPCION";
	public static final String TEXT_TYPE_PUB = "TIPO DE LA PUBLICACION";
	public static final String TEXT_TYPE_PRO = "TIPO DE PRODUCTO";
	public static final String TEXT_TIME_BID = "TIEMPO DE LA SUBASTA";
	public static final String TEXT_DATE_PUB = "FECHA DE LA PUBLICACION";
	public static final String TEXT_DATE_INI = "FECHA DE INICIO";
	public static final String TEXT_DATE_FIN = "FECHA DE CIERRE";
	public static final String TEXT_HOUR_PUB = "HORA DE LA PUBLICACION";
	public static final String TEXT_HOUR_INI = "HORA DE CIERRE";
	public static final String TEXT_HOUR_FIN = "HORA DE CIERRE";
	public static final String TEXT_ABOUT_BID = "SOBRE LA SUBASTA";
	public static final String TEXT_TYPE_INCREMENT = "TIPO DE INCEMENTO";
	public static final String TEXT_MIN_VALUE = "VALOR MINIMO";
	public static final String TEXT_TYPE_BID = "TIPO DE SUBASTA";
	public static final String TEXT_AUTOMATIC = "Automatico";
	public static final String TEXT_FOR_USER = "Dado por el usuario";
	public static final String TEXT_PUBLIC = "PUBLIC";
	public static final String TEXT_PRIVATE = "PRIVATE";
	public static final String BT_CREATE_MAP = "CREAR";
	public static final String BT_CANCEL_MAP = "CANCELAR";
	
	//JPanelFormCreditCard
	public static final Dimension SIZE_PFC = new Dimension(350, 400);
	public static final String TEXT_ADD_CREDIT_CARD = "AGREGAR TARJETA DE CREDITO";
	public static final String TEXT_EXP_DATE_FPC = "FECHA DE VENCIMIENTO";
	public static final String TEXT_HOLDER_NAME_FPC = "NOMBRE TITULAR";
	public static final String TEXT_CARD_NUMBER_FPC = "NUMERO DE TARJETA";
	public static final String TEXT_SECURITY_CODE_FPC = "CODIGO DE SEGURIDAD";
	public static final String BT_ACEPT_PFC = "Aceptar";
	
	//JPanelForm
	public static final String TEXT_NAME_PF = "Nombre";
	public static final String TEXT_LAST_NAME_PF = "Apellido";
	public static final String TEXT_EMAIL_PF = "Email";
	public static final String TEXT_PASSWORD_PF = "Contraseña";
	public static final String TEXT_TYPE_DOC_PF = "Tipo de documento";
	public static final String TEXT_NUMBER_DOC_PF = "Numero Documento";
	public static final String TEXT_BIRTHDATE_PF = "Fecha de Nacimiento";
	public static final String TEXT_GENDER_PF = "Genero";
	public static final String TEXT_MALE_PF = "Masculino";
	public static final String TEXT_FEMALE_PF = "Femenino";
	public static final String TEXT_ADD_CARD_PF = "Add Tarjeta";
	public static final String TEXT_CAPTCHA_PF = "CAPTCHA";
	public static final String BT_REGIST_PF = "Registrar";
	
	//JPanelCard
	public static final Color COLOR_FORE_PC = new Color(255, 255, 255);
	public static final Color COLOR_BACK_PC = new Color(2, 41, 48);
	public static final Font FONT_PC_1 = new Font("Arial", 1, 20);
	public static final String TEXT_STATE_PC = "ESTADO";
	public static final String TEXT_TIME_REAMING_PC = "TIEMPO RESTANTE";
	public static final String BT_OK_PC = "Ingresar";
	
	//JFrameMain
	public static final String TITLE_APP = "MR BID";
	
	//JDialogAddUSer
	public static final Dimension SIZE_DIALOG_USER = new Dimension(500, 600);
	
	//JDialogAddCreditCard
	public static final Dimension SIZE_DIALOG_CREDIT_CARD = new Dimension(500, 350);
	
	//JDialogAbout
	public static Font FONT_DA_1 = new Font("Andale Mono", 1, 14);
	public static Font FONT_DA_2 = new Font("Andale Mono", 0, 9);
	public static Color COLOR_DA = new Color(0, 0, 0);
	
	public static final String TEXT_DIALOG_ABOUT = "\n\n          ACERCA DE"
			+ "\n Mr BID es una aplicación cliente servidor de subastas que busca ofrecer el"
			+ " servicio de publicación de productos de diferentes tipos en donde las personas podrán subir"
			+ " y productos y participar en las subastas que estén disponibles. \r\n" 
			;
	
}
