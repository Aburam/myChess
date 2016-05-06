package jchess.core.moves;

import jchess.core.Chessboard;

public abstract class MonteurMove {
	
	
	protected Chessboard chessboard;
	
	protected int xFrom;
	protected int yFrom;
	protected int xTo;
	protected int yTo;
	
	public MonteurMove(Chessboard chessboard){
		this.chessboard = chessboard;
	}
	
	
	
	public Chessboard getChessboard() {
		// TODO Auto-generated method stub
		return chessboard;
	}
	
	public void move(){
		chessboard.move(chessboard.getSquare(xFrom, yFrom), chessboard.getSquare(xTo,yTo));
	}

}
