
/**
 * Generates the UI for TicTacToe
 * 
 * Implement action handler when button is clicked
 * 
 * @author shwetasabne
 *
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class UITicTacToe implements ActionListener {
	
	JFrame frame = new JFrame(); // Creates a frame
	JButton[][] grid;
	int count=0;
	String user1 = "X";
	String user2 = "O";

	public UITicTacToe(int row, int col)
	{
		frame.setLayout(new GridLayout(row, col));
		grid = new JButton[row][col];
		for (int x=0; x<row; x++)
		{
			for (int y=0; y<col; y++)
			{
				grid[x][y] = new JButton("("+x+","+y+")");
				grid[x][y].addActionListener(this);
				frame.add(grid[x][y]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		count++;		
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton)a.getSource();
		System.out.println("Button pressed is "+ buttonPressed.getText());
		
		// Determine which player is playing
		// Since user1 always plays first, if count is odd-->user
		// count is even ---> user2
		if (count % 2 == 0)
		{
			System.out.println("User 1 is playing");
			buttonPressed.setText("X"); 
		}
		else
		{
			System.out.println("User 2 is playing");
			buttonPressed.setText("O");
		}
		
		//Determine Winner
		determineWinner();
		
	}

	public void determineWinner()
	{
		// Check rows
		for (int row=0; row<3; row++)
		{
			if((grid[row][0].getText() == grid[row][1].getText() ) && 
					( grid[row][1].getText() == grid[row][2].getText()))
			{
				System.out.println("We have a winner");
				if(grid[row][0].getText() == "X")
				{
					System.out.println("Winner is USER 1");
				}
				else
				{
					System.out.println("Winner is USER 2");
				}
				return;
			}
				
		}
		// Check cols
		for (int col=0; col<3; col++)
		{
			if((grid[0][col].getText() == grid[1][col].getText() ) && 
					( grid[1][col].getText() == grid[2][col].getText()))
			{
				System.out.println("We have a winner");
				if(grid[0][col].getText() == "X")
				{
					System.out.println("Winner is USER 1");
				}
				else
				{
					System.out.println("Winner is USER 2");
				}
				return;
			}			
		}
		
		// Check diags
		if((grid[0][0].getText() == grid[1][1].getText()) && 
				(grid[1][1].getText() == grid[2][2].getText()))
		{
			System.out.println("We have a winner");
			if(grid[0][0].getText() == "X")
			{
				System.out.println("Winner is USER 1");
			}
			else
			{
				System.out.println("Winner is USER 2");
			}
			return;
		}
		
		// Check other diag
		if((grid[0][2].getText() == grid[1][1].getText()) && 
				(grid[1][1].getText() == grid[2][0].getText()))
		{
			System.out.println("We have a winner");
			if(grid[0][2].getText() == "X")
			{
				System.out.println("Winner is USER 1");
			}
			else
			{
				System.out.println("Winner is USER 2");
			}
			return;
		}
	}
	
}
