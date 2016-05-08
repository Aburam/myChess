package jchess.core.pieces.traits.behaviors.implementation;


import java.util.HashSet;
import java.util.Set;

import jchess.core.Square;
import jchess.core.pieces.Piece;
import jchess.core.pieces.traits.behaviors.Behavior;

/**
 *
 * @author Baptiste Buron
 * @author Bastien Cloarec
 */
public class GuardBehavior extends Behavior
{
    
    public GuardBehavior(Piece piece)
    {
        super(piece);
    }
    
    /**
     * Annotation to superclass Piece changing pawns location
        // knight all moves<br/>
        //  _______________ Y:<br/>
        // |_|_|_|_|_|_|_|_|7<br/>
        // |_|_|_|_|_|_|_|_|6<br/>
        // |_|_|_|1|_|_|_|_|5<br/>
        // |_|_|8|_|2| |_|_|4<br/>
        // |_|7|_|G|_|3|_|_|3<br/>
        // |_|_|6|_|4|_|_|_|2<br/>
        // |_|_|_|5|_|_|_|_|1<br/>
        // |_|_|_|_|_|_|_|_|0<br/>
        //X:0 1 2 3 4 5 6 7
        //
     * @return  ArrayList with new possition of pawn
     */
    @Override
    public Set<Square> getSquaresInRange()
    {
        Set<Square> list   = new HashSet<>();
        Square[][] squares = piece.getChessboard().getSquares();
        
        int pozX = piece.getSquare().getPozX();
        int pozY = piece.getSquare().getPozY();
        
        int[][] squaresInRange = {
            {pozX - 1, pozY + 1}, //8
            {pozX - 2, pozY    }, //7
            {pozX - 1, pozY - 1}, //6
            {pozX    , pozY - 2}, //5
            {pozX + 1, pozY - 1}, //4
            {pozX + 2, pozY	   }, //3
            {pozX + 1, pozY + 1}, //2
            {pozX    , pozY + 2}, //1
        };
        
        for(int[] squareCoordinates : squaresInRange)
        {
            int x = squareCoordinates[0];
            int y = squareCoordinates[1];
            if (!piece.isOut(x, y))
            {
                list.add(squares[x][y]);
            }
        }
        return list;
    }
}