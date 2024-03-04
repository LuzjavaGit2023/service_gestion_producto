package gestion.producto.mant.consult.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gestion.producto.mant.consult.entity.ProductoEntity;
import gestion.producto.mant.consult.response.CabeceraResponse;
import gestion.producto.mant.consult.response.ProductoMsgResponse;
import gestion.producto.mant.consult.service.MantProductoService;
import gestion.producto.mant.consult.vo.ProductoVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import java.time.LocalDateTime;

import javax.validation.Valid;

@RestController
@RequestMapping("/mant")
public class GestionProducto {

	@Autowired
	private MantProductoService mantProductoServ;

	@PostMapping("/insert")
	public ResponseEntity<ProductoMsgResponse>  insertProducto(@Valid  @RequestBody  ProductoVO productoVO) {

		try {

			return new ResponseEntity<>( mantProductoServ.insertinsertProd(productoVO), 
			          HttpStatus.OK);
		
		} catch (Exception e) {
			
			LocalDateTime localDateTime = LocalDateTime.now();
			CabeceraResponse cabResponse = new CabeceraResponse();
			ProductoMsgResponse msgResponse = new ProductoMsgResponse();
			ProductoEntity productoEntity = new ProductoEntity();
			productoEntity.setIdProducto(0);
			productoEntity.setNomProducto("");
			productoEntity.setFecRegistro(localDateTime);
			
				cabResponse.setCodigo(200);
				cabResponse.setIdRastreo("Error en consulta de Producto :"+productoVO.getIdProducto());
				
				msgResponse.setCabeceraResponse(cabResponse);
				msgResponse.setMensaje("Registro no existe");

				msgResponse.setProductoVO(this.getProdVO(productoEntity));
				
		    String message = "No se registro Novedades de Peliculas o Series"+HttpStatus.INTERNAL_SERVER_ERROR;

			return new ResponseEntity<>(
					msgResponse, 
			          HttpStatus.EXPECTATION_FAILED);
			
		}
	}
	
	private ProductoVO getProdVO(ProductoEntity productoEntity)  {
		
		ProductoVO productoVO=new ProductoVO();
		BeanUtils.copyProperties(productoEntity,productoVO);
			
		return productoVO;
	}
	
}
