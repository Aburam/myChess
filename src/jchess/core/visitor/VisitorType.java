package jchess.core.visitor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import jchess.core.Chessboard;
import jchess.core.Colors;
import jchess.core.pieces.Piece;

import org.apache.log4j.Logger;

public class VisitorType implements Visitor {
	
	private final Logger LOG = Logger.getLogger(VisitorType.class);
	
	private Map<String, Integer> playerPieceWhite;
	private Map<String, Integer> playerPieceBlack;
	
	public VisitorType(){
		playerPieceWhite = new HashMap<String, Integer>();
		playerPieceBlack = new HashMap<String, Integer>();
	}

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
		String name = piece.getName();
		switch (piece.getPlayer().getColor()){
		case WHITE:
			if(playerPieceWhite.containsKey(name)){
				playerPieceWhite.replace(name, playerPieceWhite.get(name)+1);
			}
			else {
				playerPieceWhite.put(name, 1);
			}
			break;
		case BLACK:
			if(playerPieceBlack.containsKey(name)){
				playerPieceBlack.replace(name, playerPieceBlack.get(name)+1);
			}
			else {
				playerPieceBlack.put(name, 1);
			}
			break;
		default:
			break;
		}
	}

	
	
	public String toString(){
		String retWhite = "Pièces blanches : { ";
		String retBlack = "Pièces noires : { ";
		
		Iterator<Entry<String, Integer>> i = playerPieceWhite.entrySet().iterator();
		
		while(i.hasNext()){
			Entry<String,Integer> whitePiece = i.next();
			retWhite += whitePiece.getKey() + " : " + whitePiece.getValue();
			if (i.hasNext()){
				retWhite += ", ";
			}
		}
		
		i = playerPieceBlack.entrySet().iterator();
		while(i.hasNext()){
			Entry<String,Integer> blackPiece = i.next();
			retBlack += blackPiece.getKey() + " : " + blackPiece.getValue();
			if (i.hasNext()){
				retBlack += ", ";
			}
		}
		
		retWhite += " }";
		retBlack += " }";

		return retWhite + ",\n" + retBlack;
	}

	
}
