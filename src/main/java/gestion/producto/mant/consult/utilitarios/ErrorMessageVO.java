package gestion.producto.mant.consult.utilitarios;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import gestion.producto.mant.consult.enums.EnumCatalogo;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessageVO implements Serializable {

	private static final long serialVersionUID = 6450383229867016978L;

	private int cod;
	private String msg;
	private String exc;
	private Boolean success;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ErrorMessageVO> errors;

	public ErrorMessageVO() {

	}

	public ErrorMessageVO(int cod, String msg) {
		this.cod = cod;
		this.msg = msg;
	}

	public ErrorMessageVO(ErrorCodeMessage errorCodeMessage){
		this.cod = errorCodeMessage.getCodigo();
		this.msg = errorCodeMessage.getMensaje();
	}

	public ErrorMessageVO(EnumCatalogo errorCodeMessage){
		this.cod = errorCodeMessage.getCodigo();
		this.msg = errorCodeMessage.getMensaje();
	}



	public ErrorMessageVO(String s, String msg){
		this.cod = Integer.parseInt(s);
		this.msg = msg;
	}

	public int getCod() { return cod; }

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<ErrorMessageVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorMessageVO> errors) {
		this.errors = errors;
	}

	public String getExc() {
		return exc;
	}

	public void setExc(String exc) {
		this.exc = exc;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ErrorMessage [cod=" + cod + ", msg=" + msg + "]";
	}

	@JsonIgnore
	public List<ErrorMessageVO> getAsErrorMessages(){
		if ( this.errors == null || errors.isEmpty()){
			return null;
		}

		return this.errors.stream()
				.map(s -> {
					ErrorMessageVO errorMessage = new ErrorMessageVO(s.cod,s.msg);
					errorMessage.setErrors(s.getAsErrorMessages());
					return errorMessage;
				}).collect(Collectors.toList());
	}

}
