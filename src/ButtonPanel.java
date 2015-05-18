/* David Paquette
 * 18 Nov 2013
 * Program 8
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class ButtonPanel extends javax.swing.JPanel{
	private LifeView _view;
	private javax.swing.JPanel _radioRow;
	private AnimationButton _animationButton;
	private SpeedSlider _slider;
	public ButtonPanel (LifeView view){

		super(new GridLayout(0,1));
		this.setBackground(Color.BLACK);
		_view = view;
		_radioRow = new javax.swing.JPanel();
		
		this.add(_radioRow);
	}

	public void add(AnimationButton button){
		super.add(button);
		_radioRow.add(button);
		_animationButton = button;
		button.addActionListener(button);
	}
	
	public void add(SpeedSlider slider){
		_slider = slider;
		
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>(); //table for holding JLabels on JSlider
		labelTable.put(20, new JLabel("Fast") ); //set integer on JSLider 20 to be labeled "Fast"
		labelTable.put(1000, new JLabel("Slow") ); //set integer on JSLider 1000 to be labeled "Slow"
		_slider.setLabelTable( labelTable );
		
		_slider.setPaintLabels(true);

		_radioRow.add(slider);
	}

	public void setButtonText(String s){
		_animationButton.setText(s);
	}

}