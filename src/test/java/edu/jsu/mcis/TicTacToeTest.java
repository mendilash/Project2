package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	public TicTacToeModel model;
	
	@Before
	public void setup(){
		model = new TicTacToeModel();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		
		model = new TicTacToeModel();
        int count = 0;
        for(int i =0;i < 3; i++){
            for(int j = 0;j<3;j++){
               assertEquals("", model.getMark(i, j));
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.makeMark("X", 0, 2);
		assertEquals("X", model.getMark(0,2));
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.makeMark("O", 2, 0);
		assertEquals("O", model.getMark(2,0));
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.makeMark("X", 0, 1);
		model.makeMark("O", 0, 1);
		
		assertEquals("X", model.getMark(0,1));
		
		
		
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.makeMark("X", 0, 0);
		model.makeMark("O", 0, 0);
		
		assertEquals("X", model.getMark(0,0));
		
		
		
	}
	
	@Test
	public void testGameIsWonByOHorizontallyAcrossTopRow() {
		model.makeMark("O", 0, 0);
		model.makeMark("O", 0, 1);
		model.makeMark("O", 0, 2);
		
		assertEquals("O", model.getWinner());
		
		
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.makeMark("X", 0,0);
		model.makeMark("O", 0,1);
		model.makeMark("O", 0,2);
		
		model.makeMark("O", 1,0);
		model.makeMark("X", 1,1);
		model.makeMark("X", 1,2);
		
		model.makeMark("X", 2,0);
		model.makeMark("O", 2,1);
		model.makeMark("O", 2,2);
		
		assertEquals("TIE", model.getWinner());
	}	
	
	@Test
	public void testGameIsWonByXVerticallyDownLeftColumn(){
		model.makeMark("X", 0, 0);
		model.makeMark("X", 1, 0);
		model.makeMark("X", 2, 0);
		
		assertEquals("X", model.getWinner());
		
	}
	
	@Test
	public void testGameIsWonByXDiagonally(){
		
		model.makeMark("X", 0, 0);
		model.makeMark("X", 1, 1);
		model.makeMark("X", 2, 2);
		
		assertEquals("X", model.getWinner());
	}
	
	
}
