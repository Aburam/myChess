package jchess.core.moves;

import java.util.ArrayList;

import javax.swing.JScrollPane;

import jchess.core.Square;
import jchess.core.pieces.Piece;

public abstract class MovesDecorator extends MovesInterface {
	protected MovesInterface movesToBeDecorated;
	
	public MovesDecorator(MovesInterface movesToBeDecorated){
		this.movesToBeDecorated = movesToBeDecorated;
		this.movesToBeDecorated.setCaller(this);
	}

	@Override
	public void draw() {
		movesToBeDecorated.draw();
	}

	@Override
	public String getValueAt(int x, int y) {
		return movesToBeDecorated.getValueAt(x, y);
	}

	@Override
	public int getRowCount() {
		return movesToBeDecorated.getRowCount();
	}

	@Override
	public int getColumnCount() {
		return movesToBeDecorated.getColumnCount();
	}

	@Override
	public boolean isCellEditable(int a, int b) {
		return movesToBeDecorated.isCellEditable(a, b);
	}

	@Override
	public void addMove(String move) {
		movesToBeDecorated.addMove(move);
	}

	@Override
	public void addMove(Square begin, Square end, boolean registerInHistory,
			Castling castlingMove, boolean wasEnPassant, Piece promotedPiece) {
		movesToBeDecorated.addMove(begin, end, registerInHistory, castlingMove, wasEnPassant, promotedPiece);
	}

	@Override
	public void clearMoveForwardStack() {
		movesToBeDecorated.clearMoveForwardStack();
	}

	@Override
	public JScrollPane getScrollPane() {
		return movesToBeDecorated.getScrollPane();
	}

	@Override
	public ArrayList<String> getMoves() {
		return movesToBeDecorated.getMoves();
	}

	@Override
	public Move getLastMoveFromHistory() {
		return movesToBeDecorated.getLastMoveFromHistory();
	}

	@Override
	public Move getNextMoveFromHistory() {
		return movesToBeDecorated.getNextMoveFromHistory();
	}

	@Override
	public Move undo() {
		return movesToBeDecorated.undo();
	}

	@Override
	public Move redo() {
		return movesToBeDecorated.redo();
	}

	@Override
	public void addMoves(ArrayList<String> list) {
		movesToBeDecorated.addMoves(list);
	}

	@Override
	public String getMovesInString() {
		return movesToBeDecorated.getMovesInString();
	}

	@Override
	public void setMoves(String moves) {
		movesToBeDecorated.setMoves(moves);
	}
	
	@Override
	protected String getStringValueTableModel(String str) {
		return movesToBeDecorated.getStringValueTableModel(str);
	}

	@Override
	protected void setCaller(MovesInterface caller){
		this.movesToBeDecorated.setCaller(caller);		
	}
}
