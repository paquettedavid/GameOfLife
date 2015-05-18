
public class ModelTester {
	private GameModel _testTarget;
	private static int DEFAULT_HEIGHT = 20;
	private static int DEFAULT_WIDTH = 20;
	private int _rows;
	private int _cols;

	public ModelTester(int rows, int cols){
		_rows = rows;
		_cols = cols;
		_testTarget = new LifeModel(rows, cols);
	}
	
	public boolean allTestsPassed() {
		boolean result = false;
		
		
		_testTarget.setCellAlive(7, 5);
		_testTarget.setCellAlive(8, 5);
		_testTarget.updateGame();
		//two in a row test
		if(_testTarget.isCellAlive(7, 5) && _testTarget.isCellAlive(8, 5)){
			
		}
		else{
			result = true;
		}

		result = false;
		
		_testTarget.setCellAlive(7, 5);
		_testTarget.setCellAlive(8, 5);
		_testTarget.setCellAlive(9, 5);
		_testTarget.updateGame();
		
		//three in a row test
		if(_testTarget.isCellAlive(8, 4) && _testTarget.isCellAlive(8, 5) && _testTarget.isCellAlive(8, 6)){
			if(!_testTarget.isCellAlive(7, 5) && !_testTarget.isCellAlive(9, 5)){
				if(_testTarget.isCellAlive(8, 5)){
					result = true;
				}
			}
			
		}
		else{
			System.out.println("falied at three row test");
		}
		
		_testTarget.setCellAlive(0, 0);
		_testTarget.setCellAlive(0, 1);
		_testTarget.setCellAlive(0, 2);
		_testTarget.updateGame();
		_testTarget.updateGame();
		
		result = false;
		//three in corner test
		if(_testTarget.isCellAlive(0, 0) && _testTarget.isCellAlive(0, 1) && _testTarget.isCellAlive(0, 2)){
			System.out.println("falied at three corner test");
		}
		else{
			result = true;
		}
		
		
		for(int i = 0; i<_testTarget.getWidth();i++){ //killall cells
			for(int j = 0; j < _testTarget.getHeight();j++){
				_testTarget.setCellDead(i, j);
				}
			}
		
		result = false;
		
		
		_testTarget.setCellAlive(7, 8);
		_testTarget.setCellAlive(8, 8);
		_testTarget.setCellAlive(9, 8);
		_testTarget.setCellAlive(10, 8);
		_testTarget.updateGame();
		_testTarget.updateGame();
		//four row test
		if(_testTarget.isCellAlive(7, 8) && _testTarget.isCellAlive(8, 7) && _testTarget.isCellAlive(9, 7)&& _testTarget.isCellAlive(10, 8) && _testTarget.isCellAlive(9, 9)&&_testTarget.isCellAlive(8, 9)){
			result = true;
		}
		else{
			result = false;
			System.out.println("falied at four row test");
		}
		
		
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ModelTester tester = new ModelTester(DEFAULT_HEIGHT,DEFAULT_WIDTH);
		if (tester.allTestsPassed())
			System.out.println("All tests passed");
		else
			System.out.println("Not all tests passed");
	}
}

