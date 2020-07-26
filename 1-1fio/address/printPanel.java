
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class printPanel extends JPanels{
	this.setLayout(PrimaryPanel);
	setTitle("연락처 출력");
	
	JButton btn1 = new JButton("돌아가기");
	this.add(btn1,BorderLayout.SOUTH);
	
	
	
	String str = "";
	File f = new File(fname);
    if(!f.exists()) {
       BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
       bw.close();
    }
    BufferedReader br = new BufferedReader(new FileReader(fname));
    int i;
    
    for(i=1;;i++)
    {
       if(!br.ready())
          break;
       else {
          str = br.readLine();
	
}
