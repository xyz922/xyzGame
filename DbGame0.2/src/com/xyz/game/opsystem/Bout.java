package com.xyz.game.opsystem;

import com.xyz.game.role.Role;

//回合系统
public class Bout {
	public int bout =1;
	//每过2个回合，能量恢复次数+1
	 void changebout(Role role1,Role role2){
		if(bout % 2==0) {
			role1.setAddenergy(role1.getAddenergy()+1);
			role2.setAddenergy(role2.getAddenergy()+1);
		}
		bout++;
	}
}
