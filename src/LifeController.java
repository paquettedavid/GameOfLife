/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JSlider;

public class LifeController extends javax.swing.Timer implements GameController{
	
	// peer objects
	private GameModel _aModel;
	private ButtonPanel _buttonPanel;
	private LifeView _lifeView;


	public LifeController (int anInterval, GameModel aModel, ButtonPanel buttonPanel, LifeView lifeView) {
		super(anInterval, null);
		// _mover = aMover;
		_aModel = aModel;
		_buttonPanel = buttonPanel;
		_lifeView = lifeView;
		AnimationButton animationButton = new AnimationButton("Begin Animation", this); //animation button
		SpeedSlider slider = new SpeedSlider(20,1000,500, this); //Speed slider
		slider.setMajorTickSpacing(1000);
		slider.setMinorTickSpacing(100);
		slider.setPaintTicks(true);
		
		_buttonPanel.add(slider);
		_buttonPanel.add(animationButton);
		
		this.addActionListener(new LifeListener());
	}

	private class LifeListener implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e){
			_aModel.updateGame(); //compute new generation
			_lifeView.repaint(); //repaint the view
			
		}
	}

	public JPanel getIoPanel() {
		return null;
	}


	public void startAnimation() {
		_lifeView.setAllowAdd(false); //stop cells from being added/killed by mouse
		_buttonPanel.setButtonText("Stop Animation");
		this.start();

	}


	public void stopAnimation() {
		_lifeView.setAllowAdd(true); //allow user to edit cells with mouse
		_buttonPanel.setButtonText("Begin Animation");
		this.stop();

	}
	
	public void setInterval(int val){
		this.setDelay(val);
	}
	
}
