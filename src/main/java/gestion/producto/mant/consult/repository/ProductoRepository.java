package gestion.producto.mant.consult.repository;

import gestion.producto.mant.consult.entity.ProductoEntity;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ProductoRepository extends JpaRepository<ProductoEntity,Long>{
	
	@Modifying
	@Query(value="  { call p_insert_prod(:id, :nombre, :fReg) }",nativeQuery=true)
	@Transactional
	public void insertProducto(long id, String nombre, LocalDateTime fReg );
	
	
}
