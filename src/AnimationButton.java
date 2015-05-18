/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AnimationButton extends JButton implements ActionListener{

	LifeController _controller;

	public AnimationButton(String title, LifeController controller){
		super(title);
		_controller = controller;
	}


	public void actionPerformed(ActionEvent e) { //action method for when button is clicked
		if(_controller.isRunning()){
			_controller.stopAnimation();
		}
		else{
			_controller.startAnimation();
		}
	}

}