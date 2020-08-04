package com.xyz.game.newframe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.xyz.game.role.Role;

public class RolePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 20200203;
	private int key;
	private boolean finish=false;
	Role role;
	JButton conbutton;
	JButton attackButton;
	JButton addButton;
	JButton cureButton;
	JButton guardButton;
	JButton undoButton;
	
	//���������ܣ����������ƣ�ɶ�����ɵ�ʹ������
	/**
	 * Create the panel.
	 */
	public RolePanel(Role role) {
		this.role=role;
		setFinish(false);
		AbleButton(role);
		setLayout(null);
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(266, 70, 157, 63);
		attackButton=attackButton();
		addButton=addButton();
		cureButton=cureButton();
		guardButton=guardButton();
		undoButton=undoButton();
		add(attackButton);
		add(addButton);
		add(cureButton);
		add(guardButton);
		add(undoButton);
		{
			JLabel lblNewLabel = new JLabel("���"+role.toString());
			lblNewLabel.setFont(new Font("����", Font.PLAIN, 20));
			lblNewLabel.setBounds(30, 43, 268, 43);
			add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("����  "+role.getLife()+"  (���Ϊ"+role.getLIFEMAX()+")");
			label.setFont(new Font("����", Font.PLAIN, 20));
			label.setBounds(30, 109, 219, 48);
			add(label);
		}
		{
			JLabel lblNewLabel2 = new JLabel("����  "+role.getEnergy()+"  (���Ϊ"+role.getENERGYMAX()+")");
			lblNewLabel2.setFont(new Font("����", Font.PLAIN, 20));
			lblNewLabel2.setBounds(30, 177, 241, 40);
			add(lblNewLabel2);
		}
		{
			conbutton = new JButton("�����غ�");
			conbutton.setEnabled(false);
			conbutton.setBounds(106, 230, 143, 45);
			add(conbutton);
			conbutton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					attackButton.setEnabled(false);
					addButton.setEnabled(false);
					cureButton.setEnabled(false);
					guardButton.setEnabled(false);
					undoButton.setEnabled(false);
					conbutton.setEnabled(false);
					setFinish(true);
				}
			});
		}
		
	}
	//���ü�ֵ
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	//���ò���״̬
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public boolean isFinish() {
		return finish;
	}
	//���ý�ɫ����ʹ������,���°�ť��ɫ״̬
	public void AbleButton(Role role){
		role.atb=(role.getEnergy()>=2)?true:false;
		role.ade=(role.getAddenergy()>0 && role.getEnergy()<role.getENERGYMAX())?true:false;
		role.gua=(role.getEnergy()>=1)?true:false;
		role.cur=(role.getEnergy()>=2 && role.getLife()<role.getLIFEMAX())?true:false;
		role.undo=true;
		}
		//������ť
		public JButton attackButton(){
			JButton atbutton= new JButton("����");
			atbutton.setEnabled(role.atb);
			atbutton.setBounds(346, 127, 136, 63);
			//�����¼�
			atbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(2);
					conbutton.setEnabled(true);
				}
			});
			return atbutton;
		}
		//������ť
		JButton addButton(){
			JButton addbutton= new JButton("�ָ���������"+role.getAddenergy()+"��");
			addbutton.setEnabled(role.ade);
			addbutton.setBounds(346, 51, 300, 63);
			addbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(1);
					conbutton.setEnabled(true);
				}
			});
			return addbutton;
		}
		//������ť
		JButton guardButton(){
			JButton guardbutton= new JButton("����");
			guardbutton.setEnabled(role.gua);
			guardbutton.setBounds(346, 203, 136, 63);
			guardbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(3);
					conbutton.setEnabled(true);
				}
			});
			return guardbutton;
		}
		//�ָ���ť
		JButton cureButton(){
			JButton curebutton= new JButton("�ָ�����");
			curebutton.setEnabled(role.cur);
			curebutton.setBounds(510, 127, 136, 63);
			curebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(4);
					conbutton.setEnabled(true);
				}
			});
			return curebutton;
		}
		//ɶ������
		JButton undoButton(){
			JButton undobutton= new JButton("ȡ���غ�");
			undobutton.setEnabled(role.undo);
			undobutton.setBounds(510, 203, 136, 63);
			undobutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(5);
					conbutton.setEnabled(true);
				}
			});
			return undobutton;
			}
}