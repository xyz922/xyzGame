package com.xyz.game.role;
//扣血系统
public class ReduceEnergy {

	public ReduceEnergy(Role role1,Role role2) {
		if(role1.isAtack()){
			if(role2.isGuard())
				{System.out.println(role2.toString()+"防御了"+role1.toString()+"的攻击");}
			else role2.setLife(role2.getLife()-1);
		}
		if(role2.isAtack()){
			if(role1.isGuard())
				{System.out.println(role1.toString()+"防御了"+role2.toString()+"的攻击");}
			else role1.setLife(role1.getLife()-1);
		}
		role1.initialize();
		role2.initialize();
	}
}
