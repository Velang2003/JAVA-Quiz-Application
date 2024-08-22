import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String text;
    private String[] options;
    private int correctAnswerIndex;

    public Question(String text, String[] options, int correctAnswerIndex) {
        this.text = text;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}

public class QuizApp {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
System.out.printf("%30s\n\n\n","Onine Quiz Application.");
        questions.add(new Question(
			"Which of the following is the correct way to declare a variable in Java?", 
			new String[]{
					"int age = 25;", 
					"int age = '25';", 
					"age = 25;", 
					"25 = age;"
			}, 0));

        questions.add(new Question(
			"What is the output of the following code? System.out.println(\"Hello, World!\");", 
			new String[]{
					"Hello, World!", 
					"Error", 
					"Nothing", 
					"Depends on the compiler"
			}, 0));

 	  questions.add(new Question(
			"Which keyword is used to create a class in Java?", 
			new String[]{
					"class", 
					"public", 
					"static", 
					"void"
			}, 0));

        questions.add(new Question(
			"What is the data type of the result when you divide an integer by an integer in Java?", 
			new String[]{
					"int", 
					"float", 
					"double", 
					"depends on the values"
			}, 0));

	  questions.add(new Question(
			"Which loop is best suited for iterating a known number of times?", 
			new String[]{
					"while", 
					"do-while", 
					"for", 
					"all of the above"
			}, 2));

        questions.add(new Question(
			"What is the purpose of the 'main' method in a Java program?", 
			new String[]{
					"It is the entry point of the program.", 
					"It defines the class.", 
					"It handles exceptions.", 
					"It creates objects."
			}, 0));

	  questions.add(new Question(
			"Which operator is used for concatenation in Java?", 
			new String[]{
					"+", 
					"-", 
					"*", 
					"/"
			}, 0));

        questions.add(new Question(
			"Which of the following is a valid comment in Java?", 
			new String[]{
					"// This is a single-line comment", 
					"/* This is a multi-line comment */", 
					"Both 1 and 2", 
					" None of the above"
			}, 2));

	  questions.add(new Question(
			"What is the difference between an int and a long data type in Java?", 
			new String[]{
					"int can store larger numbers than long.", 
					"long can store larger numbers than int.", 
					"There is no difference between int and long.", 
					"int is used for decimal numbers, while long is used for whole numbers."
			}, 1));

	  questions.add(new Question(
			"What is the purpose of the final keyword in Java?", 
			new String[]{
					"To declare a variable as constant.", 
					"To declare a method as final.", 
					"To declare a class as final.", 
					"All of the above."
			}, 3));
        
        Quiz quiz = new Quiz(questions);
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        for (int i = 0; i < quiz.getTotalQuestions(); i++) {
            Question question = quiz.getQuestion(i);
            System.out.println(question.getText());
            for (int j = 0; j < question.getOptions().length; j++) {
                System.out.println((j + 1) + ". " + question.getOptions()[j]);
            }

            int userAnswer;
            do {
                System.out.print("Enter your answer (1-" + question.getOptions().length + "): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                userAnswer = scanner.nextInt();
            } while (userAnswer < 1 || userAnswer > question.getOptions().length);

            if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + (question.getCorrectAnswerIndex() + 1) + ".");
            }
            System.out.println();
        }

        System.out.println("Your score: " + score + "/" + quiz.getTotalQuestions());
    }
}