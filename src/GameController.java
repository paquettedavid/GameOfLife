/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

import javax.swing.JPanel;

public interface GameController {
	JPanel getIoPanel(); 
            // returns JPanel containing Button(s) 
	void startAnimation(); // starts animation
	void stopAnimation(); // stops animation
}
