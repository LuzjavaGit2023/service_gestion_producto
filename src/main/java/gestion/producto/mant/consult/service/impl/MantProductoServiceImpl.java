package gestion.producto.mant.consult.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;
import gestion.producto.mant.consult.entity.ProductoEntity;
import gestion.producto.mant.consult.exception.UnprocessableEntityException;
import gestion.producto.mant.consult.repository.ProductoRepository;
import gestion.producto.mant.consult.response.CabeceraResponse;
import gestion.producto.mant.consult.response.ProductoMsgResponse;
import gestion.producto.mant.consult.service.MantProductoService;
import gestion.producto.mant.consult.vo.ProductoVO;


import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MantProductoServiceImpl implements MantProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	

	
	@Override
	public ProductoMsgResponse insertinsertProd(ProductoVO productoVO) throws UnprocessableEntityException{
		
		try {
			LocalDateTime localDateTime = LocalDateTime.now();

			ProductoEntity productoEntity =new ProductoEntity();
			productoEntity= this.getEntityVOProducto(productoVO);
			
			productoEntity.setFecRegistro(localDateTime);
			productoRepository.insertProducto(productoEntity.getIdProducto(), productoEntity.getNomProducto(), productoEntity.getFecRegistro());
			return consultProd(productoVO.getIdProducto());
		}
		catch(Exception e) {
			System.out.println("Error al insertar y consultar Producto => " + e.getMessage());
			return consultProd(productoVO.getIdProducto());
		}
		
	}


	private ProductoEntity getEntityVOProducto(ProductoVO productoVO) {
		ProductoEntity productoEntity = new ProductoEntity();
		BeanUtils.copyProperties(productoVO, productoEntity);
		return productoEntity;
	}


	private ProductoMsgResponse consultProd(long id) {
		CabeceraResponse cabResponse = new CabeceraResponse();
		ProductoMsgResponse msgResponse = new ProductoMsgResponse();
		ProductoEntity productoEntity = new ProductoEntity();
		
		productoEntity = productoRepository.getById(id);
		
			cabResponse.setCodigo(200);
			cabResponse.setIdRastreo("Exito en consulta de Producto :"+id);
			
			msgResponse.setCabeceraResponse(cabResponse);
			msgResponse.setMensaje("Registro consultado existe");

			msgResponse.setProductoVO(this.getProdVO(productoEntity));
			
			return msgResponse;
	}


	private ProductoVO getProdVO(ProductoEntity productoEntity)  {
		
		ProductoVO productoVO=new ProductoVO();
		BeanUtils.copyProperties(productoEntity,productoVO);
			
		return productoVO;
	}


	

	
}
