package sqltest;

import java.awt.*;
import javax.swing.*;

//프로그램의 메인 클래스로, 화면 구성과 이벤트 처리를 담당한다
public class ProductGUI {

 static class StartUI extends JFrame {

    protected JLabel      lblMessage;

    protected JPanel      messagePanel;
    protected JLabel      lblPrcode;
    protected JLabel      lblPrname;
    protected JLabel      lblPrice;
    protected JLabel      lblManufacture;

    protected JPanel      updatePanel;
    protected JComboBox      cbPrcode;
    protected JTextField   txtPrname;
    protected JTextField   txtPrice;
    protected JTextField   txtManufacture;

    protected JTextArea      printArea;
    protected JScrollPane   PrintAreaScroll;

    protected JPanel      buttonPanel;
    protected JButton      btnSign;
    protected JButton      btnSearch;
    protected JButton      btnDelete;

    StartUI() {

       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout(10, 10));

       //데이터 설정
       lblMessage = new JLabel("메세지 출력부");
       lblMessage.setPreferredSize(new Dimension(820, 50));

       messagePanel = new JPanel();
       messagePanel.setPreferredSize(new Dimension(100, 225));
       lblPrcode      = new JLabel("관리번호", SwingConstants.CENTER);
       lblPrname      = new JLabel("상품명", SwingConstants.CENTER);
       lblPrice      = new JLabel("단가", SwingConstants.CENTER);
       lblManufacture   = new JLabel("제조사", SwingConstants.CENTER);
       lblPrcode.setPreferredSize(new Dimension(100, 50));
       lblPrname.setPreferredSize(new Dimension(100, 50));
       lblPrice.setPreferredSize(new Dimension(100, 50));
       lblManufacture.setPreferredSize(new Dimension(100, 50));
       messagePanel.add(lblPrcode);
       messagePanel.add(lblPrname);
       messagePanel.add(lblPrice);
       messagePanel.add(lblManufacture);

       updatePanel      = new JPanel();
       cbPrcode      = new JComboBox();
       txtPrname      = new JTextField();
       txtPrice      = new JTextField();
       txtManufacture   = new JTextField();
       updatePanel.add(cbPrcode);
       updatePanel.add(txtPrname);
       updatePanel.add(txtPrice);
       updatePanel.add(txtManufacture);
       cbPrcode.setPreferredSize(new Dimension(178, 50));
       txtPrname.setPreferredSize(new Dimension(178, 50));
       txtPrice.setPreferredSize(new Dimension(178, 50));
       txtManufacture.setPreferredSize(new Dimension(178, 50));

       printArea      = new JTextArea(10, 45);
       PrintAreaScroll   = new JScrollPane(printArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

       buttonPanel      = new JPanel();
       buttonPanel.setPreferredSize(new Dimension(820, 37));
       btnSign      = new JButton("등록");
       btnSearch   = new JButton("조회");
       btnDelete   = new JButton("삭제");
       buttonPanel.add(btnSign);
       buttonPanel.add(btnSearch);
       buttonPanel.add(btnDelete);

       add(lblMessage, BorderLayout.PAGE_START);
       add(messagePanel, BorderLayout.LINE_START);
       add(updatePanel, BorderLayout.CENTER);
       add(PrintAreaScroll, BorderLayout.LINE_END);
       add(buttonPanel, BorderLayout.PAGE_END);

       //Frame 설정
       setResizable(false);
       setSize(820, 372);
       setVisible(true);

    }//constructor

 }//StartUI class

 public static void main(String[] args) {
    new StartUI();
 }//main()

}//AppMain class