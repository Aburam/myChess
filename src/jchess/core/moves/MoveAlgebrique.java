package jchess.core.moves;


import jchess.core.Chessboard;

import org.apache.log4j.Logger;

public class MoveAlgebrique extends MonteurMove {

	private final Logger LOG = Logger.getLogger(MoveAlgebrique.class);

	
	public MoveAlgebrique(Chessboard chessboard) {
		super(chessboard);
		// TODO Auto-generated constructor stub
	}

	String horizontalCase = "abcdefgh";
	String verticalCase = "87654321";
	
	public MoveAlgebrique from(String from) {
		if(from.length()!=2){

	        LOG.error("Erreur, il faut entrer un numéro de case");//4test
		}
		else{
			xFrom = horizontalCase.indexOf(from.getBytes()[0]);
			
			yFrom = verticalCase.indexOf(from.getBytes()[1]);	
		}
		return this;
	}
	
	public MoveAlgebrique to(String to) {
		if(to.length()!=2){

	        LOG.error("Erreur, il faut entrer un numéro de case");//4test
		}
		else{
			xTo = horizontalCase.indexOf(to.getBytes()[0]);
			yTo = verticalCase.indexOf(to.getBytes()[1]);	
		}
		return this;
	}

}
