
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class printPanel extends JPanels{
	this.setLayout(PrimaryPanel);
	setTitle("����ó ���");
	
	JButton btn1 = new JButton("���ư���");
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
