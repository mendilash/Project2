package edu.jsu.mcis; 

public class TicTacToeModel {
	public int[][] grid; 
	private String player;
		
	public TicTacToeModel(){
		grid = new int[3][3];
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
	
	
	private void switchPlayer() {
		if (player.equals("X")) {
			player = "O";
		} 
		else {
			player = "X";
		}
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
		}
	}
	
	private String horizontalWin() {
		for(int i=0; i<3; i++) {
			if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] > 0) {
				return getMark(i, 0);
			}
		}
		return "";
	}
		
	private String verticalWin(){
		for(int i=0; i<3; i++) {
			if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] > 0) {
				return getMark(0, i);
			}
		}
		return "";
	}
	
	private String diagonalWin(){
		if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] > 0) {
			return getMark(0, 0);
		}
		else if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] > 0){
			return getMark(0, 2);
		}
		else {
			return "";
		}
	}
			
	private boolean tieGame(){
		boolean tie = true;
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				if(grid[i][j] == 0){
					tie = false;
				}
			}
		}
		return tie;
	}
	
	
	public String getWinner(){
		String h = horizontalWin();
		String v = verticalWin();
		String d = diagonalWin();
		if(h.length() > 0) return h;
		else if(v.length() > 0) return v;
		else if(d.length() > 0) return d;		
		else if(tieGame()) return "TIE";
		else return "";
	}
	
	
}

