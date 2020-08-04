package com.xyz.game.role;

/**
 * 
 * @author 徐宇祯
 *棋盘不好写,不适用在控制台显示
 */
public class Chess {
	private String left ="****\n"+"*  *\n"+"****";
	private String right ="```\n"+"` `\n"+"```";
	private String splitChess = "|\n|\n|";
	
	public String getSplitChess() {
		return splitChess;
	}

	public void setSplitChess(String splitChess) {
		this.splitChess = splitChess;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public void printLeft(int leftNum){
		int row = leftNum/3 + 1;
		int j = 1;
		while(j < row){
			System.out.println("****\t****\t****|");
			System.out.println("*  *\t*  *\t*  *|");
			System.out.println("****\t****\t****|");
			System.out.println("    \t    \t    |");
			j++;
		}
		switch(leftNum%3){
			case 0:
				break;
			case 1:
				System.out.print("****\t    \t    |\n");
				System.out.print("*  *\t    \t    |\n");
				System.out.print("****\t    \t    |\n");
				break;
			case 2:
				System.out.print("****\t****\t    |\n");
				System.out.print("*  *\t*  *\t    |\n");
				System.out.print("****\t****\t    |\n");
				break;
			default:
				break;
		}
	}

	public void printRight(int rightNum){
		int row = rightNum/3 + 1;
		int j = 1;
		while(j < row){
			System.out.println("|````\t````\t````");
			System.out.println("|`  `\t`  `\t`  `");
			System.out.println("|````\t````\t````");
			System.out.println("|    \t    \t    ");
			j++;
		}
		switch(rightNum%3){
			case 0:
				break;
			case 1:
				System.out.print("|````\t    \t    \n");
				System.out.print("|`  `\t    \t    \n");
				System.out.print("|````\t    \t    \n");
				break;
			case 2:
				System.out.print("|````\t````\t    \n");
				System.out.print("|`  `\t`  `\t    \n");
				System.out.print("|````\t````\t    \n");
				break;
			default:
				break;
		}
	}
	
//	public void printTable(int leftNum,int rightNum){
//		int leftrow = leftNum/3+1;
//		int rightrow = rightNum/3+1;
//		int minrow = leftrow>rightrow?rightrow:leftrow;
//		
//		int i = 1;
//		while(i < minrow){
//			System.out.println("****\t****\t****||````\t````\t````");
//			System.out.println("*  *\t*  *\t*  *||`  `\t`  `\t`  `");
//			System.out.println("****\t****\t****||````\t````\t````");
//			System.out.println("    \t    \t    ||    \t    \t    ");
//			i++;
//		}
//	}
	public static void main(String[] args) {
		Chess chess = new Chess();
		chess.printRight(8);
		
		
	}
}
