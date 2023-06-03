package cgg.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
         Question q=new Question();
         q.setQuestionId(1);
         q.setQuestion("What is Java?");
         
         Answer a = new Answer();
         a.setAnswerId(11);
         a.setAnswer("JAVA is a programming language.");
         
         q.setAnswer(a);
         a.setQuestion(q);
         Session session = factory.openSession();
         
         Transaction t = session.beginTransaction();
         session.save(q);
         session.save(a);
         
         t.commit();
         
         Question question = session.get(Question.class, 1);
         System.out.println(question.getQuestion());
         System.out.println(question.getAnswer().getAnswer());
//         Answer answer = session.get(Answer.class, 11);
         
         
         
         session.close();
         
         
         
         
         factory.close();
    }
}
