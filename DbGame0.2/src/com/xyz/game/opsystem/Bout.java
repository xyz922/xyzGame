package com.xyz.game.opsystem;

import com.xyz.game.role.Role;

//�غ�ϵͳ
public class Bout {
	public int bout =1;
	//ÿ��2���غϣ������ָ�����+1
	 void changebout(Role role1,Role role2){
		if(bout % 2==0) {
			role1.setAddenergy(role1.getAddenergy()+1);
			role2.setAddenergy(role2.getAddenergy()+1);
		}
		bout++;
	}
}
