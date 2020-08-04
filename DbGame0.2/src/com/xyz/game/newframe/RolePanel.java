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
	
	//攻击，获能，防御，治疗，啥都不干的使用条件
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
			JLabel lblNewLabel = new JLabel("玩家"+role.toString());
			lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
			lblNewLabel.setBounds(30, 43, 268, 43);
			add(lblNewLabel);
		}
		{
			JLabel label = new JLabel("生命  "+role.getLife()+"  (最大为"+role.getLIFEMAX()+")");
			label.setFont(new Font("宋体", Font.PLAIN, 20));
			label.setBounds(30, 109, 219, 48);
			add(label);
		}
		{
			JLabel lblNewLabel2 = new JLabel("能量  "+role.getEnergy()+"  (最大为"+role.getENERGYMAX()+")");
			lblNewLabel2.setFont(new Font("宋体", Font.PLAIN, 20));
			lblNewLabel2.setBounds(30, 177, 241, 40);
			add(lblNewLabel2);
		}
		{
			conbutton = new JButton("结束回合");
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
	//设置键值
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	//设置操作状态
	public void setFinish(boolean finish) {
		this.finish = finish;
	}
	
	public boolean isFinish() {
		return finish;
	}
	//设置角色能力使用条件,更新按钮角色状态
	public void AbleButton(Role role){
		role.atb=(role.getEnergy()>=2)?true:false;
		role.ade=(role.getAddenergy()>0 && role.getEnergy()<role.getENERGYMAX())?true:false;
		role.gua=(role.getEnergy()>=1)?true:false;
		role.cur=(role.getEnergy()>=2 && role.getLife()<role.getLIFEMAX())?true:false;
		role.undo=true;
		}
		//攻击按钮
		public JButton attackButton(){
			JButton atbutton= new JButton("攻击");
			atbutton.setEnabled(role.atb);
			atbutton.setBounds(346, 127, 136, 63);
			//单击事件
			atbutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setKey(2);
					conbutton.setEnabled(true);
				}
			});
			return atbutton;
		}
		//能量按钮
		JButton addButton(){
			JButton addbutton= new JButton("恢复能量可用"+role.getAddenergy()+"次");
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
		//防御按钮
		JButton guardButton(){
			JButton guardbutton= new JButton("防御");
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
		//恢复按钮
		JButton cureButton(){
			JButton curebutton= new JButton("恢复生命");
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
		//啥都不干
		JButton undoButton(){
			JButton undobutton= new JButton("取消回合");
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