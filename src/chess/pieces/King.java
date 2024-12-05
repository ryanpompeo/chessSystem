package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

import java.awt.*;

public class King extends ChessPiece {
	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		
		Position p = new Position(0, 0);
		
		//Verificação da casa a cima da peça
		p.setValues(position.getLinha() - 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa abaixo da peça
		p.setValues(position.getLinha() + 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa a esqueda da peça
		p.setValues(position.getLinha(), position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa a direita da peça
		p.setValues(position.getLinha(), position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa da diagonal superior esquerda da peça
		p.setValues(position.getLinha() - 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa da diagonal superior direita da peça
		p.setValues(position.getLinha() - 1, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa da diagonal inferior esqueda da peça
		p.setValues(position.getLinha() + 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		//Verificação da casa da diagonal inferior direita da peça
		p.setValues(position.getLinha() + 1, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		
		return matriz;
	}
}
