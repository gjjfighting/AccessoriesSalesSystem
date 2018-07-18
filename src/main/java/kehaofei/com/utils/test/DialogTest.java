package kehaofei.com.utils.test;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
 
public class DialogTest extends JFrame implements ActionListener {
     
    private JDialog d1;
    private JDialog d2;
     
    public DialogTest() {
        init();
    }
 
    private void init() {
        this.getContentPane().add(initPanel());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 400);
    }
 
    private Component initPanel() {
        JPanel panel = new JPanel();
        JButton b = new JButton("Dialog1");
        b.addActionListener(this);
        panel.add(b);
        return panel;
    }
     
    public static void main(String[] args) {
        new DialogTest();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Dialog1")) {
            JButton b = new JButton("Dialog2");
            b.addActionListener(this);
            d1 = new JDialog(this, "Im dialog one!", true);
            d1.add(b);	
            d1.setSize(200, 100);
            d1.setVisible(true);
        } else if(e.getActionCommand().equals("Dialog2")) {
            d2 = new JDialog(d1, "Im dialog two!", true);
            d2.setSize(200, 50);
            d2.setVisible(true);
        }
    }
}