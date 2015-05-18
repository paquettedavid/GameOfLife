/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class LifeView extends javax.swing.JPanel{

	private GameModel _gameModel;
	private SmartRectangle[][] _grid;
	private final int _CELL_DIAMETER = 30;
	private boolean _allowAdd; //boolean for if animation is running/ allowed to add new cells
	public LifeView(GameModel aGameModel){

		this.setBackground(java.awt.Color.WHITE);
		this.addMouseListener(new MyMouseListener());
		_gameModel = aGameModel;


		int gameH = _gameModel.getHeight();
		int gameW = _gameModel.getWidth();


		_grid = new SmartRectangle[gameH][gameW];

		for(int i = 0; i<gameH;i++){ //Instantiate all SmartRectangles for grid
			for(int j = 0; j < gameW;j++){
				_grid[i][j] = new SmartRectangle(Color.black);
				_grid[i][j].setSize(29, 29);
				_grid[i][j].setBorderColor(Color.RED);
				_grid[i][j].setLocation(i*30, j*30);
			}
		}
		_allowAdd = true;
		repaint();
	}

	private class MyMouseListener extends javax.swing.event.MouseInputAdapter{
		public void mousePressed(MouseEvent e){
			if(_allowAdd){ //if animation is not running add cell
				addCell(e.getX(), e.getY());
			}

		}
	}

	private int[] getIndex(int x, int y){ //return index of cell at mouse click location
		int[] index;
		index = new int[2];
		index[0] = x/30;
		index[1] = y/30;
		//System.out.println(index[0]+", "+index[1]);
		return index;
	}


	private void addCell(int x, int y){
		int[] currentIndex = getIndex(x,y);

		if(_gameModel.isCellAlive(currentIndex[0],currentIndex[1])){ //if cell exists then kill cell
			_gameModel.setCellDead(currentIndex[0],currentIndex[1]);
		}
		else{
			_gameModel.setCellAlive(currentIndex[0],currentIndex[1]); //add cell
		}

		this.repaint();
	}

	public void setAllowAdd(boolean condition){
		_allowAdd = condition;
	}

	public void paintComponent(java.awt.Graphics aBrush){
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) aBrush;

		for(int i = 0; i<_gameModel.getHeight();i++){ //repaint grid
			for(int j = 0; j < _gameModel.getWidth();j++){
				_grid[i][j].fill(betterBrush);
			}
		}

		for(int i = 0; i<_gameModel.getHeight();i++){ //repaint cell array
			for(int j = 0; j < _gameModel.getWidth();j++){
				if(_gameModel.isCellAlive(i, j)){
					SmartEllipse tempEllipse = new SmartEllipse(Color.WHITE);
					tempEllipse.setSize(_CELL_DIAMETER, _CELL_DIAMETER);
					tempEllipse.setLocation(i*30, j*30);
					tempEllipse.fill(betterBrush);
				}
				else{

				}

			}
		}

	}

}