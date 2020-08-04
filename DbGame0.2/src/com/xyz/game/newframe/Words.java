package com.xyz.game.newframe;

public class Words {
	static String []title = new String[10];
	static {
		title[0] = "你见过我的小熊吗";
		title[1] = "我还以为 你永远都不会选我呢";
		title[2] = "我已经做出了 我的选择";
		title[3] = "是时候表演真正的技术了";
		title[4] = "且随疾风前行 身后亦须留心";
		title[5] = "德玛西亚!!!";
		title[6] = "我曾踏足山巅 也曾陷入低谷";
		title[7] = "奉 均衡之命";
		title[8] = "当-空-皓-月-";
		title[9] = "没死？怎么可能";
	}
	
	 public static String getTitle() {
		 int k = (int)(Math.random()*10);
		 System.out.println("产生标题"+k);
		return title[k];
	}
}
