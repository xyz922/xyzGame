package com.xyz.game.opsystem;

/**
 * @author ĞìÓîìõ
 */
import com.xyz.game.role.GameTable;

public class Operation {
	
	private GameTable gameTable;
	
	public GameTable getGameTable() {
		return gameTable;
	}
	public void setGameTable(GameTable gameTable) {
		this.gameTable = gameTable;
	}
	public Operation(int leftNum,int rightNum){
		this.gameTable = new GameTable(leftNum,rightNum);
	}
	//Ö¸Áî1    ×óÓÒÊı×Ö¸÷¼õ1
	public void leftAndrightReduce(){
		gameTable.setLeftNum(gameTable.getLeftNum()-1);
		gameTable.setRightNum(gameTable.getRightNum()-1);
	}
	
	//Ö¸Áî2    ÒÆ¶¯×ó²à1ÖÁÓÒ²à
	public void leftToright(){
		gameTable.setLeftNum(gameTable.getLeftNum() - 1);
		gameTable.setRightNum(gameTable.getRightNum() + 1);
	}
	
	//Ö¸Áî3 ÒÆ³ıÓÒ²à2Æå×Ó
	public void rightReduce(){
		gameTable.setRightNum(gameTable.getRightNum() - 2);
	}
}
