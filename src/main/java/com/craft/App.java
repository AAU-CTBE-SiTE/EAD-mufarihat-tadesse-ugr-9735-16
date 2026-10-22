package com.craft;
import jakarta.persistence.*;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{

    public static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("studentPU");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    // CREATE
    public static void createStudent(Student student) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
    }

    //UPDATE
    public static void updateStudentName(String newName, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setName(newName);
        entityManager.getTransaction().commit();
    }
    public static void updateStudentNameAndTech(String newName, String newTech, int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setName(newName); student.setName(newTech);
        entityManager.getTransaction().commit();
    }
    //DELETE
    public static void deleteStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public static Student getStudentById(int id) {
        EntityManager entityManager = getEntityManager();
        return entityManager.find(Student.class, id);
    }

    //Find maximum ID
    public static int getMaxId(){
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT MAX(s.id) FROM Student s");
        return (int) query.getSingleResult();
    }

    public static void main(String[] args){

        Student student1 = new Student();
        student1.setName("Mohammed Ali");
        student1.setTech("Python");
        createStudent(student1);

        updateStudentName("Alemayehu", 2);
        System.out.println(getStudentById(2));


        //SELECT
        EntityManager em = getEntityManager();
        TypedQuery<Student> typedQuery =
                em.createQuery("SELECT s From Student s", Student.class);
        List<Student> students = typedQuery.getResultList();
        System.out.println(students);

        //FIND BY TECH
        TypedQuery<Student> query = em.createQuery( "SELECT s FROM Student s WHERE s.tech = :tech", Student.class);
        query.setParameter("tech", "python");
        List<Student> pythonStudents = query.getResultList();
        System.out.println(pythonStudents);

        //getResultList() Method
        TypedQuery<Student> typedQuery2 =
                em.createQuery("From Student s", Student.class);
        List<Student> students2 = typedQuery2.getResultList();
        students2.forEach(System.out::println);

        //Select student by name and tech
        TypedQuery<Student> typedQuery3 =
                em.createQuery(" SELECT s From Student s WHERE s.name = :name AND s.tech = :tech", Student.class);
        typedQuery3.setParameter("name", "Alemayehu");
        typedQuery3.setParameter("tech", "Python");
        List<Student> students3 = typedQuery.getResultList();
        students3.forEach(System.out::println);
        getAllStudentsOrderByNameAsc();
    }

    //Select All students ordered by name (ascending)
    public static List<Student> getAllStudentsOrderByNameAsc() {
        EntityManager em = getEntityManager();
        TypedQuery<Student> query =
                em.createQuery( "SELECT s FROM Student s ORDER BY s.name ASC",
                        Student.class); return query.getResultList();
    }
}