package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

import java.awt.*;

public class King extends ChessPiece {
	
	private ChessMatch chessMatch;
	
	
	public King(Board board, Color color, ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
		
		/*
		SpecialMove - Castling
		 */
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			//rook - kingside
			Position positionRookKing = new Position(position.getLinha(), position.getColuna() + 3);
			if (testRookCastling(positionRookKing)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() + 1);
				Position p2 = new Position(position.getLinha(), position.getColuna() + 2);
				
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					matriz[position.getLinha()][position.getColuna() + 2] = true;
				}
			}
			//rook - QueenSide
			Position positionRookQueen = new Position(position.getLinha(), position.getColuna() - 4);
			if (testRookCastling(positionRookQueen)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() - 1);
				Position p2 = new Position(position.getLinha(), position.getColuna() - 2);
				Position p3 = new Position(position.getLinha(), position.getColuna() - 3);
				
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					matriz[position.getLinha()][position.getColuna() - 2] = true;
				}
				
			}
			
			
			
		}
		
		
		return matriz;
		
		
	}
}
