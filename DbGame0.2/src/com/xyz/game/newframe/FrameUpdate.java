package com.xyz.game.newframe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;

import com.xyz.game.opsystem.Against;
import com.xyz.game.role.Role;

public class FrameUpdate extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 20200203;
	Role role1,role2;
	JPanel panel=new JPanel();
	RolePanel rolepanel1,rolepanel2;
	JLabel boutlabel;
	JButton judgment,rule;
	Against against=new Against();
	
	public void getRole(Role role1,Role role2){
		this.role1=role1;
		this.role2=role2;
	}
	
	public void panelupdate(){
		
		panel.setBounds(0, 0, 682, 800);
		panel.setLayout(null);
		
		this.rolepanel1=new RolePanel(role1);
		this.rolepanel2=new RolePanel(role2);
		
		rolepanel1.setBounds(0, 0, 682, 340);
		rolepanel2.setBounds(0, 413, 682, 340);
				
		boutlabel = new JLabel("第"+against.bout.bout+"回合");
		boutlabel.setFont(new Font("宋体", Font.PLAIN, 20));
		boutlabel.setBounds(244, 353, 150, 47);
		
		judgment = new JButton("判定");
		judgment.setBounds(447, 353, 113, 39);
		judgment.setEnabled(false);
		
		rule = new JButton("游戏规则");
		rule.setBounds(57, 353, 113, 39);
		
		panel.add(rolepanel1);
		panel.add(rolepanel2);
		panel.add(boutlabel);
		panel.add(judgment);
		panel.add(rule);

		rule.addActionListener(this);
		judgment.addActionListener(this);
		
		new paintTread().start();
	}
	
	public void gameframe() {
		/*role1=new Role();
		role2=new Role();*/
		getContentPane().setLayout(null);
		setBounds(600, 100, 700, 800);
		String title=Words.getTitle();
		setTitle(title);
		panelupdate();
		getContentPane().add(panel);
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
		if(e.getSource() == judgment){
			against.AgainstAble(role1, role2, rolepanel1.getKey(), rolepanel2.getKey());
			panel.removeAll();
			panel.repaint();
			panelupdate();
			panel.revalidate();
			if(against.winner !=null){
				WinFrame win=new WinFrame(against);
				dispose();
			}
		}
		if(e.getSource() == rule){
			RuleFrame ruleframe =new RuleFrame();
		}
	}
	class paintTread extends Thread {
		/*
		 * 绘制线程
		 */
		@Override
		public void run() {
			while (true) {
				repaint();
				if(rolepanel1.isFinish() && rolepanel2.isFinish()){
					judgment.setEnabled(true);
				}
				try {
					Thread.sleep(15); // 1s = 1000ms 参数设置为15时帧率大约是60帧，大部分屏幕刷新率是60hz
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	} 
}
