package gestion.producto.mant.consult.exception;


import java.util.Collections;
import java.util.List;

import gestion.producto.mant.consult.utilitarios.ErrorCodeMessage;
import gestion.producto.mant.consult.utilitarios.ErrorMessageVO;




public class UnprocessableEntityException extends Exception {

	private static final long serialVersionUID = -7600411902480257068L;

	private List<ErrorMessageVO> errors;
	private boolean printAllStack = true;

	public UnprocessableEntityException(ErrorMessageVO error) {
		super(error.getMsg());
		this.errors = Collections.singletonList(error);
	}

	public UnprocessableEntityException(List<ErrorMessageVO> errors) {
		this.errors = errors;
	}

	public UnprocessableEntityException(ErrorCodeMessage error){
		this(new ErrorMessageVO(error.getCodigo(), error.getMensaje()));
	}

	public UnprocessableEntityException(ErrorCodeMessage error, String args1) {
		this(new ErrorMessageVO(error.getCodigo(), String.format(error.getMensaje(), args1)));
	}

	public UnprocessableEntityException(int codigo, String descripcion) {
		this(new ErrorMessageVO(codigo, descripcion));
	}

	public List<ErrorMessageVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorMessageVO> errors) {
		this.errors = errors;
	}

	public boolean isPrintAllStack() {
		return printAllStack;
	}

	public void setPrintAllStack(boolean printAllStack) {
		this.printAllStack = printAllStack;
	}

}
