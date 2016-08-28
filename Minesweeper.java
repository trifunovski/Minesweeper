import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Minesweeper {

	public static void main(String[] args) {
		final JFrame window = new JFrame("Tic Tac Toe");
    		window.setLocationRelativeTo(null);
    		window.setSize(300,200);
    		window.setLayout(new GridLayout(5, 1));
    		JLabel bombsT = new JLabel("Enter the number of bombs:", JLabel.CENTER);
    		JTextField bombs = new JTextField("");
    		JLabel sizeT = new JLabel("Enter the size of a row in the table:", JLabel.CENTER);
    		JTextField sizes = new JTextField("");
    		bombs.setHorizontalAlignment(JTextField.CENTER);
    		sizes.setHorizontalAlignment(JTextField.CENTER);
    		JButton enter = new JButton("Play!");
    		class bombListener implements ActionListener
        {
        	    public void actionPerformed(ActionEvent event)
        	    {
        	    		String num = new String(bombs.getText());
        	    		int bombs = Integer.parseInt(num);
        	    		System.out.println(bombs);
        	    		String num1 = new String(sizes.getText());
        	    		int size = Integer.parseInt(num1);
        	    		System.out.println(size);
        	    		System.out.println(bombs);
        	    		Board board = new Board(bombs,size);
        	    		window.setVisible(false);
        	    		BoardDrawer bDraw = new BoardDrawer(board);
            }
        }
    		bombListener lis1 = new bombListener();
    		enter.addActionListener(lis1);
    		window.add(bombsT);
    		window.add(bombs);
    		window.add(sizeT);
    		window.add(sizes);
    		window.add(enter);
    		window.setVisible(true);
	}

}
