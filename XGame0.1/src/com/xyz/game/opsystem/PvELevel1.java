package com.xyz.game.opsystem;

import java.util.Scanner;

/**
  * 
  * @author ������
  *��ģʽ������8,8����ѡ���ֺ���
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
			System.out.println("A.����ߡ��ұ߸�����һ������");
		}
		if(opB){
			System.out.println("B.�����һ�������õ��ұ�");
		}
		if(opC){
			System.out.println("C.�����ұ�2������");
		}
	}
	//�������
	public void combatPlayer(){
		int bout = 1;
		while(opA || opB || opC){
			System.out.println("���"+op.getGameTable().getLeftNum());
			System.out.println("�Ҳ�"+op.getGameTable().getRightNum());
			System.out.println("��"+bout+"�غ���ѡ����Ĳ���!!");
			canOp();
			playerDo();
			bout++;
			
			if(!(opA || opB || opC)){
				break;
			}
			System.out.println("���"+op.getGameTable().getLeftNum());
			System.out.println("�Ҳ�"+op.getGameTable().getRightNum());
			System.out.println("��"+bout+"�غϵ��Բ���!!");
			canOp();
			EnviromentDo();
			bout++;
			
	
		}
		System.out.println("��Ϸ����!!!");
		if(bout%2 ==0 ){
			System.out.println("��һ�ʤ");
		}else{
			System.out.println("���Ի�ʤ");
		}
	}
	
	public void combatEnviroment(){
		int bout = 1;
		while(opA || opB || opC){
			System.out.println("���"+op.getGameTable().getLeftNum());
			System.out.println("�Ҳ�"+op.getGameTable().getRightNum());
			System.out.println("��"+bout+"�غϵ��Բ���!!");
			canOp();
			EnviromentDo();
			bout++;
			
			if(!(opA || opB || opC)){
				break;
			}
			
			System.out.println("���"+op.getGameTable().getLeftNum());
			System.out.println("�Ҳ�"+op.getGameTable().getRightNum());
			System.out.println("��"+bout+"�غ���ѡ����Ĳ���!!");
			canOp();
			playerDo();
			bout++;
			
		}
		System.out.println("��Ϸ����!!!");
		if(bout%2 ==0 ){
			System.out.println("���Ի�ʤ");
		}else{
			System.out.println("��һ�ʤ");
		}
	}
	
	
	//����ж�
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
					System.out.println("�޷�����A����������������");
					playerDo();
				}
				break;
			case "B":
			case "b":
				if(opB){
					System.out.println("B");
					op.leftToright();}
				else{
					System.out.println("�޷�����B����������������");
					playerDo();
				}
				break;
			case "C":
			case "c":
				if(opC){
					System.out.println("C");
					op.rightReduce();}
				else{
					System.out.println("�޷�����C����������������");
					playerDo();
				}
				break;
			default:
				playerDo();
				System.out.println("ר��Ŷ!!!!");
				break;
		}
		isOpA();
		isOpB();
		isOpC();
	}
	
	//����AI
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
		System.out.println("����1���֣��������");
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
