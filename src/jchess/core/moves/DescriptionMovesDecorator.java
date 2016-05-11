package jchess.core.moves;

import javax.swing.JOptionPane;

public class DescriptionMovesDecorator extends MovesDecorator {

	public DescriptionMovesDecorator(MovesInterface movesToBeDecorated) {
		super(movesToBeDecorated);
	}

	@Override
	protected String getStringValueTableModel(String str) {
		String commentaire;
		commentaire = JOptionPane.showInputDialog(null, "Ajoutez un commentaire à ce coup");
		if(commentaire == null)
			commentaire = "";
		
		return super.getStringValueTableModel(str) + " : " + commentaire;
	}

}
