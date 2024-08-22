
package Login;
import Login.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author velan
 */
public class Quiz  extends JFrame implements ActionListener{
    Font heading_font = new Font("Times New Roman",Font.BOLD,30);
    Font question_font = new Font("Tahoma",Font.BOLD,18);
    Font button_font = new Font("Courier New", Font.BOLD, 20);
    Color customColor = new Color(245, 164, 96);
    Color bgColor = new Color(245, 222, 179);
    
    JButton next,submit;
    JRadioButton opt1,opt2,opt3,opt4;
    JLabel heading,Q_number,Question, reveal_ans;
    ButtonGroup option;

    
    String[][] quizQuestions = {

{"Which of the following is the correct way to declare a variable in Java?",
					"int age = 25;", 
					"int age = \"25\";", 
					"age = 25;", 
					"25 = age;"},
        {"What is the output of the following code? System.out.println(\"Hello, World!\");",
					"Hello, World!", 
					"Error", 
					"Nothing", 
					"Depends on the compiler"},
        {"Which keyword is used to create a class in Java?", 
					"class", 
					"public", 
					"static", 
					"void"},
        {"<html>What is the data type of the result when you divide<br> an integer by an integer in Java?</html>", 
					"int", 
					"float", 
					"double", 
					"depends on the values"},
        {"Which loop is best suited for iterating a known number of times?", 
					"while", 
					"do-while", 
					"for", 
					"all of the above"},
        {"What is the purpose of the 'main' method in a Java program?", 
					"It is the entry point of the program.", 
					"It defines the class.", 
					"It handles exceptions.", 
					"It creates objects."},
        {"Which operator is used for concatenation in Java?", 
					"+", 
					"-", 
					"*", 
					"/"},
        {"Which of the following is a valid comment in Java?", 
					"// This is a single-line comment", 
					"/* This is a multi-line comment */", 
					"Both 1 and 2", 
					" None of the above"},
        {"<html>What is the difference between an<br> int and a long data type in Java?</html>", 
					"int can store larger numbers than long.", 
					"long can store larger numbers than int.", 
					"There is no difference between int and long.", 
					"<html>int is used for decimal numbers,<br>while long is used for whole numbers.</html>"},
        {"What is the purpose of the final keyword in Java?", 
					"To declare a variable as constant.", 
					"To declare a method as final.", 
					"To declare a class as final.", 
					"All of the above."},
};
    
   String crt_answers[][]={
    {"int age = 25;"},
    {"Hello, World!"},
    {"class"},
    {"int"},
    {"for"},
    {"It is the entry point of the program."},
    {"+"},
    {"Both 1 and 2"},
    {"long can store larger numbers than int."},
    {"All of the above."}
    };   

     public static int flag = 0;
     String answers[][] = new String[10][1];
     public static int count = 0;
     
