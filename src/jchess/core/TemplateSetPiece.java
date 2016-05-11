package jchess.core;

import org.apache.log4j.Logger;

public abstract class TemplateSetPiece {
	
    /**  
     *  Method to set Figures in row (and set Queen and King to right position)
     *  @param i row where to set figures (Rook, Knight etc.)
     *  @param player which is owner of pawns
     *  @param upsideDown if true white pieces will be on top of chessboard
     * */
    protected abstract void setFigures4NewGame(int i, Player player, Chessboard chess, Logger log);
    
    /**  method set Pawns in row
     *  @param i row where to set pawns
     *  @param player player which is owner of pawns
     * */
    protected abstract void setPawns4NewGame(int i, Player player, Chessboard chess, Logger log);
    
    
    public final void setPieces4NewGame(Player plWhite, Player plBlack, Chessboard chess, Logger log)
    {
        /* WHITE PIECES */
        Player player = plBlack;
        Player player1 = plWhite;
        setFigures4NewGame(0, player, chess, log);
        setPawns4NewGame(1, player, chess, log);
        setFigures4NewGame(chess.getHeight()-1, player1, chess, log);
        setPawns4NewGame(chess.getHeight()-2, player1, chess, log);
    }/*--endOf-setPieces(boolean upsideDown)--*/
}
