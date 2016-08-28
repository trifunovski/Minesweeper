import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoardDrawer {
	private JButton[][] buttons;
	private int size;
	private int open = 0;
	final JFrame window;
	
	public BoardDrawer(Board board){
		this.size = board.getSize();
		buttons = new JButton[size][size];
		window = new JFrame("Minesweeper");
		window.setLocationRelativeTo(null);
		window.setSize(size*30,size*30);
		window.setLayout(new GridLayout(size, size));
		
		class clickListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton button = (JButton) e.getSource();
				int index = Integer.valueOf(button.getActionCommand());
				int iCoord = index/size;
				int jCoord = index%size;
				press(iCoord, jCoord, board);
			}
		}
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				buttons[i][j] = new JButton();
				clickListener click = new clickListener();
				buttons[i][j].addActionListener(click);
				buttons[i][j].setActionCommand(Integer.toString(i*size+j));
				window.add(buttons[i][j]);
			}
		}
		window.setVisible(true);
	}
	
	private void press(int i, int j, Board board){
		switch (board.getLoc(i, j)){
			case -1:
				//buttons[i][j].setEnabled(false);
				buttons[i][j].setText("X");
				buttons[i][j].setForeground(Color.RED);
				break;
			case 0:
				countBombs(i,j, board);
				break;
			case 1:
					
		}
	}

	private void countBombs(int i, int j, Board board) {
		if(i<0 || i>=size || j<0 || j>=size || board.getLoc(i, j) != 0)
			return;
		board.setLoc(i,j,1);
		open++;
		int sum = board.hasBomb(i-1, j) + board.hasBomb(i-1, j-1) + board.hasBomb(i-1, j+1) + 
		board.hasBomb(i, j-1) + board.hasBomb(i, j+1) + board.hasBomb(i+1, j-1) + board.hasBomb(i+1, j) + board.hasBomb(i+1, j+1);
		if(sum==0){
			buttons[i][j].setEnabled(false);
			countBombs(i-1,j,board);
			countBombs(i+1,j,board);
			countBombs(i-1,j-1,board);
			countBombs(i-1,j+1,board);
			countBombs(i,j-1,board);
			countBombs(i,j+1,board);
			countBombs(i+1,j-1,board);
			countBombs(i+1,j+1,board);
		}
		else{
			setButtonColor(i,j,sum);
			
		}
		System.out.println(open);
		if(size*size - open == board.bombs)
			System.out.println("YOU WIN");
	}

	private void setButtonColor(int i, int j, int sum) {
		buttons[i][j].setText(Integer.toString(sum));
		switch (sum){
			case 1:
				buttons[i][j].setForeground(Color.GREEN);
				break;
			case 2:
				buttons[i][j].setForeground(Color.BLUE);
				break;
			case 3:
				buttons[i][j].setForeground(Color.DARK_GRAY);
				break;
			case 4:
				buttons[i][j].setForeground(Color.YELLOW);
				break;
			case 5:
				buttons[i][j].setForeground(Color.CYAN);
				break;
			case 6:
				buttons[i][j].setForeground(Color.MAGENTA);
				break;
			case 7:
				buttons[i][j].setForeground(Color.ORANGE);
				break;
			case 8:
				buttons[i][j].setForeground(Color.PINK);
				break;
		}
		
	}

}
