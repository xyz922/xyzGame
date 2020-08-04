package com.xyz.game.role;
/**
 * @author –Ï”ÓÏı
 */
public class GameTable {
	private int leftNum;
	private int rightNum;
	
	public GameTable(){
		
	}
	
	public GameTable(int leftNum,int rightNum){
		this.leftNum = leftNum;
		this.rightNum = rightNum;
	}
	
	public int getLeftNum() {
		return leftNum;
	}
	
	public void setLeftNum(int leftNum) {
		this.leftNum = leftNum;
	}
	
	public int getRightNum() {
		return rightNum;
	}
	
	public void setRightNum(int rightNum) {
		this.rightNum = rightNum;
	}
	
}
