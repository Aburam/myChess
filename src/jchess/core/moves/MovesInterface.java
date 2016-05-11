package jchess.core.moves;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import jchess.core.Square;
import jchess.core.pieces.Piece;

public abstract class MovesInterface extends AbstractTableModel{
	
    protected int rowsNum = 0;
    
    protected MyDefaultTableModel tableModel;
    
    protected MovesInterface caller;

	public abstract void draw();

	public abstract String getValueAt(int x, int y);

	public abstract int getRowCount();

	public abstract int getColumnCount();

	public abstract boolean isCellEditable(int a, int b);

	/** Method of adding new move
	 * @param move String which in is capt player move
	 */
	public abstract void addMove(String move);

	public abstract void addMove(Square begin, Square end,
			boolean registerInHistory, Castling castlingMove,
			boolean wasEnPassant, Piece promotedPiece);

	public abstract void clearMoveForwardStack();

	public abstract JScrollPane getScrollPane();

	public abstract ArrayList<String> getMoves();

	public abstract Move getLastMoveFromHistory();

	public abstract Move getNextMoveFromHistory();

	public abstract Move undo();

	public abstract Move redo();

	public abstract void addMoves(ArrayList<String> list);

	/** Method of getting the moves in string
	 *  @return str String which in is capt player move
	 */
	public abstract String getMovesInString();

	/** Method to set all moves from String with validation test (usefoul for network game)
	 *  @param  moves String to set in String like PGN with full-notation format
	 */
	public abstract void setMoves(String moves);

	protected abstract String getStringValueTableModel(String str);
	
	protected void setCaller(MovesInterface caller){
		this.caller = caller;
	}

}