package jchess.core.pieces.implementation;

import jchess.core.Chessboard;
import jchess.core.Player;
import jchess.core.pieces.Piece;
import jchess.core.pieces.traits.behaviors.implementation.GuardBehavior;

/**
 * Move of guard:
 *       |_|_|_|_|_|_|_|_|7
         |_|_|_|_|_|_|_|_|6
         |_|_|_|X|_|_|_|_|5
         |_|_|X| |X|_|_|_|4
         |_|X|_|G|_|X|_|_|3
         |_|_|X|_|X|_|_|_|2
         |_|_|_|X|_|_|_|_|1
         |_|_|_|_|_|_|_|_|0
         0 1 2 3 4 5 6 7
*/

public class Guard extends Piece{
    
    protected static short value = 1;
    
    
    public Guard(Chessboard chessboard, Player player)
    {
        super(chessboard, player);
        this.symbol = "G";
        this.behaviors.add(new GuardBehavior(this));
        this.score=2;
    }
}

