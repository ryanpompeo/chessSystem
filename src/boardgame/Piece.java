package boardgame;

public class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}
	
	/*
	Exclusão do setBoard impossibilita alteração do tabuleiro
	 */
	protected Board getBoard() {
		return board;
	}
}
