package gestion.producto.mant.consult.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.SequenceGenerator;

@Table(name="PRODUCTO_H")
@Entity

public class ProductoEntity   implements Serializable{

	private static final long serialVersionUID = 8889765510811719485L;
	
	@Id   
	@Column(name="IDPRODUCTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUnico")
	@SequenceGenerator(name = "seqUnico",allocationSize=1,sequenceName="SEQ_PRODUCTO_H")
	private long idProducto;
	
	@Column(name="NOMBRE")
	private  String nomProducto;
	
	@Column(name="FECREGISTRO")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS", timezone = "GMT-5:00")
	private LocalDateTime fecRegistro;

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
	

	public ProductoEntity() {
		
	}



	
	
}
