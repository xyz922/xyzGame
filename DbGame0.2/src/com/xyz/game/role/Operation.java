package com.xyz.game.role;
/**
 * 
 * @author 徐宇祯
 *
 */
public class Operation {
	//行动状态
	public void operation(Role role,Able able){
		switch (able) {
		//恢复能量
		case ADDENERGY:
			role.setEnergy(role.getEnergy()+1);
			role.setAddenergy(role.getAddenergy()-1);
			System.out.println("恢复能量");
			break;
		//攻击能力
		case ATTACT:
			role.setAtack(true);
			System.out.println("攻击");
			role.setEnergy(role.getEnergy()-2);
			break;
		//防御能力
		case GUARD:
			role.setGuard(true);
			role.setEnergy(role.getEnergy()-1);
			System.out.println("防御");
			break;
		//治疗
		case CURE:
				role.setLife(role.getLife()+1);
				role.setEnergy(role.getEnergy()-2);
				System.out.println("治疗");
			break;
		//啥都不干
		case UNDO:
			System.out.println("无法操作");
			break;
		}
	}
}
