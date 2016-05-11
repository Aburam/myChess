package jchess.core.moves;

public class TimeMovesDecorator extends MovesDecorator {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long lastTime;

	public TimeMovesDecorator(MovesInterface movesToBeDecorated) {
		super(movesToBeDecorated);
		this.lastTime = System.currentTimeMillis();
	}

	@Override
	protected String getStringValueTableModel(String str) {
		long timeCoup = System.currentTimeMillis() - this.lastTime;
		timeCoup /= 1000;
		this.lastTime = System.currentTimeMillis();
		return super.getStringValueTableModel(str) + " (" + timeCoup +"s)";
	}

}
