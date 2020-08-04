package com.xyz.game.opsystem;

import com.xyz.game.role.Able;

//使用能力
public class UseAble {
	//获取角色能力
	public Able selectAble(int key){
		Able able=null;
		System.out.println(
					"1.增加能量 \n"
				+ 	"2.攻击能力\n"
				+ 	"3.防御能力\n"
				+ 	"4.回复\n"
				+ 	"5.无法操作");
		switch (key) {
		case 1:
			//增加能量
			able=Able.ADDENERGY;
			break;
		case 2:
			//攻击能力
			able=Able.ATTACT;
			break;
		case 3:
			//防御能力
			able=Able.GUARD;
			break;
		case 4:
			//恢复
			able=Able.CURE;
			break;
		case 5:
			//啥都不干
			able=Able.UNDO;
			break;
		}
		return able;
	}
}
