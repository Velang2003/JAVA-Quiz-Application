
package Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author velan
 */
public class Login extends JFrame implements ActionListener{
    Font heading_font = new Font("Times New Roman",Font.BOLD,30);
    Font description_font = new Font("Courier New",Font.BOLD,18);
    Font button_font = new Font("Courier New", Font.BOLD, 20);
    Color customColor = new Color(245, 164, 96);
    Color bgColor = new Color(245, 222, 179);
     JButton start;
    Login(){
        
        JLabel heading = new JLabel("<html><u>Welcome To Online JAVA Quiz<u></html>");
        heading.setBounds(100,20,500, 40);
        heading.setFont(heading_font);
        add(heading);
        
        JLabel description = new JLabel("<html><p>Challenge your Java knowledge with this interactive quiz app! Test your skills across various Java topics, from core concepts to advanced features. With multiple-choice questions, you can track your progress and improve your coding abilities. Perfect for beginners and experienced programmers alike. Learn while you play and become a Java expert!</p></html>");
        description.setBounds(50,90,500,250);
        description.setFont(description_font);
        add(description);
         
        start = new JButton("START QUIZ");
        start.setFont(button_font);
        start.setBounds(290,350,170,40);
        start.setBackground(customColor);
        start.setFocusable(false);
        start.addActionListener(this);
        add(start);
        
        JButton stop = new JButton("STOP QUIZ");
        stop.setFont(button_font);
        stop.setBounds(100,350,170,40);
        stop.setBackground(customColor);
        stop.setFocusable(false);
        stop.addActionListener(e-> System.exit(0));
        add(stop);
        
        getContentPane().setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Online Quiz Application");
        setResizable(false);
        setLocation(600,250);
        setSize(600,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == start){
            setVisible(false);
            new Quiz();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
