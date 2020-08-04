package com.xyz.game.opsystem;


import com.xyz.game.role.Operation;
import com.xyz.game.role.ReduceEnergy;
import com.xyz.game.role.Role;

/**
 * 
 * @author 徐宇祯
 *
 */
//对战系统
public class Against {
	public Bout bout=new Bout();
	//扣血系统
	ReduceEnergy redu;
	//使用能力
	UseAble usable=new UseAble();
	//行动状态
	Operation op=new Operation();
	//结束条件
	public String winner;
	//获取角色,能力
	public void AgainstAble(Role role1,Role role2,int key1,int key2){
			UseAble usable=new UseAble();
			//进行行动判断
			op.operation(role1, usable.selectAble(key1));
			op.operation(role2, usable.selectAble(key2));
			//判断扣血
			redu=new ReduceEnergy(role1, role2);
			winner=win(role1,role2);
			//本回合结束，状态
			bout.changebout(role1, role2);			
	}
	//胜利判断
	public String win(Role role1,Role role2){
		if(role1.getLife()==0 && role2.getLife()==0){
			return "平局";
			}
		else if(role1.getLife()==0 && role2.getLife()!=0){
			return role2.getName()+"获胜";
			}
		else if(role2.getLife()==0 && role1.getLife()!=0){
			return role1.getName()+"获胜";
			}
		return null;
		}
}
