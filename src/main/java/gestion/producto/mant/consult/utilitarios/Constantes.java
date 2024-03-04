package gestion.producto.mant.consult.utilitarios;

import java.math.BigDecimal;

public class Constantes {

  private Constantes() {
    super();
  }

  public static final String bdPplJndi = "pe.com.claro.jdbc.datasources.noXA.ppl";
  public static final String bdPplName = "XE";
  public static final String bdPplOwner = "SYSTEM";
  public static final String PkgProducto = "pkg_producto_remoto";
  public static final String SpRegistrarProd = "p_insert_prod";
 
  
  public static final String ERROR = "Error";
  public static final String TEXTO_VACIO = "";
  public static final String FORMATOFECHACABECERA = "yyyy-MM-dd'T'HH:mm:ss'Z'";
  public static final int NUM_ZERO = 0;
  public static final String ERROR_EJECUCION_SP = " Error en la ejecucion del SP : ";
  public static final String SEPARADOR_TRES_LLAVES = "{}{}{}";
  
}
