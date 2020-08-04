package com.xyz.game.newframe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class RuleFrame extends JFrame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 20200203;
	StringBuffer rule=new StringBuffer();
	public RuleFrame() {
		//获取文本
		File file =new File("rule.txt");
		Reader reader=null;
		try {
			reader=new FileReader(file);
			char[] buffer=new char[1024];
			int temp=0;
			while((temp=reader.read(buffer)) !=-1)
			{
				rule.append(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(rule.toString());
		textPane.setFont(new Font("宋体", Font.PLAIN, 20));
		getContentPane().add(textPane, BorderLayout.CENTER);
		setTitle("游戏规则");
		setBounds(600, 100, 650, 400);
		setVisible(true);
		addWindowListener(new WindowAdapter(){  
			   public void windowClosing(WindowEvent e){  
				   dispose();
			   }  
		});
	}
}
