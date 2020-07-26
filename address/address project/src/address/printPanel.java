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
		
		//GUI설정
		//setBackground(Color.white);
		setPreferredSize(new Dimension(300, 800)); 
		setLayout(null);
		
		//데이터 생성
		parentPanel	= parent;
		
		title = new JLabel("연락처 출력");
		title.setBounds(10, 10, 280, 50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		//데이터출력구역 생성
		listArea = new JTextArea(280,500);
		listArea.setBounds(10, 110, 280, 500);
		listArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(listArea);
		
		//이전으로 돌아가기 버튼 생성
		 btnBack = new JButton("돌아가기");
			btnBack.setBounds(10, 660, 280, 50);
			btnBack.addActionListener(new btnListener());
			add(btnBack);
	
	} //생성자
	//출력하기
		public void view_juso()throws IOException{	
			
			String strFileName ="C:/dev/test.txt";
			String str = "";
			
			File f = new File(strFileName);
			try {
				BufferedReader br = new BufferedReader(new FileReader(strFileName));
	    
	    while((str=br.readLine()) != null){
	    			cnt++;
	    			//넘버링
					listArea.append( cnt + "\t" + str);
					//행구분
					listArea.append("\r\n");
					}
	      
	    if(cnt==0) {
	       listArea.setText("\n**연락처 파일에 전화번호가 하나도 없어요.**\n");
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
