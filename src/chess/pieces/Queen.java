package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
	
	public Queen(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		
		Position p = new Position(0, 0);
		
		//Verificar a cima da peça
		p.setValues(position.getLinha() - 1, position.getColuna());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha((p.getLinha() - 1));
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificar casas a esquerda
		p.setValues(position.getLinha(), position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		//Verificar casas a direita
		p.setValues(position.getLinha(), position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		//Verificar abaixo da peça
		p.setValues(position.getLinha() + 1, position.getColuna());
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha((p.getLinha() + 1));
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificar diagonal esquerda superior da peça
		p.setValues(position.getLinha() - 1, position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() - 1, p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificar casas diagonal superior direita
		p.setValues(position.getLinha() - 1, position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() - 1, p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificar diagonal inferior direita
		p.setValues(position.getLinha() + 1, position.getColuna() + 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() + 1, p.getColuna() + 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		//Verificar diagonal inferior esquerda
		p.setValues(position.getLinha() + 1, position.getColuna() - 1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() + 1, p.getColuna() - 1);
		}
		if (getBoard().positionExists(p) && isThereOpponentePiece(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		
		
		
		
		
		
		return matriz;
	}
	
}
