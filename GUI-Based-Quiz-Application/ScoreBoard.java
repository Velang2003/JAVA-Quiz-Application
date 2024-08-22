
package Login;
import Login.*;
import static Login.Quiz.flag;
import javax.swing.*;
import java.awt.*;



/**
 *
 * @author velan
 */
public class ScoreBoard extends JFrame{
    Font heading_font = new Font("Times New Roman",Font.BOLD,50);
    Color bgColor = new Color(245, 222, 179);
    Font button_font = new Font("Courier New", Font.BOLD, 20);
      Color customColor = new Color(245, 164, 96);
    JLabel marks = new JLabel();
   
    
    public ScoreBoard(int score){
    marks.setText("Your Score : "+ (score+10));
    marks.setFont(heading_font);
    marks.setBounds(100,150,500,100);
    add(marks);
    
    JButton next = new JButton("Exit");
        next.setFont(button_font);
        next.setBounds(290,350,170,40);
        next.setBackground(customColor);
        next.setFocusable(false);
        next.addActionListener(e-> System.exit(0));
        add(next);
        
    JButton  submit= new JButton("Play Again");
        submit.setFont(button_font);
        submit.setBounds(100,350,170,40);
        submit.setBackground(customColor);
        submit.addActionListener(e-> new Login());
        submit.setFocusable(false);  
        add(submit);
    
    getContentPane().setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Online Quiz Application");
        setResizable(false);
        setLocation(600,250);
        setSize(600,500);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new ScoreBoard(flag);
    }
}
