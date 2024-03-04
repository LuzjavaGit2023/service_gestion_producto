package gestion.producto.mant.consult.utilitarios;

public interface ErrorCodeMessage {

	int getCodigo();
	String getMensaje();

	default String getMensaje(Object[] args) {
		return String.format(getMensaje(), (Object[]) args);
	}

}
