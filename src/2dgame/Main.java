public class Main{
	public static void main(String args[]){

    System.out.println("Testing");
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("2dgame");

    GamePael gamePanel = new GamePanel();
    window.add(gamePanel);

    window.pack();

    window.setLocationRelativeTo(null);
    window.setVisible(true);

	}}