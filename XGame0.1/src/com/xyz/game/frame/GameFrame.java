package com.xyz.game.frame;

/**
 * @author ������
 */

import java.util.Scanner;

import com.xyz.game.opsystem.PvELevel1;
import com.xyz.game.opsystem.PvP;

public class GameFrame {
	public Scanner scanner = new Scanner(System.in);
	//����̨����
	
	public void gameRule(){
		System.out.println("��ʼ��������������ӣ���������һ�β�������ִ��һ�µ����ֲ���֮һ\n" +
							"A.����ߡ��ұ߸�����һ������\n" +
							"B.�����һ�������õ��ұ�\n" +
							"C.�����ұ�2������\n" +
							"��������޷��������ϲ���ʱ����Ϸ�������и�");
	}
	public void index(){
		while(true){
			System.out.println("|-----------��ӭ----------|");
			System.out.println("|----��������������̰�----|");
			System.out.println("|*************************|");
			System.out.println("|**1.��Ϸ����||2.��ʼ��Ϸ**|");
			System.out.println("|**3.��Ҫ�˳�||4.�ո�����**|");
			System.out.println("|*************************|");
			String temp = scanner.nextLine();
			switch (temp) {
			case "1":
				this.gameRule();
				break;
			case "2":
				this.startGame();
				break;
			case "3":
				System.out.println("�˳�!!!");
				System.exit(0);
				break;
			case "4":
				System.out.println("�ո�����");
				break;
			default:
				System.out.println("����һ��");
				break;
			}
		}
	}
	
	public void startGame(){
		while(true){
			System.out.println("|**1.�˻�ģʽ||2.����ģʽ**|");
			System.out.println("|**3.��Ҫ�˳�||4.�ո�����**|");
			String temp = scanner.nextLine();
			String flag = null;
			switch (temp) {
			case "1":
				PvELevel1 pveLevel1 = null;
				System.out.println("�˻�ģʽ");
				System.out.println("��(Y)���ֶ��������Ҳ�������Ŀ,Ĭ�����Ҹ�8");
				flag = scanner.nextLine();
				if("Y".equals(flag) || "y".equals(flag)){
					System.out.println("���");
					int leftNum = scanner.nextInt();
					System.out.println("�Ҳ�");
					int rightNum = scanner.nextInt();
					pveLevel1 = new PvELevel1(leftNum,rightNum);
					
				}else{
					pveLevel1 = new PvELevel1(8,8);
				}	
				pveLevel1.doGame();
				break;
			case "2":
				PvP pvp = null;
				System.out.println("����ģʽ");
				System.out.println("��(Y)���ֶ��������Ҳ�������Ŀ,Ĭ�����Ҹ�8");
				flag = scanner.nextLine();
				if("Y".equals(flag) || "y".equals(flag)){
					System.out.println("���");
					int leftNum = scanner.nextInt();
					System.out.println("�Ҳ�");
					int rightNum = scanner.nextInt();
					pvp = new PvP(leftNum,rightNum);
					
				}else{
					pvp = new PvP(8,8);
				}	
				pvp.combat();
				break;
			case "3":
				System.out.println("�˳�!!!");
				System.exit(0);
				break;
			case "4":
				System.out.println("�ո�����");
				break;
			default:
				System.out.println("����һ��");
				break;
			}
		}
	}
	
	public void test(){
		
	}
	public static void main(String[] args) {
		GameFrame gf = new GameFrame();
		gf.index();
	}
}
