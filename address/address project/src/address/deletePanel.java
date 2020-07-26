package address;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class deletePanel extends JPanel {

	//data
	private PrimaryPanel	parentPanel;

	private JLabel			lblAction;			//행동 안내
	private JTextField		txtInsertDelete;	//삭제할 행을 삽입한다
	private JLabel			lblDeleteHere;		//나머지 전화번호가 출력됨을 알려줌
	private JTextArea		areaPhoneNumber;	//번호가 출력될 공간
	private JButton			btnBack;			//메뉴로 돌아가는 버튼

	//method
	public deletePanel(PrimaryPanel parent) {

		//GUI설정
		//setBackground(Color.white);
		setPreferredSize(new Dimension(300, 800));
		setLayout(null);

		//데이터 생성
		parentPanel	= parent;

		lblAction	= new JLabel("삭제할 행을 삽입하시오");
		lblAction.setBounds(10, 10, 280, 50);
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAction);

		txtInsertDelete = new JTextField(5);
		txtInsertDelete.setBounds(100, 60, 100, 20);
		txtInsertDelete.addActionListener(new btnListener());
		add(txtInsertDelete);

		lblDeleteHere = new JLabel("아래에 남은 전화번호부가 나옵니다");
		lblDeleteHere.setBounds(10, 90, 280, 50);
		lblDeleteHere.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDeleteHere);

		areaPhoneNumber = new JTextArea();
		areaPhoneNumber.setBounds(10, 150, 280, 200);
		areaPhoneNumber.setBorder(BorderFactory.createLineBorder(Color.black));
		add(areaPhoneNumber);

		btnBack = new JButton("돌아가기");
		btnBack.setBounds(10, 360, 280, 50);
		btnBack.addActionListener(new btnListener());
		add(btnBack);

	}//constructor

	//행(인자)에 따라 연락처 삭제
	public void delete_juso(int delete_line) throws IOException {

		String			strFileName	= "C:/dev/test.txt";

		String[]		read_str	= new String[50];									//저장된 연락처는 최대 50개로 설정
		String			str			= "";
		int				count		= 0;

		//1. 파일 출력부
		BufferedReader	reader		= new BufferedReader(new FileReader(strFileName));
		for (int i = 0; i < 50; i++) {
			if ((str = reader.readLine()) == null) {
				break;
			} //if

			//삭제하는 행을 제외하고 배열에 저장
			if (i + 1 != delete_line) {
				read_str[count] = str;
				count++;
			} //if

		} //for
		reader.close();

		//2. 파일 입력부
		BufferedWriter writer = new BufferedWriter(new FileWriter(strFileName));

		areaPhoneNumber.setText(""); //번호 나오는 부분 초기화

		//삭제한 행을 제외하고 메모장에 저장
		for (int i = 0; i < count; i++) {

			writer.write(read_str[i]);
			writer.newLine();

			areaPhoneNumber.setText(areaPhoneNumber.getText() + read_str[i] + "\n");

		} //for
		writer.close();

	}//delete_juso()

	private class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();

			if (obj == btnBack) {
				parentPanel.disableDeltePanel();
				parentPanel.enableInitPanel();
			} //if
			else if (obj == txtInsertDelete) {

				try {
					delete_juso(Integer.parseInt(txtInsertDelete.getText()));
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			} //else if
		}//actionPerformed

	}//btnListener class

}//deletePanel class
