/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedSlider extends JSlider{

	LifeController _controller;

	public SpeedSlider(int min, int max, int start, LifeController controller){
		super(min, max, start);
		_controller = controller;
		this.addChangeListener(new myChangeListener());
	}

public class myChangeListener implements ChangeListener{ //Listener class for changing the value of the JSlider
	public void stateChanged(ChangeEvent e) { //if state changes
		_controller.setInterval(getValue()); //set speed of animation

	}
}

}