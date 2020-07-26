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

	private JLabel			lblAction;			//�ൿ �ȳ�
	private JTextField		txtInsertDelete;	//������ ���� �����Ѵ�
	private JLabel			lblDeleteHere;		//������ ��ȭ��ȣ�� ��µ��� �˷���
	private JTextArea		areaPhoneNumber;	//��ȣ�� ��µ� ����
	private JButton			btnBack;			//�޴��� ���ư��� ��ư

	//method
	public deletePanel(PrimaryPanel parent) {

		//GUI����
		//setBackground(Color.white);
		setPreferredSize(new Dimension(300, 800));
		setLayout(null);

		//������ ����
		parentPanel	= parent;

		lblAction	= new JLabel("������ ���� �����Ͻÿ�");
		lblAction.setBounds(10, 10, 280, 50);
		lblAction.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblAction);

		txtInsertDelete = new JTextField(5);
		txtInsertDelete.setBounds(100, 60, 100, 20);
		txtInsertDelete.addActionListener(new btnListener());
		add(txtInsertDelete);

		lblDeleteHere = new JLabel("�Ʒ��� ���� ��ȭ��ȣ�ΰ� ���ɴϴ�");
		lblDeleteHere.setBounds(10, 90, 280, 50);
		lblDeleteHere.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDeleteHere);

		areaPhoneNumber = new JTextArea();
		areaPhoneNumber.setBounds(10, 150, 280, 200);
		areaPhoneNumber.setBorder(BorderFactory.createLineBorder(Color.black));
		add(areaPhoneNumber);

		btnBack = new JButton("���ư���");
		btnBack.setBounds(10, 360, 280, 50);
		btnBack.addActionListener(new btnListener());
		add(btnBack);

	}//constructor

	//��(����)�� ���� ����ó ����
	public void delete_juso(int delete_line) throws IOException {

		String			strFileName	= "C:/dev/test.txt";

		String[]		read_str	= new String[50];									//����� ����ó�� �ִ� 50���� ����
		String			str			= "";
		int				count		= 0;

		//1. ���� ��º�
		BufferedReader	reader		= new BufferedReader(new FileReader(strFileName));
		for (int i = 0; i < 50; i++) {
			if ((str = reader.readLine()) == null) {
				break;
			} //if

			//�����ϴ� ���� �����ϰ� �迭�� ����
			if (i + 1 != delete_line) {
				read_str[count] = str;
				count++;
			} //if

		} //for
		reader.close();

		//2. ���� �Էº�
		BufferedWriter writer = new BufferedWriter(new FileWriter(strFileName));

		areaPhoneNumber.setText(""); //��ȣ ������ �κ� �ʱ�ȭ

		//������ ���� �����ϰ� �޸��忡 ����
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
