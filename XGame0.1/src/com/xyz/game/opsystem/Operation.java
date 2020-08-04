package com.xyz.game.opsystem;

/**
 * @author ������
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
	//ָ��1    �������ָ���1
	public void leftAndrightReduce(){
		gameTable.setLeftNum(gameTable.getLeftNum()-1);
		gameTable.setRightNum(gameTable.getRightNum()-1);
	}
	
	//ָ��2    �ƶ����1���Ҳ�
	public void leftToright(){
		gameTable.setLeftNum(gameTable.getLeftNum() - 1);
		gameTable.setRightNum(gameTable.getRightNum() + 1);
	}
	
	//ָ��3 �Ƴ��Ҳ�2����
	public void rightReduce(){
		gameTable.setRightNum(gameTable.getRightNum() - 2);
	}
}
