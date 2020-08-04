package com.xyz.game.opsystem;
/**
 * @author ������
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
			System.out.println("���"+op.getGameTable().getLeftNum());
			System.out.println("�Ҳ�"+op.getGameTable().getRightNum());
			System.out.println("��"+bout+"�غ���ѡ����Ĳ���!!");
			canOp();
			doGame();
			bout++;
			isOpA();
			isOpB();
			isOpC();
		}
		System.out.println("��Ϸ����!!!");
		if(bout%2 ==0 ){
			System.out.println("���ֻ�ʤ");
		}else{
			System.out.println("���ֻ�ʤ");
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
			System.out.println("A.����ߡ��ұ߸�����һ������");
		}
		if(opB){
			System.out.println("B.�����һ�������õ��ұ�");
		}
		if(opC){
			System.out.println("C.�����ұ�2������");
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
					System.out.println("�޷�����A����������������");
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
					System.out.println("�޷�����B����������������");
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
					System.out.println("�޷�����C����������������");
					doGame();
				}
				break;
			default:
				doGame();
				System.out.println("ר��Ŷ!!!!");
				break;
		}
	}
//	public static void main(String[] args) {
//		PvP pvp =new PvP(2,3);
//		pvp.combat();
//	}
}
