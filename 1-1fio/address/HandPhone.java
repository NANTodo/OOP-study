
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class HandPhone {

   static String fname ="C:\\temp\\juso.txt";
   
   
   static class MyFrame extends JFrame{
      
      public MyFrame() {
         
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setTitle("친구 연락처 관리");
         this.setLayout(null);
         this.setPreferredSize(new Dimension(300,800));
         this.setBounds(0,0,300,800);
         
         setVisible(true);
      }
   }
   
   public class btnListener implements ActionListener{

      @Override
      public void actionPerformed(ActionEvent e) {
         Object obj = e.getSource();
      }
      
   }
   
   static class address{
      String name;
      String age;
      String phone;
      
      address(String s1,String s2,String s3){
         this.name =s1;
         this.age =s2;
         this.phone = s3;
      }
   }
   
   public static void main(String[] args) throws IOException {
   
      new MyFrame();
      PrimaryPanel();
      
      Scanner scan = new Scanner(System.in);
      String select = "";
      System.out.printf("\n###친구 연락처 관리 ###\n");
      
      while(select != "4") {
         print_menu();
         select = scan.next();
         
         switch(select) {
         case"1":
            view_juso();
            break;
         case "2":
            add_juso();
               break;
         case "3":
            delete_juso();
            break;
         case "4":
            return;
            default:
               System.out.printf("\n잘못 입력했어요. 다시 선택하세요.\n");
         }
      }
   }
   static void print_menu() {
      System.out.printf("\n");
      System.out.printf("1. 연락처 출력\n");
      System.out.printf("2. 연락처 등록\n");
      System.out.printf("3. 연락처 삭제\n");
      System.out.printf("4. 끝내기\n");
      
   }
   static void view_juso()throws IOException {
      String str ="";
      
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
            System.out.printf("%2d: %s\n",i,str);
            
         }
      }
      
      if(i==1)
         System.out.printf("\n **연락처 파일에 전화번호가 하나도 없어요.**\n");
      
      br.close();
      
   }
   static void add_juso()throws IOException {
      Scanner sc = new Scanner(System.in);
      address adr = new address("","","");
      
      String wstr ="";
      
      BufferedWriter bw = new BufferedWriter(new FileWriter(fname,true));
      
      System.out.printf("이름을 입력==>");
      adr.name = sc.nextLine();
      System.out.printf("나이를 입력==>");
      adr.age = sc.nextLine();
      System.out.printf("전화번호를 입력==>");
      adr.phone = sc.nextLine();
      
      wstr = adr.name + "\t" + adr.age + "\t"+adr.phone;
      
      bw.write(wstr);
      bw.newLine();
      
      bw.close();
   }
   static void delete_juso()throws IOException {
      Scanner sc = new Scanner(System.in);
      
      String[] read_str = new String[50];
      String str ="";
      int del_line,i,count=0;
      
      BufferedReader br = new BufferedReader(new FileReader(fname));
      
      if(!br.ready()) {
         System.out.printf("\n!! 연락처 파일이 없습니다. !!\n");
         return;
      }
      
      System.out.printf("\n삭제할 행 번호는 ? ");
      del_line = sc.nextInt();
      
      for(i = 0; i<50;i++) {
         if((str = br.readLine())==null)
            break;
         
         if(i+1!=del_line)
         {
            read_str[count]=str;
            count++;
         }else
            System.out.printf("%d 행이 삭제되었습니다. \n",del_line);
      }
      
      br.close();
      
      BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
      
      for(i = 0; i<count;i++) {
         bw.write(read_str[i]);
         bw.newLine();
      }
      bw.close();
   }

}