package sda;

import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Methods {

    public static void main(String[] args) {
   //loadEmployeesWithSamsung();
        loadEmployeesWithoutTask();
    //loadBlockerTasks();

    }

    public static void loadEmployeesWithSamsung(){
    final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Query query = entityManager.createQuery("select e from Employee e "
            + "join fetch e.phone "
            + "where e.phone.mark = :param", Employee.class);

    query.setParameter("param", "samsung");
    List<Employee> employeeList = query.getResultList();
    employeeList.forEach(x-> System.out.println(x.getName()));

    entityManager.getTransaction().commit();
    entityManager.close();

    HibernateUtils.shutdown();
}

public static void loadEmployeesWithoutTask(){
    final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Query query = entityManager.createQuery("select e from Employee e "
            + "where e.task is empty", Employee.class);

    List<Employee> employeeList = query.getResultList();
    employeeList.forEach(x-> System.out.println(x.getName()));

    entityManager.getTransaction().commit();
    entityManager.close();
    HibernateUtils.shutdown();

}

/*public static void loadBlockerTasks(){
    final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    final EntityManager entityManager = sessionFactory.createEntityManager();
    entityManager.getTransaction().begin();

    Query query = entityManager.createQuery("select t from Task t "
    + "join fetch t.type "
    + "where t.type =: param", Task.class);

    query.setParameter("param",TaskType.BLOCKER);
    List<Task> taskList = query.getResultList();
    taskList.forEach(x-> System.out.println(x.getTitle()));

    entityManager.getTransaction().commit();
    entityManager.close();

    HibernateUtils.shutdown();

}*/

}
