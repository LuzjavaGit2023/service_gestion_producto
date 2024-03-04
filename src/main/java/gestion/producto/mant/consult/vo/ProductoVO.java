package gestion.producto.mant.consult.vo;
import java.io.Serializable;
import java.time.LocalDateTime;


public class ProductoVO   implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long idProducto;
	private  String nomProducto;
	private  LocalDateTime fecRegistro;
	
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNomProducto() {
		return nomProducto;
	}
	public void setNomProducto(String nomProducto) {
		this.nomProducto = nomProducto;
	}
	public LocalDateTime getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(LocalDateTime fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	
	

	

	
	
}
