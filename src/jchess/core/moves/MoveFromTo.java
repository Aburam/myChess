package jchess.core.moves;

import jchess.core.Chessboard;

public class MoveFromTo extends MonteurMove {

	
	public MoveFromTo(Chessboard chessboard) {
		super(chessboard);
		// TODO Auto-generated constructor stub
	}

	public MoveFromTo xFrom(int xFrom){
		this.xFrom = xFrom;
		return this;
	}
	
	public MoveFromTo yFrom(int yFrom){
		this.yFrom = yFrom;
		return this;
	}
	
	public MoveFromTo xTo(int xTo){
		this.xTo = xTo;
		return this;
	}
	
	public MoveFromTo yTo(int yTo){
		this.yTo = yTo;
		return this;
	}

}
