package com.xyz.game.frame;

/**
 * @author 徐宇祯
 */

import java.util.Scanner;

import com.xyz.game.opsystem.PvELevel1;
import com.xyz.game.opsystem.PvP;

public class GameFrame {
	public Scanner scanner = new Scanner(System.in);
	//控制台界面
	
	public void gameRule(){
		System.out.println("初始情况下有两堆棋子，操作规则：一次操作必须执行一下的三种操作之一\n" +
							"A.将左边、右边各拿走一个棋子\n" +
							"B.将左边一个棋子拿到右边\n" +
							"C.拿走右边2个棋子\n" +
							"当轮玩家无法进行以上操作时，游戏结束，判负");
	}
	public void index(){
		while(true){
			System.out.println("|-----------欢迎----------|");
			System.out.println("|----快来测试你的智商吧----|");
			System.out.println("|*************************|");
			System.out.println("|**1.游戏规则||2.开始游戏**|");
			System.out.println("|**3.我要退出||4.凑个字数**|");
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
				System.out.println("退出!!!");
				System.exit(0);
				break;
			case "4":
				System.out.println("凑个字数");
				break;
			default:
				System.out.println("再来一次");
				break;
			}
		}
	}
	
	public void startGame(){
		while(true){
			System.out.println("|**1.人机模式||2.人人模式**|");
			System.out.println("|**3.我要退出||4.凑个字数**|");
			String temp = scanner.nextLine();
			String flag = null;
			switch (temp) {
			case "1":
				PvELevel1 pveLevel1 = null;
				System.out.println("人机模式");
				System.out.println("是(Y)否手动输入左右侧棋子数目,默认左右各8");
				flag = scanner.nextLine();
				if("Y".equals(flag) || "y".equals(flag)){
					System.out.println("左侧");
					int leftNum = scanner.nextInt();
					System.out.println("右侧");
					int rightNum = scanner.nextInt();
					pveLevel1 = new PvELevel1(leftNum,rightNum);
					
				}else{
					pveLevel1 = new PvELevel1(8,8);
				}	
				pveLevel1.doGame();
				break;
			case "2":
				PvP pvp = null;
				System.out.println("人人模式");
				System.out.println("是(Y)否手动输入左右侧棋子数目,默认左右各8");
				flag = scanner.nextLine();
				if("Y".equals(flag) || "y".equals(flag)){
					System.out.println("左侧");
					int leftNum = scanner.nextInt();
					System.out.println("右侧");
					int rightNum = scanner.nextInt();
					pvp = new PvP(leftNum,rightNum);
					
				}else{
					pvp = new PvP(8,8);
				}	
				pvp.combat();
				break;
			case "3":
				System.out.println("退出!!!");
				System.exit(0);
				break;
			case "4":
				System.out.println("凑个字数");
				break;
			default:
				System.out.println("再来一次");
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
