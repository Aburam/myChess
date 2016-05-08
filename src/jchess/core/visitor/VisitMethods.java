package jchess.core.visitor;

import jchess.core.Chessboard;

public final class VisitMethods {

	
	/**
	 * Recense le nombre de types de pièces de chaque côté
	 */
	public static void m1(Chessboard chessboard){
		Visitor myVisitor = new VisitorType();
		chessboard.accept(myVisitor);
	}
	
	public static void m2(Chessboard chessboard){
		Visitor myVisitor = new VisitorScore();
		chessboard.accept(myVisitor);
	}
}
