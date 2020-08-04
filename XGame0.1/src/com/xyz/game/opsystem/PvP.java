package com.xyz.game.opsystem;
/**
 * @author 徐宇祯
 */
import java.util.Scanner;

public class PvP {
	private Operation op = null;
	private Scanner scanner = new Scanner(System.in);
	private	boolean winner = false;
	private boolean opA = true;
	private boolean opB = true;
	private boolean opC = true;
	
	public PvP(int leftNum,int rightNum){
		op = new Operation(leftNum,rightNum);
	}
	
	public void combat(){
		int bout = 1;
		while(opA || opB || opC){
			System.out.println("左侧"+op.getGameTable().getLeftNum());
			System.out.println("右侧"+op.getGameTable().getRightNum());
			System.out.println("第"+bout+"回合请选择你的操作!!");
			canOp();
			doGame();
			bout++;
			isOpA();
			isOpB();
			isOpC();
		}
		System.out.println("游戏结束!!!");
		if(bout%2 ==0 ){
			System.out.println("先手获胜");
		}else{
			System.out.println("后手获胜");
		}
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
		this.isOpA();
		this.isOpB();
		this.isOpC();
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
	
	public void doGame(){
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
					doGame();
				}
				break;
			case "B":
			case "b":
				if(opB){
					System.out.println("B");
					op.leftToright();
				}
				else{
					System.out.println("无法进行B操作，请重新输入");
					doGame();
				}
				break;
			case "C":
			case "c":
				if(opC){
					System.out.println("C");
					op.rightReduce();
				}
				else{
					System.out.println("无法进行C操作，请重新输入");
					doGame();
				}
				break;
			default:
				doGame();
				System.out.println("专心哦!!!!");
				break;
		}
	}
//	public static void main(String[] args) {
//		PvP pvp =new PvP(2,3);
//		pvp.combat();
//	}
}
