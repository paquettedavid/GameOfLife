/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

public class LifeModel implements GameModel{

	//height and width of grid
	private int _gridX; 
	private int _gridY;
	private Cell[][] _cells; //double array to hold all cells

	public LifeModel(int x, int y){
		_gridX = x;
		_gridY = y;
		_cells = new Cell[_gridX][_gridY]; //Instantiate new cell array

		for(int i = 0; i<_gridY;i++){ //set all cells originally to dead
			for(int j = 0; j < _gridX;j++){
				_cells[i][j] = new Cell(false);
			}
		}
	}

	public boolean isCellAlive(int i, int j) { //returns if cell at index is alove
		return _cells[i][j].isAlive();
	}

	public void setCellAlive(int i, int j) { //turn cell at index to alive
		_cells[i][j].liveCell();
	}

	public void setCellDead(int i, int j) { //turn cell at index to dead
		_cells[i][j].killCell();
	}
	public void updateGame() { //compute new genration
		checkCells();
	}

	public int getHeight() { //returns height of grid/array
		return _gridY;
	}

	public int getWidth() { //returns width of grid/array
		return _gridX;
	}

	private int getNeighbors(int i, int j){ //returns number of neighbors of cell at index

		int tN = 0;
		if(i>0 && j>0){ //if cells are not along edges
			if(_cells[i-1][j-1].isAlive()){
				tN++;
			}
			if(_cells[i][j-1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j-1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j].isAlive()){
				tN++;
			}
			if(_cells[i-1][j].isAlive()){
				tN++;
			}
			if(_cells[i-1][j+1].isAlive()){
				tN++;
			}
			if(_cells[i][j+1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j+1].isAlive()){
				tN++;
			}

		}
		else if(i==0 && j==0){ //cells in top corner

			if(_cells[i+1][j].isAlive()){
				tN++;
			}
			if(_cells[i][j+1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j+1].isAlive()){
				tN++;

			}

		}
		else if(i==0){ //along top
			if(_cells[i][j-1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j-1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j].isAlive()){
				tN++;
			}
			if(_cells[i][j+1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j+1].isAlive()){
				tN++;
			}
		}
		else if(j==0){ //along side
			if(_cells[i+1][j].isAlive()){
				tN++;
			}
			if(_cells[i-1][j].isAlive()){
				tN++;
			}
			if(_cells[i-1][j+1].isAlive()){
				tN++;
			}
			if(_cells[i][j+1].isAlive()){
				tN++;
			}
			if(_cells[i+1][j+1].isAlive()){
				tN++;
			}
		}
		return tN;	
	}

	private void checkCells(){
		Cell[][] cells;
		cells = new Cell[_gridX][_gridY]; //new temp cell array
		
		for(int i = 0; i<_gridY;i++){ //copy _cell array to new temp array
			for(int j = 0; j < _gridX;j++){
				cells[i][j] = new Cell(_cells[i][j].isAlive());
			}
		}
		
		
		for(int i = 0; i<_gridY-1;i++){ //compute the next generation
			for(int j = 0; j < _gridX-1;j++){

				int n = getNeighbors(i,j);

				if(_cells[i][j].isAlive()){
					if(n < 2){
						cells[i][j].killCell();
					}
					if(n == 2 || n == 3){
						cells[i][j].liveCell();
					}
					if(n > 3){
						cells[i][j].killCell();
					}
				}
				else{
					if(n == 3)
						cells[i][j].liveCell();
				}
			}
		}
		_cells = cells; //copy temp back to _cells
		
	}

}

