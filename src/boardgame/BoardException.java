package boardgame;

/*
Runtime indica que tratará exceções opcionais
 */
public class BoardException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public BoardException(String msg) {
		super(msg);
	}
	
	
}
