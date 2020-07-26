package address;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class printPanel  extends JPanel {
	private PrimaryPanel parentPanel;
	private JButton	btnBack;
	private JLabel title;
	private JTextArea listArea;
	private int cnt = 0;
	
	//method
	public printPanel (PrimaryPanel parent) {
		
		//GUI����
		//setBackground(Color.white);
		setPreferredSize(new Dimension(300, 800)); 
		setLayout(null);
		
		//������ ����
		parentPanel	= parent;
		
		title = new JLabel("����ó ���");
		title.setBounds(10, 10, 280, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		//��������±��� ����
		listArea = new JTextArea(280,500);
		listArea.setBounds(10, 110, 280, 500);
		listArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(listArea);
		
		//�������� ���ư��� ��ư ����
		 btnBack = new JButton("���ư���");
			btnBack.setBounds(10, 660, 280, 50);
			btnBack.addActionListener(new btnListener());
			add(btnBack);
	
	} //������
	//����ϱ�
		public void view_juso()throws IOException{	
			
			String strFileName ="C:/dev/test.txt";
			String str = "";
			
			File f = new File(strFileName);
			try {
				BufferedReader br = new BufferedReader(new FileReader(strFileName));
	    
	    while((str=br.readLine()) != null){
	    			cnt++;
	    			//�ѹ���
					listArea.append( cnt + "\t" + str);
					//�౸��
					listArea.append("\r\n");
					}
	      
	    if(cnt==0) {
	       listArea.setText("\n**����ó ���Ͽ� ��ȭ��ȣ�� �ϳ��� �����.**\n");
	       }
	    br.close();  
	} catch(Exception e) {
		e.printStackTrace();
		
	}
		}//view_juso()
	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == btnBack) {
				parentPanel.disablePrintPanel();
				parentPanel.enableInitPanel();
			}
		}//actionPerformed

	}//btnListener class

}
