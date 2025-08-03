package springqns;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class Q6_MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Q6_springjdbc.xml");
        Q6_PersonDAO dao = (Q6_PersonDAO) context.getBean("personDAO");

        List<Q6_Person> people = dao.getAllPersons();
        for (Q6_Person person : people) {
            System.out.println(person.getId() + " | " + person.getFirstName() + " " + person.getLastName() + " | Age: " + person.getAge());
        }
    }
}
/*1 | Mani Kumar | Age: 22
2 | Ravi Teja | Age: 25
*/