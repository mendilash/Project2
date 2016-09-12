package edu.jsu.mcis; 

public class TicTacToeModel{
	public int[][] grid; 
	public boolean winner;
	public boolean tie;
	public String win;
	
	public int counter;
	
	public TicTacToeModel(){
		grid = new int[3][3];
		counter = 0;
	}

	public String getMark(int row, int col){
		if(grid[row][col] == 0){
			return "";
		}
		else if(grid[row][col] == 1){
			return "X";
		}
		else return "O";
	}

	public void makeMark(String mark, int row, int col){
		
		
		if(grid[row][col] < 1){
			if(mark.equals("X")){
				grid[row][col] = 1;
			}
			else if(mark.equals("O")){
				grid[row][col] = 2; 
			}
			else if(mark.equals("")){
				grid[row][col] = 0; 
			}
			counter++;
		}
	}
	
	public boolean HorizontalWin(){
		
		for(int i=0; i<3; i++){
		
			if(getMark(0, i).equals("X") || (getMark(0, i).equals("O"))){
				winner = true;
			}
			else if(getMark(1, i).equals("X") || (getMark(1, i).equals("O"))){
				winner = true;
			}
			else if(getMark(2, i).equals("X") || (getMark(2, i).equals("O"))){
				winner = true;
			}
			else{
				winner = false;
			}
		
		}
		return winner;
	}
		
	public boolean VerticalWin(){
		
		for(int i = 0; i<3; i++){
		if(getMark(i, 0).equals("X") || (getMark(i,0).equals("O"))){
				winner = true;
			}
			else if(getMark(i, 1).equals("X") || (getMark(i,1).equals("O"))){
				winner = true;
			}
			else if(getMark(i, 2).equals("X") || (getMark(i,2).equals("O"))){
				winner = true;
			}
			else{
				winner = false;
			}
			
		}
		return winner;
	}
	
	public boolean DiagonalWin(){
		
		if(grid[0][0] == grid[1][1] && 
			grid[0][0] == grid[2][2] &&
			grid[0][0] != 0){
			
			return true;
		}
		else if(grid[0][2] == grid[1][1] &&
				grid[0][2] == grid[2][0] &&
				grid[0][2] != 0){
					return true;
				}
		else{
			return false;
		}
		
		
	}
			
	
	
	public boolean TieGame(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				
				if(getMark(i, j).equals("X")|| getMark(i, j).equals("O")){
					
					tie = true;
				}
				else{
					
					tie = false;
				}	
			}
		}
		return tie;
		
	}
	
	
	public String getWinner(){
		
		
		
		if(HorizontalWin()){
			win = "X";
		}
		else if(DiagonalWin()){
			win = "X";
		}
		else{
			if(TieGame()){
				win = "TIE";
			}
		}
		
		
		return win;
		
	}
	
	
}

