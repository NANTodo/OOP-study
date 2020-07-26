
import javax.swing.*;
import java.awt.*;

public class PrimaryPanel extends JPanel{

   private initPanel   init_p;
   private printPanel   print_p;
   private deletePanel   delete_p;
   private signPanel   sign_p;
   public PrimaryPanel() {
      this.setBackground(Color.white);
      this.setBounds(0, 0, 300, 800);
      
      init_p = new initPanel(this);
      this.add(init_p);
   }
   public void addPrintPanel() {
      print_p = new printPanel(this);
      print_p.setBounds(0, 0, 300, 800);
      this.add(print_p);
      repaint();
   }
   public void addDeletePanel() {
      delete_p = new deletePanel(this);
      delete_p.setBounds(0, 0, 300, 800);
      this.add(delete_p);
      repaint();
   }
   public void addSignPanel() {
      sign_p = new signPanel(this);
      sign_p.setBounds(0,0,300,800);
      this.add(sign_p);
      repaint();
   }
   
   public void disablePrintPanel()
   {
      this.print_p.setVisible(false);
   }
   public void disableDeltePanel()
   {
      this.delete_p.setVisible(false);
   }
   public void disableSignPanel()
   {
      this.sign_p.setVisible(false);
   }
   public void disableInitPanel()
   {
      this.init_p.setVisible(false);
   }
   public void enableInitPanel()
   {
      this.init_p.setVisible(true);
   }
   public void enablePrintPanel()
   {
      this.print_p.setVisible(true);
   }
   public void enableSignPanel()
   {
      this.sign_p.setVisible(true);
   }
   public void enableDeletePanel()
   {
      this.init_p.setVisible(true);
   }
}