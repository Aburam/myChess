package jchess.core;

import jchess.core.pieces.implementation.Bishop;
import jchess.core.pieces.implementation.Guard;
import jchess.core.pieces.implementation.King;
import jchess.core.pieces.implementation.Knight;
import jchess.core.pieces.implementation.Pawn;
import jchess.core.pieces.implementation.Queen;
import jchess.core.pieces.implementation.Rook;

import org.apache.log4j.Logger;

public class NormalSetPiece extends TemplateSetPiece {

	@Override
	protected void setFigures4NewGame(int i, Player player, Chessboard chess, Logger log) {
		if (i != 0 && i != chess.getHeight()-1) {
			log.error("error setting figures like rook etc.");
			return;
		} else if (i == 0) {
			player.goDown = true;
		}

		chess.getSquare(0, i).setPiece(new Rook(chess, player));
		chess.getSquare(7, i).setPiece(new Rook(chess, player));
		chess.getSquare(1, i).setPiece(new Knight(chess, player));
		chess.getSquare(6, i).setPiece(new Knight(chess, player));
		chess.getSquare(2, i).setPiece(new Bishop(chess, player));
		chess.getSquare(5, i).setPiece(new Bishop(chess, player));
		chess.getSquare(3, i).setPiece(new Queen(chess, player));

		for (int x = 8; x < chess.getWidth(); x++) {
			int randomPiece = (int) (Math.random() * 5);
			switch (randomPiece) {
			case 0:
				chess.getSquare(x, i).setPiece(new Rook(chess, player));
				break;
			case 1:
				chess.getSquare(x, i).setPiece(new Knight(chess, player));
				break;
			case 2:
				chess.getSquare(x, i).setPiece(new Bishop(chess, player));
				break;
			case 3:
				chess.getSquare(x, i).setPiece(new Queen(chess, player));
				break;
			case 4:
				chess.getSquare(x, i).setPiece(new Guard(chess, player));
				break;
			default:
				break;
			}
		}

		if (player.getColor() == Colors.WHITE) {
			chess.setKingWhite(new King(chess, player));
			chess.getSquare(4, i).setPiece(chess.getKingWhite());
		} else {
			chess.setKingBlack(new King(chess, player));
			chess.getSquare(4, i).setPiece(chess.getKingBlack());
		}
	}

	@Override
	protected void setPawns4NewGame(int i, Player player, Chessboard chess, Logger log) {
		if (i != 1 && i != chess.getHeight()-2) {
			log.error("error setting pawns etc.");
			return;
		}
		for (int x = 0; x < chess.getWidth(); x++) {
			chess.getSquare(x, i).setPiece(new Pawn(chess, player));
		}
	}

}