    Quiz(){
    //Heading Question section
        Q_number = new JLabel();
        Q_number.setFont(heading_font);
        Q_number.setBounds(470, 20, 50,40);
        add(Q_number); 
        
        heading = new JLabel("QUESTION -");
        heading.setFont(heading_font);
        heading.setBounds(280,20,200, 40);
        add(heading);
       
            
     // Next and Submit Section
        next = new JButton("NEXT");
        next.setFont(button_font);
        next.setBounds(400,500,170,40);
        next.setBackground(customColor);
        next.setFocusable(false);
        next.addActionListener(this);
        next.setEnabled(false);
        add(next);
        
        submit= new JButton("SUBMIT");
        submit.setFont(button_font);
        submit.setBounds(200,500,170,40);
        submit.setBackground(customColor);
        submit.addActionListener(this);
        submit.setFocusable(false);   
        submit.setEnabled(false);
        add(submit);
        
        
    //Quiz questions and options    
        Question = new JLabel();
        Question.setFont(question_font);
        Question.setBounds(60, 80, 800, 50);
        add(Question);
        
       
        opt1 = new JRadioButton();
        opt1.setBackground(bgColor);
        opt1.setFont(button_font);
        opt1.setFocusable(false);
        opt1.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_1)
           opt1.setSelected(true);
    }
});
        opt1.setBounds(60,140,600,50);
        add(opt1);
                
        opt2 = new JRadioButton();
        opt2.setBackground(bgColor);
        opt2.setFont(button_font);
        opt2.setFocusable(false);
       opt2.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_2)
           opt1.setSelected(true);
    }
});
    
        opt2.setBounds(60,200,600,50);
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBackground(bgColor);
        opt3.setFont(button_font);
        opt3.setActionCommand(quizQuestions[count][3]);
        opt3.setFocusable(false);
        opt3.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_3)
           opt1.setSelected(true);
    }
});
        opt3.setBounds(60,260,600,50);
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBackground(bgColor);
        opt4.setFont(button_font);
        opt4.setActionCommand(quizQuestions[count][4]);
        opt4.setFocusable(false);
        opt4.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == e.VK_4)
           opt1.setSelected(true);
    }
});
        opt4.setBounds(60,320,600,50);
        add(opt4);
        
        reveal_ans = new JLabel();
        reveal_ans.setForeground(new Color(65,163,23));
        reveal_ans.setFont(button_font);
        reveal_ans.setVisible(false);
        reveal_ans.setBounds(60,370,700,50);
        add(reveal_ans);
        
        round(count);
        
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_1) {
                    opt1.setSelected(true);// Select the first radio button
                }
            }
        });

        
        
    // Default Layout settings
        getContentPane().setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Online Quiz Application");
        setResizable(false);
        setSize(800,600);
        setLocation(500,250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        
        
        if(e.getSource() == next){
            repaint();
        if(option.getSelection() != null){
            submit.setEnabled(true);
           option.clearSelection();
           reveal_ans.setVisible(false);
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
        }
            count++;
            round(count);
        }
       
        
        if(count <9 && e.getSource() == submit){
             answers[count][0] = option.getSelection().getActionCommand();
            next.setEnabled(true);
        }
         if(submit.getText().equals("Finish")){
            setVisible(false);
            new ScoreBoard(flag);
        }
        if(e.getSource() == submit){
            reveal_ans.setVisible(true);
            opt1.setEnabled(false);
            opt2.setEnabled(false);
            opt3.setEnabled(false);
            opt4.setEnabled(false);
            reveal_ans.setText("answer: "+crt_answers[count][0]);
            if(crt_answers[count][0].equalsIgnoreCase(answers[count][0])){
              flag+=10;
            }
            repaint();
        }
         
        if(count >= 9 && reveal_ans.isVisible() ){
           submit.setText("Finish");
        }
        
       
       
        repaint();
    }
  
      public void paint(Graphics g){
          super.paint(g);
          if(option.getSelection() != null){
              submit.setEnabled(true);
          }else if(option.getSelection() == null){
              submit.setEnabled(false);
              next.setEnabled(false);
          }
    repaint();
    }
    
    public void round(int count){
        Q_number.setText(Integer.toString(count+1));
        
       Question.setText(quizQuestions[count][0]);
       
       opt1.setText(quizQuestions[count][1]);
       opt1.setActionCommand(quizQuestions[count][1]);
       
       opt2.setText(quizQuestions[count][2]);
       opt2.setActionCommand(quizQuestions[count][2]);
       
       opt3.setText(quizQuestions[count][3]);
       opt3.setActionCommand(quizQuestions[count][3]);
        
       opt4.setText(quizQuestions[count][4]);
       opt4.setActionCommand(quizQuestions[count][4]);
       
         //Radio Button seection   
       
        option = new ButtonGroup();
        option.add(opt1);
        option.add(opt2);
        option.add(opt3);
        option.add(opt4);
        
    }
   
  
    public static void main(String args[]){
        new Quiz();
    }
}

 
