package com.xyz.game.opsystem;


import com.xyz.game.role.Operation;
import com.xyz.game.role.ReduceEnergy;
import com.xyz.game.role.Role;

/**
 * 
 * @author ������
 *
 */
//��սϵͳ
public class Against {
	public Bout bout=new Bout();
	//��Ѫϵͳ
	ReduceEnergy redu;
	//ʹ������
	UseAble usable=new UseAble();
	//�ж�״̬
	Operation op=new Operation();
	//��������
	public String winner;
	//��ȡ��ɫ,����
	public void AgainstAble(Role role1,Role role2,int key1,int key2){
			UseAble usable=new UseAble();
			//�����ж��ж�
			op.operation(role1, usable.selectAble(key1));
			op.operation(role2, usable.selectAble(key2));
			//�жϿ�Ѫ
			redu=new ReduceEnergy(role1, role2);
			winner=win(role1,role2);
			//���غϽ�����״̬
			bout.changebout(role1, role2);			
	}
	//ʤ���ж�
	public String win(Role role1,Role role2){
		if(role1.getLife()==0 && role2.getLife()==0){
			return "ƽ��";
			}
		else if(role1.getLife()==0 && role2.getLife()!=0){
			return role2.getName()+"��ʤ";
			}
		else if(role2.getLife()==0 && role1.getLife()!=0){
			return role1.getName()+"��ʤ";
			}
		return null;
		}
}
