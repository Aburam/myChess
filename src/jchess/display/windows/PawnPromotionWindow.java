/*
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Authors:
 * Mateusz Sławomir Lach ( matlak, msl )
 * Damian Marciniak
 */
package jchess.display.windows;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jchess.utils.GUI;

/** Class responsible for promotion of a pawn.
 * When pawn reach the end of the chessboard it can be change to rook,
 * bishop, queen or knight. For what pawn is promoted decideds player.
 * @param parent Information about the current piece
 * @param color The player color
 */
public class PawnPromotionWindow extends JDialog implements ActionListener
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton knightButton;
    JButton bishopButton;
    JButton rookButton;
    JButton queenButton;
    JButton guardButton;
    GridBagLayout gbl;
    public String result;
    GridBagConstraints gbc;

    public PawnPromotionWindow(Frame parent, String color)
    {
        super(parent);
        this.setTitle("Choose piece");
        this.setMinimumSize(new Dimension(520, 130));
        this.setSize(new Dimension(520, 130));
        this.setMaximumSize(new Dimension(520, 130));
        this.setResizable(false);
        this.setLayout(new GridLayout(1, 5));
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.gbl = new GridBagLayout();
        this.gbc = new GridBagConstraints();
        this.knightButton = new JButton();
        this.bishopButton = new JButton();
        this.rookButton = new JButton();
        this.queenButton = new JButton();
        this.guardButton = new JButton();
        this.result = "";

        this.knightButton.addActionListener(this);
        this.bishopButton.addActionListener(this);
        this.rookButton.addActionListener(this);
        this.queenButton.addActionListener(this);
        this.guardButton.addActionListener(this);

        
        this.add(queenButton);
        this.add(rookButton);
        this.add(bishopButton);
        this.add(knightButton);
        this.add(guardButton);
    }

    /** Method setting the color fo promoted pawn
     * @param color The players color
     */
    public void setColor(String color)
    {
        this.knightButton.setIcon(new ImageIcon(GUI.loadImage("Knight-" + color + ".png")));
        this.bishopButton.setIcon(new ImageIcon(GUI.loadImage("Bishop-" + color + ".png")));
        this.rookButton.setIcon(new ImageIcon(GUI.loadImage("Rook-" + color + ".png")));
        this.queenButton.setIcon(new ImageIcon(GUI.loadImage("Queen-" + color + ".png")));
        this.guardButton.setIcon(new ImageIcon(GUI.loadImage("Guard-" + color + ".png")));

    }

    /** Method wich is changing a pawn into queen, rook, bishop, guard or knight
     * @param arg0 Capt information about performed action
     */
    public void actionPerformed(ActionEvent arg0)
    {
        if (arg0.getSource() == queenButton)
        {
            result = "Queen";
        }
        else if (arg0.getSource() == rookButton)
        {
            result = "Rook";
        }
        else if (arg0.getSource() == bishopButton)
        {
            result = "Bishop";
        }
        else if (arg0.getSource() == guardButton)
        {
            result = "Guard";
        }
        else if (arg0.getSource() == knightButton)
        {
            result = "Knight";
        }
        this.setVisible(false);
        
       
    }
    
    public String getResult(){
    	return this.result;
    }
}
