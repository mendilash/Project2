package keywords;

import edu.jsu.mcis.*;
import java.awt.Component;

public class TicTacToeKeywords {
		private TicTacToeModel model;
		private boolean turn;
		
	public void startNewGame() {
		model = new TicTacToeModel();
		turn = true;
	}
	
	public void markLocation(int row, int col) {
		String m = (turn)? "X" : "O";
		model.makeMark(m, row, col);
		turn = !turn;
	}
	
	public String getMark(int row, int col) {
		return model.getMark(row, col); 
	}
    
	public String getWinner() {
		return model.getWinner();
	}
}
