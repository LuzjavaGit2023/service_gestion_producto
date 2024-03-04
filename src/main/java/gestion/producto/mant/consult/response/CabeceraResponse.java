package gestion.producto.mant.consult.response;

public class CabeceraResponse {
	
	private String idRastreo;
	private Integer codigo;
	
	public String getIdRastreo() {
		return idRastreo;
	}
	public void setIdRastreo(String idRastreo) {
		this.idRastreo = idRastreo;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "CabeceraResponse [idRastreo=" + idRastreo + ", codigo=" + codigo + "]";
	}
	
	

}
