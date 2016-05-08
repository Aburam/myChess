package jchess.core.visitor;

import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.pieces.Piece;

import org.apache.log4j.Logger;

public class VisitorScore implements Visitor{
	
	private final Logger LOG = Logger.getLogger(VisitorType.class);

	private int scoreWhite = 0;
	private int scoreBlack = 0;
	
	@Override
	public void visitChessboard(Chessboard chessboard) {
		//Analyse des pièces du joueur blanc
				for(Piece whitePiece : chessboard.getAllPieces(Colors.WHITE)){
					whitePiece.accept(this);
				}
				
				//Analyse des pièces du joueur noir
				for(Piece blackPiece : chessboard.getAllPieces(Colors.BLACK)){
					blackPiece.accept(this);
				}
				
				LOG.info(this);
		
	}


	@Override
	public void visitPiece(Piece piece) {
		switch (piece.getPlayer().getColor()){
		case WHITE:
			scoreWhite+=piece.getScore();
			break;
		case BLACK:
			scoreBlack+=piece.getScore();
		default:
			break;
		}
	}
	
	public String toString(){
		String retWhite = "Score du joueur blanc : " + scoreWhite;
		String retBlack = "Score du joueur noir : " + scoreBlack;
		return retWhite + ", " + retBlack;
	}

}
