package gestion.producto.mant.consult.enums;

import gestion.producto.mant.consult.utilitarios.ErrorCodeMessage;

//import org.apache.commons.lang3.StringUtils;


public enum EnumCatalogo implements ErrorCodeMessage {

	CATALOGO_ERROR_42201(42201, "El campo SERIE/PELICULA es incorrecto."),
	CATALOGO_ERROR_42202(42202, "El campo ESTADO de NOVEDAD es incorrecto."),
	CATALOGO_ERROR_42203(42203, "El CODIGO SERIE/PELICULA es incorrecto."),
	
	CATALOGO_ERROR_42204(42204, "El campo SERIE/PELICULA de Continuar Viendo es incorrecto."),
	CATALOGO_ERROR_42205(42205, "El campo ESTADO de Continuar Viendo es incorrecto."),
	CATALOGO_ERROR_42206(42206, "El CODIGO SERIE/PELICULA de Continuar Viendo es incorrecto."),
	
	CATALOGO_ERROR_42207(42207, "El campo ID SERIE de SERIES MAS VISTAS es incorrecto."),
	CATALOGO_ERROR_42208(42208, "El campo ESTADO de SERIES MAS VISTAS es incorrecto."),
	;


	EnumCatalogo(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	private final int code;
	private final String msg;

	@Override
	public int getCodigo() {
		return code;
	}

	@Override
	public String getMensaje() {
		return msg;
	}

//	public static String getMensaje(int code) {
//        String msg = StringUtils.EMPTY;
//
//        for (EnumCatalogo enumCatalogo : EnumCatalogo.values()) {
//            if (enumCatalogo.code == code) {
//				msg = enumCatalogo.msg;
//                break;
//            }
//        }
//        return msg;
//    }
}
