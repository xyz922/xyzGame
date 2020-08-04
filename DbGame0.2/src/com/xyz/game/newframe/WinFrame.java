package com.xyz.game.newframe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.xyz.game.opsystem.Against;
import com.xyz.game.role.Role;

import java.awt.Font;

public class WinFrame extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 20200203;
	JButton confirm;
	JButton cancel;
	String winner;
	Against against;
	public WinFrame(Against against) {
		this.against=against;
		getContentPane().setLayout(null);
		winner=against.winner;
		JLabel lblNewLabel = new JLabel(winner,JLabel.CENTER);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 91, 340, 47);
		getContentPane().add(lblNewLabel);
		
		confirm = new JButton("继续游戏");
		confirm.setBounds(55, 199, 137, 57);
		getContentPane().add(confirm);
		confirm.addActionListener(this);
		
		cancel = new JButton("退出游戏");
		cancel.setBounds(265, 199, 137, 57);
		getContentPane().add(cancel);
		setBounds(600, 100, 500, 400);
		cancel.addActionListener(this);
		setTitle("游戏结束");
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == confirm){
			dispose();
			Role role1 =new Role();
			Role role2 =new Role();
			GetRoleName getrname=new GetRoleName(role1, role2);
		}
		if(e.getSource() == cancel){
			System.exit(0);
		}
	}
	
}
