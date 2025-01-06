package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public boolean[][] possibleMoves() {
		
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		
		Position p = new Position(0, 0);
		
		if (getColor() == Color.WHITE) {
			p.setValues(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(position.getLinha() - 2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			//en passant - white
			if (position.getLinha() == 3) {
				Position left = new Position(position.getLinha(), position.getColuna() - 1);
				if (getBoard().positionExists(left) && isThereOpponentePiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getLinha() - 1][left.getColuna()] = true;
				}
				Position right = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(right) && isThereOpponentePiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getLinha() - 1][right.getColuna()] = true;
				}
				
			}
			
			
		} else {
			p.setValues(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			
			p.setValues(position.getLinha() + 2, position.getColuna());
			Position p2 = new Position(position.getLinha() + 1, position.getColuna());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() + 1, position.getColuna() - 1);
			if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 1, position.getColuna() + 1);
			if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			//en passant - black
			if (position.getLinha() == 4) {
				Position left = new Position(position.getLinha(), position.getColuna() - 1);
				if (getBoard().positionExists(left) && isThereOpponentePiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					matriz[left.getLinha() + 1][left.getColuna()] = true;
				}
				Position right = new Position(position.getLinha(), position.getColuna() + 1);
				if (getBoard().positionExists(right) && isThereOpponentePiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					matriz[right.getLinha() + 1][right.getColuna()] = true;
				}
				
			}
			
		}
		
		return matriz;
	}
	
	
	
	@Override
	public String toString() {
		return "P";
	}
}
