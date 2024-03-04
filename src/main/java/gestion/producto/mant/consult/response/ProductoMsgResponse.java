package gestion.producto.mant.consult.response;

import java.util.Optional;

import gestion.producto.mant.consult.vo.ProductoVO;



public class ProductoMsgResponse {

	private CabeceraResponse cabeceraResponse;
	private ProductoVO productoVO;
	private String mensaje;
	public CabeceraResponse getCabeceraResponse() {
		return cabeceraResponse;
	}
	public void setCabeceraResponse(CabeceraResponse cabeceraResponse) {
		this.cabeceraResponse = cabeceraResponse;
	}
	public ProductoVO getProductoVO() {
		return productoVO;
	}
	public void setProductoVO(ProductoVO productoVO) {
		this.productoVO = productoVO;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "SeriesMsgResponse [cabeceraResponse=" + cabeceraResponse + ", productoVO=" + productoVO + ", mensaje="
				+ mensaje + "]";
	}
	
	
	
	
	
	
	
	
	
}
