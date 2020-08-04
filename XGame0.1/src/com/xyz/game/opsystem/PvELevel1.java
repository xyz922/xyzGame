package com.xyz.game.opsystem;

import java.util.Scanner;

/**
  * 
  * @author 徐宇祯
  *简单模式，棋组8,8；可选先手后手
  */
public class PvELevel1 {
	private Operation op = null;
	private Scanner scanner = new Scanner(System.in);
	private	boolean winner = false;
	private boolean opA = true;
	private boolean opB = true;
	private boolean opC = true;
	
	public PvELevel1(int leftNum,int rightNum){
		op = new Operation(leftNum,rightNum);
	}
	
	
	
	public void isOpA(){
		if(!(op.getGameTable().getLeftNum() >0 && op.getGameTable().getRightNum()>0)){
			opA = false;
		}else{
			opA = true;
		}
	}
	
	public void isOpB(){
		if(!(op.getGameTable().getLeftNum() >=1)){
			opB = false;
		}else{
			opB = true;
		}
	}
	
	public void isOpC(){
		if(!(op.getGameTable().getRightNum() >= 2)){
			opC = false;
		}else{
			opC = true;
		}
	}
	
	public void canOp(){
		isOpA();
		isOpB();
		isOpC();
		if(opA){
			System.out.println("A.将左边、右边各拿走一个棋子");
		}
		if(opB){
			System.out.println("B.将左边一个棋子拿到右边");
		}
		if(opC){
			System.out.println("C.拿走右边2个棋子");
		}
	}
	//玩家先手
	public void combatPlayer(){
		int bout = 1;
		while(opA || opB || opC){
			System.out.println("左侧"+op.getGameTable().getLeftNum());
			System.out.println("右侧"+op.getGameTable().getRightNum());
			System.out.println("第"+bout+"回合请选择你的操作!!");
			canOp();
			playerDo();
			bout++;
			
			if(!(opA || opB || opC)){
				break;
			}
			System.out.println("左侧"+op.getGameTable().getLeftNum());
			System.out.println("右侧"+op.getGameTable().getRightNum());
			System.out.println("第"+bout+"回合电脑操作!!");
			canOp();
			EnviromentDo();
			bout++;
			
	
		}
		System.out.println("游戏结束!!!");
		if(bout%2 ==0 ){
			System.out.println("玩家获胜");
		}else{
			System.out.println("电脑获胜");
		}
	}
	
	public void combatEnviroment(){
		int bout = 1;
		while(opA || opB || opC){
			System.out.println("左侧"+op.getGameTable().getLeftNum());
			System.out.println("右侧"+op.getGameTable().getRightNum());
			System.out.println("第"+bout+"回合电脑操作!!");
			canOp();
			EnviromentDo();
			bout++;
			
			if(!(opA || opB || opC)){
				break;
			}
			
			System.out.println("左侧"+op.getGameTable().getLeftNum());
			System.out.println("右侧"+op.getGameTable().getRightNum());
			System.out.println("第"+bout+"回合请选择你的操作!!");
			canOp();
			playerDo();
			bout++;
			
		}
		System.out.println("游戏结束!!!");
		if(bout%2 ==0 ){
			System.out.println("电脑获胜");
		}else{
			System.out.println("玩家获胜");
		}
	}
	
	
	//玩家行动
	public void playerDo(){
		String s = scanner.nextLine();
		switch(s){
			case "A":
			case "a":
				if(opA){
					System.out.println("A");
					op.leftAndrightReduce();
				}
				else{
					System.out.println("无法进行A操作，请重新输入");
					playerDo();
				}
				break;
			case "B":
			case "b":
				if(opB){
					System.out.println("B");
					op.leftToright();}
				else{
					System.out.println("无法进行B操作，请重新输入");
					playerDo();
				}
				break;
			case "C":
			case "c":
				if(opC){
					System.out.println("C");
					op.rightReduce();}
				else{
					System.out.println("无法进行C操作，请重新输入");
					playerDo();
				}
				break;
			default:
				playerDo();
				System.out.println("专心哦!!!!");
				break;
		}
		isOpA();
		isOpB();
		isOpC();
	}
	
	//电脑AI
	public void EnviromentDo(){
		String s = null;
		int leftNum = op.getGameTable().getLeftNum();
		int rightNum = op.getGameTable().getRightNum();
		
		
		if(leftNum%2 == 0 && (rightNum%4 == 0 || rightNum%4 == 1)){
			if((rightNum%4 == 0 && rightNum != 0)|| leftNum == 0)
				s = "C";
			else if(leftNum != 0 && rightNum%4 == 1)
				s = "A";
			else
				s = "B";
		}
		else if(opC && leftNum%2 == 0 && (rightNum%4 == 2 || rightNum%4 == 3)){
			s = "C";
		}
		else if(opA && leftNum%2 != 0 && (rightNum%4 == 0 || rightNum%4 == 3)){
			s = "A";
		}
		else if(opB && leftNum%2 != 0 && (rightNum%4 == 1 || rightNum%4 == 2)){
			s = "B";
		}
		else{
			System.out.println("eee");
			s = "B";
		}
		
		switch(s){
		case "A":
			System.out.println("A");
			op.leftAndrightReduce();
			break;
		case "B":
			System.out.println("B");
			op.leftToright();
			break;
		case "C":
			System.out.println("C");
			op.rightReduce();
		}
		isOpA();
		isOpB();
		isOpC();
	}
	public void doGame(){
		System.out.println("输入1先手，否则后手");
		String s = scanner.nextLine();
		
		if("1".equals(s)){
			combatPlayer();
		}else{
			combatEnviroment();
		}
	}
	public static void main(String[] args) {
		PvELevel1 p = new PvELevel1(8,8);
		p.doGame();
	}
}
