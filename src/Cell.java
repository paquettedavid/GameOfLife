/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

public class Cell{
	private boolean _isAlive;
	Cell(boolean state){
		_isAlive = state;
	}
	
	public void killCell(){
		_isAlive = false;
	}
	
	public void liveCell(){
		_isAlive = true;
	}
	
	public boolean isAlive(){ //false is dead, true is alive
		return _isAlive;
	}
	
}