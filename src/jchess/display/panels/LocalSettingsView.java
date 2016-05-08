/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jchess.display.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import jchess.core.Game;
import jchess.utils.Settings;

/**
 *
 * @author Mateusz Lach ( matlak, msl )
 */
public class LocalSettingsView extends JPanel implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6134915953298988783L;

	private JCheckBox isUpsideDown;
    
    private JCheckBox isDisplayLegalMovesEnabled;
    
    private JCheckBox isRenderLabelsEnabled;    
     
    private GridBagConstraints gbc;
    
    private GridBagLayout gbl;
    
    private Game game;

	private JCheckBox isTimeEnabled;

	private JComboBox<String> time4Game;
	
	private String times[] =
	    {
	        "1", "3", "5", "8", "10", "15", "20", "25", "30", "60", "120"
	    };
	
	
    
    public LocalSettingsView(Game game)
    {
        this.game = game;
        
        this.gbc = new GridBagConstraints();
        this.gbl = new GridBagLayout();
        
        this.setLayout(gbl);
        
        initUpsideDownControl();
        initDisplayLegalMovesControl();
        initRenderLabelsControl();
        initTimeGameControl();
        refreshCheckBoxesState();
    }
    
    private void initUpsideDownControl()
    {
        this.isUpsideDown = new JCheckBox();
        this.isUpsideDown.setText(Settings.lang("upside_down"));
        this.isUpsideDown.setSize(this.isUpsideDown.getHeight(), this.getWidth());
        this.gbc.gridx = 0;
        this.gbc.gridy = 0;
        this.gbc.insets = new Insets(3, 3, 3, 3);
        this.gbl.setConstraints(isUpsideDown, gbc);
        this.add(isUpsideDown);
        
        isUpsideDown.addActionListener(this);
    }
    
    private void initDisplayLegalMovesControl()
    {
        this.isDisplayLegalMovesEnabled = new JCheckBox();
        this.isDisplayLegalMovesEnabled.setText(Settings.lang("display_legal_moves"));     
        
        this.gbc.gridx = 0;
        this.gbc.gridy = 1;
        this.gbl.setConstraints(isDisplayLegalMovesEnabled, gbc);
        this.add(isDisplayLegalMovesEnabled);
        
        isDisplayLegalMovesEnabled.addActionListener(this);        
    }
    
    private void initRenderLabelsControl()
    {
        this.isRenderLabelsEnabled = new JCheckBox();
        this.isRenderLabelsEnabled.setText(Settings.lang("display_labels"));     
        
        this.gbc.gridx = 0;
        this.gbc.gridy = 2;
        this.gbl.setConstraints(isRenderLabelsEnabled, gbc);
        this.add(isRenderLabelsEnabled);
        
        
        
        isRenderLabelsEnabled.addActionListener(this);        
    }
    
    private void initTimeGameControl(){
    	
    	this.isTimeEnabled = new JCheckBox(Settings.lang("time_game_min"));
    	this.gbc.gridx = 0;
        this.gbc.gridy = 3;
        this.gbl.setConstraints(isTimeEnabled, gbc);
        this.add(isTimeEnabled);
        
        this.isTimeEnabled.addActionListener(this);

    	this.time4Game = new JComboBox<String>(times);
    	this.gbc.gridx = 1;
        this.gbc.gridy = 3;
        this.gbl.setConstraints(time4Game, gbc);
        this.add(time4Game);
        
        this.time4Game.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if(isTimeEnabled.isEnabled()){
		            String value = times[time4Game.getSelectedIndex()];//set time for game
		            Integer val = new Integer(value);
		            game.getSettings().setTimeForGame((int) val * 60);//set time for game and mult it to seconds
		            game.getGameClock().setTimes(game.getSettings().getTimeForGame(), game.getSettings().getTimeForGame());
		            game.repaint();
				}
				
			}
		});

                
    }    
    private void refreshCheckBoxesState()
    {
        if (isInitiatedCorrectly())
        {
            isUpsideDown.setSelected(game.getSettings().isUpsideDown());
            isDisplayLegalMovesEnabled.setSelected(game.getSettings().isDisplayLegalMovesEnabled());
            isRenderLabelsEnabled.setSelected(game.getSettings().isRenderLabels());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JCheckBox clickedComponent = (JCheckBox) e.getSource();
        if (clickedComponent == isUpsideDown)
        {
            game.getSettings().setUpsideDown(isUpsideDown.isSelected());
        } 
        else if (clickedComponent == isDisplayLegalMovesEnabled)
        {
            game.getSettings().setDisplayLegalMovesEnabled(isDisplayLegalMovesEnabled.isSelected());
        }
        else if (clickedComponent == isRenderLabelsEnabled) 
        {
            game.getSettings().setRenderLabels(isRenderLabelsEnabled.isSelected());
            game.resizeGame();
        }
        else if (clickedComponent == isTimeEnabled) {
	        if (this.isTimeEnabled.isSelected()) //if timeGame is checked
	        {
	        	game.getSettings().setTimeRunning(isTimeEnabled.isSelected());
	            String value = this.times[this.time4Game.getSelectedIndex()];//set time for game
	            Integer val = new Integer(value);
	            game.getSettings().setTimeForGame((int) val * 60);//set time for game and mult it to seconds
	            game.getGameClock().setTimes(game.getSettings().getTimeForGame(), game.getSettings().getTimeForGame());
	        }

        }
        game.repaint();
    }
    
    @Override
    public void repaint()
    {
        refreshCheckBoxesState();
        super.repaint();
    }
    
    public void disableTimeComboBox(){
    	this.isTimeEnabled.setVisible(false);
    	this.time4Game.setVisible(false);
    }

    private boolean isInitiatedCorrectly()
    {
        return null != isUpsideDown && null != isDisplayLegalMovesEnabled
                && null != isRenderLabelsEnabled;
    }
}
