
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
import java.util.Random;

import javax.swing.*;

public class UITicTacToeSystem implements ActionListener {
	
	JFrame frame = new JFrame(); // Creates a frame
	JButton[][] grid;
	int count=0;
	String user1 = "X";
	String user2 = "O";

	public UITicTacToeSystem(int row, int col)
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
		
		// If button press happens--> implies user has played
		// Record users selection and determine winner
		System.out.println("User 1 has played");
		buttonPressed.setText("X"); 
		int ret = determineWinner();
		if (ret != 0)
		{
			System.out.println(" User " + ret + " is the winner");
			return;
		}
		
		System.out.println("System aka User 2 turn to play ... ");
		systemPlayRandom();
		// If no winner, play system and determine winner
		// If no winner, don't return
		ret = determineWinner();
		if (ret != 0)
		{
			System.out.println(" User " + ret + " is the winner");
			return;
		}		
	}

	public int determineWinner()
	{
		// Check rows
		int retVal=0;
		for (int row=0; row<3; row++)
		{
			if((grid[row][0].getText() == grid[row][1].getText() ) && 
					( grid[row][1].getText() == grid[row][2].getText()))
			{
				System.out.println("We have a winner");
				if(grid[row][0].getText() == "X")
				{
					System.out.println("Winner is USER 1");
					retVal = 1;
				}
				else
				{
					System.out.println("Winner is USER 2");
					retVal =  2;
				}

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
					retVal = 1;
				}
				else
				{
					System.out.println("Winner is USER 2");
					retVal = 2;
				}

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
				retVal =  1;
			}
			else
			{
				System.out.println("Winner is USER 2");
				retVal = 2;
			}

		}
		
		// Check other diag
		if((grid[0][2].getText() == grid[1][1].getText()) && 
				(grid[1][1].getText() == grid[2][0].getText()))
		{
			System.out.println("We have a winner");
			if(grid[0][2].getText() == "X")
			{
				System.out.println("Winner is USER 1");
				retVal = 1;
			}
			else
			{
				System.out.println("Winner is USER 2");
				retVal = 2;
			}
		}
		return retVal;
	}
	
	public void systemPlayRandom()
	{
		// This method will make system play a random box
		// While, the value of the text is not equal to X or 0
		int row, col = 0;
		boolean unplayedCell = true;
		while(unplayedCell)
		{
			Random randomGen = new Random();
			row = randomGen.nextInt(3);
			col = randomGen.nextInt(3);
			
			if(grid[row][col].getText() != "X" && grid[row][col].getText() != "O")
			{
				grid[row][col].setText("O");
				unplayedCell = false;
			}
		}
		return;
	}
	
}
