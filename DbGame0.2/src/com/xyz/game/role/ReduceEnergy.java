package com.xyz.game.role;
//��Ѫϵͳ
public class ReduceEnergy {

	public ReduceEnergy(Role role1,Role role2) {
		if(role1.isAtack()){
			if(role2.isGuard())
				{System.out.println(role2.toString()+"������"+role1.toString()+"�Ĺ���");}
			else role2.setLife(role2.getLife()-1);
		}
		if(role2.isAtack()){
			if(role1.isGuard())
				{System.out.println(role1.toString()+"������"+role2.toString()+"�Ĺ���");}
			else role1.setLife(role1.getLife()-1);
		}
		role1.initialize();
		role2.initialize();
	}
}
