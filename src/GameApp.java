/* David Paquette
 * 18 Nov 2013
 * Program 8
 */

public class GameApp extends javax.swing.JFrame {
	public GameApp(String title, int x, int y){
		super(title);
		this.setSize(600, 686);
		this.setDefaultCloseOperation(  
				javax.swing.JFrame.EXIT_ON_CLOSE);

		GameModel gameModel = new LifeModel(21,21); //new game model
		LifeView lifeView = new LifeView(gameModel); //new Life view
		ButtonPanel buttonPanel = new ButtonPanel(lifeView); //new button panel 
		GameController controller = new LifeController(300, gameModel, buttonPanel, lifeView); //new game controller

		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setBackground(java.awt.Color.WHITE);
		this.add(lifeView,java.awt.BorderLayout.CENTER);
		this.add(buttonPanel,java.awt.BorderLayout.SOUTH);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public static void main (String [ ] args) {
		GameApp gameApp = new GameApp("A Game Like Life", 30, 30);
	}
}
