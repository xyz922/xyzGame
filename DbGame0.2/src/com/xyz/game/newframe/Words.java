package com.xyz.game.newframe;

public class Words {
	static String []title = new String[10];
	static {
		title[0] = "������ҵ�С����";
		title[1] = "�һ���Ϊ ����Զ������ѡ����";
		title[2] = "���Ѿ������� �ҵ�ѡ��";
		title[3] = "��ʱ����������ļ�����";
		title[4] = "���漲��ǰ�� �����������";
		title[5] = "��������!!!";
		title[6] = "����̤��ɽ�� Ҳ������͹�";
		title[7] = "�� ����֮��";
		title[8] = "��-��-�-��-";
		title[9] = "û������ô����";
	}
	
	 public static String getTitle() {
		 int k = (int)(Math.random()*10);
		 System.out.println("��������"+k);
		return title[k];
	}
}
