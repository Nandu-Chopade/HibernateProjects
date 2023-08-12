package code.bussinessService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.*;

import code.configuration.HibernateUtil;
import code.model.Answers;
import code.model.Questions;

public class AswerBussiness {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SessionFactory sf = HibernateUtil.getFactory();
        Session session = sf.openSession();
        Transaction t = session.beginTransaction();

        System.out.println("What is your question ?");
        String questionText = scan.nextLine();

        System.out.println("How many answers do you want to add for this question ?");
        int numAnswers = scan.nextInt();
        scan.nextLine(); // Consume the newline character left in the input stream

        Questions question = new Questions();
        question.setQuestionName(questionText);

        Set<Answers> answerSet = new HashSet<>(); // Create answer set outside the loop
        
        for (int i = 1; i <= numAnswers; i++) {
            System.out.println("Enter answer " + i + ": ");
            String answerText = scan.nextLine();
            
            Answers answer = new Answers(); // Create a new instance for each answer
            answer.setAnswerName(answerText);
            
            answerSet.add(answer); // Add answer to the answerSet
            // Save the answer separately
            session.save(answer);
        }
    
        // Set the answer set for the question
        question.setAnswer(answerSet);

        // Save the question
        session.save(question);

        t.commit();
        session.close();
        sf.close();
        scan.close();

        System.out.println("Successfully saved question and answers.");
    }
}

