package com.xyz.game.role;
/**
 * 
 * @author ������
 *
 */
public class Operation {
	//�ж�״̬
	public void operation(Role role,Able able){
		switch (able) {
		//�ָ�����
		case ADDENERGY:
			role.setEnergy(role.getEnergy()+1);
			role.setAddenergy(role.getAddenergy()-1);
			System.out.println("�ָ�����");
			break;
		//��������
		case ATTACT:
			role.setAtack(true);
			System.out.println("����");
			role.setEnergy(role.getEnergy()-2);
			break;
		//��������
		case GUARD:
			role.setGuard(true);
			role.setEnergy(role.getEnergy()-1);
			System.out.println("����");
			break;
		//����
		case CURE:
				role.setLife(role.getLife()+1);
				role.setEnergy(role.getEnergy()-2);
				System.out.println("����");
			break;
		//ɶ������
		case UNDO:
			System.out.println("�޷�����");
			break;
		}
	}
}
