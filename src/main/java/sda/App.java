package sda;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main( String[] args ) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        String sql = "SELECT version ();";

        String result = (String) session.createNativeQuery(sql).getSingleResult();
        System.out.println(result);
//zadanie2
        session.getTransaction().commit();
        session.close();
        final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        final EntityManager entityManager = sessionFactory.createEntityManager();
        Employee employee = new Employee();
        employee.setName("anna");
        employee.setSecondName("bam");
        employee.setDateOfBirth(null);
        employee.setEmail("abam@abam.com");
        Employee employee1 = new Employee();
        employee1.setName("ewa");
        employee1.setSecondName("bem");
        employee1.setDateOfBirth(null);
        employee1.setEmail("ebem@ebem.com");
        Phone phone = new Phone();
        phone.setMark("Iphone");
        phone.setModel("8");
        phone.setEmployee(employee);
        Phone phone1 = new Phone();
        phone1.setMark("Samsung");
        phone1.setModel("GalaxyS10");
        phone1.setEmployee(employee1);
        Task task = new Task();
        task.setTitle("writing");
        task.setDescription("writing down what to do");
        task.setEmployee(employee);
        Task task1 = new Task();
        task1.setTitle("thinking");
        task1.setDescription("thinking how to resolve the problem");
        task1.setEmployee(employee);
        task1.setEmployee(employee1);
        Task task2 = new Task();
        task2.setTitle("reading");
        task2.setDescription("reading explanations about the project");
        task2.setEmployee(employee1);
        Project project = new Project();
        project.setName("Alpha");
        Set<Employee> employees = new HashSet<>();
        employees.add(employee);
        employees.add(employee1);
        project.setEmployees(employees);

//CRUD here
        entityManager.getTransaction().begin();
        entityManager.persist(employee);
        entityManager.persist(employee1);
        entityManager.persist(phone);
        entityManager.persist(phone1);
        entityManager.persist(task);
        entityManager.persist(task1);
        entityManager.persist(task2);
        entityManager.persist(project);
        entityManager.flush();
//CRUD here

        entityManager.getTransaction().commit();
        HibernateUtils.shutdown();

        HibernateUtils.shutdown();





    }
}
