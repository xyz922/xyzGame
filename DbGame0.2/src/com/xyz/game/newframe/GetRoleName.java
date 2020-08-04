package com.xyz.game.newframe;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import com.xyz.game.role.Role;

import javax.swing.JButton;
//开始界面
public class GetRoleName extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 20200203;
	private JTextField roletext1;
	private JTextField roletext2;
	JButton confirm;
	JButton cancel;
	Role role1,role2;
	String rname1,rname2;
	public GetRoleName(Role role1,Role role2) {
		this.role1=role1;
		this.role2=role2;
		getContentPane().setLayout(null);
		setBounds(600, 100, 500, 400);
		
		JLabel lblNewLabel = new JLabel("请输入您的角色昵称");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 13, 181, 70);
		getContentPane().add(lblNewLabel);
		
		roletext1 = new JTextField();
		roletext1.setFont(new Font("宋体", Font.PLAIN, 20));
		roletext1.setBounds(178, 92, 181, 48);
		getContentPane().add(roletext1);
		roletext1.setColumns(10);
		
		roletext2 = new JTextField();
		roletext2.setFont(new Font("宋体", Font.PLAIN, 20));
		roletext2.setColumns(10);
		roletext2.setBounds(178, 177, 181, 48);
		getContentPane().add(roletext2);
		
		JLabel rolelabel1 = new JLabel("玩家1");
		rolelabel1.setFont(new Font("宋体", Font.PLAIN, 20));
		rolelabel1.setBounds(88, 90, 98, 48);
		getContentPane().add(rolelabel1);
		
		JLabel rolelabel2 = new JLabel("玩家2");
		rolelabel2.setFont(new Font("宋体", Font.PLAIN, 20));
		rolelabel2.setBounds(88, 175, 98, 48);
		getContentPane().add(rolelabel2);
		
		confirm = new JButton("确定");
		confirm.setBounds(86, 256, 143, 48);
		getContentPane().add(confirm);
		confirm.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setBounds(289, 256, 143, 48);
		getContentPane().add(cancel);
		cancel.addActionListener(this);
		setTitle("游戏开始");
		setVisible(true);
		addWindowListener(new WindowAdapter(){  
			   public void windowClosing(WindowEvent e){  
			       System.exit(0);  
			   }  
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == confirm){
			dispose();
			role1.setName(roletext1.getText());
			role2.setName(roletext2.getText());
			FrameUpdate my=new FrameUpdate();
			my.getRole(role1, role2);
			my.gameframe();
		}
		if(e.getSource() == cancel){
			System.exit(0);
		}
	}
}
