package gestion.producto.mant.consult.service;

import gestion.producto.mant.consult.exception.UnprocessableEntityException;
import gestion.producto.mant.consult.response.ProductoMsgResponse;
import gestion.producto.mant.consult.vo.ProductoVO;


public interface MantProductoService {
		
	ProductoMsgResponse insertinsertProd ( ProductoVO productoVO) throws UnprocessableEntityException;
	
	
}
