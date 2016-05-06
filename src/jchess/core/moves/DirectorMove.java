package jchess.core.moves;

import jchess.core.Chessboard;

public class DirectorMove {
	
	MonteurMove monteurMove;
	
	public void move(){
		monteurMove.move();
	}
	
	public void setMonteurMove(MonteurMove monteurMove){
		this.monteurMove = monteurMove;
	}
	
	
	public Chessboard getChessboard(){
		return monteurMove.getChessboard();
	}
}
