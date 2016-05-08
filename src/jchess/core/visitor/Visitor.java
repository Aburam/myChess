package jchess.core.visitor;

import jchess.core.Chessboard;
import jchess.core.pieces.Piece;

public interface Visitor {
	
	public void visitChessboard(Chessboard chessboard);
	
	//visite du Pion
	public void visitPiece(Piece piece);
	
}