package com.xyz.game.opsystem;

import com.xyz.game.role.Able;

//ʹ������
public class UseAble {
	//��ȡ��ɫ����
	public Able selectAble(int key){
		Able able=null;
		System.out.println(
					"1.�������� \n"
				+ 	"2.��������\n"
				+ 	"3.��������\n"
				+ 	"4.�ظ�\n"
				+ 	"5.�޷�����");
		switch (key) {
		case 1:
			//��������
			able=Able.ADDENERGY;
			break;
		case 2:
			//��������
			able=Able.ATTACT;
			break;
		case 3:
			//��������
			able=Able.GUARD;
			break;
		case 4:
			//�ָ�
			able=Able.CURE;
			break;
		case 5:
			//ɶ������
			able=Able.UNDO;
			break;
		}
		return able;
	}
}
